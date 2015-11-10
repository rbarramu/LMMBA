package proyecto

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PublicacionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Publicacion.list(params), model:[publicacionCount: Publicacion.count()]
    }

    def show(Publicacion publicacion) {
        respond publicacion
    }

    def create() {
        respond new Publicacion(params)
    }

    @Transactional
    def save(Publicacion publicacion) {
        if (publicacion == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (publicacion.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond publicacion.errors, view:'create'
            return
        }

        publicacion.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'publicacion.label', default: 'Publicacion'), publicacion.id])
                redirect publicacion
            }
            '*' { respond publicacion, [status: CREATED] }
        }
    }

    def edit(Publicacion publicacion) {
        respond publicacion
    }

    @Transactional
    def update(Publicacion publicacion) {
        if (publicacion == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (publicacion.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond publicacion.errors, view:'edit'
            return
        }

        publicacion.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'publicacion.label', default: 'Publicacion'), publicacion.id])
                redirect publicacion
            }
            '*'{ respond publicacion, [status: OK] }
        }
    }

    @Transactional
    def delete(Publicacion publicacion) {

        if (publicacion == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        publicacion.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'publicacion.label', default: 'Publicacion'), publicacion.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'publicacion.label', default: 'Publicacion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

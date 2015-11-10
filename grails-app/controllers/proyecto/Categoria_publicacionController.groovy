package proyecto

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class Categoria_publicacionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Categoria_publicacion.list(params), model:[categoria_publicacionCount: Categoria_publicacion.count()]
    }

    def show(Categoria_publicacion categoria_publicacion) {
        respond categoria_publicacion
    }

    def create() {
        respond new Categoria_publicacion(params)
    }

    @Transactional
    def save(Categoria_publicacion categoria_publicacion) {
        if (categoria_publicacion == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (categoria_publicacion.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond categoria_publicacion.errors, view:'create'
            return
        }

        categoria_publicacion.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'categoria_publicacion.label', default: 'Categoria_publicacion'), categoria_publicacion.id])
                redirect categoria_publicacion
            }
            '*' { respond categoria_publicacion, [status: CREATED] }
        }
    }

    def edit(Categoria_publicacion categoria_publicacion) {
        respond categoria_publicacion
    }

    @Transactional
    def update(Categoria_publicacion categoria_publicacion) {
        if (categoria_publicacion == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (categoria_publicacion.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond categoria_publicacion.errors, view:'edit'
            return
        }

        categoria_publicacion.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'categoria_publicacion.label', default: 'Categoria_publicacion'), categoria_publicacion.id])
                redirect categoria_publicacion
            }
            '*'{ respond categoria_publicacion, [status: OK] }
        }
    }

    @Transactional
    def delete(Categoria_publicacion categoria_publicacion) {

        if (categoria_publicacion == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        categoria_publicacion.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'categoria_publicacion.label', default: 'Categoria_publicacion'), categoria_publicacion.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'categoria_publicacion.label', default: 'Categoria_publicacion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

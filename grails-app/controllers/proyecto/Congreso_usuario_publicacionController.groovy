package proyecto

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class Congreso_usuario_publicacionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Congreso_usuario_publicacion.list(params), model:[congreso_usuario_publicacionCount: Congreso_usuario_publicacion.count()]
    }

    def show(Congreso_usuario_publicacion congreso_usuario_publicacion) {
        respond congreso_usuario_publicacion
    }

    def create() {
        respond new Congreso_usuario_publicacion(params)
    }

    @Transactional
    def save(Congreso_usuario_publicacion congreso_usuario_publicacion) {
        if (congreso_usuario_publicacion == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (congreso_usuario_publicacion.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond congreso_usuario_publicacion.errors, view:'create'
            return
        }

        congreso_usuario_publicacion.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'congreso_usuario_publicacion.label', default: 'Congreso_usuario_publicacion'), congreso_usuario_publicacion.id])
                redirect congreso_usuario_publicacion
            }
            '*' { respond congreso_usuario_publicacion, [status: CREATED] }
        }
    }

    def edit(Congreso_usuario_publicacion congreso_usuario_publicacion) {
        respond congreso_usuario_publicacion
    }

    @Transactional
    def update(Congreso_usuario_publicacion congreso_usuario_publicacion) {
        if (congreso_usuario_publicacion == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (congreso_usuario_publicacion.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond congreso_usuario_publicacion.errors, view:'edit'
            return
        }

        congreso_usuario_publicacion.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'congreso_usuario_publicacion.label', default: 'Congreso_usuario_publicacion'), congreso_usuario_publicacion.id])
                redirect congreso_usuario_publicacion
            }
            '*'{ respond congreso_usuario_publicacion, [status: OK] }
        }
    }

    @Transactional
    def delete(Congreso_usuario_publicacion congreso_usuario_publicacion) {

        if (congreso_usuario_publicacion == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        congreso_usuario_publicacion.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'congreso_usuario_publicacion.label', default: 'Congreso_usuario_publicacion'), congreso_usuario_publicacion.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'congreso_usuario_publicacion.label', default: 'Congreso_usuario_publicacion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

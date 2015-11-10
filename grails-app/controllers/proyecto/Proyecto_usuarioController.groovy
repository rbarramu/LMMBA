package proyecto

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class Proyecto_usuarioController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Proyecto_usuario.list(params), model:[proyecto_usuarioCount: Proyecto_usuario.count()]
    }

    def show(Proyecto_usuario proyecto_usuario) {
        respond proyecto_usuario
    }

    def create() {
        respond new Proyecto_usuario(params)
    }

    @Transactional
    def save(Proyecto_usuario proyecto_usuario) {
        if (proyecto_usuario == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (proyecto_usuario.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond proyecto_usuario.errors, view:'create'
            return
        }

        proyecto_usuario.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'proyecto_usuario.label', default: 'Proyecto_usuario'), proyecto_usuario.id])
                redirect proyecto_usuario
            }
            '*' { respond proyecto_usuario, [status: CREATED] }
        }
    }

    def edit(Proyecto_usuario proyecto_usuario) {
        respond proyecto_usuario
    }

    @Transactional
    def update(Proyecto_usuario proyecto_usuario) {
        if (proyecto_usuario == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (proyecto_usuario.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond proyecto_usuario.errors, view:'edit'
            return
        }

        proyecto_usuario.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'proyecto_usuario.label', default: 'Proyecto_usuario'), proyecto_usuario.id])
                redirect proyecto_usuario
            }
            '*'{ respond proyecto_usuario, [status: OK] }
        }
    }

    @Transactional
    def delete(Proyecto_usuario proyecto_usuario) {

        if (proyecto_usuario == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        proyecto_usuario.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'proyecto_usuario.label', default: 'Proyecto_usuario'), proyecto_usuario.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'proyecto_usuario.label', default: 'Proyecto_usuario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

package proyecto

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class Publicacion_usuarioController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Publicacion_usuario.list(params), model:[publicacion_usuarioCount: Publicacion_usuario.count()]
    }

    def show(Publicacion_usuario publicacion_usuario) {
        respond publicacion_usuario
    }

    def create() {
        respond new Publicacion_usuario(params)
    }

    @Transactional
    def save(Publicacion_usuario publicacion_usuario) {
        if (publicacion_usuario == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (publicacion_usuario.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond publicacion_usuario.errors, view:'create'
            return
        }

        publicacion_usuario.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'publicacion_usuario.label', default: 'Publicacion_usuario'), publicacion_usuario.id])
                redirect publicacion_usuario
            }
            '*' { respond publicacion_usuario, [status: CREATED] }
        }
    }

    def edit(Publicacion_usuario publicacion_usuario) {
        respond publicacion_usuario
    }

    @Transactional
    def update(Publicacion_usuario publicacion_usuario) {
        if (publicacion_usuario == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (publicacion_usuario.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond publicacion_usuario.errors, view:'edit'
            return
        }

        publicacion_usuario.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'publicacion_usuario.label', default: 'Publicacion_usuario'), publicacion_usuario.id])
                redirect publicacion_usuario
            }
            '*'{ respond publicacion_usuario, [status: OK] }
        }
    }

    @Transactional
    def delete(Publicacion_usuario publicacion_usuario) {

        if (publicacion_usuario == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        publicacion_usuario.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'publicacion_usuario.label', default: 'Publicacion_usuario'), publicacion_usuario.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'publicacion_usuario.label', default: 'Publicacion_usuario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

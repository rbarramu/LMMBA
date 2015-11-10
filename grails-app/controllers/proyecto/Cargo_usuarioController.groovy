package proyecto

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class Cargo_usuarioController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Cargo_usuario.list(params), model:[cargo_usuarioCount: Cargo_usuario.count()]
    }

    def show(Cargo_usuario cargo_usuario) {
        respond cargo_usuario
    }

    def create() {
        respond new Cargo_usuario(params)
    }

    @Transactional
    def save(Cargo_usuario cargo_usuario) {
        if (cargo_usuario == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (cargo_usuario.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond cargo_usuario.errors, view:'create'
            return
        }

        cargo_usuario.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'cargo_usuario.label', default: 'Cargo_usuario'), cargo_usuario.id])
                redirect cargo_usuario
            }
            '*' { respond cargo_usuario, [status: CREATED] }
        }
    }

    def edit(Cargo_usuario cargo_usuario) {
        respond cargo_usuario
    }

    @Transactional
    def update(Cargo_usuario cargo_usuario) {
        if (cargo_usuario == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (cargo_usuario.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond cargo_usuario.errors, view:'edit'
            return
        }

        cargo_usuario.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'cargo_usuario.label', default: 'Cargo_usuario'), cargo_usuario.id])
                redirect cargo_usuario
            }
            '*'{ respond cargo_usuario, [status: OK] }
        }
    }

    @Transactional
    def delete(Cargo_usuario cargo_usuario) {

        if (cargo_usuario == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        cargo_usuario.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'cargo_usuario.label', default: 'Cargo_usuario'), cargo_usuario.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cargo_usuario.label', default: 'Cargo_usuario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

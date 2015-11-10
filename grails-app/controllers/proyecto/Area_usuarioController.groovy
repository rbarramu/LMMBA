package proyecto

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class Area_usuarioController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Area_usuario.list(params), model:[area_usuarioCount: Area_usuario.count()]
    }

    def show(Area_usuario area_usuario) {
        respond area_usuario
    }

    def create() {
        respond new Area_usuario(params)
    }

    @Transactional
    def save(Area_usuario area_usuario) {
        if (area_usuario == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (area_usuario.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond area_usuario.errors, view:'create'
            return
        }

        area_usuario.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'area_usuario.label', default: 'Area_usuario'), area_usuario.id])
                redirect area_usuario
            }
            '*' { respond area_usuario, [status: CREATED] }
        }
    }

    def edit(Area_usuario area_usuario) {
        respond area_usuario
    }

    @Transactional
    def update(Area_usuario area_usuario) {
        if (area_usuario == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (area_usuario.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond area_usuario.errors, view:'edit'
            return
        }

        area_usuario.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'area_usuario.label', default: 'Area_usuario'), area_usuario.id])
                redirect area_usuario
            }
            '*'{ respond area_usuario, [status: OK] }
        }
    }

    @Transactional
    def delete(Area_usuario area_usuario) {

        if (area_usuario == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        area_usuario.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'area_usuario.label', default: 'Area_usuario'), area_usuario.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'area_usuario.label', default: 'Area_usuario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

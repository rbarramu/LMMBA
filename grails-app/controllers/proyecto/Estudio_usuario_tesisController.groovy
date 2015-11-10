package proyecto

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class Estudio_usuario_tesisController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Estudio_usuario_tesis.list(params), model:[estudio_usuario_tesisCount: Estudio_usuario_tesis.count()]
    }

    def show(Estudio_usuario_tesis estudio_usuario_tesis) {
        respond estudio_usuario_tesis
    }

    def create() {
        respond new Estudio_usuario_tesis(params)
    }

    @Transactional
    def save(Estudio_usuario_tesis estudio_usuario_tesis) {
        if (estudio_usuario_tesis == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (estudio_usuario_tesis.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond estudio_usuario_tesis.errors, view:'create'
            return
        }

        estudio_usuario_tesis.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'estudio_usuario_tesis.label', default: 'Estudio_usuario_tesis'), estudio_usuario_tesis.id])
                redirect estudio_usuario_tesis
            }
            '*' { respond estudio_usuario_tesis, [status: CREATED] }
        }
    }

    def edit(Estudio_usuario_tesis estudio_usuario_tesis) {
        respond estudio_usuario_tesis
    }

    @Transactional
    def update(Estudio_usuario_tesis estudio_usuario_tesis) {
        if (estudio_usuario_tesis == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (estudio_usuario_tesis.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond estudio_usuario_tesis.errors, view:'edit'
            return
        }

        estudio_usuario_tesis.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'estudio_usuario_tesis.label', default: 'Estudio_usuario_tesis'), estudio_usuario_tesis.id])
                redirect estudio_usuario_tesis
            }
            '*'{ respond estudio_usuario_tesis, [status: OK] }
        }
    }

    @Transactional
    def delete(Estudio_usuario_tesis estudio_usuario_tesis) {

        if (estudio_usuario_tesis == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        estudio_usuario_tesis.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'estudio_usuario_tesis.label', default: 'Estudio_usuario_tesis'), estudio_usuario_tesis.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'estudio_usuario_tesis.label', default: 'Estudio_usuario_tesis'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

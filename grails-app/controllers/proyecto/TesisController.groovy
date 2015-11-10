package proyecto

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TesisController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Tesis.list(params), model:[tesisCount: Tesis.count()]
    }

    def show(Tesis tesis) {
        respond tesis
    }

    def create() {
        respond new Tesis(params)
    }

    @Transactional
    def save(Tesis tesis) {
        if (tesis == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tesis.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tesis.errors, view:'create'
            return
        }

        tesis.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tesis.label', default: 'Tesis'), tesis.id])
                redirect tesis
            }
            '*' { respond tesis, [status: CREATED] }
        }
    }

    def edit(Tesis tesis) {
        respond tesis
    }

    @Transactional
    def update(Tesis tesis) {
        if (tesis == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tesis.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tesis.errors, view:'edit'
            return
        }

        tesis.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tesis.label', default: 'Tesis'), tesis.id])
                redirect tesis
            }
            '*'{ respond tesis, [status: OK] }
        }
    }

    @Transactional
    def delete(Tesis tesis) {

        if (tesis == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        tesis.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tesis.label', default: 'Tesis'), tesis.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tesis.label', default: 'Tesis'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

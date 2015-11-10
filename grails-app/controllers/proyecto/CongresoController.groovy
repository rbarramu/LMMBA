package proyecto

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CongresoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Congreso.list(params), model:[congresoCount: Congreso.count()]
    }

    def show(Congreso congreso) {
        respond congreso
    }

    def create() {
        respond new Congreso(params)
    }

    @Transactional
    def save(Congreso congreso) {
        if (congreso == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (congreso.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond congreso.errors, view:'create'
            return
        }

        congreso.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'congreso.label', default: 'Congreso'), congreso.id])
                redirect congreso
            }
            '*' { respond congreso, [status: CREATED] }
        }
    }

    def edit(Congreso congreso) {
        respond congreso
    }

    @Transactional
    def update(Congreso congreso) {
        if (congreso == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (congreso.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond congreso.errors, view:'edit'
            return
        }

        congreso.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'congreso.label', default: 'Congreso'), congreso.id])
                redirect congreso
            }
            '*'{ respond congreso, [status: OK] }
        }
    }

    @Transactional
    def delete(Congreso congreso) {

        if (congreso == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        congreso.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'congreso.label', default: 'Congreso'), congreso.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'congreso.label', default: 'Congreso'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

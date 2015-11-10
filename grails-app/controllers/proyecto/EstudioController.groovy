package proyecto

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EstudioController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Estudio.list(params), model:[estudioCount: Estudio.count()]
    }

    def show(Estudio estudio) {
        respond estudio
    }

    def create() {
        respond new Estudio(params)
    }

    @Transactional
    def save(Estudio estudio) {
        if (estudio == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (estudio.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond estudio.errors, view:'create'
            return
        }

        estudio.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'estudio.label', default: 'Estudio'), estudio.id])
                redirect estudio
            }
            '*' { respond estudio, [status: CREATED] }
        }
    }

    def edit(Estudio estudio) {
        respond estudio
    }

    @Transactional
    def update(Estudio estudio) {
        if (estudio == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (estudio.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond estudio.errors, view:'edit'
            return
        }

        estudio.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'estudio.label', default: 'Estudio'), estudio.id])
                redirect estudio
            }
            '*'{ respond estudio, [status: OK] }
        }
    }

    @Transactional
    def delete(Estudio estudio) {

        if (estudio == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        estudio.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'estudio.label', default: 'Estudio'), estudio.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'estudio.label', default: 'Estudio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

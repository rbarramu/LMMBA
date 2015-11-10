package proyecto

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CargoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Cargo.list(params), model:[cargoCount: Cargo.count()]
    }

    def show(Cargo cargo) {
        respond cargo
    }

    def create() {
        respond new Cargo(params)
    }

    @Transactional
    def save(Cargo cargo) {
        if (cargo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (cargo.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond cargo.errors, view:'create'
            return
        }

        cargo.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'cargo.label', default: 'Cargo'), cargo.id])
                redirect cargo
            }
            '*' { respond cargo, [status: CREATED] }
        }
    }

    def edit(Cargo cargo) {
        respond cargo
    }

    @Transactional
    def update(Cargo cargo) {
        if (cargo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (cargo.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond cargo.errors, view:'edit'
            return
        }

        cargo.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'cargo.label', default: 'Cargo'), cargo.id])
                redirect cargo
            }
            '*'{ respond cargo, [status: OK] }
        }
    }

    @Transactional
    def delete(Cargo cargo) {

        if (cargo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        cargo.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'cargo.label', default: 'Cargo'), cargo.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cargo.label', default: 'Cargo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

package lmmba

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class AdminController {

    def index() {
        render view:'admin'
    }

    def save(){

}

}

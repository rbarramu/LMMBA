package lmmba

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured(['ROLE_USER', 'ROLE_ADMIN'])
class UsuarioController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        def c=Usuario.countByEnabled("false")
        params.max = Math.min(max ?: 10, 100)
        respond Usuario.list(params), model:[usuarioInstanceCount: Usuario.count(),usuario: c]
        
    }

    def springSecurityService
    def profile(){

        def x = springSecurityService.currentUser

        def y = Cargo_usuario.findByUsuario(x) // Con el findBy buscas en la tabla relacional
        def z = Cargo.findById(y.cargo.id)  // con esa pillas en tabla que quieres

        def k = Area_usuario.findByUsuario(x)
        def c = Area.findById(k.area.id)

        render view: 'perfil', model:[usuario: x, cargo: z, area: c]  // y lo devuelves como variable   
    }

    def buscador(){
        render view: 'buscar'
    }

    def search(){
        def buscar = request.getParameter("buscar")
        def tipo = request.getParameter("tipo")

        if(buscar.empty) {
            flash.message = "El campo de texto no puede estar en blanco"
            render view: 'buscar'
        }else{
            if(tipo == 'Archivo'){
                flash.message = "No implementado"
                render view: 'buscar'

            }
            if(tipo == 'Nombre'){
                def c = Usuario.findAllByNombres(buscar)

                if(c == null) {
                    flash.message = "Usuario no encontrado"
                    render view: 'buscar'
                }else{
                    def d=Usuario.countByNombres(buscar)
                    params.max = 100
                    render view: "visit", model:[usuarioInstanceCount: Usuario.count(),usuario: d, usuarioInstanceList: c]
                }
            }
            if(tipo == 'Apellido'){
                def c = Usuario.findAllByApellidoPaterno(buscar)

                if(c == null) {
                    flash.message = "Usuario no encontrado"
                    render view: 'buscar'
                }else{
                    def d=Usuario.countByApellidoPaterno(buscar)
                    params.max = 100
                    render view: "visit", model:[usuarioInstanceCount: Usuario.count(),usuario: d, usuarioInstanceList: c]
                }
            }
        }
    }

    def show(Usuario usuarioInstance) {
        respond usuarioInstance
    }

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def create() {
        respond new Usuario(params)
    }
    @Transactional
    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def save(Usuario usuarioInstance) {
        if (usuarioInstance == null) {
            notFound()
            return
        }

        if (usuarioInstance.hasErrors()) {
            respond usuarioInstance.errors, view:'create'
            return
        }

        usuarioInstance.save flush:true
        Rol aux=Rol.find{authority=='ROLE_USER'}
        Cargo aux2=Cargo.find{nombre=='Otros'}
        Area aux3=Area.find{nombre=='Otros'}
        //def asdf=Rol.findById(id:'1')
        UsuarioRol.create usuarioInstance,aux,true
        Area_usuario.create aux3,usuarioInstance,true
        Cargo_usuario.create aux2,usuarioInstance,true
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'usuario.label', default: 'Usuario'), usuarioInstance.id])
                redirect usuarioInstance
            }
            '*' { respond usuarioInstance, [status: CREATED] }
        }
    }

    def edit(Usuario usuarioInstance) {
        respond usuarioInstance
    }

    @Transactional
    def update(Usuario usuarioInstance) {
        if (usuarioInstance == null) {
            notFound()
            return
        }

        if (usuarioInstance.hasErrors()) {
            respond usuarioInstance.errors, view:'edit'
            return
        }

        usuarioInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Usuario.label', default: 'Usuario'), usuarioInstance.id])
                render view: "perfil"
            }    
            '*'{ respond usuarioInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Usuario usuarioInstance) {

        if (usuarioInstance == null) {
            notFound()
            return
        }

        usuarioInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Usuario.label', default: 'Usuario'), usuarioInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuario.label', default: 'Usuario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

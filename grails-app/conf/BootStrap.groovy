import lmmba.*
class BootStrap {

    def init = { servletContext ->
        def usuarioRol= new Rol('ROLE_USER').save(failOnError: true)
        def adminRol= new Rol('ROLE_ADMIN').save(failOnError: true)

        def usuarioUser=new Usuario('user','pass').save(failOnError: true)
        def adminUser= new Usuario('goku','dragonball').save(failOnError: true)

        UsuarioRol.create usuarioUser,usuarioRol
        UsuarioRol.create adminUser,adminRol,true
    }
    def destroy = {
    }
}

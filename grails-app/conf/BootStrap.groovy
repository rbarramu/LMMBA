
import lmmba.*
class BootStrap {

    def init = { servletContext ->
        def usuarioRol= new Rol('ROLE_USER').save(failOnError: true)
        def adminRol= new Rol('ROLE_ADMIN').save(failOnError: true)

        def usuarioUser=new Usuario('JuanPerez','juan', 'Juan', 'Perez', '-', 'juan@usm.cl','12345678-1', true).save(failOnError: true) 
        def usuario=new Usuario('BeatrizCamara','lmmba', 'Beatriz', 'Camara', '-', 'beatriz.camara@usm.cl','12345678-1', true).save(failOnError: true) 
        def adminUser= new Usuario('admin','admin','Administrador','Administrador', 'Administrador', 'a@a.com','87654321-1', true).save(failOnError: true)

        UsuarioRol.create usuarioUser,usuarioRol, true
        UsuarioRol.create adminUser,adminRol,true
        UsuarioRol.create usuario,usuarioRol, true



//Agrega Nombres de areas a la tabla Area
        def are1= new Area('Biotecnología Vegetal').save(failOnError:true)
        def are2= new Area('Compuestos Bioactivos').save(failOnError:true)
        def are3= new Area('Microbiología').save(failOnError:true)
        def are4= new Area('Biotecnología Ambiental').save(failOnError:true)
        def are5= new Area('Otros').save(failOnError:true)

//Agrega Cargos de las personas
        def cargo1 =new Cargo('Estudiante pregrado').save(failOnError:true)
        def cargo2 =new Cargo('Estudiante postgrado').save(failOnError:true)
        def cargo3 =new Cargo('Jefe de Laboratorio').save(failOnError:true)
        def cargo4 =new Cargo('Trabajador').save(failOnError:true)
        def cargo5 =new Cargo('Colaborador').save(failOnError:true)
        def cargo6 =new Cargo('Otros').save(failOnError:true)
        def cargo8 =new Cargo('Colaborador Nacional').save(failOnError:true)

//Cuando se cree la tabla Tipo sacar comentarios
        def tipo1= new Tipo('Revista Científica').save(failOnError:true)
        def tipo2= new Tipo('Capítulos de Libros').save(failOnError:true)
        def tipo3= new Tipo('Congreso').save(failOnError:true)
        def tipo4= new Tipo('Tesis').save(failOnError:true)
        def tipo5= new Tipo('Otros').save(failOnError:true)

        Cargo_usuario.create cargo4,adminUser,true
        Cargo_usuario.create cargo4,usuarioUser,true
        Cargo_usuario.create cargo8,usuario,true

        Area_usuario.create are1,adminUser, true
        Area_usuario.create are2,usuarioUser, true
        Area_usuario.create are4,usuario, true

    }
    def destroy = {
    }
}

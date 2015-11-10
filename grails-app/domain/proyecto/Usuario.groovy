package proyecto

class Usuario {

  static hasMany = [area_usuarios:Area_usuario, cargo_usuarios:Cargo_usuario,
  estudio_usuario_tesis:Estudio_usuario_tesis, proyecto_usuarios:Proyecto_usuario,
  publicacion_usuarios:Publicacion_usuario, congreso_usuario_publicacion:Congreso_usuario_publicacion]


	String nombres
	String apellidoPaterno
	String apellidoMaterno
	String email
	String sexo
  Date fechaNacimiento
   String cargo  
	String password


    static constraints = {
    	nombres()
    	apellidoPaterno()
    	apellidoMaterno()
    	email email:true, blank:false, unique:true
    	sexo inList: ['masculino','femenino']
      fechaNacimiento ()
      cargo inList: ['Estudiante pregrado','Estudiante postgrado']
    	password size: 8..20, password:true
     
    }
}

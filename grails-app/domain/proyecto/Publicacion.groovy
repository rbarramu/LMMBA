package proyecto

class Publicacion {

	static hasMany = [congreso_usuario_publicacion:Congreso_usuario_publicacion, 
	publicacion_usuarios:Publicacion_usuario, categoria_publicacion:Categoria_publicacion]

	String nombrePublicacion
	Date ano
	String tipo
	String autores
	String revista

    static constraints = {
    	nombrePublicacion()
    	ano()
    	tipo()
    	autores()
    	revista()
    }
}

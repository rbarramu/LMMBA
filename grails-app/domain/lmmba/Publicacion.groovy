package lmmba

class Publicacion {

	static hasMany = [congreso_usuario_publicacion:Congreso_usuario_publicacion, 
	publicacion_usuarios:Publicacion_usuario, categoria_publicacion:Categoria_publicacion]

	String nombrePublicacion
	Date ano = new Date()
	String autores
	String revista
	String contrasena
	String editorial
	String isbn

	Publicacion (String nombrePublicacion, Date ano, String autores, String revista, String contrasena,
		String editorial, String isbn){
		this()
		this.nombrePublicacion = nombrePublicacion
		this.ano = ano
		this.autores = autores
		this.revista = revista
		this.contrasena = contrasena
		this.editorial = editorial
		this.isbn = isbn
	}
 

    static constraints = {
    }
}

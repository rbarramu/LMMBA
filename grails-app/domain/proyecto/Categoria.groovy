package proyecto

class Categoria {

	static hasMany = [categoria_publicacion:Categoria_publicacion]

	String nombreCategoria

    static constraints = {
    	nombreCategoria()
    }
}

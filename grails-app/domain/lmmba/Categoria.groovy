package lmmba

class Categoria {

	static hasMany = [categoria_publicacion:Categoria_publicacion]

	String nombreCategoria

	Categoria (String nombreCategoria){
		this()
		this.nombreCategoria = nombreCategoria

	}

    static constraints = {
    	nombreCategoria()
    }
}

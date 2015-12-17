package lmmba

class Categoria_publicacion {

	static belongsTo = [Categoria, Publicacion]

	Categoria categoria
	Publicacion publicacion

	Categoria_publicacion (Categoria categoria, Publicacion publicacion){
		this()
		this.categoria = categoria
		this.publicacion = publicacion
	}

	static Categoria_publicacion create(Categoria categoria, Publicacion publicacion, boolean flush = false){
		def instance = new Categoria_publicacion(categoria, publicacion)
		instance.save(flush: flush, insert: true)
		instance
	}
    static constraints = {
    }
}

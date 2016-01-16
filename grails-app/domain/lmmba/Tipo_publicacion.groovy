package lmmba

class Tipo_publicacion {

	Tipo tipo 
	Publicacion publicacion

	Tipo_publicacion(Tipo tipo, Publicacion publicacion){
		this()
		this.tipo = tipo
		this.publicacion = publicacion
	}

	static Tipo_publicacion create(Tipo tipo, Publicacion publicacion ,  boolean flush = false){
		def instance = new Tipo_publicacion(tipo, publicacion)
		instance.save(flush: flush, insert: true)
		instance

	}

    static constraints = {
    }
}

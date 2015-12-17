package lmmba

class Congreso_usuario_publicacion {

	static belongsTo = [congreso:Congreso, publicacion:Publicacion, usuario:Usuario]

	Usuario usuario
	Congreso congreso
	Publicacion publicacion

	Congreso_usuario_publicacion(Usuario usuario, Congreso congreso, Publicacion publicacion){
		this()
		this.usuario = usuario
		this.congreso = congreso
		this.publicacion = publicacion
	}

	static Congreso_usuario_publicacion create (Usuario usuario, Congreso congreso, Publicacion publicacion, boolean flush = false){
		def instance = new Congreso_usuario_publicacion(usuario, congreso,publicacion)
		instance.save(flush: flush, insert: true)
		instance
	}
    static constraints = {
    }
}

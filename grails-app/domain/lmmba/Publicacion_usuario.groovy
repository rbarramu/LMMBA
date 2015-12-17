package lmmba

class Publicacion_usuario {

	  Usuario usuario
	  Publicacion publicacion
  	boolean privacidad

  	Publicacion_usuario (Usuario usuario, Publicacion publicacion, boolean privacidad){
  		this()
  		this.usuario = usuario
  		this.publicacion = publicacion
  		this.privacidad = privacidad
  	}

  	static Publicacion_usuario create (Usuario usuario,Publicacion publicacion, boolean privacidad, boolean flush = false){
  		def instance = new Publicacion_usuario(usuario, publicacion, privacidad)
		instance.save(flush: flush, insert: true)
		instance
  	}
    static constraints = {
    }
}

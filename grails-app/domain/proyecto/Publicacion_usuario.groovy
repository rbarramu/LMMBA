package proyecto

class Publicacion_usuario {

	static belongsTo = [publicacion:Publicacion, usuario:Usuario]

	boolean privacidad

    static constraints = {
    	privacidad()
    }
}

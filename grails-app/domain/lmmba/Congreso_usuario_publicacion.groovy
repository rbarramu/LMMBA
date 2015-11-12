package lmmba

class Congreso_usuario_publicacion {

	static belongsTo = [congreso:Congreso, publicacion:Publicacion, usuario:Usuario]

    static constraints = {
    }
}

package proyecto

class Tesis {

	static hasMany = [estudio_usuario_tesis:Estudio_usuario_tesis]

	String nombre
	String archivo

    static constraints = {
    	nombre()
    	archivo()

    }
}

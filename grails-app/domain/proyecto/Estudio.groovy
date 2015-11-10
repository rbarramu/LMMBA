package proyecto

class Estudio {

	static hasMany = [estudio_usuario_tesis:Estudio_usuario_tesis]

	String nombre
	String tipo

    static constraints = {
    	nombre()
    	tipo()
    }
}

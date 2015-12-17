package lmmba

class Estudio {

	static hasMany = [estudio_usuario_tesis:Estudio_usuario_tesis]

	String nombre
	String tipo

	Estudio(String nombre, String tipo){
		this()
		this.nombre = nombre
		this.tipo = tipo
	}

    static constraints = {
    	nombre()
    	tipo()
    }
}

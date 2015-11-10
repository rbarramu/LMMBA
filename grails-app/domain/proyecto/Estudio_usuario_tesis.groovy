package proyecto

class Estudio_usuario_tesis {

	static belongsTo = [Usuario, Estudio, Tesis]

	Date año

    static constraints = {
    	año()
    }
}

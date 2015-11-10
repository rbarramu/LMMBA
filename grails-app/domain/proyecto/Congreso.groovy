package proyecto

class Congreso {

	static hasMany = [congreso_usuario_publicacion:Congreso_usuario_publicacion]

	String nombreCongreso
	Date ano

    static constraints = {
    	nombreCongreso()
    	ano()
    }
}

package proyecto

class Proyecto {

	static hasMany = [proyecto_usuarios:Proyecto_usuario]

	String nombreProyecto

    static constraints = {
    	nombreProyecto()
    }
}

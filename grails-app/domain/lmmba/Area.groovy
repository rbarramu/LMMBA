package lmmba

class Area {

	static hasMany = [area_usuarios:Area_usuario]
	
	String nombre

    static constraints = {
    	nombre()
    }
}

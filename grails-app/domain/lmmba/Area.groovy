package lmmba

class Area {

	static hasMany = [area_usuarios:Area_usuario]
	 static belongsTo = Usuario

	String nombre

	Area (String nombre){
		this()
		this.nombre = nombre
	}

    static constraints = {
    	nombre ()
    }
}

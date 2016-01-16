package lmmba

class Proyecto {

	static hasMany = [proyecto_usuarios:Proyecto_usuario]

	String nombreProyecto

	Proyecto (String nombreProyecto){
		this()
		 this.nombreProyecto = nombreProyecto
		
	}


    static constraints = {
    	nombreProyecto()
    }
}

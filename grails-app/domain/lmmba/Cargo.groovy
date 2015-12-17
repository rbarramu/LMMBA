package lmmba

class Cargo {

	static hasMany = [cargo_usuarios:Cargo_usuario]
	String nombre

	Cargo (String nombre){
		this()
		this.nombre = nombre
	}

    static constraints = {
    	nombre ()
    }
}

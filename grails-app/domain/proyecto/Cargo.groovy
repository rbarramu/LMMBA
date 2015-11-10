package proyecto

class Cargo {

	static hasMany = [cargo_usuarios:Cargo_usuario]

	String nombre

    static constraints = {
    	nombre()
    }
}

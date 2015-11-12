package lmmba

class Proyecto_usuario {

	static belongsTo = [proyecto:Proyecto, usuario:Usuario]

	String cargo

    static constraints = {
    	cargo()
    }
}

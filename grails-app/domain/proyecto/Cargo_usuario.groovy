package proyecto

class Cargo_usuario {

	static belongsTo = [usuario:Usuario, cargo:Cargo]

    static constraints = {
    }
}

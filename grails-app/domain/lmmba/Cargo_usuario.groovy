package lmmba

class Cargo_usuario {

	static belongsTo = [usuario:Usuario, cargo:Cargo]
	Cargo cargo
	Usuario usuario

	Cargo_usuario (Cargo cargo, Usuario usuario) {
		this()
		this.cargo = cargo
		this.usuario = usuario
	}

	static Cargo_usuario create(Cargo cargo, Usuario usuario, boolean flush = false){
		def instance = new Cargo_usuario(cargo, usuario)
		instance.save(flush: flush, insert: true)
		instance
	}

    static constraints = {
    }
}

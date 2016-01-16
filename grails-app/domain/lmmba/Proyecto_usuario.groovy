package lmmba

class Proyecto_usuario {

	static belongsTo = [proyecto:Proyecto, usuario:Usuario]

	Usuario usuario
	Proyecto proyecto
	String cargo
	Date ano_inicio = new Date()
	Date ano_final = new Date()

	Proyecto_usuario(Usuario usuario, Proyecto proyecto, String cargo, Date ano_inicio, Date ano_final){
		this ()
		this.usuario = usuario
		this.proyecto = proyecto
		this.cargo = cargo
		this.ano_inicio = ano_inicio
		this.ano_final = ano_final
	}

	static Proyecto_usuario create(Usuario usuario, Proyecto proyecto, String cargo, Date ano_inicio, Date ano_final, boolean flush = false){
		def instance = new Proyecto_usuario(usuario, proyecto, cargo, ano_inicio, ano_final)
		instance.save(flush: flush, insert: true)
		instance
	}


    static constraints = {
    	cargo()
    }
}

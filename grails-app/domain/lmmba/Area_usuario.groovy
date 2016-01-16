package lmmba

class Area_usuario {
	
	static belongsTo = [usuario:Usuario, area:Area]

	Area area 
	Usuario usuario

	Area_usuario (Area area, Usuario usuario) {
		this()
		this.area = area
		this.usuario = usuario
	}

	static Area_usuario create(Area area, Usuario usuario, boolean flush = false){
		def instance = new Area_usuario(area, usuario)
		instance.save(flush: flush, insert: true)
		instance
	}

    static constraints = {
    }
}

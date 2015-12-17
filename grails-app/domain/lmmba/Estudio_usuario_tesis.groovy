package lmmba

class Estudio_usuario_tesis {

	static belongsTo = [Usuario, Estudio, Tesis]

	Date ano = new Date()
	Usuario usuario
	Estudio estudio
	Tesis tesis
	String comentario
	Usuario profeA
	Usuario profeB

	Estudio_usuario_tesis(Date ano, Usuario usuario, Estudio estudio, Tesis tesis, String comentario, Usuario profeA, Usuario profeB){
		this()
		this.ano = ano
		this.usuario = usuario
		this.estudio = estudio
		this.tesis = tesis
		this.comentario = comentario
		this.profeA = profeA
		this.profeB = profeB
	}

	static Estudio_usuario_tesis create (Usuario usuario, Estudio estudio, Tesis tesis, String comentario, Usuario profeA, Usuario profeB, boolean flush = false){
		def instance = new Estudio_usuario_tesis(usuario, estudio, tesis, comentario,profeA,profeB)
		instance.save(flush: flush, insert: true)
		instance
	}

    static constraints = {
    	ano()
    	profeA(nullable:true)
    	profeB(nullable:true)
    }
}

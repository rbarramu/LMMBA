package lmmba

class Congreso {

	static hasMany = [congreso_usuario_publicacion:Congreso_usuario_publicacion]

	String nombreCongreso
	Date ano = new Date()

	Congreso(String nombreCongreso, Date ano){
		this()
		this.nombreCongreso = nombreCongreso
		this.ano = ano
	}
    static constraints = {
    	nombreCongreso()
    	ano()
    }
}

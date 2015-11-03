package usuarios

class Usuario {

	String nombres
	String apellidoPaterno
	String apellidoMaterno
	String email
	Integer edad
	String sexo
	String password

    static constraints = {
    	nombres()
    	apellidoPaterno()
    	apellidoMaterno()
    	email email:true
    	edad min:18, max:60
    	sexo inList: ['masculino','femenino']
    	password size: 8..20, password:true
    }
}

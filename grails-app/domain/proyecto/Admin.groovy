package proyecto

class Admin {

	String nombre
	String password

    static constraints = {
    	nombre()
    	password size: 8..20, password:true
    }
}

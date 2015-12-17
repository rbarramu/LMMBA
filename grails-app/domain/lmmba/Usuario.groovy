package lmmba

class Usuario implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService

	
	String username
	String password
	String nombres 
	String apellidoPaterno
	String apellidoMaterno
	String email
	String rut
	boolean enabled 
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	Usuario(String username, String password, String nombres, String apellidoPaterno, String apellidoMaterno, 
		String email, String rut, boolean enabled) {
		this()
		this.username = username
		this.password = password
		this.nombres = nombres
		this.apellidoPaterno = apellidoPaterno
		this.apellidoMaterno = apellidoMaterno
		this.email = email
		this.rut = rut
		this.enabled = enabled
	}

	@Override
	int hashCode() {
		username?.hashCode() ?: 0
	}

	@Override
	boolean equals(other) {
		is(other) || (other instanceof Usuario && other.username == username)
	}

	@Override
	String toString() {
		username
	}

	Set<Rol> getAuthorities() {
		UsuarioRol.findAllByUsuario(this)*.rol
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
		password blank: false
		email unique: true, size: 5..100
		
	}

	static hasMany = [areas : Area, cargos : Cargo]

	static mapping = {
		password column: '`password`'
	}
}

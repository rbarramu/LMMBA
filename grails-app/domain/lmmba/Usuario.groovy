package lmmba

class Usuario implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService

	String username
	String password
	String titulo // Agrege este atributo de ejemplos, revisen boostrap.groovy en la carpeta conf.
	boolean enabled 
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	// Fijense que agrege a la identidad usuario String titulo, para que al moment de crear resiva el atributo
	Usuario(String username, String password, String titulo, boolean enabled) {
		this()
		this.username = username
		this.password = password
		this.titulo = titulo // Agregre la declaracion para agregar titulo
		this.enabled = enabled
	}

	// La edicione de arriba es muy importante, al igual que editar los usuarios de prueba en boostrap.groovy

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
	}

	static mapping = {
		password column: '`password`'
	}
}

package lmmba

class Tesis {

	String nombreTesis
	String archivo
	String url

	Tesis (String nombreTesis, String archivo, String url){
		this()
		this.nombreTesis = nombreTesis
		this.archivo = archivo
		this.url = url
	}

    static constraints = {
    	nombreTesis(nullable:true)
    	archivo(nullable:true)
    	url(nullable:true)
    }
}

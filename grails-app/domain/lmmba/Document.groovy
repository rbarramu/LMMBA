package lmmba

class Document {
    String filename
    String fullPath
    Date uploadDate = new Date()
    String descripcion
    String tipo
    static constraints = {
        filename(blank:false,nullable:false)
        fullPath(blank:false,nullable:false)
    }
}
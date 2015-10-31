package forotallersd

class File {
    String fileType
    byte[] content
    Double size

    static belongsTo = [post_belongs_id : Post]

    static constraints = {
        fileType matches: "[a-zA-Z]+/[a-zA-Z]+", nullable: false, blank: false
        content nullable:false, blank:false
        size maxSize: 10*1024*1024d, nullable: false, blank: false
    }
}

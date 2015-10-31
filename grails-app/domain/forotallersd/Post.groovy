package forotallersd

class Post {
    String topic
    Date dateCreated
    Date lastUpdate
    Boolean itsAllowed
    List<String> comments = new ArrayList<String>()
    Integer rate

    static hasMany = [owner_id : File, comments : String]

    static belongsTo = [fatherForum_id : Forum, regular: Regular]

    def beforeInsert(){
        this.dateCreated = new Date()
    }

    def beforeUpdate(){
        this.lastUpdate = new Date()
    }

    static constraints = {
        topic (nullable: false, minSize: 3, maxSize: 50)
        dateCreated (nullable: false, min: new Date())
        lastUpdate (nullable: false, min: new Date())
        itsAllowed (nullable: false)
        rate (min: 0)
    }
}

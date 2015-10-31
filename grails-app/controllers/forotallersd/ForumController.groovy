package forotallersd

class ForumController {

    static scaffold = Forum

    def indexForum() {
      def listForum = Forum.list()
      [forum:listForum]
    }
}

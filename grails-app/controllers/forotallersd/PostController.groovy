package forotallersd

class PostController {

    static  scaffold = Post

    def indexPost() {
      def listPost = Post.list()
      [post:listPost]
    }
}

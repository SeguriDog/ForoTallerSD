package forotallersd

class UserController {

    static scaffold = User
    def indexUser() {
      def listUsers = User.list()
      [user:listUsers]
    }
}

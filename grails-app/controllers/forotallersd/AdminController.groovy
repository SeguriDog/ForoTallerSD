package forotallersd

class AdminController {

    static scaffold = Admin

    def indexAdmin() {
      def listAdmin = Admin.list()
      [admin:listAdmin]
    }
}

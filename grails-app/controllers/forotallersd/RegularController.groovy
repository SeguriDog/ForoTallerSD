package forotallersd

class RegularController {

    static scaffold = Regular

    def indexRegular() {
      def listRegular = Regular.list()
      [regular:listRegular]
    }
}

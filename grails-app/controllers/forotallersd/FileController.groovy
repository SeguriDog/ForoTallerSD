package forotallersd

class FileController {

    static  scaffold = File

    def indexFile() {
      def listFile = File.list()
      [file:listFile]
    }
}

package forotallersd

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

class ForumController {

    static scaffold = Forum

    def index() {
      redirect(action:'listforum')
    }
    def listforum(Integer max){
        params.max = Math.min(max ?: 10, 100)
        respond Forum.list(params), model:[forumInstanceCount: Forum.count()]
    }
    def create(){
        respond new Forum(params)
    }
    @Transactional
    def update(Forum forumInstance) {
        if (forumInstance == null) {
            notFound()
            return
        }

        if (forumInstance.hasErrors()) {
            respond forumInstance.errors, view:'edit'
            println("${forumInstance.errors}")
            return
        }

        forumInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Forum.label', default: 'Forum'), forumInstance.id])
                redirect forumInstance
            }
            '*'{ respond forumInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Forum forumInstance) {

        if (forumInstance == null) {
            notFound()
            return
        }

        forumInstance.delete flush:true

        if (forumInstance.hasErrors()) {
            println("${forumInstance.errors}")
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Forum.label', default: 'Forum'), forumInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'Forum.label', default: 'Forum'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def beforeInterceptor = {
        println("Se va a ejecutar la acci�n: ${getActionName()}")
    }

    def afterInterceptor = {
        println ("Se ha ejecutado la acci�n: ${getActionName()}")
    }

    def show(Forum forumInstance) {
        respond forumInstance
    }
}

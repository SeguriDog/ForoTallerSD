package forotallersd



import grails.test.mixin.*
import spock.lang.*

@TestFor(PostController)
@Mock(Post)
class PostControllerSpec extends Specification {

    void "Text action: rate"(){
        setup:
        def test = new Post(id: 1, topic: 'test', dateCreated: '2015-10-10', lastUpdate: '2015-10-10', itsAllowed: true, rate: 0)
        test.save()
        def pc = new PostController()

        and:
        pc.params.actualPost = 1

        when:
        pc.rate()

        then:
        Post.findById(1).rate == 1
    }

    void "Text action: comment"(){
        setup:
        def test = new Post(id: 1, topic: 'test', dateCreated: '2015-10-10', lastUpdate: '2015-10-10', itsAllowed: true, rate: 0)
        test.save()
        def pc = new PostController()

        and:
        pc.params.actualPost = 1
        pc.params.commentContent = 'prueba'

        when:
        pc.comment()

        then:
        Post.findById(1).comments.size() == 1
    }
}

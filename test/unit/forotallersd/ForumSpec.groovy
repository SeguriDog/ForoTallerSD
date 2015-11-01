package forotallersd

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Forum)
class ForumSpec extends Specification {

    def setup() {
		mockForConstraintsTests(Forum)
    }

    def cleanup() {
    }
	
	@Unroll("test Forum attribute name: #name, field: #field, valid: #valid")
    def "Testing Domain Class Forum - name"() {
		when:
		def t_forum_name = new Forum(name: name, dateCreated: new Date(), category: "12")
		t_forum_name.validate()
		
		then:
		t_forum_name.errors.hasFieldErrors("name") == false

		where:
		name	| valid		| field
		'bc'	| false		| 'minSize'
		null	| false		| 'null'
		'abdc'	| true		| 'size'
		'aaaaaaaaaaeeeeeeeeeeiiiiiiiiiioooooooooouuuuuuuuuu'	| true		| 'size'
		'zzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvv1'	| false		| 'maxSize'
    }
	
	@Unroll("test Forum attribute dateCreated: #dateCreated, field: #field, valid: #valid")
	def "Testing Domain Class Forum - dateCreated"(){
		when:
		def t_forum_dateCreated = new Forum(name: "Prueba", dateCreated: dateCreated, category: "4")
		t_forum_dateCreated.validate()

		then:
		t_forum_dateCreated.hasFieldErrors("dateCreated") == false

		where:
		dateCreated 	| valid		| field
		null			| false		| 'null'
		new Date()		| true		| 'min'
		new Date()-2	| false		| 'minValue'	
	}
	@Unroll("test Forum attribute category: #category, field: #field, valid: #valid")
	def "Testing Domain Class Forum - category"(){
		when:
		def t_forum_category = new Forum(name: "Prueba", dateCreated: new Date(), category: category)

		then:
		t_forum_category.hasFieldError("category") == false

		where:
		category	| valid		| field
		'ab'		| false 	| 'minSize'
		null		| false		| null
		'xyz'		| true		| 'size'
		'hhhiiijjjkkklll'	| true	| 'size'
		'hhhiiijjjkkklllt'	| false	| 'maxSize'






	}
}

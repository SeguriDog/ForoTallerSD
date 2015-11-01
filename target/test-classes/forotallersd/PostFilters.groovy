package forotallersd

class PostFilters {

    def filters = {
        banFilter(controller: '(index)'){
            before = {
                if (!(session.authStatus == 'logged')){
                    redirect(controller: 'Post', action: 'index')
                }
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}

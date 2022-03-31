package qotd

class QuoteController {

    def index = { 
    	redirect(action: home)
    }
    
    def home = {
    	render "<h1>Real Programmers don't eat much Quiche</h1>"
    }
    
    def random = {
    	def staticAuthor = "Anonymous"
    	def staticContent = "Real Programmers don't eat much Quiche!"
    	[ author: staticAuthor, content: staticContent ]
    }
}

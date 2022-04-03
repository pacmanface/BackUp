@RestController
class HelloGroovy {

	@RequestMapping("/")
	def hello() {
		return "hello groovy"
	}
}

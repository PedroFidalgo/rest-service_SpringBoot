package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	// The @RequestMapping annotation ensures that HTTP requests to /greeting are mapped to the greeting() method.
	@RequestMapping (value = "/greeting", method = RequestMethod.GET)
	// @RequestParam binds the value of the query string parameter name into the  name parameter of the greeting() method. 
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		// This RESTful web service controller simply populates and returns a Greeting object. The object data will be written directly to the HTTP response as JSON.
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
}

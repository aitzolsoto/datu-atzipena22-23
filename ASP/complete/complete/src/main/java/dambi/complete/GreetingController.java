package dambi.complete;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name, @RequestParam(value = "lang", defaultValue = "EN") String lang) {
		if(lang.toLowerCase().equals("eu")){
			template = "Kaixo, %s!";
			return new Greeting(counter.incrementAndGet(), String.format(template, name));
		}else if(lang.toLowerCase().equals("ca")){
			template = "Hola, %s!";
			return new Greeting(counter.incrementAndGet(), String.format(template, name));
		}else{
			template = "Hello, %s";
			return new Greeting(counter.incrementAndGet(), String.format(template, name));
		}
	}
}

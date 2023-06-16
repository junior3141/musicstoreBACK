package com.musicstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MusicstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicstoreApplication.class, args);
		redirect();
	}
	
	 @RequestMapping(value = "/{path:[^\\.]*}", method = RequestMethod.GET)
	    public static String redirect() {
	        return "forward:/";
	    }

}
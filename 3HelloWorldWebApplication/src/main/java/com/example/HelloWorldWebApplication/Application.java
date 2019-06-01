package com.example.HelloWorldWebApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	@RequestMapping(value = "/",method = RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_VALUE)//produces="application/json"
	public String index(){
		return "Hello World!";
	}

	@GetMapping("/hello")
	@ResponseBody
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<Object> hello() throws URISyntaxException {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return new ResponseEntity<>("hello url",httpHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = "/hello2",method = RequestMethod.GET,
	produces = "text/html")
	public String hello2(){
		return String.format("<html><body><h1 style='color:#100fff;font-size:20em;'>" +
				"Hello World!</h1><p onmousemove='myfunction()'>This is html paragraph</p>" +
				"<script>function myfunction(){alert('Hello World');}</script></body><html>");
	}



}

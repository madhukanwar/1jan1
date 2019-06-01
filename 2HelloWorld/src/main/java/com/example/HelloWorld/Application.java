package com.example.HelloWorld;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

		System.out.println("Hello world from main method");

	}

	public static class Demo implements CommandLineRunner{

		@Override
		public void run(String... args) throws Exception {
			System.out.println("Hello world from run method");
		}


		@Bean
		public CommandLineRunner function(){
			return args -> {
				System.out.println("Hello world from function method");
			};
		}


	}


}

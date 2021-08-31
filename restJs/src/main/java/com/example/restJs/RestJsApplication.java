package com.example.restJs;

import com.example.restJs.model.Role;
import com.example.restJs.model.User;
import com.example.restJs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;


@SpringBootApplication
public class RestJsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestJsApplication.class, args);



	}

}

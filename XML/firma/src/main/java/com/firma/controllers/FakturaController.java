package com.firma.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/faktura")
public class FakturaController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String basicTest() {
		return "demo";
	}
	
	
	//TODO Model firme. Rest endpoit za dodavanje firmi
	//Slanje fakture. Controller sa enpointom. primer api/{firmaA}/faktura/{firmaB} -, id firme

}

package com.firma.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/demo")
public class FakturaController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String basicTest() {
		return "demo";
	}
	
	//TODO Srediti da ovo radit
	//TODO Model firme. Rest endpoit za dodavanje firmi, Baza.
	//Slanje fakture. Controller sa enpointom. primer api/{firmaA}/faktura/{firmaB} -, id firme

}

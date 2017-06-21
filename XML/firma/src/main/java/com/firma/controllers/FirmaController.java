package com.firma.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/firma")
public class FirmaController {

	@RequestMapping(method = RequestMethod.GET)
	public String basicTest() {
		return "firma";
	}
}

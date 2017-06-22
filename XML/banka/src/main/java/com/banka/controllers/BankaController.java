package com.banka.controllers;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/app/banka")
public class BankaController {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> hello() {
		return new ResponseEntity<String>("hello", HttpStatus.OK);

	}

}

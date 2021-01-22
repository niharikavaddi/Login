package com.Login.Controller;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.Login.Model.Admin;
import com.Login.Model.Donor;
import com.Login.Model.Requestor;
import com.Login.Service.LoginService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MainController {

	@Autowired
	private LoginService service;

	@PostMapping(value = "/loginrequestor")
	public ResponseEntity<Requestor> loginRequestor(@RequestBody Requestor requestor) throws NoSuchElementException {

		try {
			log.info("Requestor logged in");
			return new ResponseEntity<>(service.loginRequestor(requestor), HttpStatus.OK);
		} catch (InternalServerError ex) {
			throw new NoSuchElementException("Data not found");
		}
	}

	@PostMapping(value = "/logindonor")
	public ResponseEntity<Donor> loginDonor(@RequestBody Donor donor) throws NoSuchElementException {
		try {
			log.info("Donor logged in");
			return new ResponseEntity<>(service.loginDonor(donor), HttpStatus.OK);
		} catch (InternalServerError ex) {
			throw new NoSuchElementException("Data not found");
		}
	}

	@PostMapping(value = "/loginadmin")
	public ResponseEntity<Admin> loginAdmin(@RequestBody Admin admin) throws NoSuchElementException {

		try {
			log.info("Admin logged in");
			return new ResponseEntity<>(service.loginAdmin(admin), HttpStatus.OK);
		} catch (InternalServerError ex) {
			throw new NoSuchElementException("Data not found");
		}
	}

}

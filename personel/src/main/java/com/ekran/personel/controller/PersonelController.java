package com.ekran.personel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekran.personel.entity.Personel;
import com.ekran.personel.service.PersonelService;

@RestController
@RequestMapping(path = "/personels")
public class PersonelController {
	
	@Autowired
	private PersonelService personelService;
	
	@GetMapping
	public List<Personel> getAllPersonel() {
		return personelService.getAllPersonel();
	}

	@GetMapping(path = "/personelId/{personelId}")
	public Personel getSinglePersonel(@PathVariable Long personelId) {
		return personelService.getPersonelById(personelId);
	}
	
	@PostMapping
	public Personel createPersonel(@RequestBody Personel newPersonel) {
		return personelService.createPersonel(newPersonel);
	}
	
	@PutMapping(path = "/personelId/{personelId}")
	public Personel updatePersonel(@PathVariable Long personelId, @RequestBody Personel newPersonel) {
		return personelService.updatePersonel(personelId, newPersonel);
	}

	@DeleteMapping(path = "/personelId/{personelId}")
	public void deletePersonel(@PathVariable Long personelId) {
		personelService.deletePersonel(personelId);
	}
}

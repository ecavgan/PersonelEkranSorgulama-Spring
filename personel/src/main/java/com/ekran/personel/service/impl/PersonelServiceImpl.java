package com.ekran.personel.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekran.personel.entity.Personel;
import com.ekran.personel.repository.PersonelRepository;
import com.ekran.personel.service.PersonelService;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PersonelServiceImpl implements PersonelService {

	private final PersonelRepository personelRepository;

    public PersonelServiceImpl(PersonelRepository personelRepository) {
        this.personelRepository = personelRepository;
    }
	
	@Override
	public Personel getPersonelById(Long personelId) {
		return personelRepository.findById(personelId).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<Personel> getAllPersonel() {
		return personelRepository.findAll();
	}

	@Override
	public Personel createPersonel(Personel newPersonel) {
		Optional<Personel> personel = personelRepository.findById(newPersonel.getId());
		if (personel.isPresent()) {
			throw new RuntimeException("Personel with this id already exists");
		}
		
		return personelRepository.save(newPersonel);
	}

	@Override
	public Personel updatePersonel(Long personelId, Personel newPersonel)
	{
		Optional<Personel> personel = personelRepository.findById(personelId);
		
		if (personel.isPresent()) {
			Personel foundPersonel = personel.get();
			foundPersonel.setFirstName(newPersonel.getFirstName());
			foundPersonel.setLastName(newPersonel.getLastName());
			foundPersonel.setAddress(newPersonel.getAddress());
			foundPersonel.setAge(newPersonel.getAge());
			
			personelRepository.save(foundPersonel);
			return foundPersonel;
		}
		
		return null;
	}

	@Override
	public void deletePersonel(Long personelId) {
		personelRepository.deleteById(personelId);
	}
}

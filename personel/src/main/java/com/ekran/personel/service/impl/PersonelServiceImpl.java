package com.ekran.personel.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ekran.personel.dto.PersonelDTO;
import com.ekran.personel.entity.Personel;
import com.ekran.personel.repository.PersonelRepository;
import com.ekran.personel.service.PersonelService;

@Service
public class PersonelServiceImpl implements PersonelService {

	private final PersonelRepository personelRepository;
	private final ModelMapper modelMapper;
	
	public PersonelServiceImpl(PersonelRepository personelRepository, ModelMapper modelMapper) {
		this.personelRepository = personelRepository;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public PersonelDTO getPersonelById(Long personelId) {
		Optional<Personel> personel = personelRepository.findById(personelId);
		if (personel.isPresent()) {
			return modelMapper.map(personel.get(), PersonelDTO.class);
		}
		
		return null;
	}

	@Override
	public List<PersonelDTO> getAllPersonel() {
		List<Personel> personels = personelRepository.findAll();
		List<PersonelDTO> DTOs = personels.stream().map(personel -> modelMapper.map(personel, PersonelDTO.class)).collect(Collectors.toList());
		return DTOs;
	}

	@Override
	public PersonelDTO createPersonel(PersonelDTO newPersonel) {
		Optional<Personel> personel = personelRepository.findById(newPersonel.getId());
		if (personel.isPresent()) {
			throw new RuntimeException("Personel with this id already exists");
		}
		
		personelRepository.save(modelMapper.map(newPersonel, Personel.class));
		return newPersonel;
	}

	@Override
	public PersonelDTO updatePersonel(Long personelId, PersonelDTO newPersonel)
	{
		Optional<Personel> personel = personelRepository.findById(personelId);
		
		if (personel.isPresent()) {
			Personel foundPersonel = personel.get();
			foundPersonel.setFirstName(newPersonel.getFirstName());
			foundPersonel.setLastName(newPersonel.getLastName());
			foundPersonel.setAddress(newPersonel.getAddress());
			foundPersonel.setAge(newPersonel.getAge());
			
			personelRepository.save(foundPersonel);
			return modelMapper.map(foundPersonel, PersonelDTO.class);
		}
		
		return null;
	}

	@Override
	public void deletePersonel(Long personelId) {
		personelRepository.deleteById(personelId);
	}
}

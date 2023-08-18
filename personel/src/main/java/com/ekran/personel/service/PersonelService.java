package com.ekran.personel.service;

import java.util.List;

import com.ekran.personel.dto.PersonelDTO;

public interface PersonelService {
	
	PersonelDTO getPersonelById(Long personelId);	
	List<PersonelDTO> getAllPersonel();
	
	PersonelDTO createPersonel(PersonelDTO personel);
	PersonelDTO updatePersonel(Long personelId, PersonelDTO personel);
	void deletePersonel(Long personelId);
}

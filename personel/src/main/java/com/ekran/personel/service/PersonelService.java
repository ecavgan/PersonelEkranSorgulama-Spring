package com.ekran.personel.service;

import java.util.List;

import com.ekran.personel.entity.Personel;

public interface PersonelService {
	
	Personel getPersonelById(Long personelId);	
	List<Personel> getAllPersonel();
	
	Personel createPersonel(Personel personel);
	Personel updatePersonel(Long personelId, Personel personel);
	void deletePersonel(Long personelId);
}

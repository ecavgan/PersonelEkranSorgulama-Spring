package com.ekran.personel.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "personel")
@Data
public class Personel {	
	@Id
	private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private Integer age;

	@Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
    private Date createdAt;
	
	@Column(name = "last_updated_at")
    @Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
    private Date lastUpdatedAt;
	
	public Personel() {
		
	}
}

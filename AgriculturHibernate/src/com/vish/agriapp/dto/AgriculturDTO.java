package com.vish.agriapp.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="agricultur")
public class AgriculturDTO implements Serializable{
	
	@Id
	@GeneratedValue(generator="patil")
	@GenericGenerator(name="patil", strategy = "increment") 
	@Column(name="a_id")
	private int id;
	@Column(name="a_name")
	private String name;
	@Column(name="a_hector")
	private float hector;
	@Column(name="a_soiltype")
	private Agri soilType;
	
	public AgriculturDTO() {
		System.out.println("Created : "+this.getClass().getSimpleName());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getHector() {
		return hector;
	}

	public void setHector(float hector) {
		this.hector = hector;
	}

	public Agri getSoilType() {
		return soilType;
	}

	public void setSoilType(Agri soilType) {
		this.soilType = soilType;
	}

	@Override
	public String toString() {
		return "AgriculturDTO [id=" + id + ", name=" + name + ", hector=" + hector + ", soilType=" + soilType + "]";
	}
	
	
}

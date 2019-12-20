package com.vish.agriapp.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vish.agriapp.dto.AgriculturDTO;

public class AgriculturDAOimpl implements AgriculturDAO{
	public void store(AgriculturDTO dto) {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("resource/hibernate.cfg.xml");
			configuration.addAnnotatedClass(AgriculturDTO.class);
			SessionFactory sfactory = configuration.buildSessionFactory();
			Session session = sfactory.openSession();
			session.beginTransaction();
			session.save(dto);
			session.getTransaction().commit();
			session.close();
			sfactory.close();
			
			System.out.println("Data Stored Succesfully. So be Happy.");
			
		}	catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public AgriculturDTO retrieveById(int aid) {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("resource/hibernate.cfg.xml");
			configuration.addAnnotatedClass(AgriculturDTO.class);
			SessionFactory sfactory = configuration.buildSessionFactory();
			Session session = sfactory.openSession();
			session.beginTransaction();
			AgriculturDTO entity = session.get(AgriculturDTO.class, aid);
			
			session.close();
			sfactory.close();
			
			return entity;
		}	catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void updateRow(String newName,int aid) {
		try {

			Configuration configuration = new Configuration();
			configuration.configure("resource/hibernate.cfg.xml");
			configuration.addAnnotatedClass(AgriculturDTO.class);
			SessionFactory sfactory = configuration.buildSessionFactory();
			Session session = sfactory.openSession();
			session.beginTransaction();
			AgriculturDTO entity = session.get(AgriculturDTO.class, aid);
			
			if(entity != null) {
				System.out.println("Entity Founded, Now JVM able to update it.");
				entity.setName(newName);
				session.update(entity);
			}else {
				System.out.println("Entity Not Found, Use Diffrent Programming Language.");
			}
			
			session.getTransaction().commit();
			System.out.println("tranzaction commited");
			session.close();
			sfactory.close();
			System.out.println("Resources closed.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteRowById(int aid) {
		try {

			Configuration configuration = new Configuration();
			configuration.configure("resource/hibernate.cfg.xml");
			configuration.addAnnotatedClass(AgriculturDTO.class);
			SessionFactory sfactory = configuration.buildSessionFactory();
			Session session = sfactory.openSession();
			session.beginTransaction();
			AgriculturDTO removableEntity = session.load(AgriculturDTO.class, aid);
			
			if(removableEntity != null) {
				System.out.println("Entity Founded, JVM Is Great Now JVM able to update it.");
				session.delete(removableEntity);
				System.out.println("Hmmm now you are on fly, Give me Triple Party.");
			}else {
				System.out.println("Entity Not Found, Use Diffrent Programming Language.");
			}
			
			session.getTransaction().commit();
			System.out.println("tranzaction commited");
			session.close();
			sfactory.close();
			System.out.println("Resources closed.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

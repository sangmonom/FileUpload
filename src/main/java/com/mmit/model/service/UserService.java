package com.mmit.model.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.mmit.model.entity.Users;

public class UserService {
	private EntityManager em;
	public UserService(EntityManager em) {
		this.em=em;
	}
	public void save(Users u) {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		
	}
	public List<Users> findAll() {
		
		return em.createQuery("SELECT u from Users u",Users.class).getResultList();	
		}
}

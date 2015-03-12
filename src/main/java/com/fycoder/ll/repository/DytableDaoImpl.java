/*******************************************************************************
 * Copyright 2015 
 * Fycoder liuy
 * 
 *******************************************************************************/
package com.fycoder.ll.repository;

import java.util.List;
import java.util.Map;

import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;


import javax.persistence.Query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;



import com.fycoder.ll.dyentity.Tls;
import com.google.common.collect.Iterables;

public class DytableDaoImpl implements DytableDao  {
	
	@PersistenceContext
    private EntityManager em;	

	public int  mmmmAll() {
		String hql = "select name from User ";      
		String hql2="SELECT id, login_name, name, password, register_date, roles, salt  FROM yuser  ";      
		//em.createQuery(hql).getResultList();  
		//em.createNativeQuery(hql2).getResultList();
		Query query  = em.createNativeQuery(hql2);
		List  lrows= query.getResultList();
		//在 Hibernate 4.2.x的环境下，无论你原生SQL中写的是大写字母还是小写字母，返回的字段名都是大写的
		for (Object obj:lrows){
			Object[] cells = (Object[]) obj; 
			System.out.println("id = " + cells[0]);
		}

		return 5;
	}



	@Override
	public <S extends Tls> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends Tls> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Tls findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Iterable<Tls> findAll() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Iterable<Tls> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void delete(Tls entity) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void delete(Iterable<? extends Tls> entities) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	

}

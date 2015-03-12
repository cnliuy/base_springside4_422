/*******************************************************************************
 * Copyright 2015 
 * Fycoder liuy
 * 
 *******************************************************************************/
package com.fycoder.ll.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.fycoder.ll.dyentity.Tls;






//public interface DytableDao {

public interface DytableDao extends CrudRepository<Tls, Long> {
	/***
	@Modifying
	@Query("select from ?1 task where tls.id=?1")
	void selectTablesById(String  tablename);
	*/
	
}

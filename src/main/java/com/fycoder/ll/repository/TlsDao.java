/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.fycoder.ll.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.fycoder.ll.dyentity.RooTlsoooUse;
import com.fycoder.ll.dyentity.Tls;
import com.fycoder.ll.entity.Task;



public interface TlsDao extends PagingAndSortingRepository <Tls, Long> , JpaSpecificationExecutor<Tls> {
	
	Tls  findById(Long id);
	
	@Modifying
	//@Query("select tls from Tls as tls,Tl_Use as tu where tls.tableNameid = tu.tableNameid  and tu.useid=?1")	
	@Query("select tls from Tls  as tls ,RooTlsoooUse as tu where  tls.tablenameid =tu.tablenameid")
	List <Tls> findByTablenameid();
	//Page<Tls> findByTableNameid(Long id, Pageable pageRequest);

}

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
import org.springframework.data.repository.PagingAndSortingRepository;

import com.fycoder.ll.dyentity.RooTlsoooUse;
import com.fycoder.ll.entity.Task;

public interface RooTlsoooUseDao extends PagingAndSortingRepository<RooTlsoooUse, Long>, JpaSpecificationExecutor<RooTlsoooUse> {

	//	Page<RooTlsoooUse> findByUserId(Long id, Pageable pageRequest);
	//
	//	@Modifying
	//	@Query("delete from Tl_Use tu where tu.useid=?1")
	//	void deleteByUserId(Long id);
	
	//liuy add   
	//   属性  Useid
	List <RooTlsoooUse> findByUseid(Long useid );
}

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
import org.springframework.data.repository.query.Param;

import com.fycoder.ll.dyentity.RooTlsoooUse;
import com.fycoder.ll.dyentity.Tls;
import com.fycoder.ll.entity.Task;



public interface TlsDao extends PagingAndSortingRepository <Tls, Long> , JpaSpecificationExecutor<Tls> {
	
	Tls  findById(Long id);
	
//	@Modifying
//	@Query("select tls from Tls  as tls ,RooTlsoooUse as tu where  tls.tablenameid =tu.tablenameid and tu.useid=?1")
//	List <Tls> findByTablenameid(String useid, Pageable pageRequest);
	//Page<Tls> findByTableNameid(Long id, Pageable pageRequest);
	
	//@Modifying
	//@Query("select tls from Tls  as tls  where  tls.tablenameid in ?1 ")
	//@Query("select tls from Tls as tls,Tl_Use as tu where tls.tableNameid = tu.tableNameid  and tu.useid=?1")	
	//Page<Tls> findByTablenameid( String tablenameid_charset,Pageable pageRequest );
	
	//@Modifying
	//@Query("select tls from Tls  as tls  where  tls.tablenameid = ?1 ")
	//@Query("select tls from Tls as tls,Tl_Use as tu where tls.tableNameid = tu.tableNameid  and tu.useid=?1")	
	
	//本地查询
	//@Query(value="select tls from Tls  as tls  where  tls.tablenameid = :nn ",nativeQuery=true)
	//@Modifying
	
	/**
	 * @Query与 @Modifying 执行更新操作 
	 * 
	 * http://blog.csdn.net/shuimumu/article/details/7676425
	 * Spring Data JPA 
	 * 
	 * http://www.tuicool.com/articles/m6V7nqB
	 * 
	 * 
	 *  findByTablenameidIn
	 *  
	 * */	
	
	////@Query(value="select tls  from Tls  as tls  where  tls.tablenameid = :nn ")
	//@Query("select tls from Tls as tls where tls.tablenameid =?1 ")
	//Page<Tls> findByTablenameid(String tablenameid_charset,Pageable pageRequest );
	
	
	//--空置报错  @Query("select tls from Tls as tls where tls.id in ?1 ")
	Page<Tls> findByIdIn(List <Long> tablenameid_charset,Pageable pageRequest );
	
	//Page<Tls> findByTablenameid(@Param String tablenameid_charset,Pageable pageRequest );
	

}

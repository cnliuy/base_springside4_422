/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.fycoder.ll.service.tls;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fycoder.ll.dyentity.Tls;
import com.fycoder.ll.entity.Task;
import com.fycoder.ll.repository.DytableDao;
import com.fycoder.ll.repository.DytableDaoImpl;
import com.fycoder.ll.repository.TaskDao;
import com.fycoder.ll.repository.TlsDao;

import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;
import org.springside.modules.persistence.SearchFilter.Operator;

// Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class TlsService {

	//private TaskDao taskDao;	
	
	@Autowired
	private TlsDao tlsDao;

//	@Test
//	public void findTasksByUserId() throws Exception {
//		int  a= 0 ;
//		for(int i = 0 ;i<1000000 ;i++){
//			a = dytableDaoImpl.mmmmAll();
//			System.out.println(i);
//		}
//		assertThat(a).isEqualTo(5);
//		
//	}		

	public TlsDao getTlsDao() {
		return tlsDao;
	}

	public void setTlsDao(TlsDao tlsDao) {
		this.tlsDao = tlsDao;
	}


	public Tls getTls(Long id) {
		return tlsDao.findOne(id);
	}

	public void saveTls(Tls entity) {
		tlsDao.save(entity);
	}

	public void deleteTls(Long id) {
		tlsDao.delete(id);
	}

	public List<Tls> getAllTask() {
		return (List<Tls>) tlsDao.findAll();
	}

	public Page<Tls> getUserTls(Long userId, int pageNumber, int pageSize,
			String sortType) {
		//param : Map<String, Object> searchParams
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		//Specification<Tls> spec = buildSpecification(userId, searchParams);		
		//select h from Hytxbz as h,Tgbzk as t where h.hytxbzid=t.hytxbzid and t.bztgid=:bztgid
		//return tlsDao.findAll(spec, pageRequest);
		//return tlsDao.findByUserId(userId,pageRequest);	
		return  null ;
	}
	

	/**
	 * 创建分页请求.
	 */
	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = null;
		if ("auto".equals(sortType)) {
			sort = new Sort(Direction.DESC, "id");
		} else if ("title".equals(sortType)) {
			sort = new Sort(Direction.ASC, "title");
		}

		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}

	/**
	 * 创建动态查询条件组合.
	 */
//	private Specification<Task> buildSpecification(Long userId, Map<String, Object> searchParams) {
//		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
//		filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
//		Specification<Task> spec = DynamicSpecifications.bySearchFilter(filters.values(), Task.class);
//		return spec;
//	}
	
	/**
	 * 创建动态查询条件组合.
	 */
//	private Specification<Tls> buildSpecification(Long userId, Map<String, Object> searchParams) {
//		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
//		filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
//		Specification<Tls> spec = DynamicSpecifications.bySearchFilter(filters.values(), Tls.class);
//		return spec;
//	}


}

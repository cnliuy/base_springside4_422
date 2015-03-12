/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.fycoder.ll.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;

import com.fycoder.ll.dyentity.Tls;

import org.springside.modules.test.spring.SpringTransactionalTestCase;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TlsDaoTest extends SpringTransactionalTestCase {

	@Autowired
	private TlsDao tlsDao;

	@Test
	public void findTasksByUserId() throws Exception {
		
		//Page<Tls> tls = tlsDao.findByTableNameid(2L, new PageRequest(0, 100, Direction.ASC, "id"));
		//Page<Tls> tls = tlsDao.findByTableNameid();
		List <Tls> tls = tlsDao.findByTablenameid();
		
		assertThat(tls.size()).isEqualTo(0);
		//assertThat(tls.getContent()).hasSize(5);
		//assertThat(tls.getContent().get(0).getId()).isEqualTo(1);

//		tls = tlsDao.findByUserId(99999L, new PageRequest(0, 100, Direction.ASC, "id"));
//		assertThat(tls.getContent()).isEmpty();
//		assertThat(tls.getContent()).isEmpty();
	}
}
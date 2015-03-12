/*******************************************************************************
 *  
 * mytestclass
 * 
 *******************************************************************************/
package com.fycoder.ll.repository;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import com.fycoder.ll.entity.Task;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class DytableDaoTest extends SpringTransactionalTestCase {

	@Autowired
	private DytableDaoImpl dytableDaoImpl;

	@Test
	public void findTasksByUserId() throws Exception {
		int  a= 0 ;
		for(int i = 0 ;i<1000000 ;i++){
			a = dytableDaoImpl.mmmmAll();
			System.out.println(i);
		}
		assertThat(a).isEqualTo(5);
		
	}
}

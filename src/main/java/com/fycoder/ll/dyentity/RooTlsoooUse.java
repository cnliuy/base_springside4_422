package com.fycoder.ll.dyentity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.fycoder.ll.entity.IdEntity;

/**
 * 关系表   tls 和  use 对应的关系
 * 
 * */

@Entity
@Table(name = "r_tls_use")
public class RooTlsoooUse extends IdEntity {
	
	private String  tablenameid; // Tls对象的
	
	private String  useid; // Use对象的
	

	
	public String getTablenameid() {
		return tablenameid;
	}

	public void setTablenameid(String tablenameid) {
		this.tablenameid = tablenameid;
	}

	public String getUseid() {
		return useid;
	}

	public void setUseid(String useid) {
		this.useid = useid;
	}


	
	
}

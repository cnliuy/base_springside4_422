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
	
	private Long  tlsid; // Tls对象的
	
	private Long  useid; // Use对象的

	public Long getTlsid() {
		return tlsid;
	}

	public void setTlsid(Long tlsid) {
		this.tlsid = tlsid;
	}

	public Long getUseid() {
		return useid;
	}

	public void setUseid(Long useid) {
		this.useid = useid;
	}
	
}

package com.fycoder.ll.repository;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.relational.Table;

//动态对应表单的    测试的      可删 。
public class ReportDBApi {
	 private SessionFactory sessionFactory = null;
	  public ReportDBApi(){
	    createSession();
	  }

	  public void createSession(){
	    Date date = new Date();
	    SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMdd");
	    String now_time = simpledateformat.format(date);
	    String tablename = "TBL_REPORT_STATUS_20050707";
	    tablename = "TBL_REPORT_STATUS_" + now_time;
	    try {
	      //Configuration cfg = new Configuration().addClass(cn.sports.vas.sms.unicom.TblReportStatus.class).configure();

	      //Table table = cfg.getClassMapping(TblReportStatus.class).getTable();
	      //table.setName(tablename);
	      //cfg.getClassMapping(TblReportStatus.class).setTable(table);
	      //sessionFactory  = cfg.buildSessionFactory();
	    }
	    catch (MappingException ex) {
	      ex.printStackTrace();
	    }catch (HibernateException ex) {
	      ex.printStackTrace();
	    }
	  }
//
//	  public void insertPO(TblReportStatus po) throws HibernateException {
//	    Session session = sessionFactory.openSession();
//	    Transaction tx = session.beginTransaction();
//	    session.save(po);
//	    tx.commit();
//	    session.close();
//	  }
//
//	  public void closeSession() throws HibernateException {
//	    sessionFactory.close();
//	  }
//	}
}

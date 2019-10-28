package com.sony.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.sony.model.entity.SkillSet;

@Repository
public class SkillSetDAOImpl implements SkillSetDAO {

	private static SessionFactory factory;
	
	public SkillSetDAOImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public Integer addSkillSet(SkillSet skillset) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer skillId = null;

		try {
			tx = session.beginTransaction();
			skillId = (Integer) session.save(skillset);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return skillId;
	}

	public List<SkillSet> getAllSkills() {
		Session session = factory.openSession();
		List<SkillSet> skillset = new ArrayList<SkillSet>();

		try {
			skillset = session.createQuery("FROM SkillSet").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return skillset;
	}

}
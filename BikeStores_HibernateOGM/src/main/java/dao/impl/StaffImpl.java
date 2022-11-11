package dao.impl;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import dao.StaffDao;
import model.Staff;
import util.HibernateUtil;

public class StaffImpl implements StaffDao{ 
	protected OgmSessionFactory sessionFactory;

	public StaffImpl() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}

	public boolean addStaff(Staff sff) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(sff);
			tr.commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean updateStaff(Staff sff) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(sff);
			tr.commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}

		return false;
	}

	public boolean deleteStaff(long id) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.delete(session.find(Staff.class, id));
			tr.commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}

		return false;
	}

	public Staff getStaff(long id) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			Staff sff = session.find(Staff.class, id);
			tr.commit();

			return sff;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}

		return null;
	}

	
	
}

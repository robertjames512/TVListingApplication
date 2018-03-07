package com.james.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.james.spring.model.TvShow;

@Repository
public class TvShowDAOImpl implements TvShowDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(TvShowDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addTvShow(TvShow show) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(show);
		logger.info(show + " was saved successfully");
	}

	@Override
	public void updateTvShow(TvShow show) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(show);
		logger.info(show + " was updated successfully");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TvShow> listTvShows() {
		Session session = this.sessionFactory.getCurrentSession();
		List<TvShow> tvshowList = session.createQuery("from TvShow").list();
		for(TvShow show : tvshowList){
			logger.info("TV show Listing:" + show);
		}
		return tvshowList;
	}

	@Override
	public TvShow getTvShowById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		TvShow show = (TvShow) session.load(TvShow.class, new Integer(id));
		logger.info(show + " loaded successfully");
		return show;
	}

	@Override
	public void removeTvShow(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		TvShow show = (TvShow) session.load(TvShow.class, new Integer(id));
		if(null != show){
			session.delete(show);
		}
		logger.info("TV show " + show + " was deleted successfully");
	}

}

package com.james.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.james.spring.dao.TvShowDAO;
import com.james.spring.model.TvShow;

@Service
public class TvShowServiceImpl implements TvShowService {
	
	private TvShowDAO tvshowDAO;

	public void setTvShowDAO(TvShowDAO tvshowDAO) {
		this.tvshowDAO = tvshowDAO;
	}

	@Override
	@Transactional
	public void addTvShow(TvShow show) {
		this.tvshowDAO.addTvShow(show);
	}

	@Override
	@Transactional
	public void updateTvShow(TvShow show) {
		this.tvshowDAO.updateTvShow(show);
	}

	@Override
	@Transactional
	public List<TvShow> listTvShow() {
		return this.tvshowDAO.listTvShows();
	}

	@Override
	@Transactional
	public TvShow getTvShowById(int id) {
		return this.tvshowDAO.getTvShowById(id);
	}

	@Override
	@Transactional
	public void removeTvShow(int id) {
		this.tvshowDAO.removeTvShow(id);
	}

}

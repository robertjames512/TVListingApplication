package com.james.spring.dao;

import java.util.List;

import com.james.spring.model.TvShow;

public interface TvShowDAO {

	public void addTvShow(TvShow show);
	public void updateTvShow(TvShow show);
	public List<TvShow> listTvShows();
	public TvShow getTvShowById(int id);
	public void removeTvShow(int id);
}

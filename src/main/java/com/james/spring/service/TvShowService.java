package com.james.spring.service;

import java.util.List;

import com.james.spring.model.TvShow;

public interface TvShowService {

	public void addTvShow(TvShow show);
	public void updateTvShow(TvShow show);
	public List<TvShow> listTvShow();
	public TvShow getTvShowById(int id);
	public void removeTvShow(int id);
	
}

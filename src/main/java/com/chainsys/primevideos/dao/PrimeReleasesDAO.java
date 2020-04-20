package com.chainsys.primevideos.dao;

import java.util.List;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.PrimeRelease;

public interface PrimeReleasesDAO {

	public PrimeRelease findOneMovieDetails(int id) throws DbException;

	public void saveMovies(PrimeRelease pr) throws DbException;

	public List<PrimeRelease> findMoviesSearch(PrimeRelease primeRelease) throws DbException;

	public List<PrimeRelease> findlanguages() throws DbException;
	
	public List<PrimeRelease> findGenres() throws DbException;
	
	public List<PrimeRelease> findImdbRating() throws DbException;
}


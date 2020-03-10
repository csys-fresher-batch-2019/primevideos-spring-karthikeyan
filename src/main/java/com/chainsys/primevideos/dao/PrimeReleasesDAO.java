package com.chainsys.primevideos.dao;

import java.util.List;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.PrimeReleases;

public interface PrimeReleasesDAO {

	public PrimeReleases findOneMovieDetails(int id) throws DbException;

	public void saveMovies(PrimeReleases pr) throws DbException;

	public List<PrimeReleases> findMoviesSearch(PrimeReleases PrimeRelease) throws DbException;

}

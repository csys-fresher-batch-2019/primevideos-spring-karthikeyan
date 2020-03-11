package com.chainsys.primevideos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.primevideos.dao.PrimeReleasesDAO;
import com.chainsys.primevideos.dao.imp.PrimeReleasesDAOImp;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.PrimeRelease;

@Service
public class ServiceReleases {

	private PrimeReleasesDAO prime = new PrimeReleasesDAOImp();

	public PrimeRelease findOneMovieDetails(int id) throws DbException {
		return prime.findOneMovieDetails(id);
	}

	public void saveMovies(PrimeRelease pr) throws DbException {
		prime.saveMovies(pr);
	}

	public List<PrimeRelease> findMoviesSearch(PrimeRelease PrimeRelease) throws DbException {
		return prime.findMoviesSearch(PrimeRelease);
	}

}

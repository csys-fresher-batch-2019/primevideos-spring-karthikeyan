package com.chainsys.primevideos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.primevideos.dao.PrimeReleasesDAO;
import com.chainsys.primevideos.dao.imp.PrimeReleasesDAOImp;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.exception.ServiceException;
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

	public List<PrimeRelease> findMoviesSearch(PrimeRelease primeRelease) throws DbException {
		return prime.findMoviesSearch(primeRelease);
	}

	public List<PrimeRelease> findlanguages() throws ServiceException{
		List<PrimeRelease> ls = new ArrayList<>();
		try {
			ls = prime.findlanguages();
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return ls;
	}
	
	public List<PrimeRelease> findGenres() throws ServiceException{
		List<PrimeRelease> ls = new ArrayList<>();
		try {
			ls = prime.findGenres();
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return ls;
	
	}
	
	public List<PrimeRelease> findImdbRating() throws ServiceException{
		List<PrimeRelease> ls = new ArrayList<>();
		try {
			ls = prime.findImdbRating();
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return ls;
	}
	
	

}

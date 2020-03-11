package com.chainsys.primevideos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.primevideos.dao.imp.PrimeReleasesDAOImp;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.PrimeRelease;

@RestController
@RequestMapping("api")
public class PrimeReleasesController {
	
	@GetMapping("/findOneMovieDetails")
	public PrimeRelease findOneMovieDetails(int id) throws DbException{
		PrimeReleasesDAOImp releases = new PrimeReleasesDAOImp();
		@SuppressWarnings("unused")
		PrimeRelease release = new PrimeRelease();
		return release = releases.findOneMovieDetails(id);
		
	}
	
	@GetMapping("/findMoviesSearch")
	public List<PrimeRelease> findMoviesSearch(PrimeRelease PrimeRelease) throws  DbException, ClassNotFoundException {
		PrimeReleasesDAOImp releases = new PrimeReleasesDAOImp();
		@SuppressWarnings("unused")
		PrimeRelease release = new PrimeRelease();
		return releases.findMoviesSearch(PrimeRelease);
	}

}

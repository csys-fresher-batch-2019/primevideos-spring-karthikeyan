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
	PrimeReleasesDAOImp releases = new PrimeReleasesDAOImp();

	@GetMapping("/findOneMovieDetails")
	public PrimeRelease findOneMovieDetails(int id) throws DbException {
		return releases.findOneMovieDetails(id);

	}

	@GetMapping("/findMoviesSearch")
	public List<PrimeRelease> findMoviesSearch(PrimeRelease primeRelease) throws DbException, ClassNotFoundException {
		return releases.findMoviesSearch(primeRelease);
	}

}

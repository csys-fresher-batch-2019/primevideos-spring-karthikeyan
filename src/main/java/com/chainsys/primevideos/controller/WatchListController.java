package com.chainsys.primevideos.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.primevideos.dao.imp.WatchListDAOImpl;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.PrimeReleases;

@RestController
@RequestMapping("api")
public class WatchListController {
	@GetMapping("/watchedMovies")
	public ArrayList<PrimeReleases> list(String mailId) throws DbException {
		WatchListDAOImpl movie = new WatchListDAOImpl();
		ArrayList<PrimeReleases> movies = new ArrayList<>();
		movies = movie.findOneWatched(mailId);
		return movies;

	}
	@GetMapping("/watchLaterMovies")
	public ArrayList<PrimeReleases> list1(String mailId) throws DbException {
		WatchListDAOImpl movie = new WatchListDAOImpl();
		ArrayList<PrimeReleases> movies = new ArrayList<>();
		movies = movie.findOneWatchLater(mailId);
		return movies;

	}

}

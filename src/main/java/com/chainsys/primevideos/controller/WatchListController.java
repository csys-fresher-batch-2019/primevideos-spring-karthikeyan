package com.chainsys.primevideos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.primevideos.dao.imp.WatchListDAOImpl;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.PrimeRelease;

@RestController
@RequestMapping("api")
public class WatchListController {
	@PostMapping("/saveLikes")
	public void saveLikes(@RequestParam("mailId") String mailId, @RequestParam("primeId") int primeId) {
		WatchListDAOImpl movie = new WatchListDAOImpl();
		try {
			movie.saveLikes(mailId, primeId);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

	@PostMapping("/saveDislikes")
	public void saveDislikes(@RequestParam("mailId") String mailId, @RequestParam("primeId") int primeId) {
		WatchListDAOImpl movie = new WatchListDAOImpl();
		try {
			movie.saveDislikes(mailId, primeId);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

	@PostMapping("/saveViewerRating")
	public void saveViewerRating(@RequestParam("mailId") String mailId, @RequestParam("primeId") int primeId,
			@RequestParam("viewerRating") int viewerRating) {
		WatchListDAOImpl movie = new WatchListDAOImpl();
		try {
			movie.saveViewerRating(mailId, primeId, viewerRating);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/updateWatched")
	public boolean updateWatched(String mailId, int primeId, int decide) {
		WatchListDAOImpl movie = new WatchListDAOImpl();
		boolean result = false;
		try {
			result = movie.updateWatched(mailId, primeId, decide);
		} catch (DbException e) {
			e.printStackTrace();
		}
		return result;

	}

	@GetMapping("/watchedMovies")
	public List<PrimeRelease> findOneWatched(String mailId) throws DbException {
		WatchListDAOImpl movie = new WatchListDAOImpl();
		List<PrimeRelease> movies = new ArrayList<>();
		movies = movie.findOneWatched(mailId);
		return movies;

	}

	@GetMapping("/watchLaterMovies")
	public List<PrimeRelease> findOneWatchLater(String mailId) throws DbException {
		WatchListDAOImpl movie = new WatchListDAOImpl();
		List<PrimeRelease> movies = new ArrayList<>();
		movies = movie.findOneWatchLater(mailId);
		return movies;

	}

	@GetMapping("/existWatchList")
	public boolean existWatchList(String mailID, int primeId) throws DbException {
		WatchListDAOImpl movie = new WatchListDAOImpl();
		boolean result = movie.existWatchList(mailID, primeId);
		return result;
	}
}

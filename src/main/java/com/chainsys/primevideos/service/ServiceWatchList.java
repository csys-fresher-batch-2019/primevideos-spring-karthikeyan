package com.chainsys.primevideos.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.chainsys.primevideos.dao.WatchListDAO;
import com.chainsys.primevideos.dao.imp.WatchListDAOImpl;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.PrimeReleases;
@Service
public class ServiceWatchList {
	private WatchListDAO watch = new WatchListDAOImpl();
	
	public void saveLikes(String mailId, int primeId) throws DbException{
		watch.saveLikes(mailId, primeId);
	}

	public void saveDislikes(String mailId, int primeId) throws DbException{
		watch.saveDislikes(mailId, primeId);
	}

	public void saveViewerRating(String mailID, int primeId, int viewerRating) throws DbException{
		watch.saveViewerRating(mailID, primeId, viewerRating);
	}

	public boolean updateWatched(String mailId, int primeId, int decide) throws DbException{
		return watch.updateWatched(mailId, primeId, decide);
	}

	public ArrayList<PrimeReleases> findOneWatched(String MailId) throws DbException{
		return watch.findOneWatched(MailId);
	}

	public ArrayList<PrimeReleases> findOneWatchLater(String MailId) throws DbException{
		return watch.findOneWatchLater(MailId);
	}


}

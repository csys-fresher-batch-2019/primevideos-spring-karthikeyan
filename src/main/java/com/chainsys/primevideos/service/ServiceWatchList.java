package com.chainsys.primevideos.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.chainsys.primevideos.dao.WatchListDAO;
import com.chainsys.primevideos.dao.imp.WatchListDAOImp;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.PrimeReleases;
@Service
public class ServiceWatchList {
	private WatchListDAO watch = new WatchListDAOImp();
	
	public void likes(String mailId, int primeId) throws DbException{
		watch.likes(mailId, primeId);
	}

	public void dislikes(String mailId, int primeId) throws DbException{
		watch.dislikes(mailId, primeId);
	}

	public void viewerRating(String mailID, int primeId, int viewerRating) throws DbException{
		watch.viewerRating(mailID, primeId, viewerRating);
	}

	public boolean updateWatched(String mailId, int primeId, int decide) throws DbException{
		return watch.updateWatched(mailId, primeId, decide);
	}

	public ArrayList<PrimeReleases> select(String MailId) throws DbException{
		return watch.select(MailId);
	}

	public ArrayList<PrimeReleases> select1(String MailId) throws DbException{
		return watch.select1(MailId);
	}

	public boolean watched(String mailID, int primeId) throws DbException{
		return watch.watched(mailID, primeId);
	}
}

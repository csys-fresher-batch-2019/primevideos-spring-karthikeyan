package com.chainsys.primevideos.dao;

import java.util.ArrayList;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.PrimeReleases;

public interface WatchListDAO {
	
	void saveLikes(String mailId, int primeId) throws DbException;
	
	void saveDislikes(String mailId, int primeId) throws DbException;
	
	void saveViewerRating(String mailID,int primeId,int viewerRating) throws DbException;

	boolean updateWatched(String mailId, int primeId, int decide) throws DbException;
	
	ArrayList<PrimeReleases> findOneWatched(String MailId) throws DbException;
	
	ArrayList<PrimeReleases> findOneWatchLater(String MailId) throws DbException;
	
}

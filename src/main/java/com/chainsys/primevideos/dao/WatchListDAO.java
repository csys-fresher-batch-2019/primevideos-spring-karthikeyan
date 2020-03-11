package com.chainsys.primevideos.dao;

import java.util.List;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.PrimeRelease;

public interface WatchListDAO {
	
	void saveLikes(String mailId, int primeId) throws DbException;
	
	void saveDislikes(String mailId, int primeId) throws DbException;
	
	void saveViewerRating(String mailID,int primeId,int viewerRating) throws DbException;

	boolean updateWatched(String mailId, int primeId, int decide) throws DbException;
	
	List<PrimeRelease> findOneWatched(String MailId) throws DbException;
	
	List<PrimeRelease> findOneWatchLater(String MailId) throws DbException;
	
}

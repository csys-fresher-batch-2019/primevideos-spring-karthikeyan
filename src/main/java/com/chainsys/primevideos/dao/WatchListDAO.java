package com.chainsys.primevideos.dao;

import java.util.ArrayList;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.PrimeReleases;

public interface WatchListDAO {
	
	void likes(String mailId, int primeId) throws DbException;
	
	void dislikes(String mailId, int primeId) throws DbException;
	
	void viewerRating(String mailID,int primeId,int viewerRating) throws DbException;

	boolean updateWatched(String mailId, int primeId, int decide) throws DbException;
	
	ArrayList<PrimeReleases> select(String MailId) throws DbException;
	
	ArrayList<PrimeReleases> select1(String MailId) throws DbException;
	
	boolean watched(String mailID, int primeId) throws DbException;
}

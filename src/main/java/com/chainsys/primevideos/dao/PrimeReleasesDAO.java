package com.chainsys.primevideos.dao;

import java.util.ArrayList;
import java.util.List;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.method.PrimeReleases;

public interface PrimeReleasesDAO {

	
	
	ArrayList<PrimeReleases> getSearchMovies(String sql) throws DbException;
	
	
	ArrayList<PrimeReleases> getDetails(int id) throws DbException;

	List<PrimeReleases> list1() throws DbException;

	List<PrimeReleases> list2() throws DbException;
	
	List<PrimeReleases> list3() throws DbException;
	
	List<PrimeReleases> list4() throws DbException;

}

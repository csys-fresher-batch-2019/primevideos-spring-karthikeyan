package com.chainsys.primevideos.dao;

import java.util.ArrayList;
import java.util.List;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.PrimeReleases;

public interface PrimeReleasesDAO {

	
	
	public ArrayList<PrimeReleases> getSearchMovies(String sql) throws DbException;	
	
	public ArrayList<PrimeReleases> getDetails(int id) throws DbException;

	public List<PrimeReleases> powerSearchMethod(String sql) throws DbException;
	
	public ArrayList<PrimeReleases> list(String sqlq) throws DbException;
	
	public ArrayList<PrimeReleases> list1() throws DbException;

	public ArrayList<PrimeReleases> list2() throws DbException;
	
	public ArrayList<PrimeReleases> list3() throws DbException;
	
	public ArrayList<PrimeReleases> list4() throws DbException;
	
	public List<PrimeReleases> select() throws DbException;
	
	public void insertMovies(PrimeReleases pr) throws DbException;
	
	public List<PrimeReleases> powerServletSearchMethod(PrimeReleases PrimeRelease) throws DbException;

	public  List<PrimeReleases> completeSearch(String sql) throws DbException;
}

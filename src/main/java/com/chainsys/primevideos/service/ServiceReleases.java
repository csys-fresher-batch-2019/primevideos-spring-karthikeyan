package com.chainsys.primevideos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.primevideos.dao.PrimeReleasesDAO;
import com.chainsys.primevideos.dao.imp.PrimeReleasesDAOImp;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.PrimeReleases;
@Service
public class ServiceReleases {
	
	
	private PrimeReleasesDAO prime = new PrimeReleasesDAOImp();

	public ArrayList<PrimeReleases> getSearchMovies(String sql) throws DbException {
		return prime.getSearchMovies(sql);
	}

	public ArrayList<PrimeReleases> getDetails(int id) throws DbException {
		return prime.getDetails(id);
	}

	public ArrayList<PrimeReleases> list1() throws DbException {
		return prime.list1();
	}

	public ArrayList<PrimeReleases> list2() throws DbException {
		return prime.list2();
	}

	public ArrayList<PrimeReleases> list3() throws DbException {
		return prime.list3();
	}

	public ArrayList<PrimeReleases> list4() throws DbException {
		return  prime.list4();
	}

	public List<PrimeReleases> powerSearchMethod(String sql) throws DbException {
		return  prime.powerSearchMethod(sql);
	}

	public List<PrimeReleases> list(String sqlq) throws DbException {
		return  prime.list(sqlq);
	}

	public List<PrimeReleases> select() throws DbException {
		return  prime.select();
	}

	public void insertMovies(PrimeReleases pr) throws DbException {
		 prime.insertMovies(pr);
	}
	public List<PrimeReleases> powerServletSearchMethod(PrimeReleases PrimeRelease) throws DbException{
		return  prime.powerServletSearchMethod(PrimeRelease);
	}
	public  List<PrimeReleases> completeSearch(String sql) throws DbException {
		return prime.completeSearch(sql);
	}
	
}

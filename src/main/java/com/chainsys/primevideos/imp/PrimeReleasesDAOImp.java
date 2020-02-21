package com.chainsys.primevideos.imp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.primevideos.connection.TestConnection;
import com.chainsys.primevideos.dao.PrimeReleasesDAO;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.exception.InfoMessages;
import com.chainsys.primevideos.logger.Logger;
import com.chainsys.primevideos.method.PrimeReleases;

public class PrimeReleasesDAOImp implements PrimeReleasesDAO {
	static Logger logger = Logger.getInstance();


	private static void printLocal() {
		logger.info("Prime Id   Name of Video");
	}

	
	public ArrayList<PrimeReleases> getSearchMovies(String sql) throws DbException {
		return commonCall(sql);
		
	}

	public List<PrimeReleases> powerSearchMethod(String sql) throws DbException {
		
		return commonCall(sql);
	}

	private static ArrayList<PrimeReleases> commonCall(String sql) throws DbException {
		try(Connection con = TestConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);){
		try(ResultSet rs = pst.executeQuery();){
		ArrayList<PrimeReleases> l = new ArrayList<>();
		while(rs.next())
		{
			PrimeReleases at =new PrimeReleases();
			int a=rs.getInt(1);
			String b=rs.getString(2);
			int c = rs.getInt(3);
			String d = rs.getString(4);
			int e =rs.getInt(5);
			int f = rs.getInt(6);
			logger.info(a+"      "+b);
			at.setPrimeId(a);
			at.setNameofVideo(b);
			at.setImdbRating(c);
			at.setGenre(d);
			at.setTlikes(e);
			at.setTdislikes(f);
			l.add(at);
		}
		return l;
		}
		}
		catch (SQLException e1) {
			throw new DbException(InfoMessages.VIEWVIDEO);
		} 
		 catch (Exception e1) {
				throw new DbException(InfoMessages.CONNECTION);
			}
	}
	
	public ArrayList<PrimeReleases> getDetails(int id) throws DbException
	{
		
		String sql ="Select * from prime_releases where prime_id = ?";
		try(Connection con = TestConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);	){
		pst.setInt(1,id);
		ArrayList<PrimeReleases> list = new ArrayList<>();
		try(ResultSet rs = pst.executeQuery();){			
		rs.next();
		int a = rs.getInt(1);
		int b = rs.getInt(2);
		String c = rs.getString(3);
		String d = rs.getString(4);
		int e = rs.getInt(5);
		int f = rs.getInt(6);
		String g = rs.getString(7);
		String h = rs.getString(8);
		String i = rs.getString(9);
		Date j = rs.getDate(10);
		Date k = rs.getDate(11);
		int m = rs.getInt(12);
		String n = rs.getString(13);
		String o = rs.getString(14);
		PrimeReleases ad  =new PrimeReleases();
		System.out.println(sql);
		ad.setPrimeId(a);
		ad.setCategoryId(b);
		ad.setNameofVideo(c);
		ad.setGenre(d);
		ad.setSeason(e);
		ad.setTotalEpisodes(f);
		ad.setAudioLanguages(g);
		ad.setSubtitleLanguages(h);
		ad.setDirector(i);		
		ad.setReleaseDate(j.toLocalDate());
		ad.setPrimereleaseDate(k.toLocalDate());
		ad.setBoxofficecollectionuinmillions(m);
		ad.setCasting(n);
		ad.setDescriptionofvideo(o);
		list.add(ad);
		logger.info(ad);
		return list;
			}	}
		catch (SQLException e1) {
			throw new DbException(InfoMessages.VIEWVIDEO);
		} 
		 catch (Exception e1) {
				e1.printStackTrace();
			}
		return null;
		}
	
	
	public List<PrimeReleases> list(String sqlq) throws DbException{
		String sql = sqlq;
		return commonCall(sql);
	}
	public ArrayList<PrimeReleases> list1() throws DbException {
		String sql = "select prime_id,name_of_video from prime_releases  where ROWNUM<=5  order by release_date desc";
		return commonCall(sql);
		}
	public ArrayList<PrimeReleases> list2() throws DbException {
		String sql = "select prime_id,name_of_video,imdb_rating,genre,tlikes,tdislikes from prime_releases  where ROWNUM<=10  order by imdb_rating desc";
		return commonCall(sql);
		}
	public ArrayList<PrimeReleases> list3() throws DbException {
		String sql = "select prime_id,name_of_video,imdb_rating,genre,tlikes,tdislikes from prime_releases  where originals = 1 and ROWNUM<=10  order by imdb_rating desc";
		return commonCall(sql);			
		}
	public ArrayList<PrimeReleases> list4() throws DbException {
		String sql = "select prime_id,name_of_video from prime_releases  where ROWNUM<=5  order by prime_release_date desc";
		return commonCall(sql);	
		}
	public  List<PrimeReleases> completeSearch(String sql) throws DbException {
		return commonCall(sql);
	}
	public  List<PrimeReleases> select() throws DbException {
		String sql = "select prime_id,name_of_video,imdb_rating,genre from prime_releases";
		try(Connection con = TestConnection.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);){
				try(ResultSet rs = pst.executeQuery();){
				ArrayList<PrimeReleases> l = new ArrayList<>();
				while(rs.next())
				{
					PrimeReleases at =new PrimeReleases();
					int a=rs.getInt(1);
					String b=rs.getString(2);
					int c = rs.getInt(3);
					String d = rs.getString(4);
					at.setPrimeId(a);
					at.setNameofVideo(b);
					at.setImdbRating(c);
					at.setGenre(d);
					l.add(at);
				}
				return l;
				}
				}
				catch (SQLException e1) {
					throw new DbException(InfoMessages.VIEWVIDEO);
				} 
				 catch (Exception e1) {
						throw new DbException(InfoMessages.CONNECTION);
					}
			}
	
	public List<PrimeReleases> powerServletSearchMethod(PrimeReleases PrimeRelease) throws DbException {
		String term = PrimeRelease.getNameofVideo();
		int categorys = PrimeRelease.getCategoryId();
		int imdbrating  = PrimeRelease.getImdbRating();
		String language = PrimeRelease.getAudioLanguages();
		String director = PrimeRelease.getDirector();
		String actor = PrimeRelease.getCasting();
		String genre = PrimeRelease.getGenre();
		boolean originals = PrimeRelease.isOriginals();
		String sql = "select prime_id,name_of_video,imdb_rating,genre,tlikes,tdislikes from prime_releases where ";
		int d = 0;
		if(term.length()!=0)
		{
				sql = sql +"name_of_video Like '%"+term+"%'";
				d+=1;
			
		}
		if(categorys!=0)
		{ 
			if (d!=0)
			{
				sql = sql +" and ";
			}
				sql = sql+" category_id = "+categorys+"";
				d+=1;
		}
		if(imdbrating!=0)
		{
			if (d!=0)
			{
				sql = sql +" and ";
			}
				sql = sql+" imdb_rating = "+imdbrating+"";
				d+=1;
		}
		if(language.length()!=0)
		{
			if (d!=0)
			{
				sql = sql +" and ";
			}
				sql = sql+" audio_languages = '"+language+"'";
				d+=1;
		}
		if(director.length()!=0)
		{
			if (d!=0)
			{
				sql = sql +" and ";
			}
				sql = sql+"director Like '%"+director+"%'";
				d+=1;
		}
		if(actor.length()!=0)
		{
			if (d!=0)
			{
				sql = sql +" and ";
			}
				sql = sql+"actor Like '%"+actor+"%'";
				d+=1;
		}
		if(genre.length()!=0)
		{
			if (d!=0)
			{
				sql = sql +" and ";
			}
				sql = sql+" genre = '"+genre+"'";
				d+=1;
		}
		if(originals)
		{
			if (d!=0)
			{
				sql = sql +" and ";
			}
				sql = sql+" originals = 1 ";
				d+=1;
		}
		
		if (d==0)
		{
			sql = "select prime_id,name_of_video,imdb_rating,genre,tlikes,tdislikes from prime_releases";
		}
		
		System.out.println(sql);		
		return  commonCall(sql);

	

	
		
	}
	public void insertMovies(PrimeReleases pr) throws DbException {
		String sql = "insert into prime_releases(prime_id,name_of_video,category_id,genre,audio_languages,director,casting,description_of_video,imdb_rating,originals) values (?,?,?,?,?,?,?,?,?,?)";
		try (Connection con = TestConnection.getConnection(); 
			PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1,pr.getPrimeId());
			pst.setString(2, pr.getNameofVideo());
			pst.setInt(3, pr.getCategoryId());
			pst.setString(4, pr.getGenre());
			pst.setString(5,pr.getAudioLanguages());
			pst.setString(6, pr.getDirector());
			pst.setString(7,pr.getCasting());
			pst.setString(8,pr.getDescriptionofvideo());
			pst.setInt(9,pr.getImdbRating());
			pst.setBoolean(10,pr.isOriginals());
			int row = pst.executeUpdate();
			if (row == 1) {
				logger.info("PrimeId :" + pr.getPrimeId() + " Inserted\n");
			}
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.ADPLAN);

		} catch (Exception e1) {
			
			throw new DbException(InfoMessages.CONNECTION);
		}

	}
	}
	
	

	



package com.chainsys.primevideos.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.primevideos.connection.ConnectionUtil;
import com.chainsys.primevideos.dao.PrimeReleasesDAO;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.exception.InfoMessages;
import com.chainsys.primevideos.model.PrimeRelease;
import com.chainsys.primevideos.util.Logger;

@Repository
public class PrimeReleasesDAOImp implements PrimeReleasesDAO {
	static Logger logger = Logger.getInstance();
	@SuppressWarnings("unused")
	private static final String ACTION = "and";

	public PrimeRelease findOneMovieDetails(int id) throws DbException {

		String sql = "Select * from prime_releases where prime_id = ?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					int movieid = rs.getInt(1);
					int categoryid = rs.getInt(2);
					String name = rs.getString(3);
					String genre = rs.getString(4);
					int season = rs.getInt(5);
					int episodes = rs.getInt(6);
					String audio = rs.getString(7);
					String subtitles = rs.getString(8);
					String director = rs.getString(9);
					/*
					 * Date j = rs.getDate(10); Date k = rs.getDate(11);
					 */
					int boxOffice = rs.getInt(12);
					String casting = rs.getString(13);
					String description = rs.getString(14);
					PrimeRelease release = new PrimeRelease();
					logger.info(sql);
					release.setPrimeId(movieid);
					release.setCategoryId(categoryid);
					release.setNameOfVideo(name);
					release.setGenre(genre);
					release.setSeason(season);
					release.setTotalEpisodes(episodes);
					release.setAudioLanguages(audio);
					release.setSubtitleLanguages(subtitles);
					release.setDirector(director);
					/*
					 * release.setReleaseDate(j.toLocalDate());
					 * release.setPrimereleaseDate(k.toLocalDate());
					 */
					release.setBoxOfficeCollectionInMillions(boxOffice);
					release.setCasting(casting);
					release.setDescriptionOfVideo(description);
					logger.info(release);
					return release;
				}
			}
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.VIEWVIDEO, e1);
		}
		return null;
	}

	public List<PrimeRelease> findlanguages() throws DbException {
		String sql = "select audio_languages from prime_releases group by audio_languages";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			List<PrimeRelease> list = new ArrayList<>();
			try (ResultSet rs = pst.executeQuery();) {

				while (rs.next()) {
					String languages = rs.getString(1);
					PrimeRelease at = new PrimeRelease();
					at.setAudioLanguages(languages);
					list.add(at);
				}
				return list;
			}
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.VIEWVIDEO, e1);
		}
	}
	public List<PrimeRelease> findGenres() throws DbException {
		String sql = "select genre from prime_releases group by genre";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			List<PrimeRelease> list = new ArrayList<>();
			try (ResultSet rs = pst.executeQuery();) {

				while (rs.next()) {
					String genre = rs.getString(1);
					PrimeRelease at = new PrimeRelease();
					at.setGenre(genre);
					list.add(at);
				}
				logger.info(list);
				return list;
			}
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.VIEWVIDEO, e1);
		}
	}
	public List<PrimeRelease> findImdbRating() throws DbException {
		String sql = "select imdb_rating from prime_releases group by imdb_rating order by imdb_rating";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			List<PrimeRelease> list = new ArrayList<>();
			try (ResultSet rs = pst.executeQuery();) {

				while (rs.next()) {
					int imdb = rs.getInt(1);
					PrimeRelease at = new PrimeRelease();
					at.setImdbRating(imdb);
					list.add(at);
				}
				return list;
			}
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.VIEWVIDEO, e1);
		}
	}

	public List<PrimeRelease> findMoviesSearch(PrimeRelease primeRelease) throws DbException {
		String term = primeRelease.getNameOfVideo();
		int categorys = primeRelease.getCategoryId();
		int imdbrating = primeRelease.getImdbRating();
		String language = primeRelease.getAudioLanguages();
		String director = primeRelease.getDirector();
		String actor = primeRelease.getCasting();
		String genre = primeRelease.getGenre();
		boolean originals = primeRelease.isOriginals();
		String sql = "select prime_id,name_of_video,imdb_rating,genre,tlikes,tdislikes from prime_releases where ";
		int d = 0;
		if (term != null && term.length() != 0) {
			sql = sql + "name_of_video Like '%" + term + "%'";
			d += 1;

		}
		if (term != null && categorys != 0) {
			if (d != 0) {
				sql = sql + ACTION;
			}
			sql = sql + " category_id = " + categorys + "";
			d += 1;
		}
		if (term != null && imdbrating != 0) {
			if (d != 0) {
				sql = sql + ACTION;
			}
			sql = sql + " imdb_rating = " + imdbrating + "";
			d += 1;
		}
		if (term != null && language.length() != 0) {
			if (d != 0) {
				sql = sql + ACTION;
			}
			sql = sql + " audio_languages = '" + language + "'";
			d += 1;
		}
		if (term != null && director.length() != 0) {
			if (d != 0) {
				sql = sql + ACTION;
			}
			sql = sql + "director Like '%" + director + "%'";
			d += 1;
		}
		if (term != null && actor.length() != 0) {
			if (d != 0) {
				sql = sql + ACTION;
			}
			sql = sql + "actor Like '%" + actor + "%'";
			d += 1;
		}
		if (term != null && genre.length() != 0) {
			if (d != 0) {
				sql = sql + ACTION;
			}
			sql = sql + " genre = '" + genre + "'";
			d += 1;
		}
		if (term != null && originals) {
			if (d != 0) {
				sql = sql + ACTION;
			}
			sql = sql + " originals = 1 ";
			d += 1;
		}

		if (d == 0) {
			sql = "select prime_id,name_of_video,imdb_rating,genre,tlikes,tdislikes from prime_releases";
		}

		logger.info(sql);
		return commonCall(sql);

	}

	public void saveMovies(PrimeRelease release) throws DbException {
		String sql = "insert into prime_releases(prime_id,category_id,name_of_video,genre,audio_languages,director,box_office_collection_millions,casting,description_of_video,imdb_rating,originals) values (?,?,?,?,?,?,?,?,?,?,?)";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, release.getPrimeId());
			pst.setInt(2, release.getCategoryId());
			pst.setString(3, release.getNameOfVideo());
			pst.setString(4, release.getGenre());
			pst.setString(5, release.getAudioLanguages());
			pst.setString(6, release.getDirector());
			pst.setInt(7, release.getBoxOfficeCollectionInMillions());
			pst.setString(8, release.getCasting());
			pst.setString(9, release.getDescriptionOfVideo());
			pst.setInt(10, release.getImdbRating());
			pst.setBoolean(11, release.isOriginals());
			int row = pst.executeUpdate();
			if (row == 1) {
				logger.info("PrimeId :" + release.getPrimeId() + " Inserted\n");
			}
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.ADDVIDEO, e1);

		}
	}

	private static List<PrimeRelease> commonCall(String sql) throws DbException {
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				List<PrimeRelease> list = new ArrayList<>();
				while (rs.next()) {
					PrimeRelease at = new PrimeRelease();
					int a = rs.getInt(1);
					String b = rs.getString(2);
					int c = rs.getInt(3);
					String d = rs.getString(4);
					int e = rs.getInt(5);
					int f = rs.getInt(6);
					logger.info(a + "      " + b);
					at.setPrimeId(a);
					at.setNameOfVideo(b);
					at.setImdbRating(c);
					at.setGenre(d);
					at.setTotalLikes(e);
					at.setTotalDislikes(f);
					list.add(at);
				}
				return list;
			}
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.VIEWVIDEO, e1);
		}
	}

}

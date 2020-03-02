package com.chainsys.primevideos.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.imp.PrimeReleasesDAOImp;
import com.chainsys.primevideos.model.PrimeReleases;

public class TestCSV {


	public static void main(String[] args) throws IOException, DbException {
		String fileName = "D:\\insertmovies.txt";
		Path path = Paths.get(fileName);
		
		List<String> readAllLines  =  Files.readAllLines(path);
		PrimeReleasesDAOImp asa = new PrimeReleasesDAOImp();
		for(String line : readAllLines)
		{
			String[] s = line.split(",");
			String a = s[0];
			String b = s[1];
			String c = s[2];
			String d = s[3];
			String e = s[4];
			String f = s[5];
			String g = s[6];
			String h = s[8];
			String i = s[9];
			/*String j = s[10];
			String k = s[11];*/
			String l = s[12];
			String m = s[13];
			PrimeReleases as = new PrimeReleases();
			int id = Integer.parseInt(a);
			as.setPrimeId(id);
			int ca = Integer.parseInt(b);
			as.setCategoryId(ca);
			as.setNameofVideo(c);			
			as.setGenre(d);
			as.setDescriptionofvideo(e);
			as.setDirector(f);
			as.setCasting(g);
			int hh = Integer.parseInt(h);
			as.setBoxofficecollectionuinmillions(hh);
			int imdb = Integer.parseInt(i);
			as.setImdbRating(imdb);		
			/*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy");      
			LocalDate r = LocalDate.parse(j, formatter);
	        as.setReleaseDate(r);
	        LocalDate rr = LocalDate.parse(k, formatter);
			as.setPrimereleaseDate(rr);*/
			as.setAudioLanguages(l);
			boolean or = false;
			if(m == "1")
			{
				or = true;
			}
			
			as.setOriginals(or);
			
			asa.insertMovies(as);
			
		}
		
	}

}

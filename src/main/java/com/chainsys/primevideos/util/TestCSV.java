package com.chainsys.primevideos.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.imp.PrimeReleasesDAOImp;
import com.chainsys.primevideos.method.PrimeReleases;

public class TestCSV {


	public static void main(String[] args) throws IOException, DbException {
		String fileName = "D:\\project3.txt";
		Path path = Paths.get(fileName);
		
		List<String> readAllLines  =  Files.readAllLines(path);
		PrimeReleasesDAOImp asa = new PrimeReleasesDAOImp();
		for(String line : readAllLines)
		{
			String[] s = line.split(",");
			String a = s[0];
			System.out.println(a);
			String b = s[1];
			String c = s[2];
			String d = s[3];
			String e = s[4];
			String f = s[5];
			String g = s[6];
			String i = s[9];
			String j = s[10];
			String k = s[11];
			PrimeReleases as = new PrimeReleases();
			int id = Integer.parseInt(a);
			as.setPrimeId(id);
			as.setNameofVideo(c);
			int ca = Integer.parseInt(b);
			as.setCategoryId(ca);
			as.setGenre(d);
			as.setDescriptionofvideo(e);
			as.setDirector(f);
			as.setCasting(g);
			int imdb = Integer.parseInt(i);
			as.setImdbRating(imdb);
			as.setAudioLanguages(j);
			boolean or = false;
			if(k == "1")
			{
				or = true;
			}
			
			as.setOriginals(or);
			
			asa.insertMovies(as);
			
		}
		
	}

}

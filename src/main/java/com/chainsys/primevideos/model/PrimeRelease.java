package com.chainsys.primevideos.model;

import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class PrimeRelease {
	private int primeId;
	private int categoryId;
	private String nameOfVideo;
	private String genre;
	private int season = 0;
	private int totalEpisodes = 0;
	private String audioLanguages;
	private String subtitleLanguages;
	private String director;
	private LocalDate releaseDate;
	private LocalDate primeReleaseDate;
	private int boxOfficeCollectionInMillions;
	private String casting;
	private String descriptionOfVideo;
	private int imdbRating;
	private boolean originals;
	private int totalLikes;
	private int totalDislikes;
	private int viewerRating;
	
	
	public String toString() {
		return "PrimeReleases \nprimeId =" + primeId + "\ncategoryId =" + categoryId + "\nnameofVideo = " + nameOfVideo
				+ "\nGenre = " + genre + "\nSeason = " + season + "\nTotalEpisodes = " + totalEpisodes + "\nAudioLanguages = "
				+ audioLanguages + "\nSubtitleLanguages = " + subtitleLanguages + "\nDirector=" + director
				+ "\nReleaseDate=" + releaseDate + "\nPrimereleaseDate = " + primeReleaseDate
				+ "\nBoxofficecollectionuinmillions = " + boxOfficeCollectionInMillions + "\nCasting=" + casting
				+ "\nDescriptionofvideo=" + descriptionOfVideo + "\nImdbRating=" + imdbRating + "\nOriginals="
				+ originals + "\nTlikes="+totalLikes+"\nTdislikes="+totalDislikes+"\nViewerRating"+"viewerRating";
	}

	
	

}

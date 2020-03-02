package com.chainsys.primevideos.model;

import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class PrimeReleases {
	private int primeId;
	private int categoryId;
	private String nameofVideo;
	private String genre;
	private int season = 0;
	private int totalEpisodes = 0;
	private String audioLanguages;
	private String subtitleLanguages;
	private String director;
	private LocalDate releaseDate;
	private LocalDate primereleaseDate;
	private int boxofficecollectionuinmillions;
	private String casting;
	private String descriptionofvideo;
	private int imdbRating;
	private boolean originals;
	private int tlikes;
	private int tdislikes;
	private int viewerRatings;
	
	
	public String toString() {
		return "PrimeReleases \nprimeId =" + primeId + "\ncategoryId =" + categoryId + "\nnameofVideo = " + nameofVideo
				+ "\nGenre = " + genre + "\nSeason = " + season + "\nTotalEpisodes = " + totalEpisodes + "\nAudioLanguages = "
				+ audioLanguages + "\nSubtitleLanguages = " + subtitleLanguages + "\nDirector=" + director
				+ "\nReleaseDate=" + releaseDate + "\nPrimereleaseDate = " + primereleaseDate
				+ "\nBoxofficecollectionuinmillions = " + boxofficecollectionuinmillions + "\nCasting=" + casting
				+ "\nDescriptionofvideo=" + descriptionofvideo + "\nImdbRating=" + imdbRating + "\nOriginals="
				+ originals + "\nTlikes="+tlikes+"\nTdislikes="+tdislikes+"\nViewerRating"+"viewerRating";
	}

	
	

}

package com.chainsys.primevideos.method;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor

public class WatchLists {
	private String mailId;
	private int primeId;
	private int watched;
	private int watchLater;
	private LocalDate watchLaterDate; 
	private int likes;
	private int viewerRating;

	
}


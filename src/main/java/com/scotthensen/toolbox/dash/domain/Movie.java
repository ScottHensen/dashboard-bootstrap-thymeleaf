package com.scotthensen.toolbox.dash.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Movie {

	private final long   id;
	private final String title;
	private final int    episode;
	private final String releaseDate;
	
}

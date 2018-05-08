package com.scotthensen.toolbox.dash;

import java.util.List;

import com.scotthensen.toolbox.dash.domain.Movie;

import lombok.Data;

@Data
public class DashViewModel {

	private String title;
	private String navbarBrand;
	private String navbarRightButton;
	private List<Movie> movies;
}

package com.scotthensen.toolbox.dash;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scotthensen.toolbox.dash.domain.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/dash")
public class DashController {

	@GetMapping
	public String showDash(Model model) {
		
		List<Movie> movies = Arrays.asList(
			new Movie(1L, "A New Hope",           4, "1977-05-25"),
			new Movie(2L, "Empire Strikes Back",  5, "1980-05-17"),
			new Movie(3L, "Return of the Jedi",   6, "1983-05-25"),
			new Movie(4L, "The Phantom Menace",   1, "1999-05-19"),
			new Movie(5L, "Attack of the Clones", 2, "2002-05-16"),
			new Movie(6L, "Revenge of the Sith",  3, "2005-05-19"),
			new Movie(7L, "The Force Awakens",    7, "2015-12-11")
		);
		
		DashViewModel viewModel = new DashViewModel();
		viewModel.setMovies(movies);
		viewModel.setTitle("Der Dashbird");
		viewModel.setNavbarBrand("Der Dashboard");
		viewModel.setNavbarRightButton("Login");
		model.addAttribute("dash", viewModel);
		
		return "dash";
	}
}

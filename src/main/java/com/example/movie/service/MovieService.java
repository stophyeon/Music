package com.example.movie.service;

import com.example.movie.dto.SearchRes;
import com.example.movie.entity.MyMovies;
import com.example.movie.entity.User;
import com.example.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public void addMovies(SearchRes searchRes, User user){
        MyMovies myMovies = new MyMovies(searchRes.getPoster_path(),searchRes.getTitle(),user);
        movieRepository.save(myMovies);
    }
    public List<MyMovies> showMovies(){
        List<MyMovies> movies = movieRepository.findAll();
        return movies;

    }
    public MyMovies findMovieByTitle(String title){
        MyMovies myMovies = movieRepository.findByTitle(title);
        return myMovies;
    }

}

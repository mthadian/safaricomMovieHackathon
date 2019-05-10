/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SAF.MovieBackEnd.Controllers;

import com.SAF.MovieBackEnd.Models.Movies;
import com.SAF.MovieBackEnd.Repositories.MovieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PMMuthama
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MoviesController
{
    @Autowired
    MovieRepository movieRepo;
    
    @GetMapping("/movies")
    public List<Movies> getAllMovies() throws Exception
    {
        List<Movies> movies=movieRepo.findAll();
        if(movies.isEmpty())
        { 
            throw new Exception("No Movies Found");
        }
        
        return movies;
        
    }
    
    
    
}

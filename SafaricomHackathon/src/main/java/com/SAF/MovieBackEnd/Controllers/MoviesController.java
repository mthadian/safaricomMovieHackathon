/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SAF.MovieBackEnd.Controllers;

import com.SAF.MovieBackEnd.Models.Movies;
import com.SAF.MovieBackEnd.Repositories.MovieRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @GetMapping("/movies/watched/{watched}")
    public List<Movies> getByWatched(@PathVariable("watched") boolean watched) throws Exception
    {
        List<Movies> movies= movieRepo.findByWatched(watched);
        if(movies.isEmpty())
        {
            throw new Exception("No Movies Found with parameter "+watched);
        }
        
        return movies;
        
    }
    
    @PostMapping("/movies")
    public Movies addNewMovie(@RequestBody Movies movie)
    {
        movieRepo.save(movie);
        return movie;
    }
    
    @PutMapping("/movies")
    public Movies editMovie(@RequestBody Movies movie)
    {
        movieRepo.save(movie);
        return movie;
    }
    
    @DeleteMapping("/movies/{id}")
    public List<Movies> deleteMovie(@PathVariable("id") int id)
    {
       
        
        try 
        {
             Movies thisMovie=movieRepo.getOne(id);
             movieRepo.delete(thisMovie);
        } catch (Exception e) 
        {
            e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
        }
        
       
        
        
        return movieRepo.findAll();
    }
    
    
}

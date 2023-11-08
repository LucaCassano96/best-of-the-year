package bestOfTheYear.controller;


// Creo IndexController all'interno del package controller

import model.Movies;
import model.Songs;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller // Gli specifichiamo che è un Controller
@RequestMapping("/") //Gli passo la root con RequestMapping
public class IndexController {
    @GetMapping // Metodo Get sulla rotta di RequestMapping
    @ResponseBody // Lo vediamo effetivamente http://localhost:8080/
    public String index(){
        return "Ciao";
    }

    @GetMapping("home") // Metodo punta a /home
    public String home(Model model){
        String name = "Luca";
        model.addAttribute("nome", name);
        return "home-page"; // Fa riferimento al templates
    }


    @GetMapping("/movies")
    public String getMovies(Model model) {
        List<Movies> movies = getBestMovies();
        model.addAttribute("movies", movies);
        return "movies";
    }


    @GetMapping("/songs")
    public String getSongs(Model model) {
        List<Songs> songs = getBestSongs();
        model.addAttribute("songs", songs);
        return "songs";
    }


    @GetMapping("/{id}")
    public String getMovieDetail(@PathVariable String id){
        return "movie-detail";
    }



    private List<Movies> getBestMovies() {
        Movies[] moviesArray = {new Movies( "1", "Titanic" ), new Movies( "2", "Padrino" ), new Movies( "3", "The Gladiator" )};
        return Arrays.asList( moviesArray );
    }

    private List<Songs> getBestSongs() {
        Songs[] songsArray = {new Songs( "1", "Bohemian Rhapsody" ), new Songs( "2", "Hallelujah " ), new Songs( "3", "Imagine" )};
        return Arrays.asList( songsArray );
    }

}

package bestOfTheYear.controller;


// Creo IndexController all'interno del package controller

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
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


    private List<String> getBestMovies() {
        return Arrays.asList("Il Padrino", "Star Wars", "Forrest Gump");
    }

    private List<String> getBestSongs() {
        return Arrays.asList("Bohemian Rhapsody", "Hotel California", "Imagine");
    }

    @GetMapping("/movies")
    public String getMovies(Model model) {
        List<String> movies = getBestMovies();
        String movieTitles = String.join(", ", movies);
        model.addAttribute("mediaTitles", movieTitles);
        return "movies";
    }

    @GetMapping("/songs")
    public String getSongs(Model model) {
        List<String> songs = getBestSongs();
        String songTitles = String.join(", ", songs);
        model.addAttribute("mediaTitles", songTitles);
        return "songs";
    }
}

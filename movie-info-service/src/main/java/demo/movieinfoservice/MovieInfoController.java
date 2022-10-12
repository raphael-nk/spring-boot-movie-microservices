package demo.movieinfoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movie-info")
public class MovieInfoController {
    
    @Value("${api.key}")
    private String apiKey; 
    
    @Autowired
    private RestTemplate rest; 
    
    @GetMapping("/{movieID}")
    public Movie getMovieInfo(@PathVariable("movieID") String movieID){
        MovieSummary movieSummary = rest.getForObject("https://api.themoviedb.org/3/movie/"+ movieID+ "?api_key=" + apiKey, MovieSummary.class);
        assert movieSummary != null;
        return new Movie(movieID, movieSummary.getTitle(), movieSummary.getOverview());
    }
}

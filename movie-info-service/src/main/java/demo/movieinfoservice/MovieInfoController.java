package demo.movieinfoservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-info-service")
public class MovieInfoController {
    @GetMapping("/{movieID}")
    public Movie getMovieInfo(@PathVariable("movieID") String movieID){
        return new Movie(movieID, "Test name");
    }
}

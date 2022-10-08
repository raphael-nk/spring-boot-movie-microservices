package demo.moviecatalogservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie-catalog-service")
public class MovieCatalogController {
    
    @Autowired  //consummer
    private RestTemplate rest; 
    
    @GetMapping("/{userID}")
    public List<CatalogItem> getCatalog(@PathVariable("userID") String userID){

        // RestTemplate rest = new RestTemplate();
        // Movie movie  = rest.getForObject("http://localhost:81/movie-info-service/1", Movie.class);      
        // get all  rated movies 
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("1334", 3)
        );
        
        // for each movie ID, call movie info service and get details 
        return ratings.stream().map(rating -> {
            Movie movie = rest.getForObject("http://localhost:81/movie-info-service/"+rating.getMovieID(), Movie.class);
            return new CatalogItem(movie.getName(), "Test", rating.getRating());
        }).collect(Collectors.toList());
        // put them all together 
        /*return Collections.singletonList(
                new CatalogItem("transformer", "Test", 1)
        ); */
    }    
}

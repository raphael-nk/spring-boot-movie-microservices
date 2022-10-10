package demo.moviecatalogservice;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie-catalog")
public class MovieCatalogController {
    
    @Autowired  //consummer
    private RestTemplate rest; 
    
    @Autowired
    private WebClient.Builder builder;
    
    @GetMapping("/{userID}")
    public List<CatalogItem> getCatalog(@PathVariable("userID") String userID){

        // RestTemplate rest = new RestTemplate();
        // Movie movie  = rest.getForObject("http://localhost:81/movie-info-service/1", Movie.class);      
        // get all  rated movies 
        
        UserRating ratings = rest.getForObject("http://RATING-DATA-SERVICE/rating-data/users/"+userID, UserRating.class);
        
        return ratings.getUserRating().stream().map(rating -> {
            // for each movie ID, call movie info service and get details 
            Movie movie = rest.getForObject("http://MOVIE-INFO-SERVICE/movie-info/"+rating.getMovieID(), Movie.class);
            // put them all together 
            return new CatalogItem(movie.getName(), "Test", rating.getRating());
        }).collect(Collectors.toList());
    }    
}

/*Movie movie = builder.build()
        .get()
        .uri("http://localhost:81/movie-info-service/"+rating.getMovieID())
        .retrieve()
        .bodyToMono(Movie.class)            
        .block();
*/

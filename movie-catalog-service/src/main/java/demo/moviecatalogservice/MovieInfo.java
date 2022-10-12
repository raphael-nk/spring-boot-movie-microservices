package demo.moviecatalogservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfo {
    @Autowired  //consummer
    private RestTemplate rest;
    
    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
    public CatalogItem getCatalogItem(Rating rating) {
        // for each movie ID, call movie info service and get details 
        Movie movie = rest.getForObject("http://MOVIE-INFO-SERVICE/movie-info/"+ rating.getMovieID(), Movie.class);
        // put them all together 
        assert movie != null;
        return new CatalogItem(movie.getName(), "Test", rating.getRating());
    }

    public CatalogItem getFallbackCatalogItem(Rating rating){
        return new CatalogItem("No movie", "Test", rating.getRating());
    }
}

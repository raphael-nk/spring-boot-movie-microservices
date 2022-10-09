package demo.ratingdataservice;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rating-data-service")
public class RatingController {
    @GetMapping("/{movieID}")
    public Rating getRating(@PathVariable("movieID") String movieID){
        return new Rating(movieID, 4);
    }
    
    @GetMapping("/users/{userID}")
    public UserRating getUserRating(@PathVariable("userID") String userID){
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("1334", 3)
        );
        
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        
        return userRating;
    }
}

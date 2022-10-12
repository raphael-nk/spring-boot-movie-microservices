package demo.moviecatalogservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class UserRatingInfo {
    @Autowired  //consummer
    private RestTemplate rest;

    @HystrixCommand(fallbackMethod = "getFallbackUserRating")
    public UserRating getUserRating(@PathVariable("userID") String userID){
        return rest.getForObject("http://RATING-DATA-SERVICE/rating-data/users/"+userID, UserRating.class);
    }

    public UserRating getFallbackUserRating(@PathVariable("userID") String userID){
        UserRating userRating = new UserRating();
        userRating.setUserID(userID);
        userRating.setUserRating(Arrays.asList(new Rating("0", 0)));

        return userRating;
    }
    // getFallbackCatalog signature should be the same as getCatalog
}

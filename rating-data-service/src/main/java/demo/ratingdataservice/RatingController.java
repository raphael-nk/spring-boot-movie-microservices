package demo.ratingdataservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rating-data-service")
public class RatingController {
    @GetMapping("/{movieID}")
    public Rating getRating(@PathVariable("movieID") String movieID){
        return new Rating(movieID, 4);
    }
}

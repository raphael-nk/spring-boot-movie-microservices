package demo.moviecatalogservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class UserRating {
    private List<Rating> userRating;
    private String userID;
    
    public UserRating(List<Rating> userRating) {
        this.userRating = userRating;
    }
}

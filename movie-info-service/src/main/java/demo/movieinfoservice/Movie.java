package demo.movieinfoservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Movie {
    private String movieId; 
    private String name;
    private String description; 

    public Movie(String movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }
}

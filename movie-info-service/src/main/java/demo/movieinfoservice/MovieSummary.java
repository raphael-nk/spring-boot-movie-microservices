package demo.movieinfoservice;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieSummary {
    private String id; 
    private String title; 
    private String overview; 
}

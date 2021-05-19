package seen;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import kong.unirest.json.JSONArray;
import kong.unirest.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.*;
import seen.model.Movie;
public class Controller implements Initializable {
   final String  base_img_url="http://image.tmdb.org/t/p/";
   final String  poster_width="w185";
   String img_file_path = "";
    List<Movie> Trending;
    
    @FXML
    private HBox cardLayout;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Trending = new ArrayList<>(geTrendingmovies());
        try{
            for (Movie movie : Trending) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Card.fxml"));

                VBox vBox = fxmlLoader.load();
                Cardcontroller cardcontroller = fxmlLoader.getController();
                cardcontroller.setData(movie);
                cardLayout.getChildren().add(vBox);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private List<Movie> geTrendingmovies(){
        int i =0;
        List<Movie> movies = new ArrayList<>();
            JSONArray result = Unirest.get("https://api.themoviedb.org/3/trending/all/week?api_key=e435f0564b2644afbd7d653bf76e7634")
            .asJson()
            .getBody()
            .getObject()
            .getJSONArray("results");
        
        
        img_file_path=result.getJSONObject(i).get("poster_path").toString();
        if(result!=null)
        for (i = 0; i < result.length(); i++) {
            Movie movie = new Movie();
            movie.setPoster(base_img_url+poster_width+result.getJSONObject(i).get("poster_path").toString());
            try {
                movie.setName(result.getJSONObject(i).get("title").toString());
            } catch (Exception e) {
                movie.setName(result.getJSONObject(i).get("name").toString());
            }
            movie.setRating(result.getJSONObject(i).get("vote_average").toString());
            movies.add(movie);
        }

         return movies;
    }

}
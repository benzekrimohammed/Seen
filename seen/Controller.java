package seen;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONArray;
import kong.unirest.*;
import java.net.URLEncoder;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import seen.model.Movie;
public class Controller implements Initializable {

    @FXML
    private HBox cardLayout;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
    private List<Movie> geTrendingmovies(){
        JSONArray result = Unirest.get("http://some.json.com")
				       .asJson()
				       .getBody()
				       .getObject()
				       .getJSONArray("result");
                       
        if(result!=null)
        for (int i = 0; i < result.length(); i++) {
            
        }
        
         
    }
}
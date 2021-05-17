package seen;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import seen.model.Movie;
public class Cardcontroller {
    
    @FXML
    private ImageView img;

    @FXML
    private Label name;

    public void setData(Movie movie){
        Image image = new Image(getClass().getResourceAsStream(movie.getPoster()));
        img.setImage(image);
        name.setText(movie.getName()); 
    }
}

package seen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.*;
import javafx.scene.paint.Color;

public class Main extends Application {
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage)  throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("seen.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Seen");
        stage.show();
    }
}
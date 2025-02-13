import java.io.IOException;

import dew.Dew;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Dew using FXML.
 */
public class Main extends Application {
    private static String FILE_PATH = "src/main/tasks.txt";
    private Dew dew = new Dew(FILE_PATH);

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setDew(dew);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package regexcheck;

import javafx.application.Application; //javafx application, Main class has to extend this
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("regexview.fxml"));

        primaryStage.setTitle("Regex Check");
        primaryStage.setResizable(false);
        Scene mainScene = new Scene(root, 600, 500);
        mainScene.getStylesheets().add("/regexcheck/style.css");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

/*** TODO
 * - main Window layoyt:
 *      add menu upper bar
 *   - add regex check window
 *      text of string with highlighted regex
 *      resizeable window presenting results
 *   - refactor code to be more SOLID
 *   - exception handling: empty regex/string
 */
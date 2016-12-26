package regexcheck;

import javafx.application.Application; //javafx application, Main class has to extend this
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import regexcheckTests.RegexCheckerTest;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("regexview.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        controller.initChecker(new RegexChecker());

        primaryStage.setTitle("Regex Check");
        primaryStage.setResizable(false);
        Scene mainScene = new Scene(root, 600, 500);
        mainScene.getStylesheets().add("/regexcheck/style.css");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(RegexCheckerTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
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
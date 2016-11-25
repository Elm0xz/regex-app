package regexcheck;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import java.io.*;

public class Controller {

    @FXML
    private BorderPane mainPane;
    @FXML
    private TextField regexField;
    @FXML
    private TextArea stringField;
    @FXML
    private Label resultField;

    @FXML
    private void handleRegexCheckAction(ActionEvent actionEvent) {
        RegexChecker checker = new RegexChecker();
        String checkResult = checker.check(regexField.getText(), stringField.getText());
        resultField.setText(checkResult);
    }

    @FXML
    private void handleBrowseAction(ActionEvent actionEvent) {
        readFile(chooseFile());
    }

    private File chooseFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Text File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));

        return fileChooser.showOpenDialog(mainPane.getScene().getWindow());
    }

    private void readFile(File chosenFile) {
        try {
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(chosenFile));
            String line = reader.readLine();
            while (line != null) {
                builder.append(line);
                line = reader.readLine();
            }
            stringField.setText(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

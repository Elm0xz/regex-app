package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.*;

public class Controller {
//    private int counter = 0;

    @FXML
    private Text checkActionTarget;
    @FXML
    private TextField regexField;
    @FXML
    private TextArea stringField;
    @FXML
    private GridPane gridPane;

    @FXML
    private void handleRegexCheckAction(ActionEvent actionEvent) {
        RegexChecker checker = new RegexChecker();
        String checkResult = checker.check(regexField.getText(), stringField.getText());
        checkActionTarget.setText(checkResult);

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

        return fileChooser.showOpenDialog(gridPane.getScene().getWindow());
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

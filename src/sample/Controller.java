package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

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
//        counter++;
//        if (counter%2==1)
//            actionTarget.setText("Check processed!");
//        else
//            actionTarget.setText("Check processed again!");

        RegexChecker checker = new RegexChecker();
        String checkResult = checker.check(regexField.getText(), stringField.getText());
        checkActionTarget.setText(checkResult);

    }

    public void handleBrowseAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Text File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));

        File chosenFile = fileChooser.showOpenDialog(gridPane.getScene().getWindow());

        try {
            //FileReader reader = new FileReader(chosenFile);
            String text = new String(Files.readAllBytes(Paths.get(chosenFile.getPath()))); //ugly
            stringField.setText(text);
            //System.out.print(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

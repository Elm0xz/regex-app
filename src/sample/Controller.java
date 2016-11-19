package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

public class Controller {
//    private int counter = 0;

    @FXML
    private Text actionTarget;
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
        actionTarget.setText(checkResult);

    }

    public void handleBrowseAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Text File");
        fileChooser.showOpenDialog(gridPane.getScene().getWindow());

    }
}

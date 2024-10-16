package com.desktopapp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainController {

    public static Scene CreateScene(Integer id) throws Exception
    {
        URL sceneUrl = MainController.class.getResource("MainScreen.fxml");
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        MainController controller = loader.getController();
        controller.setId(id);
        return scene;
    }

    private Integer id;
    public void setId(Integer id){
        this.id = id;
    }

    @FXML
    protected void initialize(URL location, ResourceBundle Resources){
        this.btnLog.setText(id.toString());
    }

    @FXML
    protected Button btnLog;

    @FXML
    protected Button btnOut;

    @FXML
    protected TextField loginField;

    @FXML
    protected TextField pwText;

    @FXML
    protected PasswordField pwField;

    @FXML
    protected CheckBox checkBox;


    // @FXML
    // protected CheckBox pwView;

    @FXML
    public void sendData(MouseEvent e) throws Exception{

        String username = loginField.getText();
        String userPw= "";

        if (checkBox.isSelected()) {
            userPw = pwText.getText();
        }else{
            userPw = pwField.getText();
        }

        Stage crrStage = (Stage) btnLog.getScene().getWindow();
        Scene newScene = WelcomeController.CreateScene(id + 1, username, userPw);
        crrStage.setScene(newScene);
    }

    @FXML
    public void changeVisualization(MouseEvent e){
        if (checkBox.isSelected()) {
            pwText.setText(pwField.getText());
            pwText.setVisible(true);
            pwField.setVisible(false);
            return;
        }
        pwField.setText(pwText.getText());
        pwField.setVisible(true);
        pwText.setVisible(false);
    }

    @FXML
    public void setLoginData(InputMethodEvent e) throws Exception{
        
    }

    @FXML
    public void getOut(MouseEvent event) throws Exception{

        Stage crrStage = (Stage) btnOut.getScene().getWindow();
        Scene newScene = ButtonController.CreateScene(id);
        crrStage.setScene(newScene);
    }
}

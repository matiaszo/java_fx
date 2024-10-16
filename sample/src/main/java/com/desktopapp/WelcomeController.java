package com.desktopapp;

import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.NumberStringConverter;


public class WelcomeController {
    public static Scene CreateScene(Integer id, String username, String userPw) throws Exception
    {
        URL scenUrl = WelcomeController.class.getResource("WelcomeScreen.fxml");
        FXMLLoader loader = new FXMLLoader(scenUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        WelcomeController controller = loader.getController();
        controller.setId(id);
        controller.setUserName(username);
        controller.setUserPw(userPw);
        controller.setData();
        return scene;
    }

    private Integer id;
    public void setId(Integer id){
        this.id = id;
    }
    private String userNameData;
    public void setUserName(String userNameData){
        this.userNameData = userNameData;
    }

    private String userPwData;
    public void setUserPw(String userPwData){
        this.userPwData = userPwData;
    }

    public void setData(){
        userName.setText(userNameData);
        userPw.setText(userPwData);
    }

    @FXML
    protected Label userName;


    @FXML
    protected Label userPw;

    @FXML
    protected PasswordField pwNewUser;

    @FXML
    protected TextField nameNewUser;

    @FXML
    protected TextField ageField;

    @FXML
    protected ChoiceBox genderNewUser;

    @FXML
    protected Slider slider;



    @FXML 
    public void setAge(){

        slider.setBlockIncrement(20);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(10);

        float userAgeNumber = 0;
        try {
            userAgeNumber = Float.parseFloat(ageField.getText());
            
        } catch (Exception e) {
            userAgeNumber = 0;
        }
        float percentage = userAgeNumber*10;
        
        slider.adjustValue(percentage);
    }

    @FXML
    public void setFieldAge(){
        int value = ((int)slider.getValue());
        
        ageField.setText(String.valueOf(value));
    }
}

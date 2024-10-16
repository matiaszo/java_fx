package com.desktopapp;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ButtonController {
    public static Scene CreateScene(Integer id)throws Exception{
        URL sceneUrl = MainController.class.getResource("ButtonScreen.fxml");
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        ButtonController controller = new ButtonController();
        controller.setId(id);

        return scene;
    }

    private Integer id;
    public void setId(Integer id){
        this.id = id;
    }
}

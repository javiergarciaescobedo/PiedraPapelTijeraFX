package es.javiergarciaescobedo.piedrapapeltijerafx.test;

import es.javiergarciaescobedo.piedrapapeltijerafx.PPTViewScore;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Pruebas extends Application {

    @Override
    public void start(Stage primaryStage) {
        PPTViewScore pptViewScore = new PPTViewScore("Nombre");

        StackPane root = new StackPane();
        Scene scene = new Scene(root, 500, 350); 
        root.getChildren().add(pptViewScore);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }    
    
}

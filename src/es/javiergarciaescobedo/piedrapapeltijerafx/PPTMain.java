/*
 * Copyright (C) 2016 Javier García Escobedo <javiergarciaescobedo.es>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package es.javiergarciaescobedo.piedrapapeltijerafx;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Clase principal del juego Piedra, Papel, Tijera, con interfaz de usuario
 * realizado en JavaFX.
 * @author Javier García Escobedo <javiergarciaescobedo.es>
 */
public class PPTMain extends Application {

    @Override
    public void start(Stage primaryStage) {

        // PANELES DEL JUGADOR 1
        // Panel de puntuación (PPTViewScore)
        PPTViewScore pptViewScore1 = new PPTViewScore("Player1");
        // Panel de botones de selección de elemento (PPTViewElementSelector)
        PPTViewElementSelector pptViewElementSelector1 = new PPTViewElementSelector(PPTGame.PLAYER_1);
        // Panel para mostrar el elemento apostado (PPTViewElementPlayer)
        PPTViewElementPlayer pptViewElementPlayer1 = new PPTViewElementPlayer();

        // PANELES DEL JUGADOR 2
        PPTViewScore pptViewScore2 = new PPTViewScore("Player2");
        PPTViewElementSelector pptViewElementSelector2 = new PPTViewElementSelector(PPTGame.PLAYER_2);
        PPTViewElementPlayer pptViewElementPlayer2 = new PPTViewElementPlayer();

        // Como contenedor principal se va a usar una rejilla (GridPane) con la 
        //  siguiente estructura:
        //  (0,0) Puntuación_Jugador_1     (1,0) Puntuación_Jugador_2
        //  (0,1) Botones_Jugador_1        (1,1) Botones_Jugador_2
        //  (0,2) Apuesta_Jugador_1        (1,2) Apuesta_Jugador_2
        GridPane root = new GridPane();
        // Colocar cada panel en su posición de la rejilla
        root.add(pptViewScore1, 0, 0);
        root.add(pptViewElementSelector1, 0, 1);
        root.add(pptViewElementPlayer1, 0, 2);
        root.add(pptViewScore2, 1, 0);
        root.add(pptViewElementSelector2, 1, 1);
        root.add(pptViewElementPlayer2, 1, 2);
        // Centrado en la ventana
        root.setAlignment(Pos.CENTER);

        // Añadir el contenedor principal a la ventana de la aplicación de 500 x 350,
        //  asignar título y mostrar
        Scene scene = new Scene(root, 500, 350); 
        primaryStage.setTitle("Piedra, Papel, Tijera");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Notificar a la clase controladora (PPTController) cuáles son los paneles de las
        //  puntuaciones y los paneles de los elementos, ya que dicha clase
        //  se encargará de actualizar la información contenida en ellos.
        PPTController.setViews(pptViewScore1, pptViewElementPlayer1,
                pptViewScore2, pptViewElementPlayer2);

        // Cualquier pulsación de teclas recogida en la escena de la aplicación
        //  es desviada a la clase controladora (PPTController) para que se
        //  encargue de su gestión
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                PPTController.manageKeys(event.getCode().getName());
            }
        });

        // Para que no quede ningún botón en pantalla con el foco destacado, se
        //  asigna el foco a la puntuación del jugador 1 (por ejemplo)
        pptViewScore1.requestFocus();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

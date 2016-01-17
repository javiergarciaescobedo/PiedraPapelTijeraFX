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

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Panel que muestra la puntuación de un determinado jugador, así como el nombre
 * asignado al jugador. Se trata de una extensión de la clase VBox de JavaFX, 
 * por lo que se mostrará un contenido debajo de otro
 * @author Javier García Escobedo <javiergarciaescobedo.es>
 */
public class PPTViewScore extends VBox {
    
    private Label labelScore = new Label("0");

    /**
     * Se debe indicar el nombre del jugador que se mostrará sobre su puntuación
     * @param playerName Nombre del jugador asociado a este panel
     */
    public PPTViewScore(String playerName) {
        // Etiqueta para el nombre del jugador
        Label labelName = new Label(playerName);
        labelName.setStyle("-fx-font-size: 18");

        // Etiqueta para la puntuación del jugador
        labelScore.setStyle("-fx-font-size: 24; "
                + "-fx-font-weight: bold; "
                + "-fx-text-alignment: center");

        // Añadir los 2 textos a este panel
        this.getChildren().add(labelName);
        this.getChildren().add(labelScore);

        // Este panel se mostrará centrado dentro de su contenedor, con un
        //  margen de 10 puntos por los 4 lados
        this.setAlignment(Pos.TOP_CENTER);
        this.setPadding(new Insets(10, 10, 10, 10));
    }

    /**
     * Permite modificar en pantalla el contenido de la puntuación
     * @param score Nueva puntuación a mostrar
     */
    public void setScore(int score) {
        labelScore.setText(String.valueOf(score));
    }

}

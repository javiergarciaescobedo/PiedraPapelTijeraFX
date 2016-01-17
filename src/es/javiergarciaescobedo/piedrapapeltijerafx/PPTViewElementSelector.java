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

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Panel encargado de mostrar los botones de selección de los 3 posibles elementos
 * seleccionables por un jugador. Es una extensión de la clase HBox de JavaFX,
 * por lo que se mostrarán los botones uno al lado del otro.
 * @author Javier García Escobedo <javiergarciaescobedo.es>
 */
public class PPTViewElementSelector extends HBox {

    private final double IMAGE_SIZE = 50; 
    
    /**
     * Crea el panel HBox con los botones de selección para el jugador indicado
     * @param player Identificado del jugador para el que crearán los botones, 
     * indicando una de las propiedades constantes de la clase PPTGame
     * (PLAYER_1 ó PLAYER_2)
     */
    public PPTViewElementSelector(byte player) {     
        // BOTÓN PIEDRA
        Button buttonRock = new Button();
        // Asignar imagen al botón, Se crean del tamaño indicado en IMAGE_SIZE, manteniendo
        //  sus proporciones al reducir tamaño, y usando un suavizado de la imagen
        Image imageRock = new Image(getClass().getResourceAsStream("res/rock.png"), 
                IMAGE_SIZE, IMAGE_SIZE, true, true);
        buttonRock.setGraphic(new ImageView(imageRock));
        // Mostrar la imagen sobre el texto siguiente
        buttonRock.setContentDisplay(ContentDisplay.TOP);   
        // Mostrar el nombre de la tecla correspondiente según el jugador
        if(player == PPTGame.PLAYER_1) {
            buttonRock.setText(PPTController.KEY_ROCK_PLAYER1);
        } else {
            buttonRock.setText(PPTController.KEY_ROCK_PLAYER2);
        }
        // Código que se ejecutará en caso de que se pulse este botón
        buttonRock.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                // El controlador se encargará de gestionarlo
                PPTController.selectElement(player, PPTGame.ROCK);
            }
        });
        
        // BOTÓN PAPEL
        Button buttonPaper = new Button();
        Image imagePaper = new Image(getClass().getResourceAsStream("res/paper.png"), 
                IMAGE_SIZE, IMAGE_SIZE, true, true);
        buttonPaper.setGraphic(new ImageView(imagePaper));
        buttonPaper.setContentDisplay(ContentDisplay.TOP);            
        if(player == PPTGame.PLAYER_1) {
            buttonPaper.setText(PPTController.KEY_PAPER_PLAYER1);
        } else {
            buttonPaper.setText(PPTController.KEY_PAPER_PLAYER2);
        }
        buttonPaper.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                PPTController.selectElement(player, PPTGame.PAPER);
            }
        });
        
        // BOTÓN TIJERA
        Button buttonScissor = new Button();
        Image imageScissor = new Image(getClass().getResourceAsStream("res/scissor.png"), 
                IMAGE_SIZE, IMAGE_SIZE, true, true);
        buttonScissor.setGraphic(new ImageView(imageScissor));
        buttonScissor.setContentDisplay(ContentDisplay.TOP);            
        if(player == PPTGame.PLAYER_1) {
            buttonScissor.setText(PPTController.KEY_SCISSOR_PLAYER1);
        } else {
            buttonScissor.setText(PPTController.KEY_SCISSOR_PLAYER2);
        }
        buttonScissor.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                PPTController.selectElement(player, PPTGame.SCISSOR);
            }
        });
        
        // Dejar margen para este panel con 10 puntos en los 4 lados
        this.setPadding(new Insets(10));
        
        // Se añaden los 3 botones a este panel
        this.getChildren().add(buttonRock);
        this.getChildren().add(buttonPaper);
        this.getChildren().add(buttonScissor);
    }        
    
}

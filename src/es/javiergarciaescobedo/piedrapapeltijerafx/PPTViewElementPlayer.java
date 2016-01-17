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

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * Panel que permite mostrar la imagen del elemento que seleccione un jugador.
 * Se trata de una extensión de la clase StackPane de JavaFX, por lo que este
 * panel se debe añadir a un contenedor padre de la misma manera.
 * Este panel sólo contendrá un elemento, que será la imagen a mostrar
 * @author Javier García Escobedo <javiergarciaescobedo.es>
 */
public class PPTViewElementPlayer extends StackPane {

    private final double IMAGE_SIZE = 150; 
    private Image imageEmpty;
    private Image imageRock;
    private Image imagePaper;
    private Image imageScissor;
    private ImageView imageViewElement = null;

    /**
     * Carga las posibles imagénes para ser mostradas posteriormente
     */
    public PPTViewElementPlayer() {
        // Las imágenes se crean del tamaño indicado en IMAGE_SIZE, manteniendo
        //  sus proporciones si es escalada, y usando un suavizado de la imagen
        //  en caso de ser escalada
        imageEmpty = new Image(getClass().getResourceAsStream("res/empty.png"), 
                            IMAGE_SIZE, IMAGE_SIZE, true, true);
        imageRock = new Image(getClass().getResourceAsStream("res/rock.png"), 
                            IMAGE_SIZE, IMAGE_SIZE, true, true);
        imagePaper = new Image(getClass().getResourceAsStream("res/paper.png"), 
                            IMAGE_SIZE, IMAGE_SIZE, true, true);
        imageScissor = new Image(getClass().getResourceAsStream("res/scissor.png"), 
                            IMAGE_SIZE, IMAGE_SIZE, true, true);
        // Crea un elemento ImageView que se cargará en cada momento con la
        //  imagen correspondiente al elemento que seleccione el jugador
        imageViewElement = new ImageView(imageEmpty);
        // Es el único elemento que contendrá este panel
        this.getChildren().add(imageViewElement);
    }        
    
    /**
     * Cambia la imagen del ImageView contenido en este panel
     * @param element Identificador del elemento cuya imagen se desea mostrar, 
     * indicado una de las propiedades constantes de la clase PPTGame 
     * (ROCK, PAPER, SCISSOR ó EMPTY)
     */
    public void drawElement(byte element) {
        switch(element) {
            case PPTGame.EMPTY:
                imageViewElement.setImage(imageEmpty);
                break;
            case PPTGame.ROCK:
                imageViewElement.setImage(imageRock);
                break;
            case PPTGame.PAPER:
                imageViewElement.setImage(imagePaper);
                break;
            case PPTGame.SCISSOR:
                imageViewElement.setImage(imageScissor);
                break;
            default:
                imageViewElement.setImage(imageEmpty);
        }
    }

}

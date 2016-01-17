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

/**
 * Se encarga de gestionar las interacciones del usuario, modificando la
 * información de la ventana según las indicaciones de los jugadores
 * @author Javier García Escobedo <javiergarciaescobedo.es>
 */
public class PPTController {
    
    private static PPTGame pptGame = new PPTGame();
    private static PPTViewElementPlayer pptViewElementPlayer1;
    private static PPTViewScore pptViewScore1;
    private static PPTViewElementPlayer pptViewElementPlayer2;
    private static PPTViewScore pptViewScore2;
    
    /**
     * Tecla asignada para el elemento Piedra del jugador 1
     */
    public static final String KEY_ROCK_PLAYER1 = "A";

    /**
     * Tecla asignada para el elemento Papel del jugador 1
     */
    public static final String KEY_PAPER_PLAYER1 = "S";

    /**
     * Tecla asignada para el elemento Tijera del jugador 1
     */
    public static final String KEY_SCISSOR_PLAYER1 = "D";

    /**
     * Tecla asignada para el elemento Piedra del jugador 2
     */
    public static final String KEY_ROCK_PLAYER2 = "J";

    /**
     * Tecla asignada para el elemento Papel del jugador 2
     */
    public static final String KEY_PAPER_PLAYER2 = "K";

    /**
     * Tecla asignada para el elemento Tijera del jugador 2
     */
    public static final String KEY_SCISSOR_PLAYER2 = "L";
    
    /**
     * Permite crear un controlador indicando los elemento de la pantala
     * @param score1 Panel donde se mostrará la puntuación del jugador 1
     * @param player1 Panel donde se mostrará el elemento apostado por el jugador 1
     * @param score2 Panel donde se mostrará la puntuación del jugador 2
     * @param player2 Panel donde se mostrará el elemento apostado por el jugador 2
     */
    public static void setViews(PPTViewScore score1,
            PPTViewElementPlayer player1,
            PPTViewScore score2,
            PPTViewElementPlayer player2) {
        
        pptViewScore1  = score1;
        pptViewElementPlayer1 = player1;
        pptViewScore2  = score2;
        pptViewElementPlayer2 = player2;        
    }
    
    /**
     * Informa al panel donde se muestra el elemento apostado por cada jugador,
     * que debe mostrar el elemento indicado por parámetro
     * @param player Jugador en cuyo panel se desea mostrar el elemento
     * @param element Elemento que se debe mostrar
     */
    public static void selectElement(byte player, byte element) {
        // Ejecuta el método que se encarga de mostrar la imagen asociada al
        //  elemento especificado, en el panel correspondiente al jugador indicado
        if(player == PPTGame.PLAYER_1) {
            pptViewElementPlayer1.drawElement(element);
        } else {
            pptViewElementPlayer2.drawElement(element);
        }
        // Para que no quede ningún botón destacado en pantalla con el foco
        pptViewScore1.requestFocus();
        
        // En la clase de la mecánica del juego se indica que el jugador indicado
        //  ha realizado una apuesta por el elemento señalado
        pptGame.setBetPlayer(player, element);
        
        // Se comprueba si los 2 jugadores han realizado su apuesta
        if(pptGame.isGameStarted()) {
            // Sólo 1 jugador ha realizado su elección, por lo que se borra
            //  el fondo anterior de los dos jugadores, ya que estará indicando
            //  todavía el ganador de la jugada previa
            pptViewElementPlayer1.setStyle("-fx-background-color: transparent;");
            pptViewElementPlayer2.setStyle("-fx-background-color: transparent;");
            // Se limpia el contenido del jugador contrario
            if(player == PPTGame.PLAYER_1) {
                pptViewElementPlayer2.drawElement(PPTGame.EMPTY);
            } else {
                pptViewElementPlayer1.drawElement(PPTGame.EMPTY);
            }
        } else {
            // Los 2 jugadores han realizado su apuesta, por lo que hay que 
            //  conocer quién es el ganador o si hay empate, y se colorea
            //  en verde el fondo del ganador, o en rojo los empates
            switch(pptGame.getWinner()) {
                case PPTGame.NO_PLAYER:
                    pptViewElementPlayer1.setStyle("-fx-background-color: #FF7777;");
                    pptViewElementPlayer2.setStyle("-fx-background-color: #FF7777;");
                    break;
                case PPTGame.PLAYER_1:
                    pptViewElementPlayer1.setStyle("-fx-background-color: #77FF77;");
                    break;
                case PPTGame.PLAYER_2:
                    pptViewElementPlayer2.setStyle("-fx-background-color: #77FF77;");
                    break;
            }
            // Se actualiza en pantalla las puntuaciones de los 2 jugadores
            pptViewScore1.setScore(pptGame.getScorePlayer(PPTGame.PLAYER_1));
            pptViewScore2.setScore(pptGame.getScorePlayer(PPTGame.PLAYER_2));
        }
    }
    
    /**
     * Realiza la selección de un determinado elemento asociado a uno de los
     * jugadores en función de la tecla especificada
     * @param keyName Nombre de la tecla asociada a uno de los elementos del juego
     */
    public static void manageKeys(String keyName) {
        switch(keyName) {
            case KEY_ROCK_PLAYER1:
                selectElement(PPTGame.PLAYER_1, PPTGame.ROCK);
                break;
            case KEY_PAPER_PLAYER1:
                selectElement(PPTGame.PLAYER_1, PPTGame.PAPER);
                break;
            case KEY_SCISSOR_PLAYER1:
                selectElement(PPTGame.PLAYER_1, PPTGame.SCISSOR);
                break;
            case KEY_ROCK_PLAYER2:
                selectElement(PPTGame.PLAYER_2, PPTGame.ROCK);
                break;
            case KEY_PAPER_PLAYER2:
                selectElement(PPTGame.PLAYER_2, PPTGame.PAPER);
                break;
            case KEY_SCISSOR_PLAYER2:
                selectElement(PPTGame.PLAYER_2, PPTGame.SCISSOR);
                break;
        }
    }
    
}

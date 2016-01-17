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
 * Mecánica del clásico juego Pidra, Papel, Tijera para 2 jugadores, con métodos
 * para asignar la apuesta de cada jugador, conocer la puntuación de cada uno,
 * así como el ganador de una determinada partida.
 * @author Javier García Escobedo <javiergarciaescobedo.es>
 */
public class PPTGame {
    
    /**
     * Identificador para indicar ningún elemento 
     */
    public static final byte EMPTY = -1;

    /**
     * Identificador para el elemento tijera
     */
    public static final byte SCISSOR = 0;

    /**
     * Identificador para el elemento piedra
     */
    public static final byte ROCK = 1;

    /**
     * Identificador para el elemento papel
     */
    public static final byte PAPER = 2;

    /**
     * Identificador para indicar ningún jugador
     */
    public static final byte NO_PLAYER = 0;

    /**
     * Identificador para el jugador 1
     */
    public static final byte PLAYER_1 = 1;

    /**
     * Identificador para el jugador 2
     */
    public static final byte PLAYER_2 = 2;
    
    // Indicador para conocer si todavía sólo uno de los jugadores ha realizado apuestas
    private boolean gameStarted = false;
    // Almacen para las apuestas de cada jugador (EMPTY, ROCK, PAPER o SCISSOR)
    private byte betPlayer1 = EMPTY;
    private byte betPlayer2 = EMPTY;
    // Puntuación de los jugadores
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    
    /**
     * Establece el elemento por el que apuesta un jugador
     * @param player Identificador del jugador que realiza la apuesta, usando
     * una de las propiedades constantes declaradas en esta clase (PLAYER_1,
     * PLAYER_2)
     * @param bet Identificador del elemento por el que apuesta el jugador 
     * espeficado (piedra, papel o tijera) , usando una de las propiedades 
     * constantes declaradas en esta clase (ROCK, PAPER, SCISSOR)
     */
    public void setBetPlayer(byte player, byte bet) {
        if(!isGameStarted()) {
            setGameStarted(true);
        }
        switch(player) {
            case PLAYER_1:
                betPlayer1 = bet;
                break;
            case PLAYER_2:
                betPlayer2 = bet;
                break;
        }
        if(betPlayer1 != EMPTY && betPlayer2 != EMPTY) {
            setGameStarted(false);
        }
    }
    
    /**
     * Permite conocer el estado de la jugada actual.
     * @return true si sólo uno de los jugadores ha realizado una apuesta, y
     * false en caso de que los dos jugadores hayan realizado ya su apuesta
     */
    public boolean isGameStarted() {
        return this.gameStarted;
    }
    
    /**
     * Permite indicar si la partida está iniciada o ya finalizada
     * @param gameStarted true si sólo uno de los jugadores ha realizado su
     * apuesta, y false si los dos jugadores han realizado su apuesta
     */
    public void setGameStarted(boolean gameStarted) {
        if(gameStarted) {
            betPlayer1 = EMPTY;
            betPlayer2 = EMPTY;
        }
        this.gameStarted = gameStarted;
    }
    
    /**
     * Obtiene el identificador del jugador que gana la partida
     * @return Identificador del jugador que gana la partida, pudiendo asignarse
     * una de las propiedades constantes de esta clase (PLAYER_1, PLAYER_2 o 
     * NO_PLAYER en caso de empate)
     */
    public byte getWinner() {
        byte winner = NO_PLAYER;
        switch(betPlayer1 - betPlayer2) {
            case -2:
                scorePlayer1++;
                winner = PLAYER_1;
                break;
            case -1:
                scorePlayer2++;
                winner = PLAYER_2;
                break;
            case 0:
                winner = NO_PLAYER;
                break;
            case 1:
                scorePlayer1++;
                winner = PLAYER_1;
                break;
            case 2:
                scorePlayer2++;
                winner = PLAYER_2;
                break;
            default:
                winner = NO_PLAYER;
                break;
        }
        return winner;
    }

    /**
     * Obtiene la puntuación del jugador especificado
     * @param player Identificador del jugador del que se quiere conocer su
     * puntuación, pudiendo usarse una de las propiedades (PLAYER_1 ó PLAYER_2)
     * @return Puntuación del jugador especificado
     */
    public int getScorePlayer(byte player) {
        if(player == PLAYER_1) {
            return scorePlayer1;
        } else {
            return scorePlayer2;
        }
    }
    
}

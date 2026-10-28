/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenjava;
import java.util.ArrayList;
/**
 *
 * @author aaron
 */
public class Game {
    private static final int MAX_ROUNDS = 10;
    private int currentPlayerIndex;
    private String log;
    
    private Player currentPlayer;
    private ArrayList<Player> players;
    private ArrayList<Monster> monsters;
    private Labyrinth labyrinth;

    public Game(int nPlayers) {
        this.players = new ArrayList<>();
        for (int i = 0; i < nPlayers; i++) {
            this.players.add(new Player((char) ('0' + i), Dice.randomIntelligence(), Dice.randomStrength()));
        }
        
        this.currentPlayerIndex = Dice.whoStarts(nPlayers);
        this.currentPlayer = this.players.get(this.currentPlayerIndex);
        this.monsters = new ArrayList<>();
        // Dimensiones configurables según el diseño del tablero
        this.labyrinth = new Labyrinth(10, 10, 9, 9); 
        this.log = "";
        
        this.configureLabyrinth();
        this.labyrinth.spreadPlayers(this.players);
    }

    public boolean finished() {
        return this.labyrinth.haveAWinner();
    }

    public GameState getGameState() {
        String playersState = "";
        for (Player p : players) playersState += p.toString() + "\n";
        
        String monstersState = "";
        for (Monster m : monsters) monstersState += m.toString() + "\n";
        
        return new GameState(labyrinth.toString(), playersState, monstersState, currentPlayerIndex, finished(), log);
    }

    public void configureLabyrinth() {
        // Inicialización básica de prueba; ajustar en función del laberinto final
        labyrinth.addBlock(Orientation.VERTICAL, 1, 1, 3);
        Monster m1 = new Monster("Orc", 4.0f, 3.0f);
        this.monsters.add(m1);
        labyrinth.addMonster(2, 2, m1);
    }

    public void nextPlayer() {
        this.currentPlayerIndex = (this.currentPlayerIndex + 1) % this.players.size();
        this.currentPlayer = this.players.get(this.currentPlayerIndex);
    }

    public void logPlayerWon() {
        this.log += "El jugador ha ganado el combate.\n";
    }

    public void logMonsterWon() {
        this.log += "El monstruo ha ganado el combate.\n";
    }

    public void logResurrected() {
        this.log += "El jugador ha resucitado.\n";
    }

    public void logPlayerSkipTurn() {
        this.log += "El jugador ha perdido el turno por estar muerto.\n";
    }

    public void logPlayerNoOrders() {
        this.log += "El jugador no ha seguido las instrucciones del jugador humano (no fue posible).\n";
    }

    public void logNoMonster() {
        this.log += "El jugador se ha movido a una celda vacía o no le ha sido posible moverse.\n";
    }

    public void logRounds(int rounds, int max) {
        this.log += "Se han producido " + rounds + " de " + max + " rondas de combate.\n";
    }

    public boolean nextStep(Directions preferredDirection) {
        throw new UnsupportedOperationException();
    }

    public Directions actualDirection(Directions preferredDirection) {
        throw new UnsupportedOperationException();
    }

    public GameCharacter combat(Monster monster) {
        throw new UnsupportedOperationException();
    }

    public void manageReward(GameCharacter winner) {
        throw new UnsupportedOperationException();
    }

    public void manageResurrection() {
        throw new UnsupportedOperationException();
    }
}

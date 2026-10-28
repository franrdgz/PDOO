/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenjava;

/**
 *
 * @author fran-rdgz
 */
public class TestP2 {

    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE LA PRÁCTICA 2 (JAVA) ===");
        
        // 1. Creamos una partida con 2 jugadores
        System.out.println("\n--- Creando partida con 2 jugadores ---");
        Game game = new Game(2);
        
        // 2. Comprobamos el estado inicial llamando a getGameState()
        GameState state = game.getGameState();
        
        System.out.println("\n--- LABERINTO INICIAL ---");
        System.out.println(state.getLabyrinth());
        
        System.out.println("--- JUGADORES ---");
        System.out.println(state.getPlayers());
        
        System.out.println("\n--- MONSTRUOS ---");
        System.out.println(state.getMonsters());
        
        System.out.println("\n--- ESTADO DEL TURNO ---");
        System.out.println("Índice del jugador actual: " + state.getCurrentPlayer());
        System.out.println("¿Hay ganador?: " + state.getWinner());
        System.out.println("Log actual:\n" + state.getLog());
        
        // 3. Probamos el cambio de turno
        System.out.println("--- Cambiando de turno con nextPlayer() ---");
        game.nextPlayer();
        
        GameState nextState = game.getGameState();
        System.out.println("Nuevo jugador actual: " + nextState.getCurrentPlayer());
        
        // 4. Probar logs
        System.out.println("\n--- Añadiendo mensajes al log de prueba ---");
        game.logPlayerWon();
        game.logMonsterWon();
        game.logResurrected();
        
        System.out.println("Log actualizado:\n" + game.getGameState().getLog());
        
        System.out.println("=== FIN DE LAS PRUEBAS P2 ===");
    }
}
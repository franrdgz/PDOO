/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenjava;

/**
 *
 * @author aaron
 */
public class MainP3 {
    
    public static void main(String[] args) {
        System.out.println("=== INICIANDO PARTIDA IRRGARTEN ===");
        
        // 1. Inicializamos el juego con el número de jugadores deseado
        int numPlayers = 2; 
        Game game = new Game(numPlayers);
        
        // 2. Inicializamos la vista (interfaz de texto)
        TextUI view = new TextUI();
        
        // 3. Inicializamos el controlador pasándole el juego y la vista
        Controller controller = new Controller(game, view);
        
        // 4. Arrancamos el bucle del juego
        controller.play();
    }
}
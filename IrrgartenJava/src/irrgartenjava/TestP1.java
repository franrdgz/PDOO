/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package irrgartenjava;

/**
 *
 * @author aaron
 */
public class TestP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("--- PRUEBAS DE LA PRÁCTICA 1 ---");

        // Prueba de enumerados
        System.out.println("Dirección de ejemplo: " + Directions.LEFT);
        System.out.println("Orientación de ejemplo: " + Orientation.VERTICAL);
        System.out.println("Personaje de ejemplo: " + GameCharacter.MONSTER);

        // Prueba de Weapon
        Weapon arma = new Weapon(2.5f, 4);
        System.out.println("\nArma creada: " + arma.toString());
        System.out.println("Ataque 1: " + arma.attack());
        System.out.println("Estado de arma tras ataque: " + arma.toString());

        // Prueba de Shield
        Shield escudo = new Shield(1.5f, 2);
        System.out.println("\nEscudo creado: " + escudo.toString());
        System.out.println("Defensa 1: " + escudo.protect());
        System.out.println("Estado de escudo tras defensa: " + escudo.toString());

        // Prueba de GameState
        GameState estado = new GameState("Laberinto Base", "Jugador 1", "Monstruo A", 0, false, "Iniciando turno");
        System.out.println("\nGameState - Jugador actual index: " + estado.getCurrentPlayer());
        System.out.println("GameState - Log actual: " + estado.getLog());

        // Prueba de Dice (100 llamadas)
        System.out.println("\n--- COMPROBACIÓN DE PROBABILIDADES EN DICE ---");
        int resurrections = 0;
        for (int i = 0; i < 100; i++) {
            if (Dice.resurrectPlayer()) {
                resurrections++;
            }
        }
        System.out.println("Veces que el jugador resucita en 100 intentos (debería rondar 30): " + resurrections);
        System.out.println("Ejemplo de recompensa de arma generada (0-2): " + Dice.weaponsReward());
        System.out.println("Ejemplo de fuerza generada (0.0-10.0): " + Dice.randomStrength());

    }
    
}

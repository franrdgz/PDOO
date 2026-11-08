/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenjava;

/**
 *
 * @author fran-rdgz
 */

import java.util.ArrayList;

public class TestP3 {
    public static void main(String[] args) {
        System.out.println("=== PRUEBAS SOCIO B (P3 JAVA) ===");

        // 1. Probar Player y descarte inverso
        Player p = new Player('0', 5.0f, 5.0f);
        System.out.println("Añadiendo armas de prueba...");
        p.receiveWeapon(new Weapon(2.0f, 0)); // Usos en 0 para forzar discard()
        p.receiveWeapon(new Weapon(3.0f, 2));
        System.out.println("Estado Player: " + p.toString());

        // 2. Probar Labyrinth y addBlock
        Labyrinth lab = new Labyrinth(6, 6, 5, 5);
        lab.addBlock(Orientation.VERTICAL, 0, 1, 3);
        System.out.println("\nLaberinto con bloque vertical:\n" + lab.toString());

        // 3. Probar validMoves
        ArrayList<Directions> moves = lab.validMoves(0, 0);
        System.out.println("Movimientos válidos desde (0,0): " + moves);
    }
}

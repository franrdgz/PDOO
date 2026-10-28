/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenjava;

/**
 *
 * @author aaron
 */
public class Monster {
    private static final int INITIAL_HEALTH = 5;
    // Atributo de clase añadido para representar posición inválida
    private static final int INVALID_POS = -1;

    private String name;
    private float intelligence;
    private float strength;
    private int health;
    private int row;
    private int col;

    public Monster(String name, float intelligence, float strength) {
        this.name = name;
        this.intelligence = intelligence;
        this.strength = strength;
        this.health = INITIAL_HEALTH;
        this.row = INVALID_POS;
        this.col = INVALID_POS;
    }

    public boolean dead() {
        return this.health <= 0;
    }

    public float attack() {
        return Dice.intensity(this.strength);
    }

    public void setPos(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public String toString() {
        return "Monster[name=" + name + ", health=" + health + 
               ", intelligence=" + intelligence + ", strength=" + strength + 
               ", pos=(" + row + "," + col + ")]";
    }

    public void gotWounded() {
        this.health -= 1;
    }

    public boolean defend(float receivedAttack) {
        //Este se hace en la siguiente practica
        throw new UnsupportedOperationException();
    }
}

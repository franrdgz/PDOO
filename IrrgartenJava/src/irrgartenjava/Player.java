/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenjava;
import java.util.ArrayList;
/**
 *
 * @author fran-rdgz
 */
public class Player {
    private static final int MAX_WEAPONS = 2;
    private static final int MAX_SHIELDS = 3;
    private static final int INITIAL_HEALTH = 10;
    private static final int HITS_2_LOSE = 3;

    private String name;
    private char number;
    private float intelligence;
    private float strength;
    private float health;
    private int row;
    private int col;
    private int consecutiveHits;

    private ArrayList<Weapon> weapons;
    private ArrayList<Shield> shields;

    public Player(char number, float intelligence, float strength) {
        this.number = number;
        this.name = "Player #" + number;
        this.intelligence = intelligence;
        this.strength = strength;
        this.health = INITIAL_HEALTH;
        this.row = -1;
        this.col = -1;
        this.consecutiveHits = 0;
        this.weapons = new ArrayList<>();
        this.shields = new ArrayList<>();
    }

    public void resurrect() {
        this.weapons.clear();
        this.shields.clear();
        this.health = INITIAL_HEALTH;
        this.consecutiveHits = 0;
    }

    public void setPos(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean dead() {
        return this.health <= 0;
    }

    public float attack() {
        return this.strength + this.sumWeapons();
    }

    public boolean defend(float receivedAttack) {
        return this.manageHit(receivedAttack);
    }

    public String toString() {
        return "P[" + name + ", H:" + health + ", S:" + strength + ", I:" + intelligence 
             + ", Pos:(" + row + "," + col + "), Hits:" + consecutiveHits + "]";
    }

    private Weapon newWeapon() {
        return new Weapon(Dice.weaponPower(), Dice.usesLeft());
    }

    private Shield newShield() {
        return new Shield(Dice.shieldPower(), Dice.usesLeft());
    }

    protected float defensiveEnergy() {
        return this.intelligence + this.sumShields();
    }

    private void resetHits() {
        this.consecutiveHits = 0;
    }

    private void gotWounded() {
        this.health--;
    }

    private void incConsecutiveHits() {
        this.consecutiveHits++;
    }

    protected float sumWeapons() {
        float totalPower = 0.0f;
        for (Weapon w : weapons) {
            totalPower += w.attack();
        }
        return totalPower;
    }

    protected float sumShields() {
        float totalProtect = 0.0f;
        for (Shield s : shields) {
            totalProtect += s.protect();
        }
        return totalProtect;
    }

    // Cabeceras de métodos pendientes para la Práctica 3
    public Directions move(Directions direction, ArrayList<Directions> validMoves) {
        throw new UnsupportedOperationException();
    }

    public void receiveReward() {
        throw new UnsupportedOperationException();
    }

    public void receiveWeapon(Weapon w) {
        throw new UnsupportedOperationException();
    }

    public void receiveShield(Shield s) {
        throw new UnsupportedOperationException();
    }

    public boolean manageHit(float receivedAttack) {
        throw new UnsupportedOperationException();
    } 
}

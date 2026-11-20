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
public class Player extends LabyrinthCharacter{
    private static final int MAX_WEAPONS = 2;
    private static final int MAX_SHIELDS = 3;
    private static final int INITIAL_HEALTH = 10;
    private static final int HITS_2_LOSE = 3;

    private char number;
    private int consecutiveHits;

    private ArrayList<Weapon> weapons;
    private ArrayList<Shield> shields;

    public Player(char number, float intelligence, float strength) {
        super("Player #" + number, intelligence, strength, INITIAL_HEALTH);
        this.number = number;
        this.consecutiveHits = 0;
        this.weapons = new ArrayList<>();
        this.shields = new ArrayList<>();
    }
    
    public Player(Player other) {
        super(other);
        this.number = other.number;
        this.consecutiveHits = other.consecutiveHits;
        this.weapons = new ArrayList<>(other.weapons);
        this.shields = new ArrayList<>(other.shields);
    }

    public void resurrect() {
        this.weapons.clear();
        this.shields.clear();
        setHealth(INITIAL_HEALTH);
        this.consecutiveHits = 0;
    }

    @Override
    public float attack() {
        return getStrength() + this.sumWeapons();
    }

    @Override
    public boolean defend(float receivedAttack) {
        return this.manageHit(receivedAttack);
    }

    @Override
    public String toString() {
        return "P[" + super.toString() + ", Hits:" + consecutiveHits
             + ", Weapons:" + weapons.size() + ", Shields:" + shields.size() + "]";
    }

    private Weapon newWeapon() {
        return new Weapon(Dice.weaponPower(), Dice.usesLeft());
    }

    private Shield newShield() {
        return new Shield(Dice.shieldPower(), Dice.usesLeft());
    }

    protected float defensiveEnergy() {
        return getIntelligence() + this.sumShields();
    }

    private void resetHits() {
        this.consecutiveHits = 0;
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

    public Directions move(Directions direction, ArrayList<Directions> validMoves) {
        int size = validMoves.size();
        boolean contained = validMoves.contains(direction);
        if (size > 0 && !contained) {
            return validMoves.get(0);
        } else {
            return direction;
        }
    }

    public void receiveReward() {
        int wReward = Dice.weaponsReward();
        int sReward = Dice.shieldsReward();
        for (int i = 0; i < wReward; i++) {
            receiveWeapon(newWeapon());
        }
        for (int i = 0; i < sReward; i++) {
            receiveShield(newShield());
        }
        int extraHealth = Dice.healthReward();
        setHealth(getHealth() + extraHealth);
    }

    public void receiveWeapon(Weapon w) {
        for (int i = weapons.size() - 1; i >= 0; i--) {
            if (weapons.get(i).discard()) {
                weapons.remove(i);
            }
        }
        if (weapons.size() < MAX_WEAPONS) {
            weapons.add(w);
        }
    }

    public void receiveShield(Shield s) {
        for (int i = shields.size() - 1; i >= 0; i--) {
            if (shields.get(i).discard()) {
                shields.remove(i);
            }
        }
        if (shields.size() < MAX_SHIELDS) {
            shields.add(s);
        }
    }

    public boolean manageHit(float receivedAttack) {
        float defense = defensiveEnergy();
        if (defense < receivedAttack) {
            gotWounded();
            incConsecutiveHits();
        } else {
            resetHits();
        }
        return (consecutiveHits == HITS_2_LOSE) || dead();
    }

    public char getNumber() {
        return this.number;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenjava;

/**
 *
 * @author aaron
 */
abstract class CombatElement {
    private float effect;
    private int uses;

    public CombatElement(float effect, int uses) {
        this.effect = effect;
        this.uses = uses;
    }

    protected float getEffect() {
        return effect;
    }

    protected int getUses() {
        return uses;
    }

    protected float produceEffect() {
        if (uses > 0) {
            uses--;
            return effect;
        }
        return 0.0f;
    }

    public boolean discard() {
        return Dice.discardElement(uses);
    }

    @Override
    public String toString() {
        return "[" + effect + ", " + uses + "]";
    }
}

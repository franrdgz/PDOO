/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenjava;

/**
 *
 * @author aaron
 */
public class Shield {
    private float protection;
    private int uses;
    
    public Shield(float p, int u) {
        this.protection = p;
        this.uses = u;
    }
    
    public float protect() {
        if (this.uses > 0) {
            this.uses--;
            return this.protection;
        } else {
            return 0.0f;
        }
    }
    
    public String toString() {
        return "S[" + protection + ", " + uses + "]";
    }
    
    public boolean discard() {
        return Dice.discardElement(this.uses);
    }
}

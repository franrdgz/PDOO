/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenjava;

/**
 *
 * @author fran-rdgz
 */
public class Weapon {
    private float power;
    private int uses; 
    
    
    public Weapon (float p, int u){
        this.power = p;
        this.uses = u;
    }
    
    public float attack (){
        if (this.uses > 0){
            this.uses--;
            return this.power;
        }
        else{
            return 0.0f;
        }
    }
    
    public String toString (){
        return "W[" + power + ", " + uses + "]";
    }
}

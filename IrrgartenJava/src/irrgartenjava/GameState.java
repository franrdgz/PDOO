/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenjava;

/**
 *
 * @author fran-rdgz
 */
public class GameState {
    private String labyrinth;
    private String players;
    private String monsters;
    private int currentPlayer;
    private boolean winner;
    private String log;
 
    public GameState( String l, String p, String m, int cP, boolean w, String log){
        this.labyrinth = l;
        this.players = p;
        this.monsters = m;
        this.currentPlayer = cP;
        this.winner = w;
        this.log = log;
    }
    
    public String getLabyrinth(){
        return labyrinth;
    }
    
     public String getPlayers(){
        return players;
    }
     
      public String getMonsters(){
        return monsters;
    }
      
       public int getCurrentPlayer(){
        return currentPlayer;
    }
       
        public boolean getwinner(){
        return winner;
    }
       
         public String getLog(){
        return log;
    }
         
         
}

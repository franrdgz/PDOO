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
public class Labyrinth {
    private static final char BLOCK_CHAR = 'X';
    private static final char EMPTY_CHAR = '-';
    private static final char MONSTER_CHAR = 'M';
    private static final char EXIT_CHAR = 'E';
    private static final char COMBAT_CHAR = 'C';

    public static final int ROW = 0;
    public static final int COL = 1;

    private int nRows;
    private int nCols;
    private int exitRow;
    private int exitCol;

    private Monster[][] monsters;
    private Player[][] players;
    private char[][] labyrinth;

    public Labyrinth(int nRows, int nCols, int exitRow, int exitCol) {
        this.nRows = nRows;
        this.nCols = nCols;
        this.exitRow = exitRow;
        this.exitCol = exitCol;

        this.monsters = new Monster[nRows][nCols];
        this.players = new Player[nRows][nCols];
        this.labyrinth = new char[nRows][nCols];

        for (int r = 0; r < nRows; r++) {
            for (int c = 0; c < nCols; c++) {
                this.labyrinth[r][c] = EMPTY_CHAR;
            }
        }

        if (posOK(exitRow, exitCol)) {
            this.labyrinth[exitRow][exitCol] = EXIT_CHAR;
        }
    }

    public boolean haveAWinner() {
        return players[exitRow][exitCol] != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < nRows; r++) {
            for (int c = 0; c < nCols; c++) {
                sb.append('[').append(labyrinth[r][c]).append(']');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public void addMonster(int row, int col, Monster monster) {
        if (posOK(row, col) && emptyPos(row, col)) {
            labyrinth[row][col] = MONSTER_CHAR;
            monsters[row][col] = monster;
            monster.setPos(row, col);
        }
    }

    public boolean posOK(int row, int col) {
        return row >= 0 && row < nRows && col >= 0 && col < nCols;
    }

    public boolean emptyPos(int row, int col) {
        return posOK(row, col) && labyrinth[row][col] == EMPTY_CHAR;
    }

    public boolean monsterPos(int row, int col) {
        return posOK(row, col) && labyrinth[row][col] == MONSTER_CHAR;
    }

    public boolean exitPos(int row, int col) {
        return posOK(row, col) && row == exitRow && col == exitCol;
    }

    public boolean combatPos(int row, int col) {
        return posOK(row, col) && labyrinth[row][col] == COMBAT_CHAR;
    }

    public boolean canStepOn(int row, int col) {
        return posOK(row, col) && (emptyPos(row, col) || monsterPos(row, col) || exitPos(row, col));
    }

    public void updateOldPos(int row, int col) {
        if (posOK(row, col)) {
            if (combatPos(row, col)) {
                labyrinth[row][col] = MONSTER_CHAR;
            } else {
                labyrinth[row][col] = EMPTY_CHAR;
            }
        }
    }

    public int[] dir2Pos(int row, int col, Directions direction) {
        int targetRow = row;
        int targetCol = col;

        switch (direction) {
            case UP:
                targetRow--;
                break;
            case DOWN:
                targetRow++;
                break;
            case LEFT:
                targetCol--;
                break;
            case RIGHT:
                targetCol++;
                break;
        }

        return new int[]{targetRow, targetCol};
    }

    public int[] randomEmptyPos() {
        int row, col;
        do {
            row = Dice.randomPos(nRows);
            col = Dice.randomPos(nCols);
        } while (!emptyPos(row, col));

        return new int[]{row, col};
    }

    // Cabeceras de métodos pendientes para la Práctica 3
    public void spreadPlayers(ArrayList<Player> players) {
        throw new UnsupportedOperationException();
    }

    public Monster putPlayer(Directions direction, Player player) {
        throw new UnsupportedOperationException();
    }

    public void addBlock(Orientation orientation, int startRow, int startCol, int length) {
        throw new UnsupportedOperationException();
    }

    public ArrayList<Directions> validMoves(int row, int col) {
        throw new UnsupportedOperationException();
    }    
}

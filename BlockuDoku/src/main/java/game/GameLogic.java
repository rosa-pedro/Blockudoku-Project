
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author rosap
 */
public class GameLogic {
    private static Scoreboard<User> userHighScores = new Scoreboard();
    
    public GameLogic() {
        
    }
    
    public static void addUserHighScore(Score score){
        if(score != null){
        userHighScores.insertScore(score);
        }
    }
    
    public static Scoreboard getScoreboard(){
        return userHighScores;
    }
    
    /*public void insertScoreboard(Scoreboard scoreboard){
        Iterator it = scoreboard.getScoreboard().iterator();
        //ArrayList<Score<User>> scoreboard1 = userHighScores.getScoreboard();
        while(it.hasNext()){
            Score<User> next = (Score<User>)it.next();
            userHighScores.getScoreboard().add(next);
        }
    }*/
    
    public static void parseBoard(Board board) {

        HashSet<String> clearSquares = getFullSquares(board);

        if (!clearSquares.isEmpty()) {
            
            board.clearBoard(clearSquares);
        }
        
        HashSet<Integer> clearRows = getFullRows(board);
        clearRows.forEach(r -> board.clearRow(r));
        
        HashSet<String> clearColumns = getFullColumns(board);
        clearColumns.forEach(c -> board.clearColumn(c));

    }

    public static HashSet<Integer> getFullRows(Board board) {

        HashMap<String, Square> coords = board.getCoords();

        String key;
        boolean full = false;

        HashSet<Integer> fullRows = new HashSet<>();

        for (int i = 1; i <= 9; i++) {

            for (int j = 0; j < 9; j++) {

                key = String.valueOf((char) (65 + j));
                key = key.concat(String.valueOf(i));

                Square sqr = coords.get(key);
                full = sqr.isVisible();

                if (!full) {
                    break;
                }
            }

            if (full) {
                fullRows.add(i);
            }
        }

        return fullRows;
    }

    public static HashSet<String> getFullColumns(Board board) {

        HashMap<String, Square> coords = board.getCoords();

        String key;
        boolean full = false;

        HashSet<String> fullColumns = new HashSet<>();

        for (int i = 0; i < 9; i++) {

            for (int j = 1; j <= 9; j++) {

                key = String.valueOf((char) (65 + i));
                key = key.concat(String.valueOf(j));

                Square sqr = coords.get(key);
                full = sqr.isVisible();

                if (!full) {
                    break;
                }
            }

            if (full) {
                fullColumns.add(String.valueOf((char) (65 + i)));
            }
        }

        return fullColumns;
    }

    public static HashSet<String> getFullSquares(Board board) {

        HashMap<String, Square> coords = board.getCoords();

        HashSet<String> firstQuadrant = board.getBoardSquare("A1", "C3");
        HashSet<String> secondQuadrant = board.getBoardSquare("D1", "F3");
        HashSet<String> thirdQuadrant = board.getBoardSquare("G1", "I3");
        HashSet<String> fourthQuadrant = board.getBoardSquare("A4", "C6");
        HashSet<String> fifthQuadrant = board.getBoardSquare("D4", "F6");
        HashSet<String> sixthQuadrant = board.getBoardSquare("G4", "I6");
        HashSet<String> seventhQuadrant = board.getBoardSquare("A7", "C9");
        HashSet<String> eighthQuadrant = board.getBoardSquare("D7", "F9");
        HashSet<String> ninethQuadrant = board.getBoardSquare("G7", "I9");

        HashSet<String> fullSquares = new HashSet<>();

        if (firstQuadrant.stream().allMatch(c -> coords.get(c).isVisible())) {
            fullSquares.addAll(firstQuadrant);
        }
        if (secondQuadrant.stream().allMatch(c -> coords.get(c).isVisible())) {
            fullSquares.addAll(secondQuadrant);
        }
        if (thirdQuadrant.stream().allMatch(c -> coords.get(c).isVisible())) {
            fullSquares.addAll(thirdQuadrant);
        }
        if (fourthQuadrant.stream().allMatch(c -> coords.get(c).isVisible())) {
            fullSquares.addAll(fourthQuadrant);
        }
        if (fifthQuadrant.stream().allMatch(c -> coords.get(c).isVisible())) {
            fullSquares.addAll(fifthQuadrant);
        }
        if (sixthQuadrant.stream().allMatch(c -> coords.get(c).isVisible())) {
            fullSquares.addAll(sixthQuadrant);
        }
        if (seventhQuadrant.stream().allMatch(c -> coords.get(c).isVisible())) {
            fullSquares.addAll(seventhQuadrant);
        }
        if (eighthQuadrant.stream().allMatch(c -> coords.get(c).isVisible())) {
            fullSquares.addAll(eighthQuadrant);
        }
        if (ninethQuadrant.stream().allMatch(c -> coords.get(c).isVisible())) {
            fullSquares.addAll(ninethQuadrant);
        }

        return fullSquares;
    }

    public static boolean canInsertBlockInBoard(Board board, Piece piece) {

        HashMap<String, Square> coords = board.getCoords();

        boolean canBeInserted = coords.entrySet().stream().anyMatch(e -> board.canInsertBlock(piece, e.getKey()));

        return canBeInserted;
    }

    
    
    
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author rosap
 */
public class BoardCleanUpLogic {

    public static void cleanUpBoard(Board board) {

        HashSet<String> toBeCleanUp = getFullSquares(board);
        toBeCleanUp.addAll(getFullRows(board));
        toBeCleanUp.addAll(getFullColumns(board));

        if (!toBeCleanUp.isEmpty()) {
            board.clearBoard(toBeCleanUp);
        }
    }

    public static HashSet<String> getRowSection(Board board, int row) {

        HashSet<String> rowSectionCoords = new HashSet<>();
        String coord;

        for (int i = 0; i < 9; i++) {

            coord = board.getCoordinate(row, i);
            rowSectionCoords.add(coord);
        }
        return rowSectionCoords;
    }

    public static HashSet<String> getFullRows(Board board) {

        HashMap<String, Square> boardCoords = board.getCoords();
        HashSet<String> fullRows = new HashSet<>();
        HashSet<String> rowSection = new HashSet<>();

        for (int i = 1; i <= 9; i++) {

            rowSection = getRowSection(board, i);

            if (rowSection.stream().allMatch(c -> boardCoords.get(c).isVisible())) {
                fullRows.addAll(rowSection);
            }
        }
        return fullRows;
    }

    public static HashSet<String> getColumnSection(Board board, String column) {

        HashSet<String> columnSectionCoords = new HashSet<>();
        String coord;

        for (int i = 1; i <= 9; i++) {

            coord = board.getCoordinate(i, column);
            columnSectionCoords.add(coord);
        }
        return columnSectionCoords;
    }

    public static HashSet<String> getFullColumns(Board board) {

        HashMap<String, Square> boardCoords = board.getCoords();
        HashSet<String> fullColumns = new HashSet<>();
        HashSet<String> columnSection = new HashSet<>();

        for (int i = 0; i < 9; i++) {

            columnSection = getColumnSection(board, String.valueOf((char) (65 + i)));

            if (columnSection.stream().allMatch(c -> boardCoords.get(c).isVisible())) {
                fullColumns.addAll(columnSection);
            }
        }
        return fullColumns;
    }

    public static HashSet<String> getSquareSection(Board board, String firstCoord, String lastCoord) {

        HashSet<String> squareSectionCoords = new HashSet<>();
        String coord;

        int firstColumn = (int) (firstCoord.charAt(0) - 'A');
        int firstRow = Integer.parseInt(String.valueOf(firstCoord.charAt(1)));

        int lastColumn = (int) (lastCoord.charAt(0) - 'A');
        int lastRow = Integer.parseInt(String.valueOf(lastCoord.charAt(1)));

        for (int i = firstRow; i <= lastRow; i++) {

            for (int j = firstColumn; j <= lastColumn; j++) {

                coord = board.getCoordinate(i, j);
                squareSectionCoords.add(coord);
            }
        }
        return squareSectionCoords;
    }

    public static HashSet<String> getFullSquares(Board board) {

        HashMap<String, Square> boardCoords = board.getCoords();
        HashSet<String> fullSquares = new HashSet<>();

        String firstCoord, secondCoord;

        for (int i = 1; i <= 9; i = i + 3) {

            for (int j = 0; j < 9; j = j + 3) {

                firstCoord = board.getCoordinate(i, j);
                secondCoord = board.getCoordinate(i + 2, j + 2);

                HashSet<String> squareSection = getSquareSection(board, firstCoord, secondCoord);

                if (squareSection.stream().allMatch(c -> boardCoords.get(c).isVisible())) {
                    fullSquares.addAll(squareSection);
                }
            }
        }
        return fullSquares;
    }
}

package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimension;
    private List<List<Cell>> board;

    public Board(int dimension, List<List<Cell>> board) {
        super();
        this.board = new ArrayList<>();
        this.dimension = dimension;

        // Initialize the board
        for (int row = 0; row < dimension; row++) {
            List<Cell> cell_row = new ArrayList<>();
            for (int col = 0; col < dimension; col++) {
                cell_row.add(new Cell());
            }
            board.add(cell_row);
        }
    }

    public Board(int i) {
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

}

// 1. Make classes with private attributes
// 2. Create getters and setters for those
// 3. Always create a constructor that initializes those attributes - to avoid
// NULL pte exception

package models;

import java.util.Scanner;

public class Player {
    private Symbol symbol;
    private PlayerType playerType;
    private String name;

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Move makeMove(Board board) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter your row (starting from 1)");
        Integer row = sc.nextInt();
        System.out.println("Please enter your col (starting from 1)");
        Integer col = sc.nextInt();

        Move move = new Move(row, col, this);

        return move;

    }

}
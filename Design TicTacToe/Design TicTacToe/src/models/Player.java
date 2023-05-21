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

}
package com.example.user.vendingmachinekata;

public class Coin {
    private double CoinWeight=0.0;
    private double CoinSize=0.0;
    private String CoinName;

    public Coin(double CoinSize, double CoinWeight) {
        this.CoinSize = CoinSize;
        this.CoinWeight = CoinWeight;
    }

    public double getCoinWeight() {
        return CoinWeight;
    }

    public double getCoinSize() {
        return CoinSize;
    }

    public String getCoinName() {
        return CoinName;
    }

    public void setCoinName(String CoinName) {
        this.CoinName = CoinName;
    }

}

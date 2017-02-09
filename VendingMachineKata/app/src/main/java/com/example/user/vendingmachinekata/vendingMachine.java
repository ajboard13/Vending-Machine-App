package com.example.user.vendingmachinekata;

import java.math.BigDecimal;
import java.math.RoundingMode;

class vendingMachine {
    private static double ValueOfMoneyInserted;
    private CoinAcceptor coinAcceptor = new CoinAcceptor();
    private double amountNeeded;
    private String itemChosen;

    void insertQuarter() {
        Coin coin = new Coin(5.0, 1.25);
        double value = acceptCoin(coin);
        ValueOfMoneyInserted += value;
    }

    String chooseChips() {
        amountNeeded = 0.5;
        itemChosen = "Chips";
        return itemChosen + " selected." + coinAcceptor.determineIfExactChangeIsNeeded();
    }

    String chooseCandy() {
        amountNeeded = 0.65;
        itemChosen = "Candy";
        return itemChosen + " selected." + coinAcceptor.determineIfExactChangeIsNeeded();
    }

    String chooseSoda() {
        amountNeeded = 1.00;
        itemChosen = "Soda";
        return itemChosen + " selected." + coinAcceptor.determineIfExactChangeIsNeeded();
    }

    void insertDime() {
        Coin coin = new Coin(2.0, 0.5);
        double value = acceptCoin(coin);
        ValueOfMoneyInserted += value;
    }

    void insertNickle() {
        Coin coin = new Coin(4.0, 1.0);
        double value = acceptCoin(coin);
        ValueOfMoneyInserted += value;
    }

    String insertPenny() {
        Coin coin = new Coin(3.0, .75);
        double value = acceptCoin(coin);
        ValueOfMoneyInserted += value;
        return coinAcceptor.getMessage();
    }

    private double acceptCoin(Coin coin) {
        return this.coinAcceptor.DetermineCoinValue(coin);
    }

    String dispenseItem() {
        String message = "Not enough money inserted";
        ValueOfMoneyInserted = round(ValueOfMoneyInserted, 2);
        if (itemChosen == null) {
            message = "No Item Selected.";
        } else {
            if (ValueOfMoneyInserted >= amountNeeded) {
                message = itemChosen + " has been dispensed. Enjoy!\n";
                message += giveChange();
                itemChosen = null;
            }
        }
        return message;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private String giveChange() {
        double changeNeeded = ValueOfMoneyInserted - amountNeeded;
        String changeMessage = coinAcceptor.giveChange(changeNeeded);
        ValueOfMoneyInserted = 0;
        amountNeeded = 0;
        return changeMessage;
    }

    String returnCoins() {
        double coinsToReturn = ValueOfMoneyInserted;
        String changeMessage = coinAcceptor.giveChange(coinsToReturn);
        ValueOfMoneyInserted = 0;
        return changeMessage;
    }

    String emptyCoins() {
        coinAcceptor.emptyCoins();
        return "Coins emptied from machine. Exact change may be requested";
    }

    double getAmountNeeded() {
        return amountNeeded;
    }

    double getValueOfMoneyInserted() {
        return ValueOfMoneyInserted;
    }
}

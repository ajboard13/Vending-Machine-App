package com.example.user.vendingmachinekata;

public class vendingMachine {
    private static double ValueOfMoneyInserted;
    private double amountNeeded =0;
    private String itemChosen;

    CoinAcceptor coinAcceptor = new CoinAcceptor();

    public void insertQuarter(){
        Coin quarter = new Coin(5.0,1.25);
        double value = acceptCoin(quarter);
        ValueOfMoneyInserted += value;
        System.out.printf("Total: $%.2f\n" , ValueOfMoneyInserted);
    }

    public void chooseChips(){
        amountNeeded = 0.5;
        itemChosen = "Chips";
        coinAcceptor.determineIfExactChangeIsNeeded();
        System.out.printf("Chips : $%.2f", amountNeeded);
        System.out.println();
    }

    public void chooseCandy(){
        amountNeeded = 0.65;
        itemChosen = "Candy";
        coinAcceptor.determineIfExactChangeIsNeeded();
        System.out.printf("Candy : $%.2f", amountNeeded);
        System.out.println();
    }
    public void chooseSoda(){
        amountNeeded = 1.00;
        itemChosen = "Soda";
        coinAcceptor.determineIfExactChangeIsNeeded();
        System.out.printf("Soda : $%.2f", amountNeeded);
        System.out.println();
    }

    public void insertDime(){
        Coin quarter = new Coin(2.0,0.5);
        double value = acceptCoin(quarter);
        ValueOfMoneyInserted = ValueOfMoneyInserted+ value;
        System.out.printf("Total: $%.2f\n" , ValueOfMoneyInserted);
    }

    public void insertNickle(){
        Coin quarter = new Coin(4.0,1.0);
        double value = acceptCoin(quarter);
        ValueOfMoneyInserted = ValueOfMoneyInserted+ value;
        System.out.printf("Total: $%.2f\n" , ValueOfMoneyInserted);
    }

    public void insertPenny(){
        Coin quarter = new Coin(3.0,.75);
        double value = acceptCoin(quarter);
        ValueOfMoneyInserted = ValueOfMoneyInserted+ value;
        System.out.printf("Total: $%.2f\n" , ValueOfMoneyInserted);
    }
    public double acceptCoin(Coin coin){
        double coinValue = this.coinAcceptor.DetermineCoinValue(coin);
        return coinValue;
    }
    public void payForItem(){
        if(amountNeeded > ValueOfMoneyInserted){
        dispenseItem();
        }
    }

    public String dispenseItem() {
        String message = null;
        if (ValueOfMoneyInserted >= amountNeeded) {
            message = itemChosen + " has been dispensed. Enjoy!";
            System.out.printf("%s has been dispensed. Enjoy!\n", itemChosen);
            System.out.println();
            giveChange();
        }
        return message;
    }

    public void giveChange(){
        double changeNeeded = ValueOfMoneyInserted - amountNeeded;
        coinAcceptor.giveChange(changeNeeded);
        ValueOfMoneyInserted = 0;
    }
    public String emptyCoins(){
        coinAcceptor.emptyCoins();
        String message = "Coins emptied from machine. Exact change may be requested";
        return message;
    }
}

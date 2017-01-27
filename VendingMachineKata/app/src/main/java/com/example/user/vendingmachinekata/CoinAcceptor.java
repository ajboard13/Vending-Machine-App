package com.example.user.vendingmachinekata;

public class CoinAcceptor {
    private int numberOfQuarters = 3;
    private int numberOfDimes = 1;
    private int numberOfNickles = 3;
    private String message = "";


    public CoinAcceptor() {

    }

    public void emptyCoins(){
        numberOfDimes = 0;
        numberOfQuarters = 0;
        numberOfNickles = 0;
    }


    public double DetermineCoinValue(Coin coin) {
        double CoinValue = 0.0;
        double CoinSize = coin.getCoinSize();
        double CoinWeight = coin.getCoinWeight();


        if (CoinSize <= 1.00 && CoinWeight <= 0.25) {
            System.out.println("Not a valid coin.");
            message = "Not a valid coin.";
            ReturnCoin();

        } else if (CoinSize <= 2.00 && CoinWeight <= 0.5) {
            System.out.println("Dime Accepted");
            message = "Dime Accepted.";
            numberOfDimes += 1;
            CoinValue = 0.10;

        } else if (CoinSize <= 3.00 && CoinWeight <= 0.75) {
            System.out.println("Pennies are not valid.");
            message = "Pennies are not valid.\nCoin returned.";
            coin.setCoinName("Penny");
            ReturnCoin();
        } else if (CoinSize <= 4.00 && CoinWeight <= 1.0) {
            System.out.println("Nickle Accepted");
            message = "Nickle Accepted";
            numberOfNickles +=1;
            CoinValue = 0.05;
        } else if (CoinSize <= 5.00 && CoinWeight <= 1.25) {
            System.out.println("Quarter Accepted");
            message = "Quarter Accepted";
            numberOfQuarters +=1;
            CoinValue = 0.25;
        } else {
            System.out.println("Not a valid coin.");
            ReturnCoin();
        }
        return CoinValue;

    }

    public String returnMessage(){
        return message;
    }


    public String determineIfExactChangeIsNeeded(){
        message = "Change available";
        if ((numberOfNickles < 2) || (numberOfDimes < 1)){
            System.out.println("Exact change is needed");
            message = "Exact change is needed";
        }
        return message;
    }

    public void giveChange(double changeNeeded){
        System.out.printf("Change : $%.2f\n", changeNeeded);
        message = "Change: $" + changeNeeded;
        double quartersToReturn = (changeNeeded - (changeNeeded % 0.25)) / 0.25;
        System.out.printf("%.0f Quarters returned\n", quartersToReturn);
        changeNeeded = (changeNeeded % 0.25) +.0001;
        double dimesToReturn = (changeNeeded - (changeNeeded % 0.1)) / 0.1;
        System.out.printf("%.0f Dimes returned\n", dimesToReturn);
        changeNeeded = changeNeeded % 0.10;
        double nicklesToReturn = (changeNeeded - (changeNeeded %.05)) / 0.05;
        System.out.printf("%.0f Nickles returned\n", nicklesToReturn);
        numberOfQuarters -= quartersToReturn;
        numberOfDimes -= dimesToReturn;
        numberOfNickles -= nicklesToReturn;
    }


    public void ReturnCoin() {
        System.out.println("Coin/s placed in coin return");
    }

}

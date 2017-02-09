package com.example.user.vendingmachinekata;

class CoinAcceptor {
    private int numberOfQuarters = 3;
    private int numberOfDimes = 1;
    private int numberOfNickles = 3;
    private String message = "";


    CoinAcceptor() {

    }

    void emptyCoins() {
        numberOfDimes = 0;
        numberOfQuarters = 0;
        numberOfNickles = 0;
    }


    double DetermineCoinValue(Coin coin) {
        double CoinValue = 0.0;
        double CoinSize = coin.getCoinSize();
        double CoinWeight = coin.getCoinWeight();


        if (CoinSize <= 1.00 && CoinWeight <= 0.25) {
            message = "Not a valid coin.";

        } else {
            if (CoinSize <= 2.00 && CoinWeight <= 0.5) {
                message = "Dime Accepted.";
                numberOfDimes += 1;
                CoinValue = 0.10;

            } else {
                if (CoinSize <= 3.00 && CoinWeight <= 0.75) {
                    message = "Pennies are not valid.\nCoin returned.";
                    coin.setCoinName("Penny");
                } else {
                    if (CoinSize <= 4.00 && CoinWeight <= 1.0) {
                        message = "Nickle Accepted";
                        numberOfNickles += 1;
                        CoinValue = 0.05;
                    } else {
                        if (CoinSize <= 5.00 && CoinWeight <= 1.25) {
                            message = "Quarter Accepted";
                            numberOfQuarters += 1;
                            CoinValue = 0.25;
                        }
                    }
                }
            }
        }
        return CoinValue;

    }


    String determineIfExactChangeIsNeeded() {
        message = "\nChange available";
        if ((numberOfNickles < 2) || (numberOfDimes < 1)) {
            message = "\nExact change is needed";
        }
        return message;
    }

    String giveChange(double changeNeeded) {
        String changeMessage = "Change : $" + String.format("%.2f", changeNeeded) + "\n";
        double quartersToReturn = (changeNeeded - (changeNeeded % 0.25)) / 0.25;
        changeMessage += ((int) quartersToReturn) + " quarters returned\n";
        changeNeeded = (changeNeeded % 0.25) + .0001;
        double dimesToReturn = (changeNeeded - (changeNeeded % 0.1)) / 0.1;
        changeMessage += ((int) dimesToReturn) + " dimes returned\n";
        changeNeeded = changeNeeded % 0.10;
        double nicklesToReturn = (changeNeeded - (changeNeeded % .05)) / 0.05;
        changeMessage += ((int) nicklesToReturn) + " nickles returned\n";
        numberOfQuarters -= quartersToReturn;
        numberOfDimes -= dimesToReturn;
        numberOfNickles -= nicklesToReturn;
        return changeMessage;
    }

    String getMessage() {
        return message;
    }

}

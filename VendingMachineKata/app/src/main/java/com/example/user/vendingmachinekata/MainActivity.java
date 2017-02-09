package com.example.user.vendingmachinekata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    vendingMachine vm = new vendingMachine();
    ImageView[] chips = new ImageView[3];
    ImageView[] candy = new ImageView[3];
    ImageView[] soda = new ImageView[3];
    ImageView itemChosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insertQuarter(View view) {
        vm.insertQuarter();
        updateTotal(String.format("%.2f", vm.getValueOfMoneyInserted()));
    }

    public void insertDime(View view) {
        vm.insertDime();
        updateTotal(String.format("%.2f", vm.getValueOfMoneyInserted()));
    }

    public void insertNickle(View view) {
        vm.insertNickle();
        updateTotal(String.format("%.2f", vm.getValueOfMoneyInserted()));
    }

    public void insertPenny(View view) {
        changeDisplay(vm.insertPenny());
    }

    public void chooseChips(View view) {
        createChipViewArray();
        if (checkIfChipsAreVisible() != "Chips available.\n") {
            changeDisplay(checkIfChipsAreVisible());
        } else {
            changeDisplay(checkIfChipsAreVisible() + vm.chooseChips());
            updateAmountNeeded(String.format("%.2f", vm.getAmountNeeded()));
        }
    }

    public void chooseCandy(View view) {
        createCandyViewArray();
        if (checkIfCandyIsVisible() != "Candy available.\n") {
            changeDisplay(checkIfCandyIsVisible());
        } else {
            changeDisplay(checkIfCandyIsVisible() + vm.chooseCandy());
            updateAmountNeeded(String.format("%.2f", vm.getAmountNeeded()));
        }

    }

    public void chooseSoda(View view) {
        createSodaViewArray();
        if (checkIfSodaIsVisible() != "Soda available.\n") {
            changeDisplay(checkIfSodaIsVisible());
        } else {
            changeDisplay(checkIfSodaIsVisible() + vm.chooseSoda());
            updateAmountNeeded(String.format("%.2f", vm.getAmountNeeded()));
        }
    }

    public void dispenseItem(View view) {
        if (itemChosen != null) {
            if (vm.getAmountNeeded() <= vm.getValueOfMoneyInserted()) {
                itemChosen.setVisibility(View.INVISIBLE);
                itemChosen = null;
            }
        }
        String message = vm.dispenseItem();
        changeDisplay(message);
        updateAmountNeeded(String.format("%.2f", vm.getAmountNeeded()));
        updateTotal(String.format("%.2f", vm.getValueOfMoneyInserted()));

    }

    public void giveChange(View view) {
        String newMessage = vm.returnCoins();
        changeDisplay(newMessage);
        updateTotal(String.format("%.2f", vm.getValueOfMoneyInserted()));
    }

    public void emptyCoins(View view) {
        String message = vm.emptyCoins();
        changeDisplay(message);
    }

    public void changeDisplay(String message) {
        TextView mainDisplay = (TextView) findViewById(R.id.main_display);
        mainDisplay.setText(message);
    }

    public void updateAmountNeeded(String amountNeeded) {
        TextView amountNeededDisplay = (TextView) findViewById(R.id.amount_needed);
        String tempText = "$" + amountNeeded;
        amountNeededDisplay.setText(tempText);
    }

    public void updateTotal(String total) {
        TextView totalDisplay = (TextView) findViewById(R.id.total_display);
        String tempText = "$" + total;
        totalDisplay.setText(tempText);
    }

    public String checkIfChipsAreVisible() {
        String message;
        if (chips[0].getVisibility() == View.VISIBLE) {
            message = "Chips available.\n";
            itemChosen = chips[0];
        } else {
            if (chips[1].getVisibility() == View.VISIBLE) {
                message = "Chips available.\n";
                itemChosen = chips[1];
            } else {
                if (chips[2].getVisibility() == View.VISIBLE) {
                    message = "Chips available.\n";
                    itemChosen = chips[2];
                } else {
                    message = "Sorry, chips are out of stock\n";
                    itemChosen = null;
                }
            }
        }
        return message;
    }

    public void createChipViewArray() {
        chips[0] = (ImageView) findViewById(R.id.chips1);
        chips[1] = (ImageView) findViewById(R.id.chips2);
        chips[2] = (ImageView) findViewById(R.id.chips3);
    }

    public void createSodaViewArray() {
        soda[0] = (ImageView) findViewById(R.id.soda1);
        soda[1] = (ImageView) findViewById(R.id.soda2);
        soda[2] = (ImageView) findViewById(R.id.soda3);
    }

    public void createCandyViewArray() {
        candy[0] = (ImageView) findViewById(R.id.candyBar1);
        candy[1] = (ImageView) findViewById(R.id.candyBar2);
        candy[2] = (ImageView) findViewById(R.id.candyBar3);
    }

    public String checkIfSodaIsVisible() {
        String message;
        if (soda[0].getVisibility() == View.VISIBLE) {
            message = "Soda available.\n";
            itemChosen = soda[0];
        } else {
            if (soda[1].getVisibility() == View.VISIBLE) {
                message = "Soda available.\n";
                itemChosen = soda[1];
            } else {
                if (soda[2].getVisibility() == View.VISIBLE) {
                    message = "Soda available.\n";
                    itemChosen = soda[2];
                } else {
                    message = "Sorry, soda is out of stock\n";
                    itemChosen = null;
                }
            }
        }
        return message;
    }

    public String checkIfCandyIsVisible() {
        String message;
        if (candy[0].getVisibility() == View.VISIBLE) {
            message = "Candy available.\n";
            itemChosen = candy[0];
        } else {
            if (candy[1].getVisibility() == View.VISIBLE) {
                message = "Candy available.\n";
                itemChosen = candy[1];
            } else {
                if (candy[2].getVisibility() == View.VISIBLE) {
                    message = "Candy available.\n";
                    itemChosen = candy[2];
                } else {
                    message = "Sorry, candy are out of stock\n";
                    itemChosen = null;
                }
            }
        }
        return message;
    }
}

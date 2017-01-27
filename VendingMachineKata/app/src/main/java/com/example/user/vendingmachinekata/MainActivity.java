package com.example.user.vendingmachinekata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    vendingMachine vm = new vendingMachine();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vm.payForItem();
    }
    public void insertQuarter(View view){
        vm.insertQuarter();
    }
    public void insertDime(View view){
        vm.insertDime();
    }
    public void insertNickle(View view){
        vm.insertNickle();
    }
    public void insertPenny(View view){
        vm.insertPenny();
    }
    public void chooseChips(View view){
        vm.chooseChips();
    }
    public void chooseCandy(View view){
        vm.chooseCandy();
    }
    public void chooseSoda(View view){
        vm.chooseSoda();
    }
    public void dispenseItem(View view){
        String message = vm.dispenseItem();
        changeDisplay(message);
    }
    public void giveChange(View view){
        vm.giveChange();
    }
    public void emptyCoins(View view){
        String message = vm.emptyCoins();
        changeDisplay(message);
    }
    public void restockItems(View view){

    }
    public void changeDisplay(String message){
        TextView mainDisplay = (TextView) findViewById(R.id.main_display);
        mainDisplay.setText(message);
    }
}

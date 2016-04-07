//Christina Ramsey <cmramsey@stanford.edu>
//Calculator - This app works like a four-function calculator.
//It can calculate multiple operations as entered (no order of operations).
//New numbers can be entered without ever using the "off" button.
//It rounds to two decimal places.

package cs193a.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setScreen();
    }

    String first = "";
    String second = "";
    Character op = ' ';
    String prevNumber = "0";

    public void setScreen() {
            TextView screenView = (TextView) findViewById(R.id.screen);
            screenView.setText(first + op + second);
    }

    public void clear_click(View view) {
        first = "";
        second = "";
        op = ' ';
        prevNumber = "0";

        TextView screenView = (TextView) findViewById(R.id.screen);
        screenView.setText(prevNumber);
    }

    public void appendNumber(char x) {
        if(op.equals(' ')) first += x;
        else second += x;
        setScreen();
    }

    public void zero_click(View view) {
        appendNumber('0');
    }

    public void one_click(View view) {
        appendNumber('1');
    }

    public void two_click(View view) {
        appendNumber('2');
    }

    public void three_click(View view) {
        appendNumber('3');
    }

    public void four_click(View view) {
        appendNumber('4');
    }

    public void five_click(View view) {
        appendNumber('5');
    }

    public void six_click(View view) {
        appendNumber('6');
    }

    public void seven_click(View view) {
        appendNumber('7');
    }

    public void eight_click(View view) {
        appendNumber('8');
    }

    public void nine_click(View view) {
        appendNumber('9');
    }

    public void choose_op(char x, View view) {
        if(op.equals(' ')) op = x;
        else {
            equals_click(view);
            op = x;
        }
        if(first.length() == 0) first = prevNumber;
        setScreen();
    }

    public void divide_click(View view) {
        choose_op('/', view);
    }

    public void multiply_click(View view) {
        choose_op('*', view);
    }

    public void subtract_click(View view) {
        choose_op('-', view);
    }

    public void add_click(View view) {
        choose_op('+', view);
    }

    public void equals_click(View view) {
        if(first.length() == 0) first = prevNumber;
        if(second.length() == 0) second = "0";

        double result;
        double firstInt = Double.parseDouble(first);
        double secondInt = Double.parseDouble(second);

        if(op.equals('/')) result = firstInt/secondInt;
        else if(op.equals('*')) result = firstInt*secondInt;
        else if(op.equals('-')) result = firstInt - secondInt;
        else result = firstInt + secondInt;

        prevNumber = String.format("%.2f", result);

        TextView screenView = (TextView) findViewById(R.id.screen);
        screenView.setText(prevNumber);

        first = "";
        op = ' ';
        second = "";
    }
}


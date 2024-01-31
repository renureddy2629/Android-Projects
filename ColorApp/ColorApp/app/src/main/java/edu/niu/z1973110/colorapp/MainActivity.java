package edu.niu.z1973110.colorapp;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextRed, editTextGreen, editTextBlue;
    private View colorView;
    private ColorModel colorModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextRed = findViewById(R.id.editTextRed);
        editTextGreen = findViewById(R.id.editTextGreen);
        editTextBlue = findViewById(R.id.editTextBlue);
        colorView = findViewById(R.id.colorView);

        colorModel = new ColorModel(0, 0, 0);

        editTextRed.addTextChangedListener(textWatcher);
        editTextGreen.addTextChangedListener(textWatcher);
        editTextBlue.addTextChangedListener(textWatcher);
    }
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

        @Override
        public void afterTextChanged(Editable editable) {
            String redText = editTextRed.getText().toString();
            String greenText = editTextGreen.getText().toString();
            String blueText = editTextBlue.getText().toString();

            if (!redText.isEmpty() && !greenText.isEmpty() && !blueText.isEmpty()) {
                int red = parseInput(redText);
                int green = parseInput(greenText);
                int blue = parseInput(blueText);

                colorModel.setRed(red);
                colorModel.setGreen(green);
                colorModel.setBlue(blue);

                updateColorView();
            }
        }
    };

    private int parseInput(String input) {
        int value = Integer.parseInt(input);
        return Math.min(Math.max(value, 0), 255);
    }

    private void updateColorView() {
        int color = Color.rgb(colorModel.getRed(), colorModel.getGreen(), colorModel.getBlue());
        colorView.setBackgroundColor(color);
    }


}
package com.example.rockpapperscissors;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        this.mViewHolder.imgAppChoise = findViewById(R.id.imageViewAppChoise);
        this.mViewHolder.imgRock = findViewById(R.id.imageViewRock);
        this.mViewHolder.imgPapper = findViewById(R.id.imageViewPapper);
        this.mViewHolder.imgScissor = findViewById(R.id.imageViewScissor);
        this.mViewHolder.textViewResult = findViewById(R.id.textViewResult);

    }
    public void selectedRock(View view) {
        this.optionSelected("Rock");
    }
    public void selectedScissor(View view) {
        this.optionSelected("Scissor");
    }
    public void selectedPapper(View view) {
        this.optionSelected("Papper");
    }
    @SuppressLint("SetTextI18n")
    public void optionSelected(String selectedOption){
        int randomNumber = new Random().nextInt(3);

        String [] Options = {"Rock", "Papper", "Scissor"};
        String optionApp = Options [randomNumber];

        switch (optionApp){
            case "Rock":
                    this.mViewHolder.imgAppChoise.setImageResource(R.drawable.pedra);
                break;

            case "Papper":
                this.mViewHolder.imgAppChoise.setImageResource(R.drawable.papel);
                break;

            case "Scissor":
                this.mViewHolder.imgAppChoise.setImageResource(R.drawable.tesoura);
                break;
        }

        verifyChoise(selectedOption, optionApp);
    }

    private void verifyChoise(String selectedOption, String optionApp) {
        if
            ((optionApp.equals("Scissor") && selectedOption.equals("Papper"))  ||
             (optionApp.equals("Papper")  && selectedOption.equals("Rock"))    ||
             (optionApp.equals("Rock")    && selectedOption.equals("Scissor")))
        {
            //app winner
            this.mViewHolder.textViewResult.setText("You lost");

        }else if
                ((selectedOption.equals("Scissor") && optionApp.equals("Papper"))  ||
                (selectedOption.equals("Papper")   && optionApp.equals("Rock"))    ||
                (selectedOption.equals("Rock")     && optionApp.equals("Scissor")))
        {
            //user winner
            this.mViewHolder.textViewResult.setText("You won");
        }else{
            //draw
            this.mViewHolder.textViewResult.setText("Draw");
        }
    }

    private static class ViewHolder{
        TextView  textViewResult;
        ImageView imgAppChoise;
        ImageView imgRock;
        ImageView imgPapper;
        ImageView imgScissor;
    }
    private final ViewHolder mViewHolder = new ViewHolder();


}
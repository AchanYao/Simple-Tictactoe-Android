package com.achan.tictactoe;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FallChildAction action = new FallChildAction(false);
    private ArrayList<TextView> textViews = new ArrayList<>(9);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newGame();

        final TextView location1 = findViewById(R.id.location_1);
        final TextView location2 = findViewById(R.id.location_2);
        final TextView location3 = findViewById(R.id.location_3);
        final TextView location4 = findViewById(R.id.location_4);
        final TextView location5 = findViewById(R.id.location_5);
        final TextView location6 = findViewById(R.id.location_6);
        final TextView location7 = findViewById(R.id.location_7);
        final TextView location8 = findViewById(R.id.location_8);
        final TextView location9 = findViewById(R.id.location_9);

        textViews.add(location1);
        textViews.add(location2);
        textViews.add(location3);
        textViews.add(location4);
        textViews.add(location5);
        textViews.add(location6);
        textViews.add(location7);
        textViews.add(location8);
        textViews.add(location9);

        location1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.fallChild(0, 0);
                location1.setText(action.getChild());
                finished();
            }
        });
        location2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.fallChild(0, 1);
                location2.setText(action.getChild());
                finished();
            }
        });
        location3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.fallChild(0, 2);
                location3.setText(action.getChild());
                finished();
            }
        });
        location4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.fallChild(1, 0);
                location4.setText(action.getChild());
                finished();
            }
        });
        location5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.fallChild(1, 1);
                location5.setText(action.getChild());
                finished();
            }
        });
        location6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.fallChild(1, 2);
                location6.setText(action.getChild());
                finished();
            }
        });
        location7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.fallChild(2, 0);
                location7.setText(action.getChild());
                finished();
            }
        });
        location8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.fallChild(2, 1);
                location8.setText(action.getChild());
                finished();
            }
        });
        location9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.fallChild(2, 2);
                location9.setText(action.getChild());
                finished();
            }
        });
    }

    private void finished()
    {
        FallChildAction.State state = action.getState();
        if (state.getInformation() != null)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage(state.getInformation())
                    .setPositiveButton("重新开始", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 重新开始
                            boolean temp = MainActivity.this.action.isOnePlayer();
                            MainActivity.this.action = new FallChildAction(temp);
                            MainActivity.this.newGame();
                        }
                    })
                    .setNegativeButton("明白", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ;
                        }
                    });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    private void newGame()
    {
        for (TextView textView : textViews)
            textView.setText("");
    }

    public ArrayList<TextView> getTextViews()
    {
        return textViews;
    }
}

package com.uladzislau.tylkovich.apptips3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button writeButton;
    TextView viewText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("portfolios");
        writeButton = (Button) findViewById(R.id.writeButton);
        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<StockPortfolio> myFolios = new ArrayList<StockPortfolio>();
                StockPortfolio myFolio = new StockPortfolio("demoFolio", "lmoroney", "lm@hotmail.com");
                ArrayList<Stock> myFolioHoldings = new ArrayList<Stock>();
                myFolioHoldings.add(new Stock("GOOG", "Google", 100));
                myFolioHoldings.add(new Stock("AAPL", "Apple", 50));
                myFolioHoldings.add(new Stock("MSFT", "Microsoft", 10));
                myFolio.portfolioHoldings = myFolioHoldings;
                StockPortfolio myOtherFolio = new StockPortfolio("realFolio", "lmoroney", "lmwork@hotmail.com");
                ArrayList<Stock> myOtherFolioHoldings = new ArrayList<Stock>();
                myOtherFolioHoldings.add(new Stock("IBM", "IBM", 50));
                myOtherFolioHoldings.add(new Stock("MMM", "3M", 10));
                myOtherFolio.portfolioHoldings = myOtherFolioHoldings;
                myFolios.add(myFolio);
                myFolios.add(myOtherFolio);
                myRef.setValue(myFolios);


//                ArrayList<StockPortfolio> myFolios = new ArrayList<StockPortfolio>();
//                StockPortfolio myFolio = new StockPortfolio("demoFolio", "lmoroney", "lm@hotmail.com");
//                StockPortfolio myOtherFolio = new StockPortfolio("realFolio", "lmoroney", "lmwork@hotmail.com");
//                myFolios.add(myFolio);
//                myFolios.add(myOtherFolio);
//                myRef.setValue(myFolios);


//                StockPortfolio myFolio = new StockPortfolio("demoFolio", "lmoroney", "lm@ hotmail.com");
//                myRef.setValue(myFolio);
//myRef.setValue("Hello, World");
            } });
        viewText = (TextView) findViewById(R.id.viewText);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //String value = dataSnapshot.getValue(String.class);
                //viewText.setText(value);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Ch3", "Failed to read value.", error.toException()); }
        }); }
}


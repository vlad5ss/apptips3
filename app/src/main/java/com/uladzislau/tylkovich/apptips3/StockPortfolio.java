package com.uladzislau.tylkovich.apptips3;

import java.util.ArrayList;

/**
 * Created by mac on 11/27/17.
 */

public class StockPortfolio {
    public String portfolioName;
    public String portfolioOwner;
    public String portfolioContact;
    public ArrayList<Stock> portfolioHoldings;
    public StockPortfolio(){}
    public StockPortfolio(String name, String owner, String contact)
    { this.portfolioName = name;
        this.portfolioOwner = owner;
        this.portfolioContact = contact;
    }
}

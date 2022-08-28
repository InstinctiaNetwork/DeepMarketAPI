package dev.authorises.DeepMarketAPI.deepmarket;

import java.util.ArrayList;
import java.util.Random;

public class DeepMarketItem {
    private final String itemid;
    private final Double minmumPrice;
    private final Double maximumPrice;
    private final Double startPrice;
    private final DeepMarketCategory category;
    private final String material;

    private Double sellPrice;
    private Double price;
    public ArrayList<Double> history = new ArrayList<>();

    public DeepMarketItem(String itemid, Double minmumPrice, Double maximumPrice, Double startPrice, DeepMarketCategory category, String material) {
        this.itemid = itemid;
        this.minmumPrice = minmumPrice;
        this.maximumPrice = maximumPrice;
        this.startPrice = startPrice;
        this.category = category;

        this.price = startPrice;
        this.material = material;
    }

    public void recalculatePrices(Float volatility){
        Float rnd = new Random().nextFloat();
        Float change_percent = 2 * volatility * rnd;
        if (change_percent > volatility){
            change_percent -= (2*volatility);
        }
        Double change_amount = getPrice() * change_percent;
        Double r = getPrice() + change_amount;
        if(r<getStartPrice()){
            setPrice(getStartPrice());
            recalculatePrices(volatility);
        }else{
            if(r>getMaximumPrice()){
                setPrice(getStartPrice());
                recalculatePrices(volatility);
            }else{
                setPrice(r);
            }
        }
    }

    public String getItemId() {
        return itemid;
    }

    public Double getMinmumPrice() {
        return minmumPrice;
    }

    public Double getMaximumPrice() {
        return maximumPrice;
    }

    public DeepMarketCategory getCategory() {
        return category;
    }

    public Double getStartPrice() {
        return startPrice;
    }

    public Double getPrice10m(){
        if(this.history.size()>=200){
            return this.history.get(this.history.size()-200);
        }else{
            return -1D;
        }
    }

    public Double getPrice1m(){
        if(this.history.size()>=20){
            return this.history.get(this.history.size()-20);
        }else{
            return -1D;
        }
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.history.add(price);
        this.price = price;
        this.sellPrice = price/2;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public String getMaterial() {
        return material;
    }
}

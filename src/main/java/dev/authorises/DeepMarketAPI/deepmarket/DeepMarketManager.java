package dev.authorises.DeepMarketAPI.deepmarket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DeepMarketManager {
    private ArrayList<DeepMarketItem> marketItems;
    private Boolean open;
    private Long timeOpen;
    private Long timeClose;
    public Long updateDelay;

    public DeepMarketManager(){
        this.marketItems = new ArrayList<>();
        this.updateDelay = 1L;//60L;
        this.open = true;
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if(open){
                    for(DeepMarketItem item : marketItems){
                        item.recalculatePrices(0.01F);
                    }
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    public void closeMarket(){
        this.open = false;
        this.timeClose = System.currentTimeMillis();
        this.timeOpen = this.timeClose+600000;
    }

    public void openMarket(){
        this.open = true;
        this.timeOpen = System.currentTimeMillis();
        this.timeClose = this.timeOpen+600000;
    }

    public ArrayList<DeepMarketItem> getMarketItems() {
        return marketItems;
    }

    public void addItem(DeepMarketItem item){
        this.marketItems.add(item);
    }

    public void addItems(DeepMarketItem... items){
        marketItems.addAll(Arrays.asList(items));
    }

}

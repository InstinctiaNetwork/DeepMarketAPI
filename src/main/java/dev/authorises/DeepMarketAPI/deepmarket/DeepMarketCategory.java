package dev.authorises.DeepMarketAPI.deepmarket;

public enum DeepMarketCategory {
    MOB_DROPS("MOB_DROPS", "Mob Drops", "<#c22d5c>", "BONE"),
    BLOCKS("BLOCKS", "Blocks", "<#3b2dcf>", "BRICKS")
    ;

    private String id;
    private String displayName;
    private String color;
    private String item;

    DeepMarketCategory(String id, String displayName, String color, String item) {
        this.id = id;
        this.displayName = displayName;
        this.color = color;
        this.item = item;
    }
}

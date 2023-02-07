package com.gildedrose;

class GildedRose {
    private static final int MAX_QUALITY = 50;
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String AGED_BRIE = "Aged Brie";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItem(items[i]);
        }
    }

    private void updateItem(Item item) {
        if (item.name.equals(SULFURAS))
            return;
            
        if (item.name.equals(AGED_BRIE)) {
            AgedBrieUpdater updater = new AgedBrieUpdater();
            updater.update(item);
            return;
        }

        if (item.name.equals(BACKSTAGE_PASSES)) {
            updateBackstagePasses(item);
            return;
        }

        NormalItemUpdater updater = new NormalItemUpdater();
        updater.update(item);
    }

    private void updateBackstagePasses(Item item) {
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.quality = 0;
            return;
        }

        if (item.sellIn < 10 && item.sellIn >= 5) {
            item.quality = increaseQualityWithMaxCheck(item.quality, 2);
            return;
        }

        if (item.sellIn < 5) {
            item.quality = increaseQualityWithMaxCheck(item.quality, 3);
            return;
        }

        item.quality = increaseQualityWithMaxCheck(item.quality, 1);
    }

    private int increaseQualityWithMaxCheck(int quality, int value) {
        return Math.min(MAX_QUALITY, quality + value);
    }
}
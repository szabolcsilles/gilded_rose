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
            updateAgedBrie(item);
            return;
        }

        if (item.name.equals(BACKSTAGE_PASSES)) {
            updateBackstagePasses(item);
            return;
        }

        updateNormalItem(item); 
    }

    private void updateNormalItem(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void updateBackstagePasses(Item item) {
        item.quality = item.quality + 1;
        if (item.sellIn < 11) {
            item.quality = item.quality + 1;
        }

        if (item.sellIn < 6) {
            item.quality = item.quality + 1;
        }
        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
        if (item.quality >= MAX_QUALITY) {
            item.quality = MAX_QUALITY;
        }
    }

    private void updateAgedBrie(Item item) {
        item.quality = item.quality + 1;
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.quality = item.quality + 1;
        }
        if (item.quality >= MAX_QUALITY) {
            item.quality = MAX_QUALITY;
        }
    }
}
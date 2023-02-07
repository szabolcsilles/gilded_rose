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
        if (item.name.equals(SULFURAS)) {
            SulfurasUpdater updater = new SulfurasUpdater();
            updater.update(item);
            return;
        }
            
        if (item.name.equals(AGED_BRIE)) {
            AgedBrieUpdater updater = new AgedBrieUpdater();
            updater.update(item);
            return;
        }

        if (item.name.equals(BACKSTAGE_PASSES)) {
            BackstagePassesUpdater updater = new BackstagePassesUpdater();
            updater.update(item);
            return;
        }

        NormalItemUpdater updater = new NormalItemUpdater();
        updater.update(item);
    }
}
package com.gildedrose;

public abstract class ItemUpdater {
    protected abstract int updateQuality(int oldQuality, int sellIn);
    protected abstract int updateSellIn(int oldSellIn);

    private static final int MAX_QUALITY = 50;

    protected int decreaseQualityWithZeroCheck(int quality, int value) {
        return Math.max(0, quality - value);
    }

    protected int increaseQualityWithMaxCheck(int quality, int value) {
        return Math.min(MAX_QUALITY, quality + value);
    }

    public void update(Item item) {
        item.sellIn = updateSellIn(item.sellIn);
        item.quality = updateQuality(item.quality, item.sellIn);
    }
}

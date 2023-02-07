package com.gildedrose;

public class NormalItemUpdater extends ItemUpdater{

    @Override
    public int updateQuality(int oldQuality, int sellIn) {
        if (sellIn < 0) {
            return decreaseQualityWithZeroCheck(oldQuality, 2);
        }
        return decreaseQualityWithZeroCheck(oldQuality, 1);
    }

    @Override
    public int updateSellIn(int oldSellIn) {
        return oldSellIn - 1;
    }
    
}

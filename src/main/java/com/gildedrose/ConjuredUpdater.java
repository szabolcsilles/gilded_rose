package com.gildedrose;

public class ConjuredUpdater extends ItemUpdater {

    @Override
    protected int updateQuality(int oldQuality, int sellIn) {
        if (sellIn < 0) {
            return decreaseQualityWithZeroCheck(oldQuality, 4);
        }
        return decreaseQualityWithZeroCheck(oldQuality, 2);
    }
    
}

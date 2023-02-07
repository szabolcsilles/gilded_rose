package com.gildedrose;

public class BackstagePassesUpdater extends ItemUpdater {

    @Override
    protected int updateQuality(int oldQuality, int sellIn) {
        if (sellIn < 0) {
            return 0;
        }

        if (sellIn < 10 && sellIn >= 5) {
            return increaseQualityWithMaxCheck(oldQuality, 2);
        }

        if (sellIn < 5) {
            return increaseQualityWithMaxCheck(oldQuality, 3);
        }

        return increaseQualityWithMaxCheck(oldQuality, 1);
    }
    
}

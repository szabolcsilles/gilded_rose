package com.gildedrose;

public class AgedBrieUpdater extends ItemUpdater {

    @Override
    protected int updateQuality(int oldQuality, int sellIn) {
        if (sellIn < 0) {
            return increaseQualityWithMaxCheck(oldQuality, 2);
        }
        return increaseQualityWithMaxCheck(oldQuality, 1);
    }
}

package com.gildedrose;

public class SulfurasUpdater extends ItemUpdater {

    @Override
    protected int updateQuality(int oldQuality, int sellIn) {
        return oldQuality;
    }

    @Override
    protected int updateSellIn(int oldSellIn) {
        return oldSellIn;
    }
    
}

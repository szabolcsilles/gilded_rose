package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    private GildedRose createAppWithItem(Item item) {
        Item[] items = new Item[] {item};
        return new GildedRose(items);
    }

    @Test
    void sellInValueDecreasesOnUpdateQuality() {
        GildedRose app = createAppWithItem(new Item("foo", 0, 0));
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void qualityOfAnItemIsNeverNegative() {
        GildedRose app = createAppWithItem(new Item("foo", 0, 0));
        app.updateQuality();
        assertTrue(0 <= app.items[0].quality);
    }

    @Test
    void qualityOfNormalItemDegradesByOneBeforeSellIn() {
        GildedRose app = createAppWithItem(new Item("foo", 1, 1));
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void qualityOfNormalItemDegradesByTwoAfterSellIn() {
        GildedRose app = createAppWithItem(new Item("foo", 0, 2));
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void qualityOfAgedBrieIncreasesBeforeSellIn() {
        GildedRose app = createAppWithItem(new Item("Aged Brie", 2, 1));
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void qualityOfAgedBrieIncreasesByTwoAfterSellIn() {
        GildedRose app = createAppWithItem(new Item("Aged Brie", 0, 0));
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void qualityOfAnItemIsNeverMoreThanFifty() {
        GildedRose app = createAppWithItem(new Item("Aged Brie", 1, 50));
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void qualityOfSulfurasNeverChanges() {
        GildedRose app = createAppWithItem(new Item ("Sulfuras, Hand of Ragnaros", 1, 80));
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void backstagePassesIncreasesQualityByOneMoreThanTenDaysBeforeSellIn() {
        GildedRose app = createAppWithItem(new Item ("Backstage passes to a TAFKAL80ETC concert", 15, 0));
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void backstagePassesIncreasesQualityByTwoBetweenTenAndFiveDaysBeforeSellIn() {
        GildedRose app = createAppWithItem(new Item ("Backstage passes to a TAFKAL80ETC concert", 10, 0));
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void backstagePassesIncreasesQualityByTwoBetweenFiveAndZeroDaysBeforeSellIn() {
        GildedRose app = createAppWithItem(new Item ("Backstage passes to a TAFKAL80ETC concert", 5, 0));
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(15, app.items[0].quality);
    }

    @Test
    void backstagePassesQualityDropsToZeroAfterSellIn() {
        GildedRose app = createAppWithItem(new Item ("Backstage passes to a TAFKAL80ETC concert", 0, 50));
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }


}
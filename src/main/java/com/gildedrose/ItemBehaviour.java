package com.gildedrose;

enum ItemBehaviour {
    SULFURAS("Sulfuras, Hand of Ragnaros", new SulfurasUpdater()),
    NORMAL_ITEM("", new NormalItemUpdater()),
    AGED_BRIE("Aged Brie", new AgedBrieUpdater()),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert", new BackstagePassesUpdater());

    private String name;
    private ItemUpdater updater;

    ItemBehaviour(String name, ItemUpdater updater) {
        this.name = name;
        this.updater = updater;
    }

    public String getName() {
        return name;
    }

    public void update(Item item) {
        updater.update(item);
    }

    public static ItemBehaviour getBehaviour(String name) {
        for(ItemBehaviour behaviour : ItemBehaviour.values()) {
            if (behaviour.name.equals(name)) {
                return behaviour;
            }
        }
        return NORMAL_ITEM;
    }
}
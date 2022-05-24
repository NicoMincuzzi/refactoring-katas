package com.gildedrose;

class GildedRose {
    private final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            quality(item);

            if (!item.isASpecificItem("Sulfuras, Hand of Ragnaros"))
                item.decreaseSellIn();

            sellIn(item);
        }
    }

    private void quality(Item item) {
        if (item.isPresentQuality() && !item.isKnownItem()) {
            item.decreaseQuality();
            return;
        }
        if (item.qualityNotExceed()) {
            item.increaseQuality();
            if (item.isASpecificItem("Backstage passes to a TAFKAL80ETC concert") && item.sellInNotExceed() && item.qualityNotExceed())
                item.increaseQuality();
        }
    }

    private void sellIn(Item item) {
        if (item.isPresentSellIn())
            return;

        if (!item.isASpecificItem("Aged Brie")) {
            if (!item.isPresentQuality() || item.isKnownItem()) {
                item.resetQuality();
                return;
            }
            item.decreaseQuality();
            return;
        }
        if (item.qualityNotExceed())
            item.increaseQuality();
    }

    public Quality showQuality(int index) {
        return items[index].quality;
    }

    public SellIn showSellIn(int index) {
        return items[index].sellIn;
    }
}

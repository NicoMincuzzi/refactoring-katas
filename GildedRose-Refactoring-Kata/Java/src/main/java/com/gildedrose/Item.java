package com.gildedrose;

import static java.util.Arrays.asList;

public class Item {
    private final String name;
    SellIn sellIn;
    Quality quality;

    public Item(String name, SellIn sellIn, Quality quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void resetQuality() {
        quality.reset();
    }

    public boolean isPresentQuality() {
        return quality.isPresent();
    }

    public void increaseQuality() {
        quality.increase();
    }

    public void decreaseQuality() {
        quality.decrease();
    }

    public boolean qualityNotExceed() {
        return quality.notExceed();
    }

    public void decreaseSellIn() {
        sellIn.decrease();
    }

    public boolean isASpecificItem(String name) {
        return this.name.equals(name);
    }

    public boolean isPresentSellIn() {
        return sellIn.isPresent();
    }

    public boolean sellInNotExceed() {
        return sellIn.exceed();
    }

    public boolean isKnownItem() {
        return asList("Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros").contains(name);
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}

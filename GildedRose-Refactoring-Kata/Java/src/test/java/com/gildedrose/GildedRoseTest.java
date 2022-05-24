package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void test_case_1() {
        Item[] items = new Item[]{new Item("Thing", new SellIn(0), new Quality(0))};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(new SellIn(-1), app.showSellIn(0));
        assertEquals(new Quality(0), app.showQuality(0));
    }

    @Test
    void test_case_2() {
        Item[] items = new Item[]{new Item("Aged Brie", new SellIn(7), new Quality(10))};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(new SellIn(6), app.showSellIn(0));
        assertEquals(new Quality(11), app.showQuality(0));

    }

    @Test
    void test_case_3() {
        Item[] items = new Item[]{new Item("Aged Brie", new SellIn(0), new Quality(10))};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(new SellIn(-1), app.showSellIn(0));
        assertEquals(new Quality(12), app.showQuality(0));
    }

    @Test
    void test_case_4() {
        Item[] items = new Item[]{new Item("Thing", new SellIn(0), new Quality(10))};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(new SellIn(-1), app.showSellIn(0));
        assertEquals(new Quality(8), app.showQuality(0));
    }

    @Test
    void test_case_5() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", new SellIn(7), new Quality(10))};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(new SellIn(6), app.showSellIn(0));
        assertEquals(new Quality(12), app.showQuality(0));
    }

    @Test
    void test_case_6() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", new SellIn(0), new Quality(0))};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(new SellIn(-1), app.showSellIn(0));
        assertEquals(new Quality(0), app.showQuality(0));
    }

    @Test
    void test_case_7() {
        Item[] items = new Item[]{new Item("Aged Brie", new SellIn(11), new Quality(50))};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(new SellIn(10), app.showSellIn(0));
        assertEquals(new Quality(50), app.showQuality(0));
    }

    @Test
    void test_case_8() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", new SellIn(11), new Quality(50))};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(new SellIn(10), app.showSellIn(0));
        assertEquals(new Quality(50), app.showQuality(0));
    }

    @Test
    void test_case_9() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", new SellIn(11), new Quality(24))};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(new SellIn(10), app.showSellIn(0));
        assertEquals(new Quality(25), app.showQuality(0));
    }
}

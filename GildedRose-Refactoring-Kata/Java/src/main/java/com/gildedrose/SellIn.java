package com.gildedrose;

import java.util.Objects;

public class SellIn {
    public static final int SELL_IN_THRESHOLD = 11;
    private int sellIn;

    public SellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public void decrease() {
        sellIn -= 1;
    }

    public boolean isPresent() {
        return sellIn > 0;
    }

    public boolean exceed() {
        return sellIn < SELL_IN_THRESHOLD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellIn sellIn1 = (SellIn) o;
        return sellIn == sellIn1.sellIn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sellIn);
    }
}

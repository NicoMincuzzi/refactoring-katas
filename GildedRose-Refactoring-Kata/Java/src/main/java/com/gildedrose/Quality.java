package com.gildedrose;

import java.util.Objects;

public class Quality {
    public static final int QUALITY_THRESHOLD = 50;
    private int quality;

    public Quality(int quality) {
        this.quality = quality;
    }

    public void reset() {
        quality = 0;
    }

    public boolean isPresent() {
        return quality > 0;
    }

    public void increase() {
        quality += 1;
    }

    public void decrease() {
        quality -= 1;
    }

    public boolean notExceed() {
        return quality < QUALITY_THRESHOLD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quality quality1 = (Quality) o;
        return quality == quality1.quality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quality);
    }
}

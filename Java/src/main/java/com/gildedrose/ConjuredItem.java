package com.gildedrose;

public class ConjuredItem extends BasicItem {
    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public int decrease(int quality) {
        return quality - 2;
    }
}

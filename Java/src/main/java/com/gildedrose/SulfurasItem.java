package com.gildedrose;

public class SulfurasItem extends BasicItem {
    public SulfurasItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateQuality() {
    }

    @Override
    protected void decrementSellIn() {
    }

    @Override
    protected void updateQualityAccordingToSellIn() {
    }
}

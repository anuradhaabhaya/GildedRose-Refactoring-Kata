package com.gildedrose;

public class AgedBrieItem extends BasicItem {
    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        incrementQualityWhenInferiorTo50();
    }

    @Override
    protected void updateQualityAccordingToSellIn() {
        if (isExpirationDatePassed(sellIn)) {
            updateQuality();
        }
    }
}

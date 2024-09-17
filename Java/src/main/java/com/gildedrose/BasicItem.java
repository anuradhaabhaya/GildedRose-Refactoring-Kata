package com.gildedrose;

public class BasicItem extends Item implements QualityCheck, SellInCheck {
    public BasicItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    protected void updateQuality() {
        if (isSuperiorToZero(quality)) {
            quality = decrease(quality);
        }
    }

    protected void decrementSellIn() {
        sellIn = decrement(sellIn);
    }

    protected void updateQualityAccordingToSellIn() {
        if (isExpirationDatePassed(sellIn)) {
            updateQuality();
        }
    }

    protected void incrementQualityWhenInferiorTo50() {
        if (isInferiorTo50(quality)) {
            quality = increase(quality);
        }
    }
}

package com.gildedrose;

public class BackstageItem extends BasicItem {
    public BackstageItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        if (isInferiorTo50(quality)) {
            quality = increase(quality);

            if (isSellInDateInferiorTo(11)) { // si le nombre de jours restant est inférieur à 11
                incrementQualityWhenInferiorTo50();
            }
            if (isSellInDateInferiorTo(6)) { // si le nombre de jours restant est inférieur à 6
                incrementQualityWhenInferiorTo50();
            }
        }
    }

    @Override
    protected void updateQualityAccordingToSellIn() {
        if (isExpirationDatePassed(sellIn)) {
            updateQualityToZero();
        }
    }

    private void updateQualityToZero() {
        quality = 0;
    }

    private boolean isSellInDateInferiorTo(int daysLeft) {
        return sellIn < daysLeft;
    }
}

package com.gildedrose;

public interface SellInCheck {

    default boolean isExpirationDatePassed(int sellIn) {
        return sellIn < 0;
    }
    default int decrement(int sellIn) {
        return sellIn - 1;
    }
}

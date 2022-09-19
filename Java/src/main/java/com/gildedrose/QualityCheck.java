package com.gildedrose;

public interface QualityCheck {

    default boolean isSuperiorToZero(int quality) {
        return quality > 0;
    }

    default int decrease(int quality) {
        return quality -1;
    }

    default boolean isInferiorTo50(int quality) {
        return quality < 50;
    }

    default int increase(int quality) {
        return quality + 1;
    }
}

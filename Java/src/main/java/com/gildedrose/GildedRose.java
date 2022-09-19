package com.gildedrose;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GildedRose {
    List<BasicItem> items;

    public GildedRose(Item[] items) {
        this.items = Arrays.stream(items).map(ItemFactory::makeItem).collect(Collectors.toList());
    }

    public void updateQuality() {
        for (BasicItem item : items) {
            item.updateQuality();
            item.decrementSellIn();
            item.updateQualityAccordingToSellIn();
        }
    }
}

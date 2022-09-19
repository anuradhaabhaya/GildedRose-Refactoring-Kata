package com.gildedrose;

public class ItemFactory {
    public static BasicItem makeItem(Item item) {
        if (isItem(item, "Aged Brie")) {
            return new AgedBrieItem(item.name, item.sellIn, item.quality);
        }
        if (isItem(item, "Backstage passes to a TAFKAL80ETC concert")) {
            return new BackstageItem(item.name, item.sellIn, item.quality);
        }
        if (isItem(item, "Sulfuras, Hand of Ragnaros")) {
            return new SulfurasItem(item.name, item.sellIn, item.quality);
        }
        return new BasicItem(item.name, item.sellIn, item.quality);
    }

    private static boolean isItem(Item item, String itemName) {
        return item.name.equals(itemName);
    }
}

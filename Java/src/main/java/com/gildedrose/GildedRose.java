package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) { // pour chaque item
            if (!items[i].name.equals("Aged Brie") // si c'est ni Aged Brie ni Backstage
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) { // si la qualité est supérieure à 0
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { // si c'est pas un Sulfura
                        items[i].quality = items[i].quality - 1; // alors sa qualité décrémente de 1
                    }
                }
            } else { // sinon si c'est un Aged Brie ou un Backstage
                if (items[i].quality < 50) { //si sa qualité est inférieure à 50
                    items[i].quality = items[i].quality + 1; // alors sa qualité augmente de 1

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { // si c'est un Backstage
                        if (items[i].sellIn < 11) { // si le nombre de jours restant est inférieur à 11
                            if (items[i].quality < 50) { // si la qualité est inférieure à 50
                                items[i].quality = items[i].quality + 1; // alors sa qualité augmente de 1
                            }
                        }

                        if (items[i].sellIn < 6) { // si le nombre de jours restant est inférieur à 6
                            if (items[i].quality < 50) { // si la qualité est inférieure à 50
                                items[i].quality = items[i].quality + 1; // alors sa qualité augmente de 1
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { // si ce n'est pas un sulfura
                items[i].sellIn = items[i].sellIn - 1; // le nombre de jour restant décrémente de 1
            }

            if (items[i].sellIn < 0) { // si la date de péremption est passée
                if (!items[i].name.equals("Aged Brie")) { // si ce n'est pas un Aged Brie
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { // si ce n'est pas un Backstage
                        if (items[i].quality > 0) { // si la qualité est supérieure à 0
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { // si c'est pas un Sulfura
                                items[i].quality = items[i].quality - 1; // alors la qualité décrémente de 1
                            }
                        }
                    } else { // si c'est un Backstage
                        items[i].quality = items[i].quality - items[i].quality; // la qualité vaut 0
                    }
                } else { // si c'est un Aged Brie
                    if (items[i].quality < 50) { // si la qualité est inférieure à 50
                        items[i].quality = items[i].quality + 1; // la qualité incrémente de 1
                    }
                }
            }
        }
    }
}

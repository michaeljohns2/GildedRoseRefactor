package com.gildedrose;

class GildedRose {
    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;
    Item[] items;

    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String CONJURED = "Conjured";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            if (items[i].name.equals(AGED_BRIE)) {
                items[i].sellIn -= 1;
                if (items[i].quality < MAX_QUALITY) {
                    if (items[i].sellIn < 0) {
                        items[i].quality = items[i].quality + 2;
                    } else {
                        items[i].quality = items[i].quality + 1;
                    }
                }

                continue;
            }

            if (items[i].name.equals(BACKSTAGE)) {
                items[i].sellIn -= 1;

                int v = items[i].quality;

                if (items[i].sellIn < 0) {
                    v = 0;
                } else if (items[i].sellIn < 5) {
                    v += 3;
                } else if (items[i].sellIn < 10) {
                    v += 2;
                } else v += 1;

                items[i].quality = Math.min(v, MAX_QUALITY);

                continue;
            }

            if (items[i].name.equals(SULFURAS)) {
                continue;
            }

            if (items[i].name.equals(CONJURED)) {
                items[i].quality -= 1;
            }

            items[i].quality = Math.max(items[i].quality - 1, MIN_QUALITY);
            items[i].sellIn -= 1;
            if (items[i].sellIn < 0) {
                items[i].quality = Math.max(items[i].quality - 1, MIN_QUALITY);
            }
        }
    }
}

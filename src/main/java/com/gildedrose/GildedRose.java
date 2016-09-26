package com.gildedrose;

class GildedRose {
    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;
    public static final int BACKSTAGE_THRESHOLD_1 = 5;
    public static final int BACKSTAGE_THRESHOLD_2 = 10;
    Item[] items;

    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String CONJURED = "conjured";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            // Suluras is a legendary item that doesn't degrade
            if (items[i].name.equals(SULFURAS)) {
                continue;
            }

            items[i].sellIn -= 1;

            // Aged brie becomes more valuable with age,
            // and twice as valuable after the sellin date.
            if (items[i].name.equals(AGED_BRIE)) {

                if (items[i].quality < MAX_QUALITY) {
                    if (items[i].sellIn < 0) {
                        items[i].quality = items[i].quality + 2;
                    } else {
                        items[i].quality = items[i].quality + 1;
                    }
                }

                continue;
            }

            // Backstage passes become more valuable as date approaches,
            // but become worthless after the date.
            if (items[i].name.equals(BACKSTAGE)) {
                int v = items[i].quality;

                if (items[i].sellIn < 0) {
                    v = 0;
                } else if (items[i].sellIn < BACKSTAGE_THRESHOLD_1) {
                    v += 3;
                } else if (items[i].sellIn < BACKSTAGE_THRESHOLD_2) {
                    v += 2;
                } else v += 1;

                items[i].quality = Math.min(v, MAX_QUALITY);

                continue;
            }


            // Conjured items degrade twice as fast
            if (items[i].name.startsWith(CONJURED)) {
                items[i].quality -= 2;
                continue;
            }

            //Any other items get quality reduced by until they hit 0. Sellin continues decreasing
            items[i].quality = Math.max(items[i].quality - 1, MIN_QUALITY);
            if (items[i].sellIn < 0) {
                items[i].quality = Math.max(items[i].quality - 1, MIN_QUALITY);
            }
        }
    }
}

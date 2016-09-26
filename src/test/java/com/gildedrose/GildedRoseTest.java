package com.gildedrose;

import org.junit.Assert;
import org.junit.Test;

public class GildedRoseTest {

    @Test public void foo() {
        Item[] items = new Item[] { new Item("foo", 1, 2) };
        GildedRose app = new GildedRose(items);

        // establish aruguments
        Assert.assertEquals("foo", app.items[0].name);
        Assert.assertEquals(2, app.items[0].quality);
        Assert.assertEquals(1, app.items[0].sellIn);

        // test updates
        app.updateQuality();
        Assert.assertEquals(1, app.items[0].quality);
        Assert.assertEquals(0, app.items[0].sellIn);

        // test sell in negative
        app.updateQuality();
        Assert.assertEquals(0, app.items[0].quality);
        Assert.assertEquals(-1, app.items[0].sellIn);

        app.updateQuality();
        Assert.assertEquals("Quality is a non-negative value",0, app.items[0].quality);
        Assert.assertEquals("Sell in continues decreasing",-2, app.items[0].sellIn);

    }




    //Twice as fast
     @Test public void qualityDegradeBy2() {
        Item[] items = new Item[] { new Item("foo", 1, 20) };
        GildedRose app = new GildedRose(items);

         app.updateQuality();
         Assert.assertEquals(19, app.items[0].quality);
         Assert.assertEquals(0, app.items[0].sellIn);

         app.updateQuality();
         Assert.assertEquals(17, app.items[0].quality);
         Assert.assertEquals(-1, app.items[0].sellIn);

     }


    @Test public void agedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        Assert.assertEquals(21, app.items[0].quality);
        Assert.assertEquals(0, app.items[0].sellIn);

        app.updateQuality();
        Assert.assertEquals(23, app.items[0].quality);

        app.updateQuality();
        Assert.assertEquals(25, app.items[0].quality);
        Assert.assertEquals(-2, app.items[0].sellIn);

        items = new Item[] { new Item("Aged Brie", 1, 49) };
        app = new GildedRose(items);
        Assert.assertEquals(49, app.items[0].quality);

        app.updateQuality();
        Assert.assertEquals(50, app.items[0].quality);

        app.updateQuality();
        Assert.assertEquals(50, app.items[0].quality);

    }






    @Test public void sulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        Assert.assertEquals(20, app.items[0].quality);
        Assert.assertEquals(5, app.items[0].sellIn);

    }

    @Test public void backstagePass() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        Assert.assertEquals(21, app.items[0].quality);
        Assert.assertEquals(11, app.items[0].sellIn);

        app.updateQuality();
        Assert.assertEquals(22, app.items[0].quality);
        Assert.assertEquals(10, app.items[0].sellIn);

        app.updateQuality();
        Assert.assertEquals(24, app.items[0].quality);
        Assert.assertEquals(9, app.items[0].sellIn);

        app.updateQuality();
        //quality - 26, sellin 8
        Assert.assertEquals(26, app.items[0].quality);
        Assert.assertEquals(8, app.items[0].sellIn);
        app.updateQuality();
        Assert.assertEquals(28, app.items[0].quality);
        Assert.assertEquals(7, app.items[0].sellIn);
        app.updateQuality();
        Assert.assertEquals(30, app.items[0].quality);
        Assert.assertEquals(6, app.items[0].sellIn);
        app.updateQuality();
        Assert.assertEquals(32, app.items[0].quality);
        Assert.assertEquals(5, app.items[0].sellIn);
        app.updateQuality();
        Assert.assertEquals(35, app.items[0].quality);
        Assert.assertEquals(4, app.items[0].sellIn);
        app.updateQuality();
        Assert.assertEquals(38, app.items[0].quality);
        Assert.assertEquals(3, app.items[0].sellIn);
        app.updateQuality();
        Assert.assertEquals(41, app.items[0].quality);
        Assert.assertEquals(2, app.items[0].sellIn);
        app.updateQuality();
        Assert.assertEquals(44, app.items[0].quality);
        Assert.assertEquals(1, app.items[0].sellIn);
        app.updateQuality();
        Assert.assertEquals(47, app.items[0].quality);
        Assert.assertEquals(0, app.items[0].sellIn);
        app.updateQuality();
        Assert.assertEquals(0, app.items[0].quality);
        Assert.assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    public void toStringTest(){
        Item item = new Item("foo",1,1);
        Assert.assertEquals("foo, 1, 1", item.toString());
    }

    @Test
    public void conjuredTest() {
        Item[] items = new Item[] { new Item("conjured", 10, 40) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        Assert.assertEquals(38, app.items[0].quality);
        Assert.assertEquals(9, app.items[0].sellIn);

        app.updateQuality();
        Assert.assertEquals(36, app.items[0].quality);
        Assert.assertEquals(8, app.items[0].sellIn);

        app.updateQuality();
        Assert.assertEquals(34, app.items[0].quality);
        Assert.assertEquals(7, app.items[0].sellIn);

    }

    @Test
    public void conjuredStartsWithTest() {
        Item[] items = new Item[] { new Item("conjured Something", 10, 40) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        Assert.assertEquals(38, app.items[0].quality);
        Assert.assertEquals(9, app.items[0].sellIn);

        app.updateQuality();
        Assert.assertEquals(36, app.items[0].quality);
        Assert.assertEquals(8, app.items[0].sellIn);

        app.updateQuality();
        Assert.assertEquals(34, app.items[0].quality);
        Assert.assertEquals(7, app.items[0].sellIn);
    }

}
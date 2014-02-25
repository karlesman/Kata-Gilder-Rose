import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {
    @Test
    public void eachDayQualityAndSellInDecreases() {
        Item[] items = new Item[] { new Item("foo", 8, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, app.items[0].sellIn);
        assertEquals(5, app.items[0].quality);
    }
    @Test
    public void expiredItemsDecreaseTwiceFast() {
        Item[] items = new Item[] { new Item("foo", 0, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }
    @Test
    public void qualityIsNeverNegative() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
    @Test
    public void agedBrieIncreaseInQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }
    @Test
    public void qualityHasAnUpperLimit() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    @Test
    public void sulfurasIsLegendary() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].sellIn);
        assertEquals(20, app.items[0].quality);
    }
    @Test
    public void backstageIncreasesInQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
    }
    @Test
    public void backstageIncreasesFasterInQualityWhenConcertAproaches() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
    }
    @Test
    public void backstageIncreasesFasterInQualityWhenConcertIsInminent() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality);
    }
    @Test
    public void backstageLossAllQualityWhenConcertIsOver() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

}

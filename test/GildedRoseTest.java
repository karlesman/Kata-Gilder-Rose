import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {
    @Test
    public void eachDayQualityAndSellInDecreases() {
		Integer anySellIn=8;
		Integer anyQuality=6;
		Integer expectedSellIn=anySellIn-1;
		Integer expectedQuality=anyQuality-NormalItem.NORMAL_DEGRADING_FACTOR;

        Item[] items = new Item[] { new Item(GildedRose.ANY_ITEM, anySellIn, anyQuality) };
        
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(expectedSellIn, app.items[0].sellIn);
        assertEquals(expectedQuality, app.items[0].quality);
    }
    @Test
    public void expiredItemsDecreaseTwiceFast() {
		Integer sellInExpiredDate=0;
		Integer anyQuality=6;
		Integer expectedQuality=anyQuality-NormalItem.EXPIRED_DEGRADING_FACTOR;
		
        Item[] items = new Item[] { new Item(GildedRose.ANY_ITEM, sellInExpiredDate, anyQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(expectedQuality, app.items[0].quality);
    }
    @Test
    public void qualityIsNeverNegative() {
		Integer zeroQuality=0;
		Integer sellInExpiredDate=0;
		
        Item[] items = new Item[] { new Item(GildedRose.ANY_ITEM, sellInExpiredDate, zeroQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(zeroQuality, app.items[0].quality);
    }
    @Test
    public void agedBrieIncreaseInQuality() {
		Integer anySellIn=8;
		Integer anyQuality=5;
		Integer expectedQuality=anyQuality+AgedBried.AGED_BRIE_AGING_FACTOR;
		
        Item[] items = new Item[] { new Item(GildedRose.AGED_BRIE, anySellIn, anyQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(expectedQuality, app.items[0].quality);
    }
    @Test
    /*
     * This rule was not in the requirement. Is it a bug or a hidden requirement?
     * TALK TO PRODUCT OWNER ABOUT THIS
     */
    public void agedBrieIncreaseTwiceInQualityWhenExpired() {
		Integer negativeSellIn=-2;
		Integer anyQuality=5;
		Integer expectedQuality=anyQuality+AgedBried.AGED_BRIE_EXPIRED_AGING_FACTOR;
		
        Item[] items = new Item[] { new Item(GildedRose.AGED_BRIE, negativeSellIn, anyQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(expectedQuality, app.items[0].quality);
    }
    @Test
    public void qualityHasAnUpperLimit() {
		Integer anySellIn=5;
		
        Item[] items = new Item[] { new Item(GildedRose.AGED_BRIE, anySellIn, GildedRose.QUALITY_UPPER_LIMIT) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(GildedRose.QUALITY_UPPER_LIMIT, app.items[0].quality);
    }
    @Test
    public void sulfurasIsLegendary() {
		Integer anySellIn=8;
		Integer anyQuality=6;
		
        Item[] items = new Item[] { new Item(GildedRose.SULFURAS_HAND_OF_RAGNAROS, anySellIn, anyQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(anySellIn, app.items[0].sellIn);
        assertEquals(anyQuality, app.items[0].quality);
    }
    @Test
    public void backstageIncreasesInQuality() {
		Integer longSellIn=20;
		Integer anyQuality=6;
		Integer expectedQuality=anyQuality+1;
		
        Item[] items = new Item[] { new Item(GildedRose.BACKSTAGE_PASSES, longSellIn, anyQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(expectedQuality, app.items[0].quality);
    }
    @Test
    public void backstageIncreasesFasterInQualityWhenConcertAproaches() {
		Integer closeSellIn=9;
		Integer anyQuality=6;
		Integer expectedQuality=anyQuality+2;
		
        Item[] items = new Item[] { new Item(GildedRose.BACKSTAGE_PASSES, closeSellIn, anyQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(expectedQuality, app.items[0].quality);
    }
    @Test
    public void backstageIncreasesFasterInQualityWhenConcertIsInminent() {
		Integer inmminetSellIn=4;
		Integer anyQuality=6;
		Integer expectedQuality=anyQuality+3;
		
        Item[] items = new Item[] { new Item(GildedRose.BACKSTAGE_PASSES, inmminetSellIn, anyQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(expectedQuality, app.items[0].quality);
    }
    @Test
    public void backstageLossAllQualityWhenConcertIsOver() {
		Integer anyQuality=6;
		
        Item[] items = new Item[] { new Item(GildedRose.BACKSTAGE_PASSES, 0, anyQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(0, app.items[0].quality);
    }

}

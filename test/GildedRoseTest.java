import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {
    private static final int UPPER_LIMIT = 50;
    private static final int NORMAL_DEGRADING_FACTOR = 1;
    private static final int EXPIRED_DEGRADING_FACTOR = 2;
    private static final int AGED_BRIE_AGING_FACTOR = 1;
	private static final String ANY_ITEM = "Any Item";
	private static final String AGED_BRIE = "Aged Brie";
	private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	
	@Test
    public void eachDayQualityAndSellInDecreases() {
		Integer anySellIn=8;
		Integer anyQuality=6;
		Integer expectedSellIn=anySellIn-1;
		Integer expectedQuality=anyQuality-NORMAL_DEGRADING_FACTOR;

        Item[] items = new Item[] { new Item(ANY_ITEM, anySellIn, anyQuality) };
        
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(expectedSellIn, app.items[0].sellIn);
        assertEquals(expectedQuality, app.items[0].quality);
    }
    @Test
    public void expiredItemsDecreaseTwiceFast() {
		Integer sellInExpiredDate=0;
		Integer anyQuality=6;
		Integer expectedQuality=anyQuality-EXPIRED_DEGRADING_FACTOR;
		
        Item[] items = new Item[] { new Item(ANY_ITEM, sellInExpiredDate, anyQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(expectedQuality, app.items[0].quality);
    }
    @Test
    public void qualityIsNeverNegative() {
		Integer zeroQuality=0;
		Integer sellInExpiredDate=0;
		
        Item[] items = new Item[] { new Item(ANY_ITEM, sellInExpiredDate, zeroQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(zeroQuality, app.items[0].quality);
    }
    @Test
    public void agedBrieIncreaseInQuality() {
		Integer anySellIn=8;
		Integer anyQuality=5;
		Integer expectedQuality=anyQuality+AGED_BRIE_AGING_FACTOR;
		
        Item[] items = new Item[] { new Item(AGED_BRIE, anySellIn, anyQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(expectedQuality, app.items[0].quality);
    }
    @Test
    public void qualityHasAnUpperLimit() {
		Integer anySellIn=5;
		
        Item[] items = new Item[] { new Item(AGED_BRIE, anySellIn, UPPER_LIMIT) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(UPPER_LIMIT, app.items[0].quality);
    }
    @Test
    public void sulfurasIsLegendary() {
		Integer anySellIn=8;
		Integer anyQuality=6;
		
        Item[] items = new Item[] { new Item(SULFURAS_HAND_OF_RAGNAROS, anySellIn, anyQuality) };
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
		
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, longSellIn, anyQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(expectedQuality, app.items[0].quality);
    }
    @Test
    public void backstageIncreasesFasterInQualityWhenConcertAproaches() {
		Integer closeSellIn=9;
		Integer anyQuality=6;
		Integer expectedQuality=anyQuality+2;
		
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, closeSellIn, anyQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(expectedQuality, app.items[0].quality);
    }
    @Test
    public void backstageIncreasesFasterInQualityWhenConcertIsInminent() {
		Integer inmminetSellIn=4;
		Integer anyQuality=6;
		Integer expectedQuality=anyQuality+3;
		
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, inmminetSellIn, anyQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(expectedQuality, app.items[0].quality);
    }
    @Test
    public void backstageLossAllQualityWhenConcertIsOver() {
		Integer anyQuality=6;
		
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 0, anyQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(0, app.items[0].quality);
    }

}

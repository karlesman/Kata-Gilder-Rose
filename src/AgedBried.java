
public class AgedBried implements StockItem {

	public static final int AGED_BRIE_AGING_FACTOR = 1;
	public static final int AGED_BRIE_EXPIRED_AGING_FACTOR = 2;
	
	
	public void update(GildedRose gildedRose, Item item) {
		if (gildedRose.itemHasExpired(item)) {
			gildedRose.increaseItemQuality(item,AgedBried.AGED_BRIE_EXPIRED_AGING_FACTOR);
		}
		else gildedRose.increaseItemQuality(item,AgedBried.AGED_BRIE_AGING_FACTOR);		
	}



}

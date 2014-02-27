
public class AgedBried implements StockItem {

	public static final int AGED_BRIE_AGING_FACTOR = 1;
	public static final int AGED_BRIE_EXPIRED_AGING_FACTOR = 2;
	
	
	public void update(ItemContainer item) {
		item.decreaseSellIn();
		if (item.hasExpired()) {
			item.increaseQuality(AgedBried.AGED_BRIE_EXPIRED_AGING_FACTOR);
		}
		else item.increaseQuality(AgedBried.AGED_BRIE_AGING_FACTOR);		
	}



}

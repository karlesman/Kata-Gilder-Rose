
public class BackStage  implements StockItem{

	private static final int DATE_IS_INMINENT = 5;
	private static final int DATE_IS_CLOSE = 10;

	private static final int BACKSTAGE_NORMAL_FACTOR = 1;
	private static final int BACKSTAGE_CLOSEDATE_FACTOR = 2;
	private static final int BACKSTAGE_INMINETDAY_FACTOR = 3;
	
	public void update(GildedRose gildedRose, Item item) {
		if (gildedRose.itemHasExpired(item)) {
			item.quality = 0;
		}
		else if (item.sellIn < DATE_IS_INMINENT) {
			gildedRose.increaseItemQuality(item,BACKSTAGE_INMINETDAY_FACTOR);
		}
		else if (item.sellIn < DATE_IS_CLOSE) {
			gildedRose.increaseItemQuality(item,BACKSTAGE_CLOSEDATE_FACTOR);
		}
		else gildedRose.increaseItemQuality(item,BACKSTAGE_NORMAL_FACTOR);
		
	}

}

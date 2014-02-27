
public class NormalItem  implements StockItem{

	static final int NORMAL_DEGRADING_FACTOR = 1;
	static final int EXPIRED_DEGRADING_FACTOR = 2;

	
	public  void update(GildedRose gildedRose, Item item) {
		gildedRose.decreaseSellInItem(item);
		if (gildedRose.itemHasExpired(item)) {
			gildedRose.decreaseItemQuality(item,EXPIRED_DEGRADING_FACTOR);
		}
		else gildedRose.decreaseItemQuality(item,NORMAL_DEGRADING_FACTOR);
		
	}



}

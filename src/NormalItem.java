
public class NormalItem  implements StockItem{

	static final int NORMAL_DEGRADING_FACTOR = 1;
	static final int EXPIRED_DEGRADING_FACTOR = 2;

	
	public  void update(ItemContainer item) {
		item.decreaseSellIn();
		if (item.hasExpired()) {
			item.decreaseQuality(EXPIRED_DEGRADING_FACTOR);
		}
		else item.decreaseQuality(NORMAL_DEGRADING_FACTOR);
		
	}



}

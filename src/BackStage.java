
public class BackStage  implements StockItem{

	private static final int DATE_IS_INMINENT = 5;
	private static final int DATE_IS_CLOSE = 10;

	private static final int BACKSTAGE_NORMAL_FACTOR = 1;
	private static final int BACKSTAGE_CLOSEDATE_FACTOR = 2;
	private static final int BACKSTAGE_INMINETDAY_FACTOR = 3;
	
	public void update(ItemContainer item) {
		item.decreaseSellIn();
		if (item.hasExpired()) {
			item.lossAllQuality();
		}
		else if (item.getDaysToExpire() < DATE_IS_INMINENT) {
			item.increaseQuality(BACKSTAGE_INMINETDAY_FACTOR);
		}
		else if (item.getDaysToExpire() < DATE_IS_CLOSE) {
			item.increaseQuality(BACKSTAGE_CLOSEDATE_FACTOR);
		}
		else item.increaseQuality(BACKSTAGE_NORMAL_FACTOR);
		
	}

}

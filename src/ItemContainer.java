
public class ItemContainer {

	Item item;
	public static final int QUALITY_UPPER_LIMIT = 50;
	
	public ItemContainer(Item item) {
		this.item=item;
	}

	public void decreaseSellIn() {
		item.sellIn = item.sellIn - 1;		
	}
	boolean hasExpired() {
		return item.sellIn < 0;
	}

	void decreaseQuality(Integer factor) {
		if (item.quality <= 0) return;
		item.quality = item.quality -factor;
	}

	void increaseQuality(Integer factor) {
		if (item.quality >= QUALITY_UPPER_LIMIT)	return;
		item.quality = item.quality + factor;
	}

	public void lossAllQuality() {
		item.quality =0;		
	}
	
	public Integer getDaysToExpire(){
		return item.sellIn;
	}
	

}

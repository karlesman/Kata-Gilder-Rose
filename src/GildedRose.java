class GildedRose {
	Item[] items;
	static final int EXPIRED_DEGRADING_FACTOR = 2;
	static final int NORMAL_DEGRADING_FACTOR = 1;
	static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	static final String AGED_BRIE = "Aged Brie";
	static final String ANY_ITEM = "Any Item";
	public static final int QUALITY_UPPER_LIMIT = 50;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			updateItem(items[i]);
		}
	}

	private void updateItem(Item item) {

		if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS))
			return;
		decreaseSellInItem(item);

		if (item.name.equals(AGED_BRIE)){
			updateAgedBrie(item);
			return;
		}
		
		if (item.name.equals(BACKSTAGE_PASSES)){
			updateBackStagePasses(item);
			return;
		}		

		updateNormalItem(item);
	}

	private void updateNormalItem(Item item) {
		if (itemHasExpired(item)) {
			decreaseItemQuality(item,EXPIRED_DEGRADING_FACTOR);
		}
		else decreaseItemQuality(item,NORMAL_DEGRADING_FACTOR);
	}

	private void updateAgedBrie(Item item) {
		increaseItemQuality(item);
		if (itemHasExpired(item)) {
			increaseItemQuality(item);
		}
	}
	private void updateBackStagePasses(Item item) {
		increaseItemQuality(item);
		if (item.sellIn < 10) {
			increaseItemQuality(item);
		}
		if (item.sellIn < 5) {
			increaseItemQuality(item);
		}
		if (itemHasExpired(item)) {
			item.quality = 0;
		}
		
	}

	private boolean itemHasExpired(Item item) {
		return item.sellIn < 0;
	}
	
	private void decreaseSellInItem(Item item) {
		item.sellIn = item.sellIn - 1;
	}

	private void decreaseItemQuality(Item item,Integer Factor) {
		if (item.quality <= 0) return;
		item.quality = item.quality - Factor;
	}

	private void increaseItemQuality(Item item) {
		if (item.quality >= QUALITY_UPPER_LIMIT)	return;
		item.quality = item.quality + 1;
	}
}

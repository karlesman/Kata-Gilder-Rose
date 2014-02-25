class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			updateItem(items[i]);
		}
	}

	private void updateItem(Item item) {

		if (item.name.equals("Sulfuras, Hand of Ragnaros"))
			return;

		decreaseSellInItem(item);

		if (item.name.equals("Aged Brie")){
			updateAgedBrie(item);
			return;
		}
		
		if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
			updateBackStagePasses(item);
			return;
		}		

		decreaseItemQuality(item);

		if (item.sellIn < 0) {
			decreaseItemQuality(item);
		}
	}

	private void updateAgedBrie(Item item) {
		increaseItemQuality(item);
		if (item.sellIn < 0) {
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
		if (item.sellIn < 0) {
			item.quality = 0;
		}
		
	}
	
	private void decreaseSellInItem(Item item) {
		item.sellIn = item.sellIn - 1;
	}

	private void decreaseItemQuality(Item item) {
		if (item.quality <= 0) return;
		item.quality = item.quality - 1;
	}

	private void increaseItemQuality(Item item) {
		if (item.quality >= 50)	return;
		item.quality = item.quality + 1;
	}
}

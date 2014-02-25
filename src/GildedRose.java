class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			updateItem(i);
		}
	}

	private void updateItem(int i) {

		if (items[i].name.equals("Sulfuras, Hand of Ragnaros"))
			return;

		decreaseSellInItem(items[i]);

		if (items[i].name.equals("Aged Brie")){
			updateAgedBrie(items[i]);
			return;
		}
		
		if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")){
			updateBackStagePasses(items[i]);
			return;
		}		

		decreaseItemQuality(items[i]);

		if (items[i].sellIn < 0) {
			decreaseItemQuality(items[i]);
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

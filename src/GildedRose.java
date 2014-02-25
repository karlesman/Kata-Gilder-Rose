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

		decreaseSellIn(i);

		if (items[i].name.equals("Aged Brie")){
			updateAgedBrie(i);
			return;
		}
		
		
		if (!items[i].name
						.equals("Backstage passes to a TAFKAL80ETC concert")) {
			decreaseItemQuality(i);
		} else {
			increaseItemQuality(i);
			if (items[i].sellIn < 10) {
				increaseItemQuality(i);
			}

			if (items[i].sellIn < 5) {
				increaseItemQuality(i);
			}
			

		}



		if (items[i].sellIn < 0) {
	
				if (!items[i].name
						.equals("Backstage passes to a TAFKAL80ETC concert")) {

					decreaseItemQuality(i);

				} else {
					items[i].quality = items[i].quality - items[i].quality;
				}
		}
	}

	private void updateAgedBrie(int i) {
		increaseItemQuality(i);
		if (items[i].sellIn < 0) {
			increaseItemQuality(i);
		}
	}
	
	private void decreaseSellIn(int i) {
		items[i].sellIn = items[i].sellIn - 1;
	}

	private void decreaseItemQuality(int i) {
		if (items[i].quality <= 0) return;
		items[i].quality = items[i].quality - 1;
	}

	private void increaseItemQuality(int i) {
		if (items[i].quality >= 50)	return;
		items[i].quality = items[i].quality + 1;
	}
}

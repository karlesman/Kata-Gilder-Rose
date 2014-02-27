import java.util.HashMap;
import java.util.Map;

class GildedRose {
	Item[] items;
	static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	static final String AGED_BRIE = "Aged Brie";
	static final String ANY_ITEM = "Any Item";
	
	Map<String,StockItem> ItemTypes = new HashMap<String,StockItem>();

	public GildedRose(Item[] items) {
		this.items = items;
		ItemTypes.put(BACKSTAGE_PASSES,new BackStage());
		ItemTypes.put(AGED_BRIE,new AgedBried());
		ItemTypes.put(SULFURAS_HAND_OF_RAGNAROS,new Sulfuras());
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			updateItem(items[i]);
		}
	}

	private void updateItem(Item item) {		
		StockItem itemType = ItemTypes.get(item.name);
		if (itemType == null) {
			  itemType=new NormalItem(); 
		  }

		ItemContainer itemContainer=new ItemContainer(item);
		itemType.update(itemContainer);
	}

	
}

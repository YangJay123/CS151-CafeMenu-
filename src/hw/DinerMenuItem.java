package hw;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class DinerMenuItem implements MenuItem, Serializable  {
	
	private static final long serialVersionUID = 1L;
	
    private String title;
    private String itemID;
    private String description;
    private float price;
    private int count;
    private boolean available;
    private boolean current;
    
    private ArrayList<MenuItem> menuItems = new ArrayList<>(); // Store menu items
    
    public DinerMenuItem(String title, String itemID, String description, float price, int count, boolean current) {
        this.title = title;
        this.itemID = itemID;
        this.description = description;
        this.price = price;
        this.count = count;
        this.current = current;
        this.available = count > 0 && current;
    }

	@Override
	public int compareTo(MenuItem o) {
		return this.getTitle().compareTo(o.getTitle());
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public String getItemID() {
		return itemID;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public float getPrice() {
		return price;
	}

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public boolean isAvailable() {
		return this.available;
	}

	@Override
	public void setAvailable(boolean available) {
		this.available = available;
		
	}

	@Override
	public boolean isCurrent() {
		return this.current;
	}

	@Override
	public void setCurrent(boolean current) {
		this.current = current;
	}

	@Override
	public String toDataString() {
		return String.format("%s|%s|%s|.2f|%d|%b|%b", title, itemID, description, price, count, available, current);
	}

	@Override
	public void addItem(MenuItem item) {
		this.menuItems.add(item);
	}

	@Override
	public void removeItem(String itemID) {
		Iterator<MenuItem> iterator = menuItems.iterator();
		while (iterator.hasNext()) {
			MenuItem item = iterator.next();
			if(item.getItemID() == itemID) {
				iterator.remove();
				break;
			}
		}
	}

	@Override
	public Iterator<MenuItem> createIterator() {
		// TODO Auto-generated method stub
		return menuItems.iterator();
	}

	@Override
	public String getMenuType() {
		return "Diner Menu";
	}

   	// xxx your codes
}

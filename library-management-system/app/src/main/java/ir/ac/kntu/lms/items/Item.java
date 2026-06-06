package ir.ac.kntu.lms.items;

public abstract class Item {
    private int inventory = 0;
    private String title;
    private String category;
    private int publishYear;
    private int id;
    
    public Item() {}    

    public Item(String title, String category, int publishYear) {
        this.title = title;
        this.category = category;
        this.publishYear = publishYear;
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nInventory: ").append(inventory);
        sb.append("\nTitle: ").append(title);
        sb.append("\nCategory: ").append(category);
        sb.append("\nPublish Year: ").append(publishYear);
        sb.append("\nId: ").append(id);
        return sb.toString();
    }

    
    public boolean isAvailable() {
        return inventory > 0;
    }

    public void increaseInventory() {
        inventory ++;
    }
    
    public void decreaseInventory() {
        inventory --;
    }

    public int getInventory() {
        return inventory;
    }

    protected String getTitle() {
        return title;
    }

    protected String getCategory() {
        return category;
    }

    protected int getPublishYear() {
        return publishYear;
    }

    protected int getId() {
        return id;
    }

    public void setInventory(int inventory) {
        if (inventory <= 0) {
            System.out.println("Inventory must be a positive number.");
            return;
        }
        this.inventory = inventory;
    }

}



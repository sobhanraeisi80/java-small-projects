package ir.ac.kntu.lms.items;

public class Magazine extends Item {
    private publishType type;
    private String ISSN;
    
    public Magazine() {super.increaseInventory();}

    public Magazine(String title, String category, String ISSN,int publishYear, publishType type) {
        super(title, category, publishYear);
        this.type = type;
        this.ISSN = ISSN;
        super.increaseInventory();
    }

    @Override
    public String toString() {
        return "Magazine info: " + super.toString() +
                "Publish Type: " + type +
                "\nISSN: " + ISSN;
    }

}


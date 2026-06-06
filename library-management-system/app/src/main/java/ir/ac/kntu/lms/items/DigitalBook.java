package ir.ac.kntu.lms.items;

public class DigitalBook extends Item {
    private Format format;
    private double volume;
    private String downloadUrl;
    private int numberOfPage;
    
    public DigitalBook() {super.increaseInventory();}
    
    public DigitalBook(String title, String category, int publishYear, Format format, double volume, String downloadUrl,int numberOfPage) {
        super(title, category, publishYear);
        this.format = format;
        this.volume = volume;
        this.downloadUrl = downloadUrl;
        this.numberOfPage = numberOfPage;
        super.increaseInventory();
    }

    public String getKind() {
        if (this.format == Format.AAC || this.format == Format.MP3) {
            return "Audio Book";
        }
        
        return "EBook";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKind()).append(" info: ");
        sb.append(super.toString());
        sb.append("\nFormat: ").append(format);
        sb.append("\nVolume: ").append(volume).append("MB");
        sb.append("\nNumber Of Pages: ").append(numberOfPage);
        sb.append("\nDownload Url: ").append(downloadUrl);
        return sb.toString();
    }
    
    

    
}

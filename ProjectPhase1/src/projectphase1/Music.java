package projectphase1;


public class Music {
    private String name, category, description, releaseDate, artist, duration;
    private int quantity, sold;
    public float price;

    //create constructor for Music with parameters
    public Music(String name, String category, String duration,
                 String description, String releaseDate, String artist, int quantity, float price) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.quantity = quantity;
        this.price = price;
        this.artist = artist;
    }


    //create getters and setters for Music
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getDuration() {
        return duration;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public String getArtist() {
        return artist;
    }


    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setCategory(String cat){
        this.category = cat;
    }
    public String print()
    {
        
        return this.name+" - "+this.category+" - " +this.duration+" - "+this.description+" - "+this.releaseDate+" - "+this.artist+" - "+this.quantity+" - " +this.price;
    }
}

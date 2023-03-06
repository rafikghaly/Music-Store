package projectphase1;


public class InsideCart {
    private String name;
    private int quantity;
    private float price;
    public Music music;

    public InsideCart(String name, int quantity, float price, Music music) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.music = music;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

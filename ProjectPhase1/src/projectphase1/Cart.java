package projectphase1;


import java.util.ArrayList;

public class Cart {
    static ArrayList<InsideCart> musicCarts = new ArrayList<InsideCart>();
    public float getTotalPrice() {
        float total = 0;
        for (InsideCart insideCart : musicCarts) {
            
            total += insideCart.getPrice() * insideCart.getQuantity();
        }
        return total;
    }
    public boolean removeMusic(String name){
        for (InsideCart ic : musicCarts) {
            if (ic.getName().equals(name)) {
                ic.music.setQuantity(ic.music.getQuantity()+ic.getQuantity());
                musicCarts.remove(ic);
                return true;
            }
        }
        return false;
    }
    public  InsideCart getInside(String name){
        for (InsideCart ic : musicCarts) {
            if (ic.getName().equals(name)) {
               
                return ic;
            }
        }
        return null;
    }
    public void clear(){
        musicCarts = new ArrayList<InsideCart>();
    }
}

package projectphase1;


public class Customer extends User {
    Cart cart = new Cart();

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = "customer";
    }

    public void listCart() {
        if(cart.musicCarts.isEmpty())
        {
            System.out.println("Your cart is empty!");
            return;
        }
        System.out.println("listing cart...");
        for (InsideCart insideCart : cart.musicCarts) {
            System.out.println(insideCart.getName() + " " + insideCart.getQuantity() + " " + insideCart.getPrice());
        }
    }

    public void checkout() {
         if(cart.musicCarts.isEmpty())
        {
            System.out.println("Your cart is empty!");
            return;
        }
        System.out.println("checking out...");
        float total = 0;
        for (InsideCart insideCart : cart.musicCarts) {
            System.out.println(insideCart.getName() + " " + insideCart.getQuantity() + " * " + insideCart.getPrice());
            total += insideCart.getQuantity() * insideCart.getPrice();
        }
        System.out.println("total: " + total);
                    cart.musicCarts.clear();

    }

}


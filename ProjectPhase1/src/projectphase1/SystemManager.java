package projectphase1;


import java.util.ArrayList;

public class SystemManager {
     static boolean signedIn = false;
    static ArrayList<User> users = new ArrayList<User>();
    static Customer currentUser = new Customer("user", "12345");
    
    static {
        users.add(new Admin("admin", "1234"));
        users.add(new Customer("user", "12345"));
    }
    
    
    public static void greetings(){
    
        System.out.println("Greetings, Welcome to our music store system! please refer to the following commands: ");
        System.out.println("*------------------------------------------------------------------------------------*");
        help();
        System.out.println("*------------------------------------------------------------------------------------*");
    }
    
    static void help() {
        System.out.println("login {username} {password} - logs in");
        System.out.println("exit - exits the application");
        System.out.println("help - prints this help");
   
        if (currentUser == null) {
            return;
        }
        if (currentUser.role.equals("admin")) {
            System.out.println("signout - logs out");
            System.out.println("listMusic - show all music details");
            System.out.println("addCategory {category} - adds a category");
            System.out.println("addMusic {name} {category} {duration} {description} {release_date} {artist} {quantity} {price} "
                    + "- adds a song to a category");
            System.out.println("removeCategory {category} - removes a category");
            System.out.println("removeMusic {name}- removes a song from list");
            System.out.println("editDescription {name} {description} - edits the description");
            System.out.println("editCategory {name} {category} - edits the category");
            System.out.println("WARNING: For any spaces in (name, description, artist) use '_' instead");

        } else if (currentUser.role.equals("customer")) {
            System.out.println("signout - logs out");
            System.out.println("listMusic - show all music details");
            System.out.println("findMusic {token} - finds a song"+
            " || The tokens are: name, category, artist");
            System.out.println("filterMusic {token} - filters music || The tokens are: sold, inStock, allMusic");
            System.out.println("listCart - lists the cart");
            System.out.println("addToCart {name} {quantity} - creates an order");
            System.out.println("removeFromCart {name} - removes a song from the cart");
            System.out.println("checkout - checks out the cart");
        }
        System.out.println("*------------------------------------------------------------------------------------*");
        System.out.println("\t");
    }
    
    static void login(String line){
        if (signedIn) {
                    System.out.println("You are already signed in"); 
                }
                    String username = line.split(" ")[1];
                    String password = line.split(" ")[2];
                    for (User user : users) {
                        if (user.username.equals(username) && user.password.equals(password)) {
                            signedIn = true;
                            System.out.println("Login Successful");
                            System.out.println("*------------------------------------------------------------------------------------*");
                            System.out.println("Your sets of commands are:");
                            System.out.println("*------------------------------------------------------------------------------------*");

                         //   currentUser = user;
                            SystemManager.help();
                            break;

                        }
                    }
                    if (!signedIn) {
                        System.out.println("Username and password do not match");
                    }
    }
    
    static void logout(){
        if (signedIn) {
                        signedIn = false;
                        currentUser = null;
                        System.out.println("Signing out...");
                    } else {
                        System.out.println("You are not signed in");
                    }
    }
    
    static void listmusic(){
        System.out.println("listing music...");
                    System.out.println("*------------------------------------------------------------------------------------*");
                    Store.listMusic();
                    System.out.println("*------------------------------------------------------------------------------------*");

    }
    
    static void addCat(String category){
     
                       if(!Category.checkCategory(category)){ 
                           Category.addCategory(category);
                            System.out.println("'"+category+"' has been added");
                       }
                       else{
                           System.out.println("category already exists");
                       }
    }
    
    static boolean addMusic(String name,String category, String duration,String description,String releaseDate ,String artist,int quantity,float price){
 
                        if (Category.checkCategory(category)) {
                            Music music = new Music(name, category, duration, description, releaseDate, artist, quantity, price);
                            Store.addMusic(music);
                            System.out.println("'"+name+"' has been added to '"+category+"' category.");
                            return true;

                        } else {
                            return false;
                        }
    }
    
    public static void removeCat(String category){
                        if (Category.checkCategory(category)) {
                            Category.removeCategory(category);
                        System.out.println("'"+category+"' has been removed");
                        } else {
                            System.out.println("category does not exist");
                        }
    }
    
    public static void editCat(String name,String cat){
       
                        if(Category.checkCategory(cat)){
                        Store.getMusic(name).setCategory(cat);
                            System.out.println("Category edited");
                        }
                        else{
                            System.out.println("No category found");
                        }
    }
    
    public static void removeMusic(String name){
      
                        if (Store.getMusic(name) != null) {
                            Store.removeMusic(name);
                        }else{
                            System.out.println("Music not found");
                        }
    }
    
    public static void editDesc(String name,String description){
       
                        if(description.contains("_"))
                        {
                            description = description.replaceAll("_", " ");
                        }
                        Store.getMusic(name).setDescription(description);
                        System.out.println("Successfully edited...");
    }
    
    public static void addToCart(String name){

                        if (Store.buyMusic(name, 1, ((Customer) currentUser).cart)) {
                          
                            System.out.println("The following music are still available...");
                            System.out.println("*------------------------------------------------------------------------------------*");
                            Store.listMusic();
                            System.out.println("*------------------------------------------------------------------------------------*");

                        } else {
                            System.out.println("Item not found");
                        }
    }
    
    public static void removeFromCart(String name){
        
                        if (((Customer) currentUser).cart.removeMusic(name)) {
                            System.out.println("Removed: " + name);
                        } else {
                            System.out.println("Item not found");
                        }
    }
    
    public static void listCart(){
        ((Customer) currentUser).listCart();
    }
    
    public static void checkout(){
        ((Customer) currentUser).checkout();
    }
    public static void filterMusic(String line){
        String token = line.split(" ")[1];
                        Store.filter(token);
    }
    
    public static void findMusic(String line){
        String name = line.split(" ")[1];
                        Store.findMusic(name);
    }
    
    
}

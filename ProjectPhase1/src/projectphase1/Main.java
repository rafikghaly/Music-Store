package projectphase1;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
       SystemManager.greetings();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            String command = line.split(" ")[0].toLowerCase();
            if (command.equals("exit")) {
                break;
            } else if (command.equals("help")) {
                SystemManager.help();
            } else if (command.equals("login")) {
                SystemManager.login(line);

            }
            if (SystemManager.signedIn) {
                if (command.equals("signout".toLowerCase())) {
                    SystemManager.logout();
                } else if (command.equals("listMusic".toLowerCase())) {
                    SystemManager.listmusic();
                } else if (SystemManager.currentUser.role.equals("admin")) {
                    if (command.equals("addCategory".toLowerCase())) {
                       
                        SystemManager.addCat(line);
                        
                        
                    } else if (command.equals("addmusic".toLowerCase())) {
                        
                    //    SystemManager.addMusic(String name,String category, String duration,String description,String releaseDate ,String artist,int quantity,float price);
                        
                    } else if (command.equals("removeCategory".toLowerCase())) {
                         
                        SystemManager.removeCat(line);
                        
                    } else if (command.equals("editCategory".toLowerCase())){
                       // SystemManager.editCat(line);
                        
                    } 
                    
                    else if (command.equals("removeMusic".toLowerCase())) {
                           SystemManager.removeMusic(line);
                    } else if (command.equals("editDescription".toLowerCase())) {
                     //   SystemManager.editDesc(line);
                    } else if(command.equals("listCategories".toLowerCase())){
                        Category.listCategories();
                    }

                } else if (SystemManager.currentUser.role.equals("customer")) {

                    if (command.equals("addToCart".toLowerCase())) {
                        SystemManager.addToCart(line);
                    } else if (command.equals("removeFromCart".toLowerCase())) {
                        SystemManager.removeFromCart(line);
                    } else if (command.equals("listCart".toLowerCase())) {
                        SystemManager.listCart();
                    } else if (command.equals("findMusic".toLowerCase())) {
                        SystemManager.findMusic(line);
                    } else if (command.equals("filterMusic".toLowerCase())) {
                        SystemManager.filterMusic(line);

                    } else if (command.equals("checkout")) {
                        SystemManager.checkout();
                        
                    }

                }
            }
        }
    }

    
}

package projectphase1;


import java.util.ArrayList;

public class Category {
    public static ArrayList<String> categories = new ArrayList<String>();
    static {
        categories.add("comedy");
        categories.add("Classical");
        categories.add("hip hop");
    }

    
    
    public static void addCategory(String category) {
        categories.add(category);
        System.out.println(categories);

    }

    public static void removeCategory(String category) {
        
           
                System.out.println("removing "+category);
                categories.remove(category);
                for(Music m: Store.songs){
                    if (m.getCategory().equals(category)){
                        m.setCategory("Null");
                    }
                }
                
            
        
        System.out.println(categories);
        
    }

    public static boolean checkCategory(String category) {
        return categories.contains(category);
    }
    public static void listCategories(){
        for(String c: categories){
            System.out.println(c);
        }
    }
    



}

package projectphase1;


import java.util.ArrayList;

public class Store {


    public static ArrayList<Music> songs = new ArrayList<Music>();
    static Music m = new Music("Moonlight", "Classical", "5:30", "beautiful moonlight",
            "21/3/2020", "Andrew Cool", 5, 3);
    static Music m2 = new Music("Candles", "hip hop", "3:45", "lit candles",
            "20/6/2019", "Juice WRLD", 1, 100);
    static Music m3 = new Music("Ghariba El Nas", "Classical", "5:11", "Ghariba El Nas Ghariba El Donia Deyat",
            "2008", "Wael Jassar", 3, 150);
    static Music m4 = new Music("Qoulee Ouhibbouka", "Classical", "6:24", "Qoulee Ouhibbouka Ky Tzeed Wsamaty",
            "1999", "Kadim Al Sahir", 5, 120);
    static Music m5 = new Music("Ettala Fia", "Classical", "4:43", "Sad song of a heart break",
            "2016", "Carole Samaha", 60, 95);
    static Music m6 = new Music("Cold", "pop", "3:49", "lit candles",
            "2017", "Maroon 5", 22,115);

    static {
        songs.add(m);
        songs.add(m2);
        songs.add(m3);
        songs.add(m4);
        songs.add(m5);
        songs.add(m6);
    }

    public static void listMusic() {
        for (Music m : songs) {
            if (m.getQuantity() == 0) {
                continue;
            }
            System.out.println(String.format("Name: %s Category: %s Duration: %s Description: %s Release Date: %s Artist: %s " +
                            "Quantity: %d Price: %.2f",
                    m.getName(), m.getCategory(), m.getDuration(), m.getDescription(), m.getReleaseDate(), m.getArtist(),
                    m.getQuantity(), m.getPrice()));
        }

    }

    public static void addMusic(Music m) {
        songs.add(m);
    }

    public static void removeMusic(String music) {
        System.out.println("removing " + music);
        if (songs.removeIf(m -> m.getName().equals(music))) {
            System.out.println("removed");
        } else {
            System.out.println("music not found");
        }
    }

    public static Music getMusic(String music) {
        for (Music m : songs) {
            if (m.getName().startsWith(music)) {
                return m;
            }
        }
        return null;
    }

    public static void findMusic(String name) {
        boolean isFound = false;
        if (name.contains("_")) {
            name = name.replaceAll("_", " ");
        }
        for (Music m : songs) {

            if (m.getName().toLowerCase().contains(name.toLowerCase()) || m.getArtist().toLowerCase().contains(name.toLowerCase()) || m.getCategory().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(String.format("Name: %s Category: %s Duration: %s Description: %s Release Date: %s Artist: %s " +
                                "Quantity: %d Price: %.2f",
                        m.getName(), m.getCategory(), m.getDuration(), m.getDescription(), m.getReleaseDate(), m.getArtist(),
                        m.getQuantity(), m.getPrice()));

                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("No music found");
        }
    }

    public static boolean buyMusic(String name, int quantity, Cart cart) {
        for (Music m : songs) {
            if (m.getName().equals(name)) {
                if (m.getQuantity() >= quantity) {
                    m.setQuantity(m.getQuantity() - quantity);
                    m.setSold(m.getSold() + quantity);
                    for (InsideCart ic : cart.musicCarts) {
                        if (ic.getName().equals(name)) {
                            System.out.println("found " + ic.getName());
                            ic.setQuantity(ic.getQuantity() + quantity);

                            return true;
                        }
                    }
                    cart.musicCarts.add(new InsideCart(name, quantity, m.getPrice(), m));
                    System.out.println("'" + name + "' has been added to your cart!\t");
                    return true;
                } else {
                    System.out.println("not enough quantity");
                    return true;
                }
            }
        }
        return false;

    }

    public static void filter(String token) {
        boolean isFound = false;
        if (token.equals("sold".toLowerCase())) {
            for (Music m : songs) {

                if (m.getQuantity() == 0) {
                    System.out.println(m.getName());
                    isFound = true;
                }
            }
            if (!isFound) {
                System.out.println("All music are still available");
            }
        } else if (token.equals("instock".toLowerCase())) {
            for (Music m : songs) {
                if (m.getQuantity() > 0) {
                    System.out.println(m.getName());
                    isFound = true;
                }
            }
            if (!isFound) {
                System.out.println("No music available");
            }
        } else if (token.equals("allmusic".toLowerCase())) {
            for (Music m : songs) {
                if (m.getQuantity() == 0) {
                    System.out.println("Sold: *" + m.getName() + "*");
                    continue;
                }
                System.out.print("In Stock:  ");
                System.out.println(String.format("*Name: %s Category: %s Artist: %s " +
                                "Quantity: %d Price: %f*",
                        m.getName(), m.getCategory(), m.getArtist(),
                        m.getQuantity(), m.getPrice()));
            }

        }
    }


}

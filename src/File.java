public enum File {

    FOOD("src/Files/Food.txt"), DRINKS("src/Files/Drinks.txt"), BOOZE("src/Files/Booze.txt"), RESTAURANTS("src/Files/Restaurants.txt");

    public String path;



    File(String path) {
        this.path = path;
    }


}

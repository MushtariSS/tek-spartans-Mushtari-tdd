package tek.tdd.utility;

public class DataGenerator {
    public static String generateRandomEmail(String prefix){
        int random = (int)(Math.random()*1000000);
        return prefix+random+"@gmail.com";
    }
}

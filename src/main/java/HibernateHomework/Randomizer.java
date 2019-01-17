package HibernateHomework;

import java.util.Random;

public class Randomizer {

    public Randomizer() {
    }

    public static Flat newFlat () {
        Random r = new Random();
        String[] disticts = new String[] {"Borshchaga", "Troya", "Far far away"};
        //generating adress
        StringBuilder sb = new StringBuilder();
        sb.append(newString(r.nextInt(5)+3));
        sb.append(", ");
        sb.append(r.nextInt(100)+1);
        sb.append(" - ");
        sb.append(r.nextInt(500)+1);

        Flat randomFlat = new Flat(disticts[r.nextInt(3)], sb.toString(), r.nextInt(150) + 30, r.nextInt(4) + 1, (r.nextInt(800) +100 ) * 1000);
        return randomFlat;
    }

    public static int newIntParam (int value) {
        Random r = new Random();
        return r.nextInt(value) + 1;
    }

    public static String newString (int length) {
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        sb.append((char)((r.nextInt(26))+65)); // upper case letter
        for (int i = 0; i <= length - 1; i++) {
            sb.append((char)(r.nextInt(26)+97)); // lower case letters
        }
        return sb.toString();
    }

    public static String newName () {
        Random r = new Random();
        String[] names = new String[] {"Vasya", "Petya", "Masha", "Dasha", "Ignat", "Innokentij", "Agnieszka", "Bianka"};
        return names[r.nextInt(names.length)];
    }

    public static int newPhoneNumber () {
        return 1000000 + newIntParam(8999998);
    }



}

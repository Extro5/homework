package main.Java.Utilities;


import java.util.LinkedList;
import java.util.List;

public class EnumManufacturer {
    public enum Manufacturer {

        RUSSIA("Russia"), ITALY("Italy"), USA("USA"), CHINA("China"), GERMANY("Germany"), JAPAN("Japan");

        private String country;

        Manufacturer(String country) {
            this.country = country;
        }

        public String getCountry() {
            return this.country;
        }
    }


    public static String[] getManufacturers() {
        List<String> values = new LinkedList<>();
        for (Manufacturer amount : Manufacturer.values()) {
            values.add(amount.getCountry());
        }
        String[] vals = new String[values.size()];
        int i = 0;
        for (String v : values) {
            vals[i] = v;
            i++;
        }
        return vals;
    }
}

package main.Java.Repository;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import main.Java.Entities.Product;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

public class RestRep {

    private static final String URL = "http://localhost:3000/products";

    public static void add(Product product) throws Exception {

        try {
            HttpURLConnection con = (HttpURLConnection) ((new URL(URL).openConnection()));          // объявили, указали POST
            con.setRequestMethod("POST");

            StringBuilder urlProductBild = new StringBuilder();
            urlProductBild.append("name=").append(URLEncoder.encode(product.getName(), "UTF8")).append("&");
            urlProductBild.append("price=").append(product.getPrice()).append("&");
            urlProductBild.append("weight=").append(product.getWeight()).append("&");
            urlProductBild.append("manufacturer=").append(URLEncoder.encode(product.getManufacturer(), "UTF8")).append("&");
            con.setDoOutput(true);          // собарли, разрешили

            try (DataOutputStream out = new DataOutputStream(con.getOutputStream())) {  // отправили
                out.writeBytes(urlProductBild.toString());
            }

            int responseCode = con.getResponseCode();
            System.out.println("Request to  : " + URL);
            System.out.println("Response Code : " + responseCode);  // сгенерировали ответ

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<JsonElement> getElements(String json) {             // парсим
        JsonArray productArray = (new JsonParser()).parse(json).getAsJsonArray();
        List<JsonElement> elementList = new ArrayList<>();
        productArray.iterator().forEachRemaining(elementList::add);
        return elementList;
    }

    public static List<Product> getAll() throws Exception {     // достали, закинули в констурктор
        List<Product> products = new LinkedList<>();
        String data = readAll();
        for (JsonElement e : getElements(data)) {
            JsonObject obj = e.getAsJsonObject();
            Iterator<Map.Entry<String, JsonElement>> elements = obj.entrySet().iterator();
            int i = 0;
            Product current = new Product();
            while (elements.hasNext()) {
                switch (i++) {
                    case 0:
                        current.setName1(elements.next().getValue().getAsString());
                        break;
                    case 1:
                        current.setPrice1(elements.next().getValue().getAsInt());
                        break;
                    case 2:
                        current.setWeight1(elements.next().getValue().getAsInt());
                        break;
                    case 3:
                        current.setManufacturer1(elements.next().getValue().getAsString());
                        break;
                    case 4:
                        elements.next();
                        break;
                    case 5:
                        current.setId1(elements.next().getValue().getAsInt());
                }
            }
            products.add(current);
        }


        return products;
    }


    private static String readAll() throws Exception {     // читаем, с сайта, естественно GET...
        StringBuilder data = new StringBuilder();
        try {
            HttpURLConnection con = (HttpURLConnection) ((new URL(URL).openConnection()));
            con.setRequestMethod("GET");

            con.setDoInput(true);
            String s;
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                while ((s = in.readLine()) != null) {
                    data.append(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data.toString();
    }
}

package main.Java.Entities;

public class Product {

    private String name;
    private int price;
    private int weight;
    private String manufacturer;

    private int id1;
    private String name1;
    private int price1;
    private int weight1;
    private String manufacturer1;


    public Product(String name, int price, int weight, String manufacturer) {
        this.setName(name);
        this.setPrice(price);
        this.setWeight(weight);
        this.setManufacturer(manufacturer);
    }

    public Product(int id1, String name1, int price1, int weight1, String manufacturer1) {
        this.setId1(id1);
        this.setName1(name1);
        this.setPrice1(price1);
        this.setWeight1(weight1);
        this.setManufacturer1(manufacturer1);
    }

    public Product() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public int getPrice1() {
        return price1;
    }

    public void setPrice1(int price1) {
        this.price1 = price1;
    }

    public int getWeight1() {
        return weight1;
    }

    public void setWeight1(int weight1) {
        this.weight1 = weight1;
    }

    public String getManufacturer1() {
        return manufacturer1;
    }

    public void setManufacturer1(String manufacturer1) {
        this.manufacturer1 = manufacturer1;
    }
}

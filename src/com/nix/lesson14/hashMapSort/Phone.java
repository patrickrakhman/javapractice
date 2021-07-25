package com.nix.lesson14.hashMapSort;

public class Phone implements Comparable<Phone>{

    private final String brand;
    private final String model;
    private final Integer price;

    public String getBrand(){
        return brand;
    }

    public Phone(String brand, String model, Integer price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Phone somePhone = (Phone) obj;

        return (brand.equals(somePhone.brand)) && (model.equals(somePhone.model)) && (price.equals(somePhone.price));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + brand.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }


    @Override
    public int compareTo(Phone somePhone) {
        int result = brand.compareTo(somePhone.brand);
        if (result != 0)
            return result;
        result = model.compareTo(somePhone.model);
        if (result != 0)
            return result;
        result = price.compareTo(somePhone.price);
        if (result != 0) {
            result = result / Math.abs(result);
            return result;
        }
        return 0;
    }
}

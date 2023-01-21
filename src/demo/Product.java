package demo;

import java.time.LocalDate;
import java.util.Objects;

public class Product implements Comparable<Product> {

    private final Type type;
    private double price;
    private LocalDate createData = LocalDate.of(2022, 12, 31);
    private boolean discount = false;

    public Product(Type type, double price) {
        this.type = type;
        this.price = price;
    }

    public Product(Type type, double price, boolean discount) {
        this.discount = discount;
        this.type = type;
        this.price = price;
        if (this.discount) {
            this.price = price * 0.9;
        }
    }

    public Product(Type type, double price, LocalDate createData, boolean discount) {
        this.type = type;
        if (discount) {
            this.price = price * 0.9;
        }
        this.discount = discount;
        this.createData = createData;

    }

    public Type getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return createData;
    }


    public boolean isDiscount() {
        return discount;
    }


    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", createData=" + createData +
                ", discount=" + discount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && Objects.equals(type, product.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, price, createData, discount);
    }

    @Override
    public int compareTo(Product o) {
        return (int) ((this.getPrice() * 100) - (o.getPrice() * 100));
    }
}

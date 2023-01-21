package demo;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Product book = new Product(Type.BOOK, 250);
        Product toy = new Product(Type.TOY, 260);
        Product book2 = new Product(Type.BOOK, 30);
        Product pen = new Product(Type.PEN, 15);
        Product book3 = new Product(Type.BOOK, 280, true);
        Product phone = new Product(Type.PHONE, 700, true);
        Product cup = new Product(Type.CUP, 20, true);
        Product pencil = new Product(Type.PENCIL, 5, true);
        Product book4 = new Product(Type.BOOK, 300, true);
        Product book5 = new Product(Type.BOOK, 70, true);
        Product phone2 = new Product(Type.PHONE, 700, LocalDate.of(2022, 12, 20), true);
        Product cup2 = new Product(Type.CUP, 20, LocalDate.of(2022, 12, 20), true);
        Product pencil2 = new Product(Type.PENCIL, 5, LocalDate.of(2023, 1, 15), true);
        Product book6 = new Product(Type.BOOK, 150, LocalDate.of(2019, 12, 20), true);
        Product book7 = new Product(Type.BOOK, 60, LocalDate.of(2023, 1, 20), true);
        Product book8 = new Product(Type.BOOK, 70, LocalDate.of(2023, 1, 23), true);


        List<Product> productList = List.of(book, book2, book3, book4, book5, book6, book7, book8, toy, pen, pencil2, phone, phone2, cup, cup2, pencil);
        ProductHandler handler = new ProductHandler();

        System.out.println("Books, price > 250\n" +
                handler.getSomeProducts(productList, Type.BOOK)); //books, price > 250

        System.out.println("Books with discount\n" +
                handler.getListDiscountProducts(productList, Type.BOOK)); //books with discount

        System.out.println("The cheapest book\n" +
                handler.getCheapestProducts(productList, Type.BOOK)); //the cheapest book

        System.out.println("Three latest products\n" +
                handler.getThreeLatestProducts(productList)); //three products

        System.out.println("Sum of prices this year books, price < 75\n" +
                handler.calcSumSomeProducts(productList, Type.BOOK)); //calc sum of price books, price < 75

        System.out.println("Grouping by type\n" +
                handler.getGroupProducts(productList));
    }
}

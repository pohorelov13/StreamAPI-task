package demo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductHandler {

    public final List<Product> getSomeProducts(List<Product> list, Type type) {
        return list.stream().filter((product1) -> product1.getPrice() > 250
                        && product1.getType().equals(type))
                .collect(Collectors.toList());
    }


    public List<Product> getListDiscountProducts(List<Product> list, Type type) {
        return list.stream().filter((p) -> p.getType().equals(type)
                        && p.isDiscount())
                .collect(Collectors.toList());
    }

    public Product getCheapestProducts(List<Product> list, Type type) {
        return list.stream()
                .filter((product) -> product.getType().equals(type))
                .sorted().findFirst()
                .orElseThrow(() -> new NoSuchElementException("Product of type [" + type + "] not found"));
    }


    public List<Product> getThreeLatestProducts(List<Product> list) {
        return list.stream()
                .sorted((o1, o2) -> o2.getDate().compareTo(o1.getDate()))
                .limit(3)
                .collect(Collectors.toList());
    }

    public double calcSumSomeProducts(List<Product> list, Type type) {
        return list.stream()
                .filter((product) -> product.getDate().getYear() == LocalDate.now().getYear()
                        && product.getType().equals(type) && product.getPrice() < 75)
                .mapToDouble((Product::getPrice)).
                sum();
    }


    public Map<Type, List<Product>> getGroupProducts(List<Product> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }
}

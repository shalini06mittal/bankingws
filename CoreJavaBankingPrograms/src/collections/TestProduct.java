package collections;

import oops.p1.A;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestProduct {
    static void main() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"AC",25234, "elect"));
        products.add(new Product(3,"pyjama",234, "clothing"));
        products.add(new Product(2,"MAC LAPTOP PRO",125234, "elect"));
        products.add(new Product(5,"shirt",1000, "clothing"));
        products.add(new Product(4,"Mouse",20000, "elect"));

        for(Product product : products)
            System.out.println(product);
        System.out.println();
        Collections.sort(products);
        for(Product product : products)
            System.out.println(product);
        System.out.println();

        for(Product product : products)
            System.out.println(product);
        System.out.println();
        Collections.sort(products,new ProductNameComparator());
        for(Product product : products)
            System.out.println(product);
        System.out.println();
        List<Integer> nos = new ArrayList<>();
        nos.add(10);
        nos.add(21);
        nos.add(14);
        nos.add(3);
        nos.add(12);
        System.out.println(nos);
        Collections.sort(nos);
        System.out.println(nos);



    }
}


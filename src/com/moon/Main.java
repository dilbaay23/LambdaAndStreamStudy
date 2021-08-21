package com.moon;

import com.moon.lambda.Addable;
import com.moon.lambda.Drawable;
import com.moon.lambda.Product;
import com.moon.lambda.Sayable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int width= 10;


        //without lambda, Drawable implementation using anonymous class
        anonymousDrawable(width);

        //with lambda
        drawable(width);

        sayable();
        
        //In Java lambda expression, if there is only one statement, you may or may not use return keyword. 
        // You must use return keyword when lambda expression contains multiple statements.

        addable();
        
        listable();

        sayableMultipleStatement();

        sortProductList();
        
        filterProductList();

    }

    private static void filterProductList() {
        List<Product> list=new ArrayList<Product>();
        list.add(new Product(1,"Samsung A5",17000f));
        list.add(new Product(3,"Iphone 6S",65000f));
        list.add(new Product(2,"Sony Xperia",25000f));
        list.add(new Product(4,"Nokia Lumia",15000f));
        list.add(new Product(5,"Redmi4 ",26000f));
        list.add(new Product(6,"Lenevo Vibe",19000f));

        // using lambda to filter data
        Stream<Product> filtered_data = list.stream().filter(p -> p.price > 20000);

        // using lambda to iterate through collection
        filtered_data.forEach(
                product -> System.out.println(product.name+": "+product.price)
        );
    }

    private static void sortProductList() {
        List<Product> list=new ArrayList<Product>();

        //Adding Products
        list.add(new Product(1,"HP Laptop",25000f));
        list.add(new Product(3,"Keyboard",300f));
        list.add(new Product(2,"Dell Mouse",150f));

        System.out.println("Sorting on the basis of name...");

        // implementing lambda expression
        list.sort((p1, p2) -> p1.name.compareTo(p2.name));

     //   Collections.sort(list,(p1, p2)-> p1.name.compareTo(p2.name));   // list.sort ile ayni isi yapiyor

        for(Product p:list){
            System.out.println(p.id+" "+p.name+" "+p.price);
        }


    }

    private static void sayableMultipleStatement() {
        Sayable person = message -> {
            String str1 = "I would like to say, ";
            String str2 = str1 + message;
            return str2;
        };
        System.out.println(person.say("time is precious"));

        print(message->{
            String str1 = "222 I would like to say, ";
            String str2 = str1 + message;
            return str2;
        });


    }
    private static void print(Sayable str){
        System.out.println(str.say("hey"));
    }

    private static void listable() {
        List<String> list=new ArrayList<String>();
        list.add("moon");
        list.add("lua");
        list.add("bloem");
        list.forEach(n -> System.out.println(n));
    }

    private static void addable() {
        // Multiple parameters in lambda expression
        Addable ad1=(a, b)->(a+b);
        System.out.println(ad1.add(10,20));

        // Multiple parameters with data type in lambda expression
        Addable ad2=(int a,int b)->(a+b);
        System.out.println(ad2.add(100,200));

        // Replace lambda with method reference
        Addable ad3= Integer::sum;
        System.out.println(ad3.add(700,20));
    }

    private static void anonymousDrawable(int width) {
        Drawable drawableNormal = new Drawable() {
                public void draw(){
                    System.out.println("Drawing Anonymous: " + width);
                }
        };
        drawableNormal.draw();
    }

    private static void drawable(int width) {
        Drawable drawableLambda = () ->System.out.println("Drawing Lambda: " + width);
        drawableLambda.draw();
    }

    private static void sayable() {
        Sayable s1 = (name)-> "Hello, " + name;
        Sayable s2 = name-> "Hello, " + name;

        System.out.println(s1.say("Moon"));
        System.out.println(s2.say("Lua"));
    }
}

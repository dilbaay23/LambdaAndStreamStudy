package com.moon.methodReference;



/**
 * Created by Moon on 21/08/2021
 */
public class ReferenceToAnInstanceMethod {
    public void saySomething(){
        System.out.println("Hello, this is non-static method.");
    }
    public static void main(String[] args) {
         ReferenceToAnInstanceMethod methodReference = new ReferenceToAnInstanceMethod(); // Creating object
        // Referring non-static method using reference
        Sayable sayable = methodReference::saySomething;
        // Calling interface method
        sayable.say();
        // Referring non-static method using anonymous object
        Sayable sayable2 = new ReferenceToAnInstanceMethod()::saySomething; // You can use anonymous object also
        // Calling interface method
        sayable2.say();
    }
}

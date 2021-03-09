package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


//Створіть просту  ієрархію спадкування, яка відповідає сутностям Товар (властивості - назва, виробник, дата виготовлення, ціна)
// та Продукти харчування (термін придатності, харчова група (молочні, м'ясні, бакалея та інше)),
// РадіоЕлектроніка (вид електроніки, гарантійний термін). Продемонструйте перевантаження конструкторів та методів,
// перевизначення методів, особливості роботи конструкторів при спадкуванні.

class Product{
    String name;
    String virobnik;
    LocaleData date_of_release;
    double price;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }


    public Product(String name, String virobnik, LocaleData  date_of_release, double price ) {
        this.name=name;
        this.virobnik=virobnik;
        this.date_of_release=date_of_release;
        this.price=price;
    }


    public void show( String name){
        System.out.println("Назва товару: "+ name);
    }
    public void show(String name, double price){
        System.out.println("Назва товару: "+ name+ "Ціна: "+ price);
    }

    public void show(){
        System.out.println("Name: " + name+ "Virobnik: "+ virobnik+ "Date of release: "+ date_of_release+ "Price: "+ price);
    }
    public void one(){

    }






}

class Product_of_food extends Product{
    int expiration_date;
    String food_group;
    public Product_of_food(String name, String virobnik, LocaleData date_of_release, double price, int expiration_date, String food_group) {
        // super(name, virobnik, date_of_release, price);
        one();
        this.expiration_date=expiration_date;
        this.food_group=food_group;
    }
    public  void print(){
        System.out.println("Термін придатності: "+expiration_date+ "Харчова група: "+food_group);
    }

    @Override
    public void show() {
        super.show();

    }
}

class Radio_Electronics extends Product{
    String type_of_electronics;
    int guarantee;
    public Radio_Electronics(String name, String virobnik, LocaleData date_of_release, double price, String type_of_electronics, int guarantee) {
        super(name, virobnik, date_of_release, price);
        this.type_of_electronics=type_of_electronics;
        this.guarantee=guarantee;
    }

    @Override
    public void show() {
        super.show();
    }
}

//Створіть тестовий приклад, який демонструє відмінності
// при використанні різних модифікаторів доступу.

class Person {
    String name;
    public int age;
    protected String email;
    private String phone;

    public Person(String name, int age, String email, String phone) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public void name() {
        System.out.println("Name: " + name);
    }

    void age() {
        System.out.println("Age: " + age);
    }

    protected void email() {
        System.out.println("Email: " + email);
    }

    private void phone() {
        System.out.println("Phone: " + phone);
    }

    static void main(String[] args) {
        Person p = new Person("Ivan", 20, "vany56@gmail.com", "0636522834");
        p.phone();
    }
}
//Створіть метод, який приймає параметр - значення перерахування для місяця,повертає кількість днів в місяці. Лютий завжди 28

enum Month {

    January("Січень", 31 ),
    February("Лютий",28),
    March("Березень",31),
    April("Квітень",30),
    May("Травень",31),
    June("Червень",30),
    July("Липень",31),
    August("Серпень",31),
    September("Вересень",30),
    October("Жовтень",31),
    November("Листопад",30),
    December("Грудень",31);

    private String name;
    private int daysCount;


    Month( String name, int daysCount) {
        this.daysCount = daysCount;
        this.name=name;
    }


    public String toString() {
        return name +"-" + daysCount+ " днів" ;

    }






    public void Method(String[] str) {

        for(int i= str.length-1; i>=0; i--){
            System.out.println(str[i]);
        }

    }


}
//Створіть метод який дозволяє фільтрувати елементи будь якого масиву int та виводити ці елементи на консоль.
// Умови фільтрації повинні передаватися в метод як параметр.
// Використовуйте функціональні інтерфейси та анонимні класи.


interface ConditionFilter{
    boolean filter(int element);
}


class Method {
    ConditionFilter conditionFilter = new ConditionFilter() {


        @Override
        public boolean filter(int element) {
            return element > 0;
        }
    };

    public void filtr(int[] arr, ConditionFilter condition) {
        for (int i = 0; i < arr.length; i++) {
            if (condition.filter(arr[i])) {
                System.out.println(arr[i]);
            }


        }



    }


}



public class Main {


    public static void main(String[] args)
    //  throws IOException
    {
        //Створіть код, у якому генеруються слідуючі типи виключень  ArrayIndexOutOfBoundsException,
        // ArithmeticException, NullPointerException, IndexOutOfBoundsException, Exception.
        // Продемонструйте відмінність між =checked=  та  =unchecked= виключеннями.

        try {
            FileWriter fileWriter = new FileWriter("out.txt");
            fileWriter.close();
            fileWriter.write("Hello World");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            int arr[] = new int[8];
            arr[9] = 3;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error!!! ArrayIndexOutOfBounds");
        }

        try {
            int a = 10, b = 0;
            int c = a / b;
            System.out.println("Result= " + c);
        } catch (ArithmeticException e) {
            System.out.println("Не можна ділити на нуль!!!");
        } catch (Exception e) {
            System.out.println("Exception!!!");
        }

        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Error!!! NullPointerException");
        }


        Person person = new Person("Ivan", 20, "vany56@gmail.com", "0636522834");
        person.name();
        person.age();
        person.email();
        //person.phone();
        System.out.println(person.name);
        System.out.println(person.age);
        System.out.println(person.email);
        //System.out.println(person.phone);


        for (Month m : Month.values()) {
            System.out.println(m);
        }

    }


}










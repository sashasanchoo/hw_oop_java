package org.itstep.task01;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Human {
    private String fullName;
    private String dateOfBirth;
    private String phone;
    private String city;
    private String country;
    private String address;

    private Scanner _scanner;

    public Human() {
    }

    public Human(String fullName, String dateOfBirth, String phone, String city, String country, String address) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.city = city;
        this.country = country;
        this.address = address;
        this._scanner = new Scanner(System.in).useDelimiter("\n");
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void ReadValues(){
        List<Method> methods = Arrays.asList(Human.super.getClass().getDeclaredMethods());
        for(Method method: methods){
            if(method.getName().contains("get"))
            {
                try {
                    System.out.println(Human.super.getClass().getDeclaredMethod(method.getName(), (Class<?>[]) null).invoke(this));
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public void WriteValues(){
        List<Method> methods = Arrays.asList(Human.super.getClass().getDeclaredMethods());
        List<Field> fields = Arrays.asList(Human.super.getClass().getDeclaredFields());
        for(Field field: fields){
            for(Method method: methods){
                if(method.getName().toLowerCase().contains("set") && method.getName().toLowerCase().contains(field.getName().toLowerCase())){
                    System.out.println(method.getName());
                    if(_scanner.hasNext()){
                        try {
                            String value = _scanner.nextLine();
                            Human.super.getClass().getDeclaredMethod(method.getName(), String.class).invoke(this, value);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        } catch (InvocationTargetException e) {
                            throw new RuntimeException(e);
                        } catch (NoSuchMethodException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            }
        }
    }
}

package org.itstep.task02;

import org.itstep.task01.Human;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class City {
    private String name;
    private String region;
    private String country;
    private int inhabitants;
    private String code;
    private String index;
    private Scanner _scanner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getInhabitants() {
        return inhabitants;
    }

    public void setInhabitants(int inhabitants) {
        this.inhabitants = inhabitants;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }



    public City(String name, String region, String country, int inhabitants, String code, String index) {
        this.name = name;
        this.region = region;
        this.country = country;
        this.inhabitants = inhabitants;
        this.code = code;
        this.index = index;
        this._scanner = new Scanner(System.in).useDelimiter("\n");
    }

    public City() {
    }
    public void ReadValues(){
        List<Method> methods = Arrays.asList(City.super.getClass().getDeclaredMethods());
        for(Method method: methods){
            if(method.getName().contains("get"))
            {
                try {
                    System.out.println(City.super.getClass().getDeclaredMethod(method.getName(), (Class<?>[]) null).invoke(this));
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
        List<Method> methods = Arrays.asList(City.super.getClass().getDeclaredMethods());
        List<Field> fields = Arrays.asList(City.super.getClass().getDeclaredFields());
        for(Field field: fields){
            for(Method method: methods){
                if(method.getName().toLowerCase().contains("set") && method.getName().toLowerCase().contains(field.getName().toLowerCase())){
                    System.out.println(method.getName());
                    try {
                        if(_scanner.hasNext() && !_scanner.hasNextInt()){
                            String value = _scanner.nextLine();
                            City.super.getClass().getDeclaredMethod(method.getName(), String.class).invoke(this, value);
                        }
                        else if(_scanner.hasNextInt()){
                            int value = _scanner.nextInt();
                            City.super.getClass().getDeclaredMethod(method.getName(), int.class).invoke(this, value);
                        }
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

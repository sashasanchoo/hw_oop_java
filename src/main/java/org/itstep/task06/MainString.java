package org.itstep.task06;

import java.util.Arrays;

public class MainString {
    private char[] chars;

    public MainString(CharSequence charsParam) {
        chars = new char[0];
        for(int i = 0; i < charsParam.length(); i++){
            chars = Arrays.copyOf(chars, chars.length + 1);
            chars[chars.length - 1] = charsParam.charAt(i);
        }
    }
    public MainString(char symbol, int length){
        chars = new char[0];
        for(int i = 0; i < length; i++){
            chars = Arrays.copyOf(chars, chars.length + 1);
            chars[chars.length - 1] = symbol;
        }
    }
    public MainString() {
        chars = new char[0];
    }
    public int length(){
        return chars.length;
    }
    public void clean(){
        chars = new char[0];
    }
    public MainString concat(MainString str){
        return new MainString(this.toString() + str.toString());
    }
    public String toString(){
        return new String(chars);
    }
    public int indexOf(int symbol){
        return this.toString().indexOf(symbol);
    }


}

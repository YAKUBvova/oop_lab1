package org.example;

public class Main {
    public static void main(String[] args) {
        StringCalculator str = new StringCalculator() ;
        String[] test = {"//[!][!!!][!!][0][00]\n1001\n1!!!1!!102!!!1111"};
        int result;
        for (String s : test) {
            System.out.println("For string '"+s.replace('\n','n')+"'");
            result = str.add(s);
            if (result == -1) continue;
            System.out.println("result is :"+result);
        }

    }
}
package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringCalculator {
    public List<String> delimiters = new ArrayList<>();
    {
        delimiters.add(",");
        delimiters.add("\n");
    }
    public void edit(List<String> del){

        delimiters.addAll(del);
    }
    public void list_clean(){
        while (delimiters.size()>2){
            delimiters.remove(2);
        }
    }
    public String custom_del(String str){
        List<String> res = new ArrayList<>();
        int start =2 ;
        int end ;
        for (int i =2 ; i < str.length();i++){
            if (str.charAt(i)=='['&& str.charAt(i+1)!='\n')start=i+1;
            if (str.charAt(i)==']'&& str.charAt(i-1)!='/'){
                end = i;
                res.add(str.substring(start,end));
                start = i+1;
            }
            if (str.charAt(i)=='\n'){
                end=i;
                if (!str.substring(start,end).equals("")){
                    res.add(str.substring(start,end));
                }
                if (res.isEmpty()){break;}
                res.sort(Collections.reverseOrder());
                edit(res);
                return str.substring(i+1);
            }
        }
        return "";
    }


}
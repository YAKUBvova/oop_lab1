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

}
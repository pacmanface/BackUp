import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.*;

public class ListToArray{
    public static void main(String[] args) {
        int[] intArr = {0,1,2,3};
        String[] sArr = {"hi","ko","ri","ku"};
        Object[] arr = {new Object(), new Object(), new Object(),new Object()};

        List<Object> list = new ArrayList<>();

        //array -> list
        for (Object object : sArr) {
            list.add(object);
        }
        showAndClean(list);
        
        Collections.addAll(list, sArr);
        showAndClean(list);
        
        
        list = Arrays.stream(sArr).collect(Collectors.toList());
        showAndClean(list);
        
        
        list = Arrays.asList(sArr);
        showAndClean(list);

        //list -> array



    }

    static void showAndClean(List<Object> list) {
        System.out.println(list);
        list.clear();
        System.out.println(list);      
    }
}
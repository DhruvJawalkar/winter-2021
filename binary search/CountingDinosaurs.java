import java.util.*;

class Solution {
    public int solve(String animals, String dinosaurs) {
        
        int counter = 0;
        for(char ch : animals.toCharArray()){
            if(dinosaurs.indexOf(ch)!=-1){
                counter++;
            }
        }

        return counter;
    }
}
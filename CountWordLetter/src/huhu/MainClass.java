package huhu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author root
 */

public class MainClass {
    
    private static HashMap<Character, Integer> CountChar = new HashMap<>();
    private static HashMap<String, Integer> CountWord = new HashMap<>();
    
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.print("Enter your content: ");
        String content = scanner.nextLine();
        
        
        MainClass obj = new MainClass();
        obj.Count(content);
        obj.Display();
        
        
    }
        void Count(String content){
        for(char ch : content.toCharArray()){
            if(Character.isSpaceChar(ch)){
                continue;
            }
            if(!CountChar.containsKey(ch)){
                CountChar.put(ch, 1);
            }
            else{
                CountChar.put(ch, (int) CountChar.get(ch) + 1);
            }
        }
        StringTokenizer token = new StringTokenizer(content);
        while(token.hasMoreTokens()){
            String token2 = token.nextToken();
            if(!CountWord.containsKey(token)){
                CountWord.put(token2, 1);
            }
            else{
                CountWord.put(token2, (int) CountWord.get(token) + 1);
            }
        }
        
        
    }
    void Display(){
        System.out.println(CountWord);
        System.out.println(CountChar);
        
    }
    

    
    
}

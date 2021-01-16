
// Wildcard matching

// words = [cat, bat, board]

// query = c*t
// query = b*t
// query = b****
// query = cat
// query = asdfasfasdfaefsdfas


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class TrieNode{
    HashMap<Character, TrieNode> children;
    boolean isEnd;
    
    TrieNode(){
        this.children = new HashMap<>();
        this.isEnd = false;
    }
}

class Trie{
    TrieNode root;
    
    Trie(List<String> words){
        this.root = new TrieNode();
        
        for(String word : words){
            this.addWord(word);
        }
    }
    
    private void addWord(String word){
        TrieNode cur = root;
        
        for(char ch : word.toCharArray()){
            if(!cur.children.containsKey(ch)){
                cur.children.put(ch, new TrieNode());
            }
            
            cur = cur.children.get(ch);    
        }
        
        cur.isEnd = true;
    }
    
    // query = c*t
    // query = b*t
    // query = b****
    // query = cat
    // query = asdfasfasdfaefsdfas
    
    // query = c*t
    // q = b*t
    //     root
    //     /.   \
    //     c.    b
    //     /.   /  \
    //     a.  o    a
    //     /.      /  \ 
    //     t       g   t
    
    
    boolean search(TrieNode root, String query){
        TrieNode cur = root;
        
        for(int i=0; i<query.length(); i++){
            char ch = query.charAt(i);
            if(ch=='*'){
                for(Map.Entry<Character, TrieNode> entry : cur.children.entrySet()){
                    if(search(entry.getValue(), query.substring(i))){
                        return true;
                    };
                }
            }
            else{
                if(cur.children.containsKey(ch)){
                    cur = cur.children.get(ch);
                }
                else
                    return false;
            }
            

        }
        
        return cur.isEnd;
    }
    
}

public class Solution {
    

 public static void main(String[] args) {
     // words = [cat, bat, board]
     List<String> words = new ArrayList<>(Arrays.asList("cat", "bat", "board"));
     
     // query = c*t
    // query = b*t
    // query = b****
    // query = cat
    // query = asdfasfasdfaefsdfas
     List<String> queries = new ArrayList<>(Arrays.asList("c*t", "b*t", "b****", "cat", "asdfasfasdfaefsdfas"));
     List<Boolean> output = new ArrayList<>(); 
     
     Trie trie = new Trie(words);
     
     for(String query : queries){
         output.add(trie.search(trie.root, query));
     }
     
     int i = 0;
     for(boolean res : output){
        System.out.println(queries.get(i)+"->"+res); 
        i++;    
     }
     
   }
}

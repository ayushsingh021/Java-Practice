import javax.swing.plaf.TreeUI;

public class duplicateChar {

    public static void removeDup(String str, int idx , StringBuilder newStr, boolean map[]){
        //base case
        if(idx == str.length()){
            System.out.println(newStr);
            return;
        }

        //kaam
        char currChar = str.charAt(idx);
        if(map[currChar - 'a']== true){
            //duplicate char
            removeDup(str, idx+1, newStr, map);
        }else{
            map[currChar - 'a'] = true;
            removeDup(str, idx+1, newStr.append(currChar), map);
        }

    }
    public static void main(String[] args) {
        String str = "apppnacolllege";
        removeDup(str, 0, new StringBuilder(""), new boolean [26]);

    }
    
}

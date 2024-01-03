package basic.day4;

public class ProbStringReverse {
    public static void main(String[] args) {

        String message = "Hello World";
        char[] messageArray = new char[message.length()];
        String meg = "";

        for(int i=message.length() - 1;i>=0;i--){
            meg += message.charAt(i);
        }
        System.out.println(meg);

        for(int i=message.length()-1, j=0; i>=0;i--, j++){
            messageArray[j] = message.charAt(i);
        }
        System.out.println(messageArray);

        ////////////////////////////////////////////////////////////////////////////////////

        int idx=message.length()-1;
        for(int i=0;i<message.length();i++){
            char temp = message.charAt(i);
            messageArray[idx]=temp;
            idx--;
        }
        System.out.println(messageArray);
        
    }
}

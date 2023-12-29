package basic.day2;

public class A10StringVariable {
    public static void main(String[] args){
        // String 은 문자열 : 문자(' ')의 집합 문자열 리터럴은 기호 "" 사용합니다.
        String message = "Hello";

        System.out.println(message);
        System.out.println("메세지 '" + message + "'의 길이 : " + message.length());

        message = "welcome~ java world!!!";
        System.out.println("메세지 '" + message + "'의 길이 : " + message.length());

        // String 으로 선언된 변수는 '객체' 입니다.
        // 그래서 여러가지 메소드를 갖고 필요한 기능들을 제공해줍니다.
        // char imo = '😊'; // char은 2바이트 이모지는 4바이트. 문자형으로 저장안됌.
        String emo = "😊";

        System.out.println(emo);

        System.out.println("*************************************");
        // 자바 String의 중요한 메서드 10가지씩 조사해서 테스트 해보기
        // append()

        // length()
        /*
        문자열 데이터의 길이를 반환하는 메서드이다.
        파라미터는 존재하지 않는다.
        */
        String str = "Hello java";
        System.out.println(str.length());
        System.out.println("************************");


        // concat()
        /*
        문자열과 문자열을 결합하는 메서드이다.
        파라미터에 추가할 String형 데이터가 온다.
        */
        String str1 = "Hello ";
        String lang = "java";
        System.out.println(str1.concat(lang));
        System.out.println("************************");


        // substring()
        /*
        문자열을 자르는 메서드이다.
        파라미터에 어디부터 어디까지 자를지 문자열의 인덱스가 와야한다.
        첫번째 파라미터가 시작 인덱스, 두번째 파라미터가 마지막 인덱스이며,
        파라미터를 하나만 넣을경우, 입력받은 인덱스부터 마지막까지 문자열을 자른다.
         */
        String str2 = "Hello java";
        String lang1 = str2.substring(6);

        System.out.println(lang1);
        System.out.println("************************");


        // indexOf()
        /*
        문자가 위치한 인덱스를 반환하는 메서드이다.
        파라미터로 char형 문자를 입력받으며, 해당 문자와 일치하는 문자가 
        문자열에 존재할 경우 인덱스를 반환한다. 
        만약 2개 이상 문자가 발견될 경우, 가장 먼저 오는 문자의 인덱스를 반환한다.
        문자가 존재하지 않는 경우엔 -1을 반환한다.
         */
        String str3 = "Hello java";
        System.out.println(str3.indexOf('a'));
        System.out.println("************************");


        // lastIndexOf()
        /*
        indexOf()와 비슷한 기능을 가진 메서드이다.
        문자열의 인덱스를 반환하는 것은 같으나 indexOf()와 달리
        뒤에서부터 조회해서 인덱스를 반환한다는 점이 특징이다.
        마지막 문자의 인덱스를 반환한다.
        파라미터로 인덱스 조회를 하고자하는 char형 문자를 입력받는다.
         */
        String str4 = "Hello java";
        System.out.println(str4.lastIndexOf('a'));
        System.out.println("************************");


        // charAt()
        /*
        indexOf()와 반대의 메서드이다.
        인덱스에 위치한 문자를 반환하는 메서드이다.
        파라미터로는 int형 인덱스를 입력받는다.
         */
        String str5 = "Hello java";
        System.out.println(str5.charAt(0));
        System.out.println("************************");


        // isEmpty()
        /*
        해당 문자열이 빈 값인지 확인하는 메서드이다.
        문자열의 길이가 0인지 비교하여 boolean값을 반환한다.
        파라미터는 없다.
        문자열의 길이가 0이면, true
        문자열의 길이가 0이 아니면 false
         */
        String empty = "";
        System.out.println(empty.isEmpty());
        String str6 = "Hello java";
        System.out.println(str6.isEmpty());
        System.out.println("************************");


        // replace()
        /*
        문자열의 일부를 다른 문자열로 바꿔주는 메서드이다.
        파라미터로는 2개를 가지며, 첫째 파라미터로 바꿀 문자열,
        두번째 파라미터로 새로운 문자열을 입력한다.
         */
        String str7 = "Hello java";
        String newstr = str7.replace("java", "python");
        System.out.println(newstr);
        System.out.println("************************");

        
        // toUpperCase()
        /*
        문자열을 대문자로 바꿔주는 메서드이다.
        파라미터에 대문자로 바꿔줄 String 데이터를 입력한다.
         */
        System.out.println("************************");
        // toLowerCase()
        /*
        문자열로 소문자로 바꿔주는 메서드이다.
        파라미터에 소문자로 바꿔줄 String 데이터를 입력한다.
         */
        System.out.println("************************");
        // trim()
        /*
        문자열 앞뒤의 공백을 제거해주는 메서드이다.
        파라미터는 없다.
         */
        System.out.println("************************");
        // split()

        System.out.println("************************");
        // toCharArray()

        System.out.println("************************");
        // getBytes()

        System.out.println("************************");
    }
    
}

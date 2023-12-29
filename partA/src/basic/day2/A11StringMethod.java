package basic.day2;

public class A11StringMethod {
    public static void main(String[] args){
        // 메서드는 메서드 이름 뒤에 괄호가 따라옵니다.
        // 그리고, 괄호안에 값들은 메서드 처리에 필요한 입력 데이터 -> 메서드의 `인자` 라고 합니다.
        // 메서드가 처리한 결과는 출력 데이터 -> 메서드의 `리턴(반환)값` 이라고 합니다.

        // 자바 String의 중요한 메서드 7가지씩 조사해서 테스트 해보기
        // 메서드 인자에 개수 와 형식에 따라 분류 해보기

        String message = "Hello world";

        // 1. 메서드 괄호안에 아무것도 없는 것 : length, isEmpty, toUppercase, toLowerCase
        System.out.println("message.length() " + message.length() + " = 길이");
        System.out.println("message.toUpperCase() " + message.toUpperCase() + " = 대문자로 변환");
        System.out.println("message.toLowerCase() " + message.toLowerCase() + " = 소문자로 변환");
        System.out.println("message.isEmpty() " + message.isEmpty() + " = 길이가 0이면 True 아니면 False");
        System.out.println("\n************************");

        // 2. 메서드 괄호안에 정수 1개를 쓰는 것 : charAt
        System.out.println("message.charAt(0) " + message.charAt(0) + " = 0번째 자리의 값");
        System.out.println("message.charAt(3) " + message.charAt(3) + " = 3번째 자리의 값");
        // 현재 message에서 마지막 인덱스는 얼마인가하면.... length-1
        System.out.println("************************");
        
        // 3. 메서드 괄호안에 문자열 1개를 쓰는 것 : concat, equals, startsWith, endsWith
        System.out.println("message.concat(message) " + message.concat(" ~짱짱") + " = 문자열끼리 이어줌");
        // 대소문자 구분하면서 hello 로 시작하는지 검사하는 메서드
        System.out.println("message.startsWith(hello)" + message.startsWith("hello") + " = message가 Hello로 시작하므로 hello(false)");
        System.out.println("message.startsWith(Hello)" + message.startsWith("Hello") + " = message가 Hello로 시작하므로 Hello(true)");
        System.out.println("message.endsWith(hello) " + message.endsWith("hello") + " = message가 world로 끝나므로 hello(false)");
        System.out.println("message.endsWith(HellO) " + message.endsWith("world") + " = message가 world로 끝나므로 world(true)");
        // 문자열안에서 원하는 단어의 위치를 찾기 -> 시작위치 index값을 리턴, 단어가 없으면 -1을 리턴
        System.out.println("message.indexOf(World) " + message.indexOf("World") + " = 시작위치에 대문자 (W)가 없으므로 -1");
        System.out.println("message.indexOf(World) " + message.indexOf("world") + " = 시작위치에 소문자 (w)가 있으므로 순서에 따른 값을 리턴");

        String str = "hello world";
        System.out.println("message.equals(str) " + message.equals(str) + " = 두 값이 서로 다르므로 false");
        System.out.println("message.equals(message) " + message.equals(message) + " = 두 값이 서로 같으므로 true");
        System.out.println("************************");

        // 4. 메서드 괄호안에 정수 2개를 쓰는 것 : substring(문자열 부분 추출 : 시작인덱스, 마지막인덱스값을 인자로 주기)
        System.out.println("message.substring(1,3) " + message.substring(1,3) + " = 1 ~ 3 사이에 인덱스만 추출");
        System.out.println("************************");
        // 추출할 때 마지막 인덱스는 포함안함 message.substring(1,3)(3은 포함안함 Hello 1~3 사이에 인덱스만 추출)

        // 5. 메서드 괄호안에 문자 또는 문자열 2개를 쓰는 것 : replace(문자열 바꾸기)
        System.out.println("message.replace() " + message.replace("world", "python") + " = target을 새 문자열로 replace");
        System.out.println("************************");

        // 질문 공유
        // 1) 메서드의 리턴타입에 따라 결과를 저장할 변수를 일치하는 형식으로 선언하기
        String temp = message.toUpperCase().substring(3,5);
        // ㄴ 2) 문자열리턴값으로 또 메서드 실행가능
        System.out.println("message.toUpperCase().substring(3,5) "
                            + message.toUpperCase().substring(3,5));

        int len = message.length();
        char ch = message.charAt(5);
        System.out.println(len);
        System.out.println(ch);
    }
        // 리턴값 형식을 기준으로 정리하기
        // boolean : isEmpty, startsWith, endsWith, equals, isBlank
        // String(문자열) : toUpperCase, toLowerCase, concat, substring, replace
        // int : length, indexOf
        // char(문자) : charAt
}

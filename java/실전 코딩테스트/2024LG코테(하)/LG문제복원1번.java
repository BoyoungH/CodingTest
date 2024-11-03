public class LG문제복원1번 {

    public static String transform(String input) {
        StringBuilder result = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                // 숫자 변환 규칙: 1->9, 2->8, ..., 9->1, 0->0
                if (ch == '0') {
                    result.append('0');
                } else {
                    result.append((char) ('9' - (ch - '1')));
                }
            } else if (Character.isLowerCase(ch)) {
                // 소문자 알파벳 변환 규칙: a->z, b->y, ..., z->a
                result.append((char) ('z' - (ch - 'a')));
            } else if (Character.isUpperCase(ch)) {
                // 대문자 알파벳 변환 규칙: A->B, B->C, ..., Z->A
                result.append((char) (((ch - 'A' + 1) % 26) + 'A'));
            } else {
                // 알파벳, 숫자 외의 문자는 그대로
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // 테스트 입력
        String input = "Hello World! 12345";
        String transformed = transform(input);
        System.out.println("Transformed: " + transformed);
    }
}

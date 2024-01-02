// 특정 알고리즘x, 시간 개념 활용 문제
//하루: 12번 정시 -> 25 * 12 = 300 명 탑승, 12*5 = 60번 10분 단위 탑승 -> 60 * 15 = 900 탑승 /  하루 총 탑승객 : 900+300=1200명
//한시간 탑승인원 : 25 + 5*15 = 25 + 75 = 100

import java.sql.Date;
import java.util.Calendar;

public class Q3 {
    public static void main(String[] args) {
        int 대기인원 = 14000605;
        solution(대기인원);
    }

    public static void solution(int 대기인원) {
        int 일년일수 = 0;

        for (int i = 10; i > 0; i--) {
            일년일수 += (int)Math.pow(2, i);
        }

        int 대기일 = 대기인원 / 1200;
        int 연도 = 대기일 / 일년일수;
        int 남은일수 = 대기일 % 일년일수;
        int 월 = 0;

        for (int i = 10; i > 0; i--) {
            월++;
            if (남은일수 < (int)Math.pow(2, i)) {
                break;
            }
            남은일수 -= (int)Math.pow(2, i);
        }

        int 일 = 남은일수;
        int 최종남은인원 = 대기인원 % 1200;
        int 시 = 최종남은인원 / 100 + 9;
        int[] 출발분 = {25, 40, 55, 70, 85, 100}; //배열 원소는 탑승객, 해당 인덱스는 10을 곱하여 "분"을 구함
        int 몇분에탈지계산 = 최종남은인원 % 100 + 1;
        int 당일출발_분 = 0;

        for (int i = 0; i < 출발분.length; i++) {
            if (출발분[i] > 몇분에탈지계산) { // 남은 인원수 check
                당일출발_분 = i * 10; 
                break;
            }
        }

        Calendar 오늘시간 = Calendar.getInstance(); 
        int 분 = 오늘시간.get(Calendar.MINUTE) + 당일출발_분;

        if (분 > 60) {
            분 = 분 - 60;
            시++;
        }
        
        System.out.println((연도 + 2020) + "년 " + 월 + "월 " + 일 + "일 " + 시 + "시 " + 분 + "분");
    }
}
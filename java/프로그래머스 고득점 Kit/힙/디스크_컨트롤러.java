package 힙;

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;           // 총 작업 시간을 저장하는 변수
        int count = 0;            // 완료된 작업 수를 카운트하는 변수
        int currentTime = 0;      // 현재 시간을 추적하는 변수
        int jobsIndex = 0;        // jobs 배열을 순차적으로 접근하기 위한 인덱스
        
        // 요청 시간이 빠른 순으로 jobs 배열 정렬
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        // 작업의 소요 시간을 기준으로 오름차순 정렬되는 우선순위 큐 생성
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        // 모든 작업을 처리할 때까지 반복
        while (count < jobs.length) {
            // 현재 시간 이하로 요청된 작업들을 우선순위 큐에 추가
            while (jobsIndex < jobs.length && jobs[jobsIndex][0] <= currentTime) {
                pq.add(jobs[jobsIndex++]); // 큐에 추가 후 인덱스 증가
            }
            
            // 큐가 비어있는 경우 -> 다음 요청된 작업의 요청 시간으로 시간을 이동
            if (pq.isEmpty()) {
                currentTime = jobs[jobsIndex][0];
            } else {
                // 큐에서 소요 시간이 가장 짧은 작업을 가져와 처리
                int[] now = pq.poll();
                
                // 요청부터 완료까지 걸린 시간을 answer에 누적
                answer += currentTime - now[0] + now[1];
                
                // 작업을 완료한 후 현재 시간을 갱신
                currentTime += now[1];
                
                // 완료한 작업 수 증가
                count++;
            }
        }
        
        // 총 소요 시간을 작업 수로 나누어 평균 반환
        return answer / jobs.length;
    }
}


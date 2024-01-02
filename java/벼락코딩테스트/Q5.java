// DFS 깊이 우선 탐색 알고리즘(stack 사용)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class Q5 {
    public static void main(String[] args) {
        HashMap<Integer, Integer[]> graph = new HashMap<Integer, Integer[]>();
        
        graph.put(100, new Integer[] {67, 66});
        graph.put(67, new Integer[] {100, 82, 63});
        graph.put(66, new Integer[] {100, 73, 69});
        graph.put(82, new Integer[] {67, 61, 79});
        graph.put(63, new Integer[] {67});
        graph.put(73, new Integer[] {66});
        graph.put(69, new Integer[] {66, 65, 81});
        graph.put(61, new Integer[] {82});
        graph.put(79, new Integer[] {82, 87, 77});
        graph.put(65, new Integer[] {69, 84, 99});
        graph.put(81, new Integer[] {69});
        graph.put(87, new Integer[] {79, 31, 78});
        graph.put(77, new Integer[] {79});
        graph.put(84, new Integer[] {65});
        graph.put(99, new Integer[] {65});
        graph.put(31, new Integer[] {87});
        graph.put(78, new Integer[] {87});

        // traversal(graph, 100);
        // System.out.println();
        getMax(graph, 100);
        System.out.println();
        getMin(graph, 100);
    }

    // 최댓값 구하기
    public static void getMax(HashMap<Integer, Integer[]> graph, int start) {
        ArrayList<Integer> 방문 = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(start);

        while(!stack.isEmpty()) {
            int top = stack.pop();

            if (!방문.contains(top)) { // 방문하지 않은 노드의 경우
                if (top != start) { // 방문하지 않은 노드 중 루트 노드가 아닌 경우
                    System.out.print((char)top);
                }

                방문.add(top); // 부모는 방문함

                ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(graph.get(top))); //부모 노드와 자식 노드들을 list로 가져옴
                list.removeAll(방문); // 자식 노드들 중에서 방문한 노드들 제거(부모 노드 제거 후 자식 노드들만 남음), 방문하지 않은 자식 노드들만 남음

                //System.out.println(list);

                if (list.size() == 0) {
                    break;
                }

                stack.push(Collections.max(list));
            }
        }
    } 

    // 최솟값 구하기
    public static void getMin(HashMap<Integer, Integer[]> graph, int start){
        ArrayList<Integer> 방문 = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        
        stack.push(start);

        while(!stack.isEmpty()){
            int top = stack.pop();

            if(!방문.contains(top)){
                if(top != start){
                    System.out.print((char)top);
                }

                방문.add(top);

                ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(graph.get(top)));
                list.removeAll(방문);

                if(list.size()==0){
                    break;
                }

                stack.push(Collections.min(list));
            }
        }
    }
}
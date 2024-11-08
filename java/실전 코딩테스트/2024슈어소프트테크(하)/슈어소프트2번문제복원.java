import java.util.*;
/*
 * 인덱스가 트리 0부터 시작하는 경우, 왼쪽 노드 2*index+1 오른쪽 노드 2*index+2
 * 인덱스가 트리 1부터 시작하는 경우, 트리 0에는 널값 추가하고 왼쪽 노드 2*index 오른쪽 노드 2*index+1
 * 순회 순서에 따라 list에 값을 추가해주는 순서를 다르게 하기(재귀함수 순서 위치)
 * 전위 : 현->왼->오, 중위 : 왼->현->오, 후위 : 왼->오->현
 */
public class 슈어소프트2번문제복원 {
    private List<Character> postOrderList = new ArrayList<>();
    private List<Character> preOrderList = new ArrayList<>();
    private List<Character> inOrderList = new ArrayList<>();

    public String solution(String message) {
        // 트리를 완전 이진 트리 형태로 만들기 위해서 리스트로 변환
        List<Character> tree = new ArrayList<>();
        tree.add(null); // 인덱스 1부터 사용하기 위해 0번 인덱스에 더미 값을 추가
        for (char c : message.toCharArray()) {
            tree.add(c);
        }

        // 후위 순회 수행 (루트는 인덱스 1부터 시작)
        postOrderTraversal(tree, 1);

        // 전위 순회 수행 (루트는 인덱스 1부터 시작)
        preOrderTraversal(tree, 1);

        // 중위 순회 수행 (루트는 인덱스 1부터 시작)
        inOrderTraversal(tree, 1);

        // 리스트에 저장된 후위, 전위, 중위 순회 결과를 문자열로 변환하여 반환
        StringBuilder sb = new StringBuilder();
        for (char c : postOrderList) {
            sb.append(c);
        }
        sb.append('\n');
        for (char c : preOrderList) {
            sb.append(c);
        }
        sb.append('\n');
        for (char c : inOrderList) {
            sb.append(c);
        }

        return sb.toString();
    }

    // 후위 순회 (post-order traversal) 함수
    private void postOrderTraversal(List<Character> tree, int index) {
        if (index >= tree.size() || tree.get(index) == null) return;

        // 왼쪽 자식 노드
        postOrderTraversal(tree, 2 * index);

        // 오른쪽 자식 노드
        postOrderTraversal(tree, 2 * index + 1);

        // 현재 노드
        postOrderList.add(tree.get(index));
    }

    // 전위 순회 (pre-order traversal) 함수
    private void preOrderTraversal(List<Character> tree, int index) {
        if (index >= tree.size() || tree.get(index) == null) return;

        // 현재 노드
        preOrderList.add(tree.get(index));

        // 왼쪽 자식 노드
        preOrderTraversal(tree, 2 * index);

        // 오른쪽 자식 노드
        preOrderTraversal(tree, 2 * index + 1);
    }

    // 중위 순회 (in-order traversal) 함수
    private void inOrderTraversal(List<Character> tree, int index) {
        if (index >= tree.size() || tree.get(index) == null) return;

        // 왼쪽 자식 노드
        inOrderTraversal(tree, 2 * index);

        // 현재 노드
        inOrderList.add(tree.get(index));

        // 오른쪽 자식 노드
        inOrderTraversal(tree, 2 * index + 1);
    }

    public static void main(String[] args) {
        슈어소프트2번문제복원 sol = new 슈어소프트2번문제복원();
        String message = "ABCDEF";
        System.out.println("Traversal results:\n" + sol.solution(message));
    }
}

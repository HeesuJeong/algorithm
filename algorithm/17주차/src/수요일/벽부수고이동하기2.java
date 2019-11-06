package 수요일;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class 벽부수고이동하기2 {
    static class Node {
        int x;
        int y;
        int limit;
        int cnt;
        Node(int x, int y, int limit, int cnt) {
            this.x = x;
            this.y = y;
            this.limit = limit;
            this.cnt = cnt;
        }
    }
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int[][] map = new int[R][C];
        int answer = Integer.MAX_VALUE;
        boolean[][][] visited = new boolean[R][C][2];
        boolean flag = false;
        for (int i = 0; i < map.length; i++) {
            String tmp = sc.next();
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, 1));
        visited[0][0][0] = true;
        visited[0][0][1] = true;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.x == R - 1 && poll.y == C - 1) {
                answer = Math.min(answer, poll.cnt);
                flag = true;
                break;
            }
            //[0]한번도 뚫은 적 없을때
            //[1]한번이라도 뚫은적 있을때
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[nx].length) {
                    // 벽 부순적 없는 경우
                    if (poll.limit == 1) {
                        // 벽을 만나면? 부수면 됨
                        if (map[nx][ny] == 1 ) {
                            visited[nx][ny][1] = true;
                            queue.add(new Node(nx, ny, 0, poll.cnt + 1));
                        }
                        // 빈칸이면? 그냥 고
                        else if (map[nx][ny] == 0 && !visited[nx][ny][0]) {
                            visited[nx][ny][0] = true;
                            //visited[nx][ny][1] = true;
                            queue.add(new Node(nx, ny, 1, poll.cnt + 1));
                        }
                    }
                    // 벽 이미 부순 경우
                    else if (poll.limit == 0) {
                        // 벽을 만나면? 그냥 못 감
                        // 벽이 아니면?
                        if (map[nx][ny] == 0 && !visited[nx][ny][1]) {
                            visited[nx][ny][1] = true;
                            queue.add(new Node(nx, ny, 0, poll.cnt + 1));
                        }
                    }
                }
            }
        }
        if(!flag)answer=-1;
        System.out.println(answer);
    }
}

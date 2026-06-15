import java.util.*;

public class DSA_Patterns_Toolkit {

    // ==============================
    // 1. TWO POINTERS
    // ==============================
    public static boolean twoSumSorted(int[] arr, int target) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
            int sum = arr[l] + arr[r];

            if (sum == target) return true;
            else if (sum < target) l++;
            else r--;
        }
        return false;
    }

    // ==============================
    // 2. SLIDING WINDOW
    // ==============================
    public static int maxSumSubarray(int[] arr, int k) {
        int sum = 0, max = 0;

        for (int i = 0; i < k; i++) sum += arr[i];

        max = sum;

        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            max = Math.max(max, sum);
        }

        return max;
    }

    // ==============================
    // 3. PREFIX SUM
    // ==============================
    public static int rangeSum(int[] prefix, int l, int r) {
        return prefix[r] - (l > 0 ? prefix[l - 1] : 0);
    }

    public static int[] buildPrefix(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        return prefix;
    }

    // ==============================
    // 4. HASHING
    // ==============================
    public static boolean hasDuplicate(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }

    // ==============================
    // 5. BINARY SEARCH
    // ==============================
    public static int binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    // ==============================
    // 6. STACK
    // ==============================
    public static boolean validParentheses(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') st.push(c);
            else {
                if (st.isEmpty()) return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }

    // ==============================
    // 7. RECURSION / BACKTRACKING
    // ==============================
    public static void printSubsets(int[] arr, int i, List<Integer> temp) {
        if (i == arr.length) {
            System.out.println(temp);
            return;
        }

        // take
        temp.add(arr[i]);
        printSubsets(arr, i + 1, temp);

        // not take
        temp.remove(temp.size() - 1);
        printSubsets(arr, i + 1, temp);
    }

    // ==============================
    // 8. LINKED LIST
    // ==============================
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node reverseList(Node head) {
        Node prev = null, curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // ==============================
    // 9. GREEDY
    // ==============================
    public static int activitySelection(int[] start, int[] end) {
        int n = start.length;

        int count = 1;
        int lastEnd = end[0];

        for (int i = 1; i < n; i++) {
            if (start[i] >= lastEnd) {
                count++;
                lastEnd = end[i];
            }
        }
        return count;
    }

    // ==============================
    // 10. DP (FIBONACCI)
    // ==============================
    public static int fib(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // ==============================
    // 11. GRAPH (BFS)
    // ==============================
    public static void bfs(List<List<Integer>> graph, int start) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            for (int nei : graph.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.add(nei);
                }
            }
        }
    }
    
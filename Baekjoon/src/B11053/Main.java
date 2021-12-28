package B11053;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        int[] list = new int[size];
        int[] dp = new int[size];
        String[] tmp = br.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            list[i] = Integer.parseInt(tmp[i]);
        }

        ArrayList<Integer> dp2 = new ArrayList<>();

        dp[0] = 1;
        dp2.add(list[0]);

        for (int i = 1; i < size; i++) {
            dp[i] = 1;
            if (dp2.get(dp2.size() - 1) < list[i]) {
                dp2.add(list[i]);
                dp[i] = dp2.size();
            } else {
                for (int j = 0; j < dp2.size(); j++) {
                    if (dp2.get(j) < list[i]) {
                        dp[i] += 1;
                    } else if (dp2.get(j) > list[i] && dp[i] == j + 1) {
                        dp2.set(j, list[i]);
                    }
                }
            }
        }
        bw.write(dp2.size() + "");
        bw.flush();
        bw.close();
    }
}

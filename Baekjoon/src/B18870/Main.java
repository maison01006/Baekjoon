package B18870;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        int[] list = new int[size];
        HashMap<Integer, Integer> map = new HashMap<>();

        String[] s = br.readLine().split(" ");

        for (int i = 0; i < list.length; i++) {
            list[i] = Integer.parseInt(s[i]);
        }
        int[] tmp = list.clone();
        Arrays.sort(tmp);
        for (int i = 0; i < tmp.length; i++) {
            if (map == null) {
                map.put(tmp[i], 0);
            } else {
                if (map.get(tmp[i]) == null) {
                    map.put(tmp[i], map.size());
                }

            }

        }
        for (int i = 0; i < list.length; i++) {
            bw.write(map.get(list[i]) + " ");
        }
        bw.flush();
        bw.close();

    }
}

package org.example.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prob2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ropes = new int[N];
        for(int i = 0; i < N; i++){
            ropes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ropes);
        int maxWeight = ropes[N - 1];
        for(int i = 2; i <= N; i++){
            maxWeight = Math.max(maxWeight, ropes[N - i] * i);
        }
        System.out.println(maxWeight);
    }
}
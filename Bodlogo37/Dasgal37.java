package Bodlogo37;

import java.util.*;

public class Dasgal37 {

    static List<Integer> getPrimes(int limit) {
        List<Integer> primes = new ArrayList<>();
        int num = 2;
        while (primes.size() < limit) {
            boolean isPrime = true;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                primes.add(num);
            num++;
        }
        return primes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        Stack<Integer> A = new Stack<>();
        for (int i = 0; i < n; i++) {
            A.push(sc.nextInt());
        }

        List<Integer> primes = getPrimes(q);
        List<Stack<Integer>> B = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            Stack<Integer> Ai = new Stack<>();
            Stack<Integer> Bi = new Stack<>();

            while (!A.isEmpty()) {
                int plate = A.pop();
                if (plate % primes.get(i) == 0) {
                    Bi.push(plate);
                } else {
                    Ai.push(plate);
                }
            }

            B.add(Bi);
            A = Ai;
        }

        for (Stack<Integer> stack : B) {
            while (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
        }

        while (!A.isEmpty()) {
            System.out.println(A.pop());
        }
    }
}

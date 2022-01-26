/*

PAT (Basic Level) Practice （中文）

1007 素数对猜想 (20 分)

让我们定义 dₙ 为：dₙ = pₙ₊₁ − pₙ，其中 pᵢ 是第 i 个素数。
显然有 d₁ = 1，且对于 n > 1 有 dₙ 是偶数。
“素数对猜想”认为“存在无穷多对相邻且差为 2 的素数”。

现给定任意正整数 N(< 10⁵)，请计算不超过 N 的满足猜想的素数对的个数。

输入格式:

输入在一行给出正整数N。

输出格式:

在一行中输出不超过 N 的满足猜想的素数对的个数。

输入样例:

20

输出样例:

4

 */
package pintia.pat.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class B1007 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        int count = 0;
        if (n > 4) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(3);
            for (int num = 5; num <= n; num += 2){
                boolean isPrime = true;
                for (int prime : list) {
                    if (prime * prime > num) {
                        break;
                    }
                    if (num % prime == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime){
                    int lastPrime = list.get(list.size() - 1);
                    if (num - lastPrime == 2){
                        count ++;
                    }
                    list.add(num);
                }
            }
        }
        System.out.println(count);
    }

}

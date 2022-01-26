/*

PAT (Basic Level) Practice （中文）

1005 继续(3n+1)猜想 (25 分)

卡拉兹(Callatz)猜想已经在1001中给出了描述。在这个题目里，情况稍微有些复杂。

当我们验证卡拉兹猜想的时候，为了避免重复计算，可以记录下递推过程中遇到的每一个数。
例如对 n=3 进行验证的时候，我们需要计算 3、5、8、4、2、1，则当我们对 n=5、8、4、2 进行验证的时候，
就可以直接判定卡拉兹猜想的真伪，而不需要重复计算，因为这 4 个数已经在验证 3 的时候遇到过了，
我们称 5、8、4、2 是被 3“覆盖”的数。我们称一个数列中的某个数 n 为“关键数”，
如果 n 不能被数列中的其他数字所覆盖。

现在给定一系列待验证的数字，我们只需要验证其中的几个关键数，就可以不必再重复验证余下的数字。
你的任务就是找出这些关键数字，并按从大到小的顺序输出它们。

输入格式：

每个测试输入包含 1 个测试用例，第 1 行给出一个正整数 K (<100)，
第 2 行给出 K 个互不相同的待验证的正整数 n (1<n≤100)的值，数字间用空格隔开。

输出格式：

每个测试用例的输出占一行，按从大到小的顺序输出关键数字。
数字间用 1 个空格隔开，但一行中最后一个数字后没有空格。

输入样例：

6
3 5 6 7 8 11

输出样例：

7 6

解题思路：

数组 num[101]，下标表示待验证数字，对每个待验证数字n执行如下操作：
如num[n]=0，表示 n 不是被之前验证数字覆盖的数字，设 num[n] = 2，暂定为关键数
对 n 执行卡拉兹猜想，中间所有被 n 覆盖的数字x，设 num[x] = 1

所有数字验证完后，如 num[n] = 2，则为关键数字；num[n] = 1，则为被覆盖的数字；num[n] = 0，则为其他无关数字

 */
package pintia.pat.basic;

import java.util.Scanner;

public class B1005 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] num = new int[101];
        int k = scanner.nextInt();
        for (int i=0; i<k; i++){
            int n = scanner.nextInt();
            if (num[n]!=1){
                num[n]=2;
                while (n > 1) {
                    if (n % 2 != 0) {
                        n = n * 3 +1;
                    }
                    n/=2;
                    if (n<=100) {
                        if (num[n] == 1) {
                            break;
                        }
                        num[n] = 1;
                    }
                }
            }
        }
        scanner.close();
        StringBuilder sb = new StringBuilder();
        for (int i=100;i>1;i--){
            if (num[i]==2){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }

}

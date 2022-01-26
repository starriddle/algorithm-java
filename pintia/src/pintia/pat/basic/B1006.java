/*

PAT (Basic Level) Practice （中文）

1006 换个格式输出整数 (15 分)

让我们用字母 B 来表示“百”、字母 S 表示“十”，用 12...n 来表示不为零的个位数字 n（<10），
换个格式来输出任一个不超过 3 位的正整数。例如 234 应该被输出为 BBSSS1234，
因为它有 2 个“百”、3 个“十”、以及个位的 4。

输入格式：

每个测试输入包含 1 个测试用例，给出正整数 n（<1000）。

输出格式：

每个测试用例的输出占一行，用规定的格式输出 n。

输入样例 1：

234

输出样例 1：

BBSSS1234

输入样例 2：

23

输出样例 2：

SS123

 */
package pintia.pat.basic;

import java.util.Scanner;

public class B1006 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        scanner.close();
        StringBuilder sb = new StringBuilder();

        // 2. 预设好字符串拼接
        String strB = "BBBBBBBBB";
        String strS = "SSSSSSSSS";
        String strN = "123456789";
        int numN = input % 10;
        input /= 10;
        int numS = input % 10;
        int numB = input /10;
        sb.append(strB, 0, numB).append(strS, 0, numS).append(strN, 0, numN);

        // 1. 一个个字符拼接
//        int n = input % 10;
//        for (int i=1;i<=n;i++){
//            sb.append(i);
//        }
//        if ((input /=10) > 0){
//            int s = input % 10;
//            for (int i=1;i<=s;i++){
//                sb.insert(0,"S");
//            }
//        }
//        if ((input /=10) > 0){
//            int b = input % 10;
//            for (int i=1;i<=b;i++){
//                sb.insert(0,"B");
//            }
//        }
        System.out.println(sb);
    }

}

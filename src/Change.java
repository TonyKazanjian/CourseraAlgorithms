import java.util.Scanner;

/**
 * Created by tonykazanjian on 4/15/17.
 */
public class Change {

    private static int getChange(int m) {
        int[] coins = new int[] {10, 5, 1};
        int tempCount = 0;
        int coinCount = 0;

        for (int i = 0; i< coins.length; i++) {
            if (coins[i] <= m) {
                tempCount = m/coins[i];
                m -= tempCount*coins[i];
                coinCount += tempCount;
            } else if (m <= coins[i] && m!=0){
                coinCount ++;
                m --;
            }
        }
        return coinCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

import java.text.DecimalFormat;
import java.util.Scanner;

public class FractionalKnapsack {
    private static float getOptimalValue(int capacity, float[] values, float[] weights) {
        float value = 0;
        //write your code here
        int i = 0;
        while (i < values.length) {
            float maxVal = getMaximumValuePerWeight(values,weights);
            if (capacity == 0) {
                return value;
                // Checks to see if this max value is greater than the other values per unit in the array
            } else if (weights[i] > 0 &&  maxVal >= values[i]/weights[i]){
                float a = Math.min(weights[i], capacity);
                if (values[i]/weights[i] == maxVal) {
                    value = value+ a * (values[i]/weights[i]);
                    weights[i] = weights[i] - a;
                    capacity = (int) (capacity - a);
                    for (int j = 0; j < weights.length; j++) {
                        if (weights[j] > 0 && getMaximumValuePerWeight(values, weights) > values[j]/weights[j]) {
                            value = value + a * (values[j] / weights[j]);
                            weights[j] = weights[j] - a;
                            capacity = (int) (capacity - a);
                        }
                    }
                }
                i++;
            }
        }

        return value;
    }

    private static float getMaximumValuePerWeight(float[] values, float[] weights) {
        float maxValue = 0;

        for (int i = 0; i < values.length; i++) {
            if (weights[i] > 0) {
                if (values[i] / weights[i] > maxValue) {
                    maxValue = values[i] / weights[i];
                }
            }
        }
        return maxValue;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        float [] values = new float[n];
        float [] weights = new float[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextFloat();
            weights[i] = scanner.nextFloat();
        }

        System.out.println(roundTwoDecimals(getOptimalValue(capacity, values, weights)));
    }

    public static double roundTwoDecimals(double d)
    {
        DecimalFormat twoDForm = new DecimalFormat("#.####");
        return Double.valueOf(twoDForm.format(d));
    }
} 

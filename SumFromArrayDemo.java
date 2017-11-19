import java.util.Scanner;

public class SumFromArrayDemo {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int testCaseCount = Integer.parseInt(scanner.nextLine());
        while(testCaseCount > 0) {
            SumFromArray sumFromArray = new SumFromArray();
            String[] input = scanner.nextLine().split(" ");
            sumFromArray.setArraySize(Integer.parseInt(input[0]));
            sumFromArray.setSum(Integer.parseInt(input[1]));
            sumFromArray.setArray(scanner.nextLine().split(" "));
            int[] indices = sumFromArray.findSubArray();
            for(int i = 0; i < indices.length; i++)
                System.out.print(indices[i] + " ");
            System.out.println();
            --testCaseCount;
        }
    }
}

class SumFromArray {
    private int arraySize = 0;
    private int sum = 0;
    private int[] array;
    
    public int getArraySize() {
        return arraySize;
    }
    
    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }
    
    public int getSum() {
        return sum;
    }
    
    public void setSum(int sum) {
        this.sum = sum;
    }
    
    public int[] getArray() {
        return array;
    }
    
    public void setArray(String[] array) {
        this.array = new int[arraySize];
        for(int i = 0; i < arraySize; i++) {
            this.array[i] = Integer.parseInt(array[i]);
        }
    }
    
    public int[] findSubArray() {
        int[] indices = {0, 0};
        for(int i = 0; i < arraySize - 1; i++) {
            indices[0] = i + 1;
            int tempSum = array[i];
            for(int j = i; j < arraySize; tempSum += array[++j]) {
                if(tempSum == sum) {
                    indices[1] = j + 1;
                    return indices;
                } else if(tempSum > sum) {
                    indices[0] = 0;
                    break;
                }
            }
        }
        return indices;
    }
}

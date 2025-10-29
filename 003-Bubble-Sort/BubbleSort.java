import java.util.Random;

public class BubbleSort {
    
    public static void main(String[] args) {
        Random rnd = new Random();
        rnd.setSeed(145368);

        final int vectorSize=1000000;
        int[] vector=new int[vectorSize];

        System.out.println("Vettore in input:");
        for (int i=0;i<vectorSize;i++) {
            vector[i]=rnd.nextInt(100);
            System.out.print(" "+vector[i]);
        }
        System.out.println("");


        vector=bubbleSort(vector);

        System.out.println("Vettore in output:");
        for (int i=0;i<vectorSize;i++) {
            System.out.print(" "+vector[i]);
        }
        System.out.println("");
    }

    public static int[] bubbleSort(int[] vector){
        int tmp=0;
        for (int i = 0; i < vector.length-1; i++) {
            for (int j = vector.length-1; j >= i+1; j--) {
                if(vector[j]<vector[j-1]){
                    tmp=vector[j];
                    vector[j]=vector[j-1];
                    vector[j-1]=tmp;
                }
            }
        }

        return vector;
    }

}

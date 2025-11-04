import java.util.Random;

public class InsertionSort {
    
    public static void main(String[] args) {
        Random rnd = new Random();
        rnd.setSeed(145368);

        final int vectorSize=Integer.parseInt(args[0]);
        int[] vector=new int[vectorSize];

        //System.out.println("Vettore in input:");
        for (int i=0;i<vectorSize;i++) {
            vector[i]=rnd.nextInt(1000);
            //System.out.print(" "+vector[i]);
        }
        //System.out.println("");


        vector=insertionSort(vector);

        /*System.out.println("Vettore in output:");
        for (int i=0;i<vectorSize;i++) {
            System.out.print(" "+vector[i]);
        }
        System.out.println("");*/
    }

    public static int[] insertionSort(int[] vector){
        int key;
        int i;
        for(int j=1; j<vector.length; j++){
            key=vector[j];
            i=j-1;
            while(i>=0 && vector[i]>key){
                vector[i+1]=vector[i];
                i--;
            }
            vector[i+1]=key;
        }

        return vector;
    }

}
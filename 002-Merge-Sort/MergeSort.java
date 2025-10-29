import java.util.Random;

public class MergeSort {
    
    public static void main(String[] args) {
        Random rnd = new Random();
        rnd.setSeed(145368);

        final int vectorSize=10000000;
        double[] vector=new double[vectorSize];

        System.out.println("Vettore in input "+vectorSize+" numeri:");
        for (int i=0;i<vectorSize;i++) {
            vector[i]=rnd.nextInt(100);
            System.out.print(" "+vector[i]);
        }
        System.out.println("");


        vector=mergeSort(vector,0,vectorSize-1);

        System.out.println("Vettore in output:");
        for (int i=0;i<vectorSize;i++) {
            System.out.print(" "+vector[i]);
        }
        System.out.println("");
    }

    public static double[] mergeSort(double[] vector, int p, int r){
        if(p<r){
            int q=(p+r)/2;
            vector=mergeSort(vector, p, q);
            vector=mergeSort(vector, q+1, r);
            vector=merge(vector, p, q, r);
        }
        return vector;
    }

    public static double[] merge(double[] vector, int p, int q, int r){
        int n1=q-p+1;
        int n2=r-q;
        double[] vectorL=new double[n1+1];
        double[] vectorR=new double[n2+1];

        for(int i=0;i<n1;i++){
            vectorL[i]=vector[p+i];
        }
        for(int j=0;j<n2;j++){
            vectorR[j]=vector[q+j+1];
        }

        vectorL[n1]=Double.POSITIVE_INFINITY;
        vectorR[n2]=Double.POSITIVE_INFINITY;

        int i=0;
        int j=0;

        for(int k=p; k<=r; k++){
            if(vectorL[i]<=vectorR[j]){
                vector[k]=vectorL[i];
                i++;
            }
            else{
                vector[k]=vectorR[j];
                j++;
            }
        }

        return vector;
    }

}
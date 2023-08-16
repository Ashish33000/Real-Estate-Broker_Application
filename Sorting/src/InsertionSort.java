public class InsertionSort {
    public static void main(String[] args) {
        int [] arr={64,25,12,15,11,22,89,65};
        int n=arr.length;
        insertion(arr,n);
        for(int x:arr) System.out.println(x);
    }
    public static void insertion(int[] arr,int n){
        for(int i=1;i<n;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0&&arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
}

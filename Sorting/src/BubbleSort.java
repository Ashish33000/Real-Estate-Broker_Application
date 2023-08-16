public class BubbleSort {
    public static void main(String[] args) {
        int [] arr={64,25,12,15,11,22,89,65};
        int n=arr.length;
        bubble(arr,n);
        for(int x:arr) System.out.println(x);
    }
    public static void bubble(int[] arr,int n){
        for(int i=1;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1 ]=temp;
                }
            }

        }
    }
}

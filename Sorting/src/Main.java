public class Main {
    public static void main(String[] args) {
        int [] arr={64,25,12,15,11,22,89,65};
        int n=arr.length;
        selection(arr,n);
        for(int x:arr) System.out.println(x);
    }
    public static void selection(int[] arr,int n){
        for(int i=0;i<n-1;i++){
            int min=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
    }
}
import java.util.*;
public class UniqueNumbers {
   public static void main(String[] args) {
    Scanner ak=new Scanner(System.in);
    
    int n=ak.nextInt();
    int arr[]=new int[n];
       HashMap<Integer,Integer> m=new HashMap<>();
       for(int i=0;i<n;i++)
       {
        arr[i]=ak.nextInt();
        if(!m.containsKey(arr[i]))
        {
            m.put(arr[i], 1);
        }
       }
       for(Integer k:m.keySet())
       System.out.print(k+" ");
       ak.close();
   } 
}

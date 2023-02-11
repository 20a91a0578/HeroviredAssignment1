import java.util.*;
public class Q1MissingNumbers {
    public static void main(String[] args) {
        Scanner ak=new Scanner(System.in);
        int m=-1;
        HashMap<Integer,Integer> h=new HashMap<>();
        int n=ak.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
          a[i]=ak.nextInt();
          if(m<a[i])
          m=a[i];
          h.put(a[i],1);
        }
       System.out.println("\nMissing Numbers in Given Array::\n");
       for(int i=1;i<=m;i++)
       if(h.get(i)==null)
       System.out.print(i+" ");
ak.close();

    }
}

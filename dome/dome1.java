/**
 * 插入排序
 */
public class dome1 {


    public static void main(String[] args) {
        int[] a =new int[]{78,59,8,59,75,529,35,59,688,486,384,351};
        int key=0;
        int i=0;
        for (int j=1;j<a.length;j++){
            key=a[j];
            i=j-1;
            while (i>=0 && a[i]>key){
                a[i+1] = a[i];
                i--;
            }
            a[i+1] =key;
        }
        for (int k:a
             ) {
            System.out.println(k);
        }

    }
}

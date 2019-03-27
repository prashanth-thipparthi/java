package Test;

import java.util.HashMap;
import java.util.HashSet;

public class Test {

//    public static void main(String args[]){

//        int a[][] = new int[2][2];
//
//        a[1][1] = 5;
//
//        String s = "hdjsf237@2$%^&(";
//
//        char ar[] = s.toCharArray();
//
//        for(int i=0;i<ar.length;i++){
//            System.out.println((int)ar[i]);
//        }
//        for(int i=0;i<2;i++){
//            for(int j=0;j<2;j++){
//                System.out.println(a[i][j]);
//            }
//
//        }
//    }

    public static int maxSubArraySum(int a[]){

        int global_max = a[0];
        int local_max = 0;

        for(int i=1;i<a.length;i++){
            local_max = Math.max(local_max+a[i],a[i]);

            if(local_max > global_max){
                global_max = local_max;
            }
            if(local_max<0){
                local_max = 0;
            }
        }
        return global_max;
    }

    public static void main (String[] args)
    {
//        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
//        System.out.println("Maximum contiguous sum is " +
//                maxSubArraySum(a));
        Student s1 = new Student(1);
        Student s2 = new Student(2);
        Student s3 = new Student(1);
        HashSet<Student> hs = new HashSet<Student>();

        System.out.println("Hash code of s1:"+s1.hashCode());
        System.out.println("Hash code of s2:"+s2.hashCode());
        System.out.println("Hash code of s3:"+s3.hashCode());

        hs.add(s1);
        hs.add(s2);
        hs.add(s3);
        hs.add(s1);

        System.out.println("size of hash set:"+hs.size());
//        HashMap<Student,Integer> hm = new HashMap<Student,Integer>();
//
//        hm.put(s1,1);
//        hm.put(s2,2);
//        hm.put(s3,3);
//        System.out.println("size of hash set:"+hm.size());

    }
}

class Student{
    int id;

    Student(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

   @Override
    public int hashCode(){
        return id;
   }

//   @Override
//    public boolean equals(Object obj){
//        if(obj==null){
//            return false;
//        }
//        if(!(obj instanceof Student)){
//            return false;
//        }
//        if(obj == this)
//            return true;
//
//        return this.getId() == ((Student) obj).getId();
//   }
}

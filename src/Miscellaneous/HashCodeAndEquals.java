package Miscellaneous;

import java.util.HashMap;
import java.util.HashSet;

public class HashCodeAndEquals {

    /*
    In order to implement your custom comparison, you have to override
    both the "public int hashCode()" and "public void equals(Object obj)"

    "public int hashCode()" - generates hashCode based on the memory location.
    (returns an integer representation of the object memory address.)

    "public void equals(Object obj)" - return objects are equal only if they are stored in the same memory address.

    The Contract Between equals() and hashcode()  - If two objects are equal according to the equals(Object) method, then calling the hashcode() method on each of the two objects must produce the same integer result.
     */
    public static void main (String[] args)
    {
        Student s1 = new Student(1);
        Student s2 = new Student(2);
        Student s3 = new Student(1);
        HashSet<Student> hs = new HashSet<Student>();

        System.out.println("Hash code of s1:"+s1.hashCode());
        System.out.println("Hash code of s2:"+s2.hashCode());
        System.out.println("Hash code of s3:"+s3.hashCode());
//
//        hs.add(s1);
//        hs.add(s2);
//        hs.add(s3);
//        hs.add(s1);
//
//        System.out.println("size of hash set:"+hs.size());
        HashMap<Student,Integer> hm = new HashMap<Student,Integer>();

        hm.put(s1,1);
        hm.put(s2,2);
        hm.put(s3,3);
        System.out.println("size of hash map:"+hm.size());

        for(Student s:hm.keySet()){
            System.out.println("id:"+hm.get(s));
        }
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

   @Override
    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        if(!(obj instanceof Student)){
            return false;
        }
        if(obj == this)
            return true;

        return this.getId() == ((Student) obj).getId();
   }
}
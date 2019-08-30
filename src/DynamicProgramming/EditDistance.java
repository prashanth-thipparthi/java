package DynamicProgramming;

public class EditDistance {
    static int deletionDistance(String str1, String str2) {
        // your code goes here
        int count = 0;

        if(str1.length() == 0 || str2.length() == 0 ){
            if(str1.length() == 0)
                return str2.length();
            else
                return str1.length();
        }

        if(str1.charAt(0) == str2.charAt(0)){
            //str1.remove(0);
            //str2.remove(0);
            return deletionDistance(str1.substring(1),str2.substring(1));
            // handle recursion
        }//else{
        // 1. case
        //str1.remove(0);

        int delCase1 = deletionDistance(str1.substring(1),str2);
        //str2.remove(0);
        int delCase2 = deletionDistance(str1,str2.substring(1));
        return Math.min(delCase1, delCase2) + 1;
        //}

    }

    public static void main(String[] args) {

    }
}

package Strings;

public class CompareVersionStrings {

    public int compareVersion(String version1, String version2) {
    String v1[] = version1.split("[.]");  // In Java you cannot do s1.split("."), As dot is a special character you have
    String v2[] = version2.split("[.]");  // to use split("\\.") or regular expression .split([.])

        int i=0;
        /*
        Awsome code
        public int compareVersion(String version1, String version2) {
            String[] levels1 = version1.split("\\.");
            String[] levels2 = version2.split("\\.");

            int length = Math.max(levels1.length, levels2.length);
            for (int i=0; i<length; i++) {
                Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
                Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
                int compare = v1.compareTo(v2);
                if (compare != 0) {
                    return compare;
                }
            }

            return 0;
        }

       */

        /*
        different test cases:
        "01" and "1"
        "1.0.0.0.0"  and "1"
         */
        while(i<v1.length && i<v2.length){

            if(Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])){
                i++;
                return 1;
            }else if(Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])){
                i++;
                return -1;
            }else{
                i++;
                continue;
            }
        }

        if(i< v1.length){
            while(i< v1.length){     // 1.0.0.0 and 1
                if(Integer.parseInt(v1[i]) != 0)    {
                    return 1;
                }
                i++;
            }
            return 0;
        }else if (i< v2.length){
            while(i< v2.length){
                if(Integer.parseInt(v2[i]) != 0)    {
                    return -1;
                }
                i++;
            }
            return 0;
        } else{
            return 0;
        }
    }

    public static void main(String args[]){
        CompareVersionStrings cvs = new CompareVersionStrings();

        int ret = cvs.compareVersion("01","1");

        System.out.println("ret:"+ret);

    }
}
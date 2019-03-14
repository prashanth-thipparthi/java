package Strings;

public class IntegerToEnglishWords {

//    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
//    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
//    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
//
//    public String numberToWords(int num) {
//        if (num == 0) return "Zero";
//
//        int i = 0;
//        String words = "";
//
//        while (num > 0) {
//            if (num % 1000 != 0)
//                words = helper(num % 1000) +THOUSANDS[i] + " " + words;
//            num /= 1000;
//            i++;
//        }
//
//        return words.trim();
//    }
//
//    private String helper(int num) {
//        if (num == 0)
//            return "";
//        else if (num < 20)
//            return LESS_THAN_20[num] + " ";
//        else if (num < 100)
//            return TENS[num / 10] + " " + helper(num % 10);
//        else
//            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);

    String [] LessThan20 =        {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen"
            ,"Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String [] Tens = {"","Ten","Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String [] Thousands ={"","Thousand","Million","Billion"};

    public String numberToWords(int num) {

        if(num==0){
            return "";
        }
        String words = "";
        int i=0;
        while(num>0){
            if(num%1000!=0){
                words = helper(num%1000) + Thousands[i] +" " +words;
            }
            num = num/1000;
        }
        return words;
    }

    public String helper(int num){

        if(num==0){
            return "";
        }else if(num<20){
            return LessThan20[num]+" ";
        }else if(num<100){
            return Tens[num/10]+" "+helper(num%10)+" ";
        }else{
            return LessThan20[num/100] + " Hundred " + helper(num%100)+" ";
        }
    }

    public static void main(String args[]){
        IntegerToEnglishWords itow = new IntegerToEnglishWords();

        String word = itow.numberToWords(345);

        System.out.println(word);
    }
}

package BasicDataStructures.stack;


public class infixToPostfix {

    public static int addToOutput(char[] output,int outputInd, int ele){
        //int len = output.length;

        switch (ele){
            case 1:
                output[outputInd] = '+';
                break;
            case 2:
                output[outputInd] = '-';
                break;
            case 3:
                output[outputInd] = '*';
                break;
            case 4:
                output[outputInd] = '\\';
                break;
            default:
                output[outputInd] = (char)ele;
                break;
        }
        outputInd++;

        return outputInd;
    }

    public static String infixToPostfixConversion(String input){

        stackDataStructure stack = new stackDataStructure();
        int len = input.length();
        char output[] = new char[len];
        int outputInd = 0;
        int j=0;
        for(int i=0;i<len;i++){
            switch (input.charAt(i)){
                case '+':
                    while(stack.top>=0 && stack.arr[stack.top]>=1) {
                        int ele = stack.pop();
                        /*
                        In Java, apart from primitive data types if you pass any other data types like arrays,Objects
                        they will pass a copy of reference(IMPORTANT: NOT the REFERENCE) is passed to the function. So if
                        you change something in the function with reference, it affects the object in the place from it is                        called but if you CHANGE the reference to any other object it'll not take the effect(AS you just                          passed the copy of reference not the reference)

                        https://stackoverflow.com/questions/9404625/java-pass-by-reference/9404727#9404727

                         */
                        outputInd = addToOutput(output,outputInd,ele);
                    }
                    stack.push(1);
                    break;
                case '-':
                    while(stack.top>=0 && stack.arr[stack.top]>=1) {
                        int ele = stack.pop();
                        outputInd = addToOutput(output,outputInd,ele);
                    }
                    stack.push(2);
                    break;
                case '*':
                    while(stack.top>=0 && stack.arr[stack.top]>=3) {
                        int ele = stack.pop();
                        outputInd = addToOutput(output,outputInd,ele);
                    }
                    stack.push(3);
                    break;
                case '\\':
                    while(stack.top>=0 && stack.arr[stack.top]>=3) {
                        int ele = stack.pop();
                        outputInd  = addToOutput(output,outputInd,ele);
                    }
                    stack.push(4);
                    break;
                case '(':
                    stack.push(0);
                    break;
                case ')':
                    while(stack.arr[stack.top] != 0){
                        int ele = stack.pop();
                        outputInd = addToOutput(output,outputInd,ele);
                    }
                    stack.pop();
                    break;
                default:
                    outputInd = addToOutput(output,outputInd,input.charAt(i));
                    break;
            }
        }

        while(stack.top>=0){
            int ele = stack.pop();
            outputInd = addToOutput(output,outputInd,ele);

        }
        String op = new String(output);
        return op;
    }
    public static void main(String args[]){
        String input = "a+b*c-d";
        String output = infixToPostfixConversion(input);
        System.out.println(output);
    }

}

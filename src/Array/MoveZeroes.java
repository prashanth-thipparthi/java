package Array;

public class MoveZeroes {
      
	static int[] moveZerosToEnd(int[] arr) {
		// your code goes here
    
    int curPos = 0;
    int origPos = 0;
    int len = arr.length;
    for(int i=0; i<len; i++) {
      if(arr[origPos] == 0){
        origPos++;
      }else{
        arr[curPos++] = arr[origPos++];
      }
    }  
    
    for(int i=curPos; i<len;i++){
      arr[i] = 0;
    }
    
    return arr;
      
	}

	public static void main(String[] args) {
    int [] arr = new int[]{0,0,0,0,0};
    arr = moveZerosToEnd(arr);
    for(int a:arr){
      System.out.print(a+" ");
    }
	}
}
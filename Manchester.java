import java.util.*;


public class Manchester {

  public static int[] getOddPalindromes(String s){
      int[] longestOdd = new int[s.length()];
      int R = 0;
      int farthestIndex = -1;
      for(int i=0; i < s.length(); ++i){
          if(R <= i){
              //we just need to expand around i
              int length = 1;
              while(i + length < s.length() && i - length >= 0 && s.charAt(i+length) == s.charAt(i-length)){
                  length++;
              }
              R = i + length-1;
              longestOdd[i] = 2*length-1;
              farthestIndex = i;
          }else{
              //note: farthestIndex can't be -1 in this case
              int j = farthestIndex - (R - farthestIndex) + R - i;
              if(longestOdd[j]/2 >= R - i){
                  int length = R-i+1;
                  while(i + length < s.length() && i - length >= 0 && s.charAt(i+length) == s.charAt(i-length)){
                      length++;
                  }
                  R = Math.max(R, i + length-1);
                  if(R == i + length-1){
                      farthestIndex = i;
                  }
                  longestOdd[i] = 2*length-1;
              }else{
                  int length = longestOdd[j]/2 + 1;
                  while(i + length < s.length() && i - length >= 0 && s.charAt(i+length) == s.charAt(i-length)){
                      length++;
                  }
                  R = Math.max(R, i + length-1);
                  if(R == i + length-1){
                      farthestIndex = i;
                  }
                  longestOdd[i] = 2*length-1;
              }

          }
      }
      return longestOdd;
  }
  
  public static int[] getEvenPalindromes(String s){
      int[] longestEven = new int[s.length()-1];

      int R = 0;
      int farthestIndex = -1;
      for(int i=0; (i + 1) < s.length(); ++i){
          if(s.charAt(i) != s.charAt(i+1)){
              continue;
          }
          if(R <= i){
              //we just need to expand around i
              int length = 1;
              while(i + length +1 < s.length() && i - length >= 0 && s.charAt(i+length+1) == s.charAt(i-length)){
                  length++;
              }
              R = i + length;
              longestEven[i] = 2*length;
              farthestIndex = i;
          }else{
              //note: farthestIndex can't be -1 in this case

              int j = farthestIndex - (R - farthestIndex) + 1 + R - i -1;

              if(longestEven[j]/2 >= R - i){
                  int length = R-i;
                  while(i + length +1 < s.length() && i - length >= 0 && s.charAt(i+length+1) == s.charAt(i-length)){
                      length++;
                  }
                  R = Math.max(R, i + length);
                  if(R == i + length){
                      farthestIndex = i;
                  }
                  longestEven[i] = 2*length;
              }else{
                  int length = longestEven[j]/2;
                  while(i + length+1 < s.length() && i - length >= 0 && s.charAt(i+length+1) == s.charAt(i-length)){
                      length++;
                  }
                  R = Math.max(R, i + length);
                  if(R == i + length){
                      farthestIndex = i;
                  }
                  longestEven[i] = 2*length;
              }

          }
      }
      return longestEven;
  }

}

import java.util.Stack;

public class BalancedParenthesis {
	public static boolean checkBalanced(String exp) {
	    Stack<Character> s= new Stack<Character>();
        for(int i =0;i<exp.length();i++){
            if(exp.charAt(i) == '(' || exp.charAt(i) == '{' || exp.charAt(i) == '['){
                s.push(exp.charAt(i));
            }
         else if(exp.charAt(i) == ')' || exp.charAt(i) == '}' || exp.charAt(i) == ']'){
             if(!s.isEmpty()){
                 return false;
             }
         char ch = s.pop();
         if(exp.charAt(i) == ')' && ch == '('){
            continue; 
         }    
       else if(exp.charAt(i) == '}' && ch == '{'){
           continue;
       }
        else if(exp.charAt(i) == ']' && ch == '['){
            continue;
        }
        else{
            return false;
        }
         }
         if(s.isEmpty())
        	 return true;
         }
        	return false;
	}
	}

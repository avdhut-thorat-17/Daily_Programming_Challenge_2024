import java.util.Stack;

class ValidParenthesis {

    public boolean validParenthesis(String s) {
        if (s.isEmpty()) {
            return true;
        }

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stk.push(s.charAt(i));
            } else {
                if ((s.charAt(i) == '}' && stk.peek() == '{') ||
                    (s.charAt(i) == ']' && stk.peek() == '[') ||
                    (s.charAt(i) == ')' && stk.peek() == '(')) {
                    stk.pop();
                } else {
                    return false;
                }
            }
        }

        return stk.isEmpty();
    }

    public static void main(String[] args) {
        String[] s = {"()", "{[]}", "(]", "()[]{}"};
        ValidParenthesis obj = new ValidParenthesis();
        for (String str : s) {
            if (obj.validParenthesis(str)) {
                System.out.println("Valid Parenthesis: " + str);
            } else {
                System.out.println("Not a valid parenthesis: " + str);
            }
        }
    }
}
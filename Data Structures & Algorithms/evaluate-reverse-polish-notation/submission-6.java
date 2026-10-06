class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            try {
                stack.push(Integer.parseInt(token));
            } catch (NumberFormatException e) {
                int right = stack.pop();
                int left = stack.pop();
                int result = switch (token) {
                    case "+" -> left + right;
                    case "-" -> left - right;
                    case "*" -> left* right;
                    case "/" -> left / right;
                    default -> throw new IllegalArgumentException("Unexpected token: " + token);
                };
                stack.push(result);
            }
        }
        return stack.pop();
    }
}

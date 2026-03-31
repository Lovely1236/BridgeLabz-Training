class ValidParanthesis {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        char[] stack = new char[s.length()];
        int head = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack[head++] = ')';
                    break;
                case '[':
                    stack[head++] = ']';
                    break;
                case '{':
                    stack[head++] = '}';
                    break;
                default:
                    if (head == 0 || stack[--head] != c)
                        return false;
            }
        }
        return head == 0;
    }

    public static void main(String[] args) {
        ValidParanthesis obj = new ValidParanthesis();

        String s = "()[]{}";
        System.out.println(obj.isValid(s));  // true

        String s2 = "(]";
        System.out.println(obj.isValid(s2)); // false
    }
}

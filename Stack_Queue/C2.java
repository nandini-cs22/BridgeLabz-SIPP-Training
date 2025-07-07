import java.util.Stack;

class SortStack {
    public void sort(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sort(stack);
            insert(stack, top);
        }
    }

    private void insert(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
        } else {
            int top = stack.pop();
            insert(stack, element);
            stack.push(top);
        }
    }
}


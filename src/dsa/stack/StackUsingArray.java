package dsa.stack;

class StackUsingArray {
    int stack[];
    int top;

    StackUsingArray(int size){
        stack = new int[size];
        top = -1;
    }

    public boolean push(int item){
        if(stack.length -1 == top){
            System.out.println("Stack is full");
            return false;
        }else{
            stack[++top] = item;
            return true;
        }
    }

    public boolean pop(){
        if(top == -1){
            System.out.println("Stack is empty");
            return false;
        }else{
            top--;
            return true;
        }
    }

    public int peek(){
        if(stack.length == top){
            System.out.println("Stack overflow exception");
            return -1;
        }else if( top == -1 ){
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }

    public int size(){
        if(stack.length == top){
            System.out.println("Stack overflow exception");
        }else if( top == -1 ){
            System.out.println("Stack is empty");
        }
        return top;
    }

    public static void main(String[] args) {
        StackUsingArray stack  = new StackUsingArray(5);
        stack.push(11);
        stack.push(12);
        stack.push(13);
        stack.push(14);
        stack.push(15);
        stack.push(16);
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.peek();
        stack.size();
    }
}

package main.java.stacks;



public class AStack<E> implements Stack<E> {

    private static final int defaultSize = 10;

    private int maxSize; // Maximum size of stack
    private int top; // Index for top Object
    private E [] listArray; //here we are holding the elements

    //Constructors
    AStack(){this(defaultSize);}
    AStack(int size) {
        maxSize = size;
        top = 0;
        listArray = (E[]) new Object[size];
    }

    @Override
    public void clear() {
        top = 0;
    }

    @Override
    public void push(E it) {
        assert top != 0 : "Stack is empty!";
        listArray[top++] = it;
    }

    @Override
    public E pop() {
        assert top != 0 : "Stack is empty!";
        return listArray[--top];
    }

    @Override
    public E topValue() {
        assert top != 0 : "Stack is empty!";
        return listArray[top-1];
    }

    @Override
    public int length() {
        return top;
    }
}

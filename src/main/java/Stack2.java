
import java.util.Stack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author glorymutombo
 */
public class Stack2 {
    public static void main(String[] args) {
       
         Stack<Integer> numbers = new Stack<>();
        Stack<Integer> temp = new Stack<>();

        int[] data = new int[]{55, 46, 90, 39, 20, 13, 56, 100, 20, 77};
        initialize(data, numbers);
        display(numbers);
        delete(numbers, temp, 39);
        decrement(numbers, temp, 100, 10);
        swap(numbers, temp, 46, 13);
        display(numbers);

    }

    private static void initialize(int[] data, Stack<Integer> numbers) {
        for (int i = 0; i < data.length; i++) {
            int value = data[i];
            numbers.push(value);
            System.out.println("Value " + value + " added into stack numbers");
        }
    }

    private static void display(Stack<Integer> numbers) {
        if (numbers.isEmpty()) {
            return;
        }
        //Pop the element and remove
        Integer item = numbers.pop();
        System.out.println(item);

        display(numbers);
        numbers.push(item);
    }

    private static void delete(Stack<Integer> numbers, Stack<Integer> temp, int i) {

        while (!numbers.isEmpty()) {
            int value = numbers.pop();
            if (value != i) {
                temp.push(value);
                System.out.println("Moved value " + value + " to temp stack");
            } else {
                System.out.println("Value " + value + " deleted");
            }

        }

        while (!temp.isEmpty()) {
            int value = temp.pop();
            System.out.println("Value " + value + " has been restored in numbers stack");
            numbers.push(value);

        }

    }

    private static void decrement(Stack<Integer> numbers, Stack<Integer> temp, int i, int x) {
        while (!numbers.isEmpty()) {
            int value = numbers.pop();
            if (value == i) {
                value = value - x;
                temp.push(value);
            }
            temp.push(value);
        }

        while (!temp.isEmpty()) {

            numbers.push(temp.pop());
        }
    }

    private static void swap(Stack<Integer> numbers, Stack<Integer> temp, int x, int y) {
        while (!numbers.isEmpty()) {
            temp.push(numbers.pop());

        }
        while (!temp.isEmpty()) {
            int value = temp.pop();
            if (value == x) {
                numbers.push(y);
            } else if (value == y) {
                numbers.push(x);
            } else {
                numbers.push(value);
            }
        }
    }
    
}

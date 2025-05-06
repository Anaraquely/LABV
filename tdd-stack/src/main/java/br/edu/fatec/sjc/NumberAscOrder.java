package br.edu.fatec.sjc;

import java.util.Collections;
import java.util.List;

public class NumberAscOrder<T extends Number & Comparable<T>> {
    private final CustomStack<T> customStack;

    public NumberAscOrder(CustomStack<T> customStack) {
        if (customStack == null) {
            throw new IllegalArgumentException("CustomStack não pode ser nula");
        }
        this.customStack = customStack;
    }

    public List<T> sort() throws StackEmptyException, StackFullException {
        if (customStack.isEmpty()) {
            throw new StackEmptyException();
        }
        List<T> sortedList = new java.util.ArrayList<>();

        CustomStack<T> tempStack = new CustomStack<>(customStack.size(), customStack.getCalculableStrategy());
        List<T> tempList = new java.util.ArrayList<>();

        while (!customStack.isEmpty()) {
            T element = customStack.pop();
            tempList.add(element);
            tempStack.push(element);
        }

        while (!tempStack.isEmpty()) {
            customStack.push(tempStack.pop());
        }
        sortedList.addAll(tempList);
        Collections.sort(sortedList);

        return sortedList;
    }
}
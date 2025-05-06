package br.edu.fatec.sjc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class NumberAscOrderTest {

    @Mock
    private CustomStack<Integer> mockStack;

    @Test
    void testSortWithFullStack() throws StackFullException, StackEmptyException {

        when(mockStack.isEmpty()).thenReturn(false);
        when(mockStack.size()).thenReturn(6);

        when(mockStack.pop())
                .thenReturn(42)
                .thenReturn(11)
                .thenReturn(23)
                .thenReturn(5)
                .thenReturn(37)
                .thenReturn(8);

        NumberAscOrder<Integer> numberAscOrder = new NumberAscOrder<>(mockStack);
        List<Integer> sorted = numberAscOrder.sort();

        List<Integer> expected = Arrays.asList(5, 8, 11, 23, 37, 42);
        assertEquals(expected, sorted);

        verify(mockStack, times(6)).pop();
        verify(mockStack, times(6)).push(anyInt());
        verify(mockStack, atLeastOnce()).isEmpty();
    }

    @Test
    void testSortWithEmptyStack() {
        when(mockStack.isEmpty()).thenReturn(true);

        NumberAscOrder<Integer> numberAscOrder = new NumberAscOrder<>(mockStack);

        assertThrows(StackEmptyException.class, () -> numberAscOrder.sort());

        verify(mockStack).isEmpty();
    }

    @Test
    void testConstructorWithNullStack() {

        assertThrows(IllegalArgumentException.class, () -> new NumberAscOrder<>(null));
    }

    @Test
    void testSortMaintainsOriginalStackOrder() throws StackFullException, StackEmptyException {
        CustomStack<Integer> spyStack = spy(new CustomStack<>(6, new IntegerStrategy()));
        spyStack.push(23);
        spyStack.push(5);
        spyStack.push(42);
        spyStack.push(11);
        spyStack.push(37);
        spyStack.push(8);

        NumberAscOrder<Integer> numberAscOrder = new NumberAscOrder<>(spyStack);
        List<Integer> sorted = numberAscOrder.sort();

        List<Integer> expected = Arrays.asList(5, 8, 11, 23, 37, 42);
        assertEquals(expected, sorted);

        assertEquals(6, spyStack.size());
        assertEquals(8, spyStack.pop());
        assertEquals(37, spyStack.pop());
        assertEquals(11, spyStack.pop());
        assertEquals(42, spyStack.pop());
        assertEquals(5, spyStack.pop());
        assertEquals(23, spyStack.pop());
    }
}

class IntegerStrategy implements CalculableStrategy<Integer> {
    @Override
    public Integer calculateValue(Integer element) {
        return element;
    }
}
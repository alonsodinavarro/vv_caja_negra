package com.practica.cajanegra.Removals;

import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RemoveLastElemTest {

    private SingleLinkedListImpl<String> validlist;
    private SingleLinkedListImpl<String> invalidlist;


    @BeforeEach
    void init(){
        this.validlist = new SingleLinkedListImpl<>("A", "B", "N", "Y", "Z");
        this.invalidlist = new SingleLinkedListImpl<>("O","[","P","@");

    }

    @ParameterizedTest(name = "Eliminación de la ultima aparición del elemento dado")
    @CsvSource(value =
            {
                    " A ;[B, N, Y, Z]",
                    " B ;[A, M, Y, Z]",
                    " N ;[A, B, Y, Z]",
                    "Y ;[A, B, M, Z]]",
                    "Z ;[A, B, M, Y]"
            },delimiter = ';')
    public void removeLastVal(String elem, String expected)throws NoSuchElementException, EmptyCollectionException
    {
        validlist.removeLast(elem);
        assertEquals(expected,validlist.toString());
    }

    @ParameterizedTest(name = "Eliminación de elementos no validos dentro de la lista")
    @ValueSource( strings ={"[","@","Z"})
    public void testRemoveLastInvalid(String elem)throws EmptyCollectionException {
        assertThrows(IllegalArgumentException.class, () -> {
            invalidlist.removeLast(elem);
        });
    }

}

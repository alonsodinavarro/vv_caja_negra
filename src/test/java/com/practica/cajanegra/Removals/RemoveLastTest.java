package com.practica.cajanegra.Removals;

import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveLastTest {
    private SingleLinkedListImpl<String> validlist;
    private SingleLinkedListImpl<String> invalidlist;
    private SingleLinkedListImpl<String> emptylist;

    @BeforeEach
    void init(){
        this.validlist = new SingleLinkedListImpl<>("A", "B", "N", "Y", "Z");
        this.emptylist = new SingleLinkedListImpl<>();
    }

    @ParameterizedTest(name = "Elimina el ultimo elemento de la lista")
    @ValueSource( strings ={"A","B","N","Y","Z"})
    public void testRemoveLastValid() throws EmptyCollectionException {

        validlist.removeLast();
        assertEquals("[A, B, N, Y]",validlist.toString());
    }

    @ParameterizedTest(name = "Elimina el ultimo elemento de la lista")
    @ValueSource( strings ={"A","B","N","Y","Z"})
    public void testRemoveLastInvalid() throws EmptyCollectionException {
        emptylist.removeLast();
        assertEquals("[]",emptylist.toString());
    }
}

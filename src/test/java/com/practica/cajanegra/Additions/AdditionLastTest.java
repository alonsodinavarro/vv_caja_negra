package com.practica.cajanegra.Additions;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdditionLastTest {
    private SingleLinkedListImpl<String> list;

    @BeforeEach
    void init(){
        this.list = new SingleLinkedListImpl<>("O","P","P","O");
    }

    @ParameterizedTest(name = "Elementos añadidos al final invalidos")
    @CsvSource(value =
            {
                 " A ;[O, P, P, O, A]",
                 " B ;[O, P, P, O, B]",
                 " N ;[O, P, P, O, N]",
                  "Y ;[O, P, P, O, Y]",
                  "Z ;[O, P, P, O, Z]"
            },delimiter = ';')
    public void addLastVal(String elem, String expected)
    {
        list.addLast(elem);
        assertEquals(expected,list.toString());
    }

    @ParameterizedTest(name = "Elementos invalidos en la lista")
    @CsvSource(value =
            {

                    "@ ;[O, P, P, O, @]",
                    "[ ;[O, P, P, O, []"
            },delimiter = ';')
    public void addLastInVal(String elem){
        assertThrows(IllegalArgumentException.class, () -> {
            list.addLast(elem);
        });
    }
}

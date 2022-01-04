package com.practica.cajanegra.Additions;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdditionNTimesTest {

    private SingleLinkedListImpl<String> list;

    @BeforeEach
    void init(){
        this.list = new SingleLinkedListImpl<>("O","P","P","O");
    }

    @ParameterizedTest(name = "Añade n veces al final de la lista el elemento dado")
    @CsvSource(value =
            {
                    "1; A; [O, P, P, O, A]",
                    "1; B; [O, P, P, O, B]",
                    "1; N; [O, P, P, O, N]",
                    "1; Y; [O, P, P, O, Y]",
                    "1; Z; [O, P, P, O, Z]",

                    "2; A; [O, P, P, O, A, A]",
                    "2; B; [O, P, P, O, B, B]",
                    "2; N; [O, P, P, O, N, N]",
                    "2; Y; [O, P, P, O, Y, Y]",
                    "2; Z; [O, P, P, O, Z, Z]",

                    "3; A; [O, P, P, O, A, A, A]",
                    "3; B; [O, P, P, O, B, B, B]",
                    "3; N; [O, P, P, O, N, N, N]",
                    "3; Y; [O, P, P, O, Y, Y, Y]",
                    "3; Z; [O, P, P, O, Z, Z, Z]",

                    "4; A; [O, P, P, O, A, A, A, A]",
                    "4; B; [O, P, P, O, B, B, B, B]",
                    "4; N; [O, P, P, O, N, N, N, N]",
                    "4; Y; [O, P, P, O, Y, Y, Y, Y]",
                    "4; Z; [O, P, P, O, Z, Z, Z, Z]"
    },delimiter = ';')
    public void AddNTimesValid(int n,String elem, String expected){
        list.addNTimes(elem, n);
        assertEquals(expected,list.toString());
    }

    @ParameterizedTest(name = "Añade n veces al final de la lista el elemento dado")
    @CsvSource(value =
            {
                    "1; @; [O, P, P, O, @]",
                    "1; [; [O, P, P, O, []",

                    "2; @; [O, P, P, O, @, @]",
                    "2; [; [O, P, P, O, [, []",

                    "3; @; [O, P, P, O, @, @, @]",
                    "3; [; [O, P, P, O, [, [, []",

                    "4; A; [O, P, P, @, @, @, @, @]",
                    "4; [; [O, P, P, [, [, [, [, []"
            },delimiter = ';')
    public void AddNTimesInValidElem(int n,String elem, String expected){
        assertThrows(IllegalArgumentException.class, () -> {
            list.addNTimes(elem, n);
        });
    }

    @ParameterizedTest(name = "Adición de elementos cantidad de veces invalidas")
    @CsvSource(value = {
            "-1: A",
            "-1: B",
            "-1: N",
            "-1: Y",
            "-1: Z"
    }, delimiter = ':')
    public void testAddNTimesInvalidN(int n,String elem) {

        assertThrows(IllegalArgumentException.class, () -> {
            list.addNTimes(elem, n);
        });
    }
}

package com.practica.cajanegra.Modifications;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToStringTest {
    private SingleLinkedListImpl<String> validlist;
    private SingleLinkedListImpl<String>emptylist;

    void init(){
        this.validlist = new SingleLinkedListImpl<>("A", "B", "C", "D", "E",
                "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
                "Y", "Z");

        this.emptylist = new SingleLinkedListImpl<>("");

    }

    @DisplayName("Lista inversa")
    @Test
    public void toStringTest(){
        assertAll("Abecedario y lista vacia, un elemento",
                ()-> assertEquals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, W, X, Y,Z]",new SingleLinkedListImpl<String>("A", "B", "C", "D", "E",
                        "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
                        "Y", "Z").toString()),
                ()-> assertEquals("",new SingleLinkedListImpl<String>("").toString()),
                ()-> assertEquals("[A, B, C, D]",new SingleLinkedListImpl<String>("A","B","C","D").reverse().toString()),
                ()-> assertEquals("[@, []",new SingleLinkedListImpl<String>("@","[").toString())
        );
    }
}

package com.practica.cajanegra.Modifications;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseTest {
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
    public void reverseTest(){
        assertAll("Abecedario y lista vacia, un elemento",
                ()-> assertEquals("[Z, Y, X, W, V, U, T, S, R, Q, P, O, Ñ, N, M, L, K, J, I, H, G, F, E, D, C, B, A]",new SingleLinkedListImpl<String>("A", "B", "C", "D", "E",
                        "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
                        "Y", "Z").reverse().toString()),
                ()-> assertEquals("",new SingleLinkedListImpl<String>("").reverse().toString()),
                ()-> assertEquals("U",new SingleLinkedListImpl<String>("U").reverse().toString())
        );
    }
}

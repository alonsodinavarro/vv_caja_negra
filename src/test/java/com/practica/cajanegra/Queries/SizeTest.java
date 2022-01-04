package com.practica.cajanegra.Queries;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SizeTest {

    private SingleLinkedListImpl<String> validlist;
    private SingleLinkedListImpl<String>emptylist;

    void init(){
        this.validlist = new SingleLinkedListImpl<>("A", "B", "C", "D", "E",
                "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
                "Y", "Z");

        this.emptylist = new SingleLinkedListImpl<>("");

    }

    @DisplayName("Tamaño de la lista")
    @Test
    public void sizeTest(){
        assertAll("Abecedario y lista vacia",
                ()-> assertEquals(27,new SingleLinkedListImpl<String>("A", "B", "C", "D", "E",
                        "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
                        "Y", "Z").size()),
                ()-> assertEquals(1,new SingleLinkedListImpl<String>("").size())
        );
    }
}

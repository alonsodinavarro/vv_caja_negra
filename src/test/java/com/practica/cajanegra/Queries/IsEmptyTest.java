package com.practica.cajanegra.Queries;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsEmptyTest {
    private SingleLinkedListImpl<String> validlist;
    private SingleLinkedListImpl<String> invalidlist;
    private SingleLinkedListImpl<String> emptylist;


    @BeforeEach
    void init(){
        this.validlist = new SingleLinkedListImpl<>("A", "B", "C", "D", "E",
                "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
                "Y", "Z");
        this.invalidlist = new SingleLinkedListImpl<>("X");
        this.emptylist = new SingleLinkedListImpl<>();

    }
    @DisplayName("Verificar que es vacía una lista")
    @Test
    public void EsVaciaTest(){
        assertAll("Obtener elemento en el abecedario",
                () -> assertEquals(false, validlist.isEmpty()),
                () -> assertEquals(false, invalidlist.isEmpty()),
                () -> assertEquals(true, emptylist.isEmpty())

        );
    }
}

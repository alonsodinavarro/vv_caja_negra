package com.practica.cajanegra.Additions;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdditionAtFirstTest {

    private SingleLinkedListImpl<String> list;

    @BeforeEach
    void init(){
        this.list = new SingleLinkedListImpl<>("A","B","C");
    }
    @DisplayName("Rango mínimo válido")
    @Test
    void addMinFirst(){
        this.list.addFirst("A");
        assertEquals("[A, A, B, C]",this.list.toString());
    }
    @DisplayName("Rango mínimo siguiente válido")
    @Test
    void addMinSigFirst(){
        this.list.addFirst("B");
        assertEquals("[B, A, B, C]",this.list.toString());
    }
    @DisplayName("Rango nominal válido")
    @Test
    void addNomFirst(){
        this.list.addFirst("N");
        assertEquals("[N, A, B, C]",this.list.toString());
    }
    @DisplayName("Rango máximo anterior válido")
    @Test
    void addMaxAntFirst(){
        this.list.addFirst("Y");
        assertEquals("[Y, A, B, C]",this.list.toString());
    }
    @DisplayName("Rango máximo válido")
    @Test
    void addMaxFirst(){
        this.list.addFirst("Z");
        assertEquals("[Z, A, B, C]",this.list.toString());
    }



}

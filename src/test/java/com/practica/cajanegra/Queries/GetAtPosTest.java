package com.practica.cajanegra.Queries;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GetAtPosTest {
    private SingleLinkedListImpl<String> validlist;
    private SingleLinkedListImpl<String> invalidlist;


    @BeforeEach
    void init(){
        this.validlist = new SingleLinkedListImpl<>("A", "B", "N", "Y", "Z");
        this.invalidlist = new SingleLinkedListImpl<>("@", "B", "N", "Y", "Z");
    }

    @ParameterizedTest(name = "Obtener el elemento en la posicion indicada")
    @CsvSource(value ={
            "1, A",
            "2, B",
            "3, N",
            "4, Y",
            "5, Z",
    },delimiter =',')
    public void getAtPosValid(int pos,String expected){
        validlist.getAtPos(pos);
        assertEquals(expected,validlist.getAtPos(pos));
    }

    @ParameterizedTest(name = "Elementos invalidos en la lista y posiciones inexistentes")
    @CsvSource(value ={
            "1",
            "-1",
            "8",

    },delimiter =',')
    public void getAtPosInValid(int pos){
        assertThrows(IllegalArgumentException.class, () -> {
            invalidlist.getAtPos(pos);
        });
    }
}

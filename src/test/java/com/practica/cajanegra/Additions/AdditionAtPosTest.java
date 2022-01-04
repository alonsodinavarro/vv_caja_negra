package com.practica.cajanegra.Additions;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdditionAtPosTest {

    private SingleLinkedListImpl<String> list;

    @BeforeEach
    void init(){
        this.list = new SingleLinkedListImpl<>("O","P","P","O");
    }

   @ParameterizedTest (name = "Inserta en la posición específica ")
   @CsvSource (value =
           {

                   "1; A; [A, O, P, P, O]",
                   "1; B; [B, O, P, P, O]",
                   "1; N; [N, O, P, P, O]",
                   "1; Y; [Y, O, P, P, O]",
                   "1; Z; [Z, O, P, P, O]",

                   "2; A; [O, A, P, P, O]",
                   "2; B; [O, B, P, P, O]",
                   "2; N; [O, N, P, P, O]",
                   "2; Y; [O, Y, P, P, O]",
                   "2; Z; [O, Z, P, P, O]",

                   "3; A; [O, P, A, P, O]",
                   "3; B; [O, P, B, P, O]",
                   "3; N; [O, P, N, P, O]",
                   "3; Y; [O, P, Y, P, O]",
                   "3; Z; [O, P, Z, P, O]",

                   "5; A; [O, P, P, O, A]",
                   "5; B; [O, P, P, O, B]",
                   "5; N; [O, P, P, O, N]",
                   "5; Y; [O, P, P, O, Y]",
                   "5; Z; [O, P, P, O, Z]",

                   "6; A; [O, P, P, O, A]",
                   "6; B; [O, P, P, O, B]",
                   "6; N; [O, P, P, O, N]",
                   "6; Y; [O, P, P, O, Y]",
                   "6; Z; [O, P, P, O, Z]"
           },delimiter = ';')
   public void AddAtPosVal(int pos, String elem, String expected){
       list.addAtPos(elem,pos);
       assertEquals(expected,list.toString());
   }


    @ParameterizedTest(name = "Inserción de un elemento invalido en una posicion valida")
    @CsvSource(value = {
            "1: @",
            "1: [",
            "2: @",
            "2: [",
            "3: @",
            "3: [",
            "5: @",
            "5: [",
            "6: @",
            "6: ["
    }, delimiter = ':')
    public void AddAtPosInElem(int pos,String elem) {

        assertThrows(IllegalArgumentException.class, () -> {
            list.addAtPos(elem, pos);
        });
    }
    @ParameterizedTest(name = "Inserción de un elemento valido en una posicion invalida")
    @CsvSource(value = {
            "0: A",
            "0: B",
            "0: N",
            "0: Y",
            "0: Z",
            "-1: A",
            "-1: B",
            "-1: N",
            "-1: Y",
            "-1: Z",
            "-1: Z"
    }, delimiter = ':')
    public void AddAtInPos(int pos,String elem) {

        assertThrows(IllegalArgumentException.class, () -> {
            list.addAtPos(elem, pos);
        });
    }
}

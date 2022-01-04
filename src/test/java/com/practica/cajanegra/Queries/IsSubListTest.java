package com.practica.cajanegra.Queries;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class IsSubListTest {
    private SingleLinkedListImpl<String> validlist;
    private SingleLinkedListImpl<String> invalidlist;
    private SingleLinkedListImpl<String> emptylist;
    private SingleLinkedListImpl<String> shorlist;
    private SingleLinkedListImpl<String> part;

    @BeforeEach
    void init(){
        this.validlist = new SingleLinkedListImpl<>("A", "B", "C", "D", "E",
                "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
                "Y", "Z");
        this.invalidlist = new SingleLinkedListImpl<>("A","F","@","B","G","[");
        this.emptylist = new SingleLinkedListImpl<>();
        this.shorlist = new SingleLinkedListImpl<>("A","F");
        this.part = new SingleLinkedListImpl<String>("A","B","C");
    }

    @DisplayName("Clase valida sublista en el abecedario")
    @Test
    public void isSubListValid(){

        validlist.isSubList(part);
        assertEquals(1,validlist.isSubList(part));
    }
    @DisplayName("Clase invalida con elementos invalidos, lista vacías, sublista mayor que la lista")
    @Test
    public void isSublistInvalid(){
        assertAll("Clases invalidas",
                () -> assertThrows(NoSuchElementException.class, ()->
                         assertEquals(1,emptylist.isSubList(part),"Lista vacía")),
                () -> assertThrows(NoSuchElementException.class, () ->
                                assertEquals(1, invalidlist.isSubList(part)),"Lista invalida"),
                () -> assertThrows(NoSuchElementException.class, () ->
                        assertEquals(-1, validlist.isSubList(new SingleLinkedListImpl<>(""))),"Elemento vacio"),
                () -> assertThrows(NoSuchElementException.class, () ->
                                assertEquals(-1, invalidlist.isSubList(new SingleLinkedListImpl<>("[","@","@"))),"Sublista invalida"),
                () -> assertThrows(NoSuchElementException.class, () ->
                        assertEquals(-1, shorlist.isSubList(part)),"Sublista mayor que lista")

        );
    }
}

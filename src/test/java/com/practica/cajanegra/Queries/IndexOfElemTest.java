package com.practica.cajanegra.Queries;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.NoSuchElementException;

import static javafx.scene.input.KeyCode.X;
import static javafx.scene.input.KeyCode.Y;
import static org.junit.jupiter.api.Assertions.*;

public class IndexOfElemTest {

    private SingleLinkedListImpl<String> validlist;
    private SingleLinkedListImpl<String> invalidlist;
    private SingleLinkedListImpl<String> emptylist;


    @BeforeEach
    void init(){
        this.validlist = new SingleLinkedListImpl<>("A", "B", "C", "D", "E",
                "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
                "Y", "Z");
        this.invalidlist = new SingleLinkedListImpl<>("A","[","N","Y","X");
        this.emptylist = new SingleLinkedListImpl<>();

    }

    @DisplayName("Obtener posición dado el elemento")
    @Test
    public void IndexOfValid(){
        assertAll("Obtener elemento en el abecedario",
                () -> assertEquals(1, validlist.indexOf("A")),
                () -> assertEquals(2, validlist.indexOf("B")),
                () -> assertEquals(14, validlist.indexOf("N")),
                () -> assertEquals(validlist.size() - 1, validlist.indexOf("Y")),
                () -> assertEquals(validlist.size(), validlist.indexOf("Z"))
        );
    }
    @DisplayName ("Clases invalidas lista vacía, y lista con elementos invalidos y no contiene elemento dado")
    @Test
    public void IndexOfInvalid(){
        assertAll("Obtener elemento en el abecedario",
                () -> assertThrows(NoSuchElementException.class, () ->
                        emptylist.indexOf("A") , "No existen elementos"),
                () -> assertThrows(NoSuchElementException.class, () ->
                        invalidlist.indexOf("M"),"No existe el elemento"),
                () -> assertThrows(NoSuchElementException.class, () ->
                        validlist.indexOf("["),"Busqueda de elemento invalido"),
                () -> assertThrows(NoSuchElementException.class, () ->
                        invalidlist.indexOf("["),"Entrada de elemento invalido")

        );
    }
}

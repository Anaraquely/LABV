package org.example.tdd.exercicio1;

import org.junit.Test;
import static org.junit.Assert.*;

public class TrianguloTest {

    // Triângulo escaleno válido
    @Test
    public void testTrianguloEscalenoValido() {
        assertEquals("Triângulo escaleno", Triangulo.classificarTriangulo(3, 4, 5));
    }

    // Triângulo isósceles válido
    @Test
    public void testTrianguloIsoscelesValido1() {
        assertEquals("Triângulo isósceles", Triangulo.classificarTriangulo(3, 3, 5));
    }

    @Test
    public void testTrianguloIsoscelesValido2() {
        assertEquals("Triângulo isósceles", Triangulo.classificarTriangulo(3, 5, 3));
    }

    @Test
    public void testTrianguloIsoscelesValido3() {
        assertEquals("Triângulo isósceles", Triangulo.classificarTriangulo(5, 3, 3));
    }

    // Triângulo equilátero válido
    @Test
    public void testTrianguloEquilateroValido() {
        assertEquals("Triângulo equilátero", Triangulo.classificarTriangulo(3, 3, 3));
    }

    // Um valor zero
    @Test
    public void testComValorZero() {
        assertEquals("Não é um triângulo válido", Triangulo.classificarTriangulo(0, 3, 4));
    }

    // Um valor negativo
    @Test
    public void testComValorNegativo() {
        assertEquals("Não é um triângulo válido", Triangulo.classificarTriangulo(-2, 3, 4));
    }

    // Soma de 2 lados igual ao terceiro lado (permutações)
    @Test
    public void testSomaDoisLadosIgualTerceiro1() {
        assertEquals("Não é um triângulo válido", Triangulo.classificarTriangulo(1, 2, 3));
    }

    @Test
    public void testSomaDoisLadosIgualTerceiro2() {
        assertEquals("Não é um triângulo válido", Triangulo.classificarTriangulo(1, 3, 2));
    }

    @Test
    public void testSomaDoisLadosIgualTerceiro3() {
        assertEquals("Não é um triângulo válido", Triangulo.classificarTriangulo(3, 1, 2));
    }

    // Soma de 2 lados menor que o terceiro lado (permutações)
    @Test
    public void testSomaDoisLadosMenorTerceiro1() {
        assertEquals("Não é um triângulo válido", Triangulo.classificarTriangulo(1, 2, 4));
    }

    @Test
    public void testSomaDoisLadosMenorTerceiro2() {
        assertEquals("Não é um triângulo válido", Triangulo.classificarTriangulo(1, 4, 2));
    }

    @Test
    public void testSomaDoisLadosMenorTerceiro3() {
        assertEquals("Não é um triângulo válido", Triangulo.classificarTriangulo(4, 1, 2));
    }

    // Três valores iguais a zero
    @Test
    public void testTodosLadosZero() {
        assertEquals("Não é um triângulo válido", Triangulo.classificarTriangulo(0, 0, 0));
    }
}
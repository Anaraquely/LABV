package org.example.tdd.exercicio1;
public class Triangulo {

    public static String classificarTriangulo(int a, int b, int c) {
        // Verifica se é um triângulo válido
        if (a <= 0 || b <= 0 || c <= 0) {
            return "Não é um triângulo válido";
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            return "Não é um triângulo válido";
        }

        // Classifica o tipo de triângulo
        if (a == b && b == c) {
            return "Triângulo equilátero";
        } else if (a == b || a == c || b == c) {
            return "Triângulo isósceles";
        } else {
            return "Triângulo escaleno";
        }
    }
}
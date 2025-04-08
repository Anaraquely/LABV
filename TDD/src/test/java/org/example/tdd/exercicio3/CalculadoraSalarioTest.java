package org.example.tdd.exercicio3;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculadoraSalarioTest {

    @Test
    public void testDesenvolvedorSalarioAlto() {
        Funcionario dev = new Funcionario("João", "joao@empresa.com", 4000.0, Cargo.DESENVOLVEDOR);
        assertEquals(3200.0, CalculadoraSalario.calcularSalarioLiquido(dev), 0.001);
    }

    @Test
    public void testDesenvolvedorSalarioBaixo() {
        Funcionario dev = new Funcionario("Maria", "maria@empresa.com", 2500.0, Cargo.DESENVOLVEDOR);
        assertEquals(2250.0, CalculadoraSalario.calcularSalarioLiquido(dev), 0.001);
    }

    @Test
    public void testDbaSalarioAlto() {
        Funcionario dba = new Funcionario("Carlos", "carlos@empresa.com", 3000.0, Cargo.DBA);
        assertEquals(2250.0, CalculadoraSalario.calcularSalarioLiquido(dba), 0.001);
    }

    @Test
    public void testDbaSalarioBaixo() {
        Funcionario dba = new Funcionario("Ana", "ana@empresa.com", 1500.0, Cargo.DBA);
        assertEquals(1275.0, CalculadoraSalario.calcularSalarioLiquido(dba), 0.001);
    }

    @Test
    public void testTestadorSalarioAlto() {
        Funcionario testador = new Funcionario("Pedro", "pedro@empresa.com", 2500.0, Cargo.TESTADOR);
        assertEquals(1875.0, CalculadoraSalario.calcularSalarioLiquido(testador), 0.001);
    }

    @Test
    public void testTestadorSalarioBaixo() {
        Funcionario testador = new Funcionario("Lucia", "lucia@empresa.com", 1800.0, Cargo.TESTADOR);
        assertEquals(1530.0, CalculadoraSalario.calcularSalarioLiquido(testador), 0.001);
    }

    @Test
    public void testGerenteSalarioAlto() {
        Funcionario gerente = new Funcionario("Fernanda", "fernanda@empresa.com", 6000.0, Cargo.GERENTE);
        assertEquals(4200.0, CalculadoraSalario.calcularSalarioLiquido(gerente), 0.001);
    }

    @Test
    public void testGerenteSalarioBaixo() {
        Funcionario gerente = new Funcionario("Roberto", "roberto@empresa.com", 4500.0, Cargo.GERENTE);
        assertEquals(3600.0, CalculadoraSalario.calcularSalarioLiquido(gerente), 0.001);
    }
}
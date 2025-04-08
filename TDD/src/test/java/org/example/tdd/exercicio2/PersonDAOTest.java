package org.example.tdd.exercicio2;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PersonDAOTest {

    @Test
    public void testNomeInvalido() {
        Person p = new Person(1, "Joao", 25);
        p.addEmail(new Email(1, "teste@email.com"));
        List<String> errors = new PersonDAO().isValidToInclude(p);
        assertTrue(errors.contains("Nome deve conter pelo menos duas partes com letras apenas."));
    }

    @Test
    public void testIdadeInvalida() {
        Person p = new Person(2, "Joao Silva", 0);
        p.addEmail(new Email(2, "teste@email.com"));
        List<String> errors = new PersonDAO().isValidToInclude(p);
        assertTrue(errors.contains("Idade deve estar entre 1 e 200."));
    }

    @Test
    public void testSemEmail() {
        Person p = new Person(3, "Joao Silva", 30);
        List<String> errors = new PersonDAO().isValidToInclude(p);
        assertTrue(errors.contains("Deve haver ao menos um e-mail associado."));
    }

    @Test
    public void testEmailInvalido() {
        Person p = new Person(4, "Joao Silva", 30);
        p.addEmail(new Email(3, "emailinvalido.com"));
        List<String> errors = new PersonDAO().isValidToInclude(p);
        assertTrue(errors.contains("Formato de e-mail inválido: emailinvalido.com"));
    }

    @Test
    public void testValido() {
        Person p = new Person(5, "Maria Clara", 28);
        p.addEmail(new Email(4, "maria@exemplo.com"));
        List<String> errors = new PersonDAO().isValidToInclude(p);
        assertTrue(errors.isEmpty());
    }
}

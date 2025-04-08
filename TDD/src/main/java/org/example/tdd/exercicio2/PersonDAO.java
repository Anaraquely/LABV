package org.example.tdd.exercicio2;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    public void save(Person p) {
        // implementação omitida
    }

    public List<String> isValidToInclude(Person p) {
        List<String> errors = new ArrayList<>();

        // Nome: pelo menos 2 partes e apenas letras
        if (p.name == null || p.name.trim().split("\\s+").length < 2 ||
                !p.name.matches("([A-Za-zÀ-ÿ]+\\s+){1,}[A-Za-zÀ-ÿ]+")) {
            errors.add("Nome deve conter pelo menos duas partes com letras apenas.");
        }

        // Idade: entre 1 e 200
        if (p.age < 1 || p.age > 200) {
            errors.add("Idade deve estar entre 1 e 200.");
        }

        // Ao menos um e-mail
        if (p.getEmails() == null || p.getEmails().isEmpty()) {
            errors.add("Deve haver ao menos um e-mail associado.");
        } else {
            // Validação de cada e-mail
            for (Email e : p.getEmails()) {
                if (!e.name.matches("^.+@.+\\..+$")) {
                    errors.add("Formato de e-mail inválido: " + e.name);
                }
            }
        }

        return errors;
    }
}

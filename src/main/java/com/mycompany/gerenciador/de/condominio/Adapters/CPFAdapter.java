package com.mycompany.gerenciador.de.condominio.Adapters;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class CPFAdapter implements CPF {

    private String cpf;

    public CPFAdapter(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean validateCpf() {
        try {
            CPFValidator cpfValidator = new CPFValidator();
            cpfValidator.assertValid(this.cpf);
            return true;
        } catch (InvalidStateException e) {
            return false;
        }
    }
}

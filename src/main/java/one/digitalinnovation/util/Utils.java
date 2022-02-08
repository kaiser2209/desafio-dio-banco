package one.digitalinnovation.util;

import one.digitalinnovation.entidades.Conta;
import one.digitalinnovation.interfaces.IConta;

public class Utils {
    public static Integer getDigitoVerificador(Integer agencia, Conta.Tipo tipo, Integer numeroConta) {
        String numero = String.format("%03d", agencia);
        numero += String.format("%02d", tipo.getCodigo());
        numero += String.format("%05d", numeroConta);
        int soma = 0;
        String[] digitos = numero.split("(?!^)");

        for (int i = digitos.length + 1; i > 1; i--) {
            soma += Integer.parseInt(digitos[digitos.length + 1 - i]) * i;
        }

        return 10 - (soma % 10);

    }

    public static boolean isContaValida(Integer agencia, Conta.Tipo tipo, Integer numeroConta, Integer dv) {
        return getDigitoVerificador(agencia, tipo, numeroConta) == dv;
    }
}

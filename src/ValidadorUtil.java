import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ValidadorUtil {

    public static String lerCpf(Scanner scanner) {
        while (true) {
            System.out.println("CPF (digite 11 números): ");
            String cpf = scanner.nextLine();

            if (validarCpf(cpf)) {
                String cpfFormatado = cpf.substring(0, 3) + "."
                        + cpf.substring(3, 6) + "."
                        + cpf.substring(6, 9) + "-"
                        + cpf.substring(9, 11);

                return cpfFormatado;
            }

            System.out.println("CPF inválido. Digite um CPF válido.");
        }
    }

    public static boolean validarCpf(String cpf) {
        if (!cpf.matches("\\d{11}")) {
            return false;
        }

        boolean todosIguais = true;

        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                todosIguais = false;
                break;
            }
        }
        if (todosIguais) {
            return false;
        }

        int soma = 0;

        for (int i = 0; i < 9; i++) {
            int digito = Character.getNumericValue(cpf.charAt(i));
            int peso = 10 - i;
            soma += digito * peso;
        }

        int resto = soma % 11;
        int primeiroDigito = 11 - resto;

        if (primeiroDigito >= 10) {
            primeiroDigito = 0;
        }

        soma = 0;

        for (int i = 0; i < 9; i++) {
            int digito = Character.getNumericValue(cpf.charAt(i));
            int peso = 11 - i;
            soma += digito * peso;
        }

        soma += primeiroDigito * 2;

        resto = soma % 11;
        int segundoDigito = 11 - resto;

        if (segundoDigito >= 10) {
            segundoDigito = 0;
        }

        int digitoInformado1 = Character.getNumericValue(cpf.charAt(9));

        int digitoInformado2 = Character.getNumericValue(cpf.charAt(10));

        return primeiroDigito == digitoInformado1
                && segundoDigito == digitoInformado2;
    }

    public static LocalDate lerDataNascimento(Scanner scanner) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyyy");

        while(true) {
            System.out.println("Data de nascimento: ");
            String data = scanner.nextLine();

            if (!data.matches("\\d{8}")) {
                System.out.println("Digite exatamente 8 números, por exemplo: 10052005.");
                continue;
            }

            try {
                return LocalDate.parse(data, formato);
            } catch (DateTimeParseException erro) {
                System.out.println("Data inválida. Verifique o dia, mês e o ano.");
            }
        }
    }

    public static String lerMatricula(Scanner scanner) {
        while (true) {
            System.out.print("Matrícula: ");
            String matricula = scanner.nextLine();

            if (matricula.matches("\\d{1,7}")) {
                return matricula;
            }

            System.out.println(
                    "Matrícula inválida. Digite apenas números, "
                            + "com no máximo 7 dígitos."
            );
        }
    }
}

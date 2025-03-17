package org.example; // Define o pacote onde a classe PixPayment está localizada, organizando o código em uma estrutura lógica.

import java.util.Random;        // Importa a classe Random, que será usada para gerar números aleatórios. Essencial para simular a criação de códigos Pix únicos.
import java.util.Scanner;       // Importa a classe Scanner, utilizada para ler a entrada do usuário a partir do console. Permite que o usuário interaja com o sistema, inserindo dados como o valor e o código Pix.
import java.time.LocalDateTime; // Importa a classe LocalDateTime para trabalhar com datas e tempos, essencial para calcular o tempo de expiração do código Pix. Oferece precisão ao lidar com datas e horários, permitindo calcular o momento exato da expiração.



// Implementação de pagamento via Pix com fluxo realista e tratamento de erros
public class PixPayment implements PaymentStrategy {

    // Constante que define o tempo de expiração do código Pix em segundos (60 segundos neste caso).
    private static final int CODE_EXPIRY_SECONDS = 60; // Define o tempo de validade do código Pix. Em um sistema real, esse valor pode variar dependendo das políticas do serviço de pagamento.

    // Constante que define o número máximo de tentativas que o usuário pode fazer ao inserir o código Pix.
    private static final int MAX_ATTEMPTS = 3; // Limita o número de tentativas para evitar abusos e aumentar a segurança. Em sistemas reais, pode haver um sistema de bloqueio após um certo número de tentativas falhas.

    // Implementa o método processPayment da interface PaymentStrategy, que processa um pagamento específico via Pix.
    @Override
    public void processPayment(double amount) {
        // Gera um código Pix aleatório para a transação, utilizando o método generatePixCode.
        String pixCode = generatePixCode(); // Cria um código Pix único para esta transação. Em um ambiente real, este código seria gerado pelo sistema bancário ou provedor de serviços Pix.

        // Calcula o tempo de expiração do código Pix adicionando CODE_EXPIRY_SECONDS ao tempo atual.
        LocalDateTime expiryTime = LocalDateTime.now().plusSeconds(CODE_EXPIRY_SECONDS); // Define quando o código Pix deixará de ser válido. Importante para garantir que a transação seja realizada em tempo hábil.

        // Exibe o código Pix gerado e informa o usuário sobre sua validade temporal.
        System.out.println("Por favor, utilize o seguinte código Pix para completar a transação: " + pixCode);
        System.out.println("Este código é válido por " + CODE_EXPIRY_SECONDS + " segundos."); // Mostra ao usuário o código Pix e o tempo restante para utilizá-lo. Essencial para uma boa experiência do usuário.

        // Cria um objeto Scanner para capturar entradas do usuário via console.
        Scanner scanner = new Scanner(System.in); // Permite que o programa leia dados inseridos pelo usuário no console. É fundamental para coletar o valor e o código Pix inseridos pelo usuário.

        // Inicializa um contador de tentativas.
        int attempts = 0; // Controla o número de vezes que o usuário tentou inserir os dados corretamente. Importante para limitar o número de tentativas e aumentar a segurança.

        // Loop principal para verificar a entrada do usuário. Continua até que o usuário insira o código correto ou o número máximo de tentativas seja atingido.
        while (attempts < MAX_ATTEMPTS) {
            // Verifica se o tempo atual já superou o tempo de expiração do código Pix.
            if (LocalDateTime.now().isAfter(expiryTime)) {
                System.out.println("O código Pix expirou. Por favor, gere um novo código.");
                return; // Sai do método se o código Pix expirou.
            }

            try {
                // Pede ao usuário para inserir o valor da transação.
                System.out.print("Digite o valor e o código Pix para confirmar a transação:\nValor (R$): ");

                // Lê o valor inserido pelo usuário e remove espaços em branco no início e no fim.
                double enteredAmount = Double.parseDouble(scanner.nextLine().trim()); // Lê o valor inserido pelo usuário e remove espaços em branco. O método `trim()` é importante para evitar erros causados por espaços extras.

                // Pede ao usuário para inserir o código Pix.
                System.out.print("Código Pix: ");

                // Lê o código Pix inserido pelo usuário e remove espaços em branco.
                String enteredCode = scanner.nextLine().trim(); // Lê o código Pix inserido pelo usuário e remove espaços em branco. Essencial para garantir que a comparação com o código gerado seja precisa.

                // Verifica se tanto o valor quanto o código Pix inseridos pelo usuário estão corretos.
                if (enteredAmount == amount && enteredCode.equals(pixCode)) {
                    // Confirma a transação se os dados estiverem corretos.
                    System.out.println("Pagamento de R$" + amount + " confirmado via Pix.");
                    return; // Encerra o método após a confirmação do pagamento.
                } else {
                    // Incrementa o contador de tentativas caso os dados estejam incorretos.
                    attempts++;
                    System.out.println("Código ou valor incorreto. Tentativas restantes: " + (MAX_ATTEMPTS - attempts));
                }
            } catch (NumberFormatException e) {
                // Captura exceções de formato numérico inválido para a entrada do valor.
                attempts++;
                System.out.println("Valor inválido. Por favor, insira um número. Tentativas restantes: " + (MAX_ATTEMPTS - attempts)); // Informa o usuário sobre o erro e o número de tentativas restantes. Ajuda a melhorar a experiência do usuário ao fornecer feedback claro.
            }
        }

        // Notifica o usuário se o número máximo de tentativas for excedido.
        System.out.println("Número máximo de tentativas excedido. Pagamento cancelado.");
        scanner.close(); // Fecha o scanner para liberar recursos.
    }

    // Método privado para gerar um código Pix aleatório de 6 dígitos.
    private String generatePixCode() {
        // Cria uma instância da classe Random para gerar um número aleatório.
        Random rand = new Random(); // Cria um gerador de números aleatórios. Em um sistema real, este código seria mais complexo e gerado de forma segura.

        // Gera um número aleatório entre 0 e 999999 e formata-o como uma string de 6 dígitos, preenchida com zeros se necessário.
        return String.format("%06d", rand.nextInt(1000000)); // Formata o número aleatório como uma string de 6 dígitos, preenchendo com zeros à esquerda se necessário. Garante que o código Pix tenha sempre 6 dígitos.
    }
}
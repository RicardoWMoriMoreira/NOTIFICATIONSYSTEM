package org.example; // Define o pacote em que a classe CreditCardPayment está localizada. Pacotes ajudam a organizar classes relacionadas e evitam conflitos de nomes em projetos maiores. A convenção de nomenclatura de pacotes geralmente segue a estrutura de domínio reverso da organização (ex: com.exemplo.projeto).

// Importa a classe Scanner do pacote java.util. A classe Scanner é utilizada para obter dados de entrada do usuário, como números ou texto, a partir do console (System.in) ou de outras fontes de entrada.
import java.util.Scanner;

// Declara a classe CreditCardPayment que implementa a interface PaymentStrategy.
// Isso significa que CreditCardPayment deve fornecer uma implementação para todos os métodos definidos em PaymentStrategy, promovendo o conceito de "programar para uma interface, não para uma implementação".
public class CreditCardPayment implements PaymentStrategy {

    // Implementação do método processPayment, definido na interface PaymentStrategy.
    // Este método recebe o valor do pagamento (amount) como argumento e realiza as etapas necessárias para processar o pagamento via cartão de crédito.
    @Override
    public void processPayment(double amount) {
        // Cria uma instância da classe Scanner associada à entrada padrão do sistema (System.in), que é o console.
        // Isso permite que o programa leia dados digitados pelo usuário.
        Scanner scanner = new Scanner(System.in);

        // Exibe uma mensagem no console solicitando ao usuário que insira o número do cartão de crédito.
        // O método System.out.print() é usado para exibir a mensagem sem adicionar uma nova linha após a mesma.
        System.out.print("Insira o número do cartão de crédito: ");

        // Lê a linha de texto inserida pelo usuário (o número do cartão de crédito) e armazena-a na variável cardNumber.
        // O método nextLine() do Scanner lê toda a linha de entrada, incluindo espaços em branco.
        String cardNumber = scanner.nextLine();

        // Exibe uma mensagem no console confirmando que o pagamento foi realizado com sucesso.
        // A mensagem inclui o valor do pagamento (amount) e o número do cartão de crédito inserido pelo usuário.
        // Em um sistema real, o número do cartão de crédito seria mascarado ou tokenizado por razões de segurança.
        System.out.println("Pagamento de R$" + amount + " efetuado via Cartão de Crédito. Número do cartão: " + cardNumber);

        // Boa prática: Fechar o scanner após o uso para liberar recursos do sistema.
        // Em um código de produção, é fundamental garantir que recursos como o Scanner sejam fechados adequadamente para evitar vazamentos de memória.
        scanner.close(); // Fecha o objeto Scanner, liberando os recursos que ele estava utilizando.

        // Em um cenário real, o código aqui realizaria operações como:
        // 1. Validação do número do cartão (formato, checksum, etc.).
        // 2. Criptografia do número do cartão para transmissão segura.
        // 3. Comunicação com um gateway de pagamento para autorizar a transação.
        // 4. Tratamento de erros e exceções (ex: cartão inválido, saldo insuficiente, etc.).
    }
}
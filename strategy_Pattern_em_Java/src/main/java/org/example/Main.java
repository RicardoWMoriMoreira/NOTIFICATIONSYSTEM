package org.example; // Define o pacote onde a classe Main está localizada, organizando o código e evitando conflitos de nomes.

import java.util.Scanner; // Importa a classe Scanner do pacote java.util, permitindo a leitura de dados inseridos pelo usuário através do console.

public class Main {
    public static void main(String[] args) {
        // Cria uma instância da classe Scanner, associando-a à entrada padrão do sistema (System.in), que geralmente é o teclado.
        Scanner scanner = new Scanner(System.in);

        // Exibe as opções de método de pagamento disponíveis para o usuário escolher.
        System.out.println("Selecione o método de pagamento:");
        System.out.println("1: Pix");
        System.out.println("2: Cartão de Crédito");
        System.out.println("3: Boleto");

        // Solicita ao usuário que escolha uma opção de pagamento, indicando o intervalo de opções válidas.
        System.out.print("Escolha uma opção (1-3): ");
        // Captura a escolha do usuário, utilizando a função auxiliar getIntInput para garantir que a entrada seja um número inteiro válido.
        int choice = getIntInput(scanner, "Escolha uma opção (1-3): ");
        // Verifica se a escolha do usuário está dentro do intervalo válido (1 a 3).
        if (choice < 1 || choice > 3) {
            System.out.println("Opção inválida. Por favor, escolha entre 1 e 3.");
            return; // Encerra a execução do programa se a opção escolhida não for válida, evitando erros posteriores.
        }

        // Solicita ao usuário que insira o valor da transação que deseja realizar.
        System.out.print("Insira o valor da transação: ");
        // Captura o valor da transação inserido pelo usuário, utilizando a função auxiliar getDoubleInput para garantir que a entrada seja um número decimal válido.
        double amount = getDoubleInput(scanner, "Insira o valor da transação: ");
        // Verifica se o valor inserido pelo usuário é maior que zero. Transações com valor zero ou negativo não são permitidas.
        if (amount <= 0) {
            System.out.println("O valor deve ser maior que zero.");
            return; // Encerra a execução do programa se o valor inserido não for válido.
        }

        // Declara uma variável do tipo PaymentStrategy, que será utilizada para armazenar a estratégia de pagamento selecionada.
        // Essa variável é fundamental para a implementação do padrão Strategy.
        PaymentStrategy strategy = null;

        // Seleciona a estratégia de pagamento com base na escolha do usuário.
        // Utiliza uma estrutura switch para determinar qual classe de estratégia instanciar.
        switch (choice) {
            case 1:
                strategy = new PixPayment(); // Instancia a classe PixPayment se o usuário escolher a opção 1 (Pix).
                break;
            case 2:
                strategy = new CreditCardPayment(); // Instancia a classe CreditCardPayment se o usuário escolher a opção 2 (Cartão de Crédito).
                break;
            case 3:
                strategy = new BoletoPayment(); // Instancia a classe BoletoPayment se o usuário escolher a opção 3 (Boleto).
                break;
        }

        // Cria uma instância da classe PaymentProcessor, passando a estratégia de pagamento selecionada como argumento.
        // O PaymentProcessor utiliza a estratégia para executar o pagamento.
        PaymentProcessor processor = new PaymentProcessor(strategy);
        // Executa o pagamento utilizando a estratégia escolhida. O método executePayment é responsável por realizar as operações necessárias para processar o pagamento.
        processor.executePayment(amount);

        // Fecha o scanner para liberar os recursos do sistema. É importante fechar o scanner após o uso para evitar vazamentos de recursos.
        scanner.close();
    }

    // Função auxiliar para capturar um número inteiro do usuário, com tratamento de exceções para garantir que a entrada seja válida.
    private static int getIntInput(Scanner scanner, String prompt) {
        while (true) { // Loop infinito que continua até que uma entrada válida seja fornecida.
            try {
                // Lê a linha de entrada do usuário, remove espaços em branco no início e no fim da linha e tenta converter a string resultante para um número inteiro.
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input); // Retorna o número inteiro se a conversão for bem-sucedida.
            } catch (NumberFormatException e) {
                // Se ocorrer uma exceção NumberFormatException (ou seja, se a entrada não puder ser convertida para um número inteiro), exibe uma mensagem de erro e solicita a entrada novamente.
                System.out.print("Entrada inválida. Por favor, insira um número inteiro válido. " + prompt);
            }
        }
    }

    // Função auxiliar para capturar um número decimal do usuário, com tratamento de exceções para garantir que a entrada seja válida.
    private static double getDoubleInput(Scanner scanner, String prompt) {
        while (true) { // Loop infinito que continua até que uma entrada válida seja fornecida.
            try {
                // Lê a linha de entrada do usuário, remove espaços em branco no início e no fim da linha e tenta converter a string resultante para um número decimal (double).
                String input = scanner.nextLine().trim();
                return Double.parseDouble(input); // Retorna o número decimal se a conversão for bem-sucedida.
            } catch (NumberFormatException e) {
                // Se ocorrer uma exceção NumberFormatException (ou seja, se a entrada não puder ser convertida para um número decimal), exibe uma mensagem de erro e solicita a entrada novamente.
                System.out.print("Entrada inválida. Por favor, insira um número decimal válido. " + prompt);
            }
        }
    }
}
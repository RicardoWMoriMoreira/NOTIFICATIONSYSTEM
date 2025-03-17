package org.example; // Define o pacote onde a classe PaymentProcessor está localizada. Pacotes ajudam a organizar classes relacionadas e evitam conflitos de nomes, especialmente em projetos grandes. Por convenção, nomes de pacotes usam letras minúsculas e refletem a estrutura de diretórios do projeto.


// Classe responsável por executar o método de pagamento selecionado
public class PaymentProcessor {
    // Declaração de uma variável privada do tipo PaymentStrategy, que armazena a estratégia de pagamento a ser utilizada.
    private PaymentStrategy paymentStrategy;

    // Construtor da classe PaymentProcessor, que recebe uma instância de PaymentStrategy como parâmetro.
    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        // Atribui a estratégia de pagamento passada como argumento ao atributo paymentStrategy da classe.
        // O uso de 'this' é essencial aqui para diferenciar o atributo da classe do parâmetro do construtor, garantindo que o valor correto seja atribuído.
        this.paymentStrategy = paymentStrategy;
    }

    // Método público que executa o pagamento, utilizando a estratégia de pagamento definida.
    public void executePayment(double amount) {
        // Chama o método processPayment da estratégia de pagamento armazenada, passando o valor da transação como argumento.
        // Este método delega a execução do pagamento para a estratégia configurada. Isso permite que a classe PaymentProcessor seja agnóstica ao método de pagamento específico.
        paymentStrategy.processPayment(amount);
    }
}
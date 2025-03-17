package org.example; // Define o pacote onde a interface PaymentStrategy está localizada. Isso ajuda a organizar o código e previne conflitos de nomes.


// Interface que define o contrato para processar pagamentos
public interface PaymentStrategy {

    // Declaração de metodo abstrato que cada classe concreta de pagamento deve implementar.
    // O metodo processPayment aceita um parâmetro double que representa o valor da transação a ser processada.
    void processPayment(double amount);
}
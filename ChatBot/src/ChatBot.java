import java.util.Scanner;

public class ChatBot {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ChatBot bot = new ChatBot();
        bot.saudar(); // Exibe mensagem de boas-vindas
        bot.chat();   // Inicia o chatbot
    }

    // Método de saudação
    public void saudar() {
        System.out.println("Olá! Eu sou o AnchorsBot, assistente virtual da Anchorstec. Como posso te ajudar hoje?");
    }

    // Método principal de interação
    public void chat() {
        while (true) {  
            exibirMenu(); // Exibe o menu de opções
            int escolha = scanner.nextInt();

            // Verifica a escolha e realiza a ação correspondente
            switch (escolha) {
                case 1:
                    solicitarOrcamento();
                    break;
                case 2:
                    agendarReuniao();
                    break;
                case 3:
                    suporte();
                    break;
                case 4:
                    System.out.println("Saindo... Obrigado!");
                    return; // Sai do loop e encerra o chatbot
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            scanner.nextLine(); // Limpa o buffer
        }
    }

    // Exibe o menu de opções
    private void exibirMenu() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Solicitar orçamento");
        System.out.println("2 - Agendar uma reunião");
        System.out.println("3 - Suporte");
        System.out.println("4 - Sair");
        System.out.print("Digite sua escolha: ");
    }

    public static void solicitarOrcamento() {
        System.out.println("Você escolheu: Solicitar orçamento.");
    }

    public static void agendarReuniao() {
        System.out.println("Você escolheu: Agendar uma reunião.");
    }

    public static void suporte() {
        System.out.println("Você escolheu: Suporte.");
    }
}

import java.util.Scanner;

public class ChatBot {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        //instancia do bot na class ChatBot
        ChatBot bot = new ChatBot();
        // Mensagem de boas-vindas
        bot.saudar();
        // Início da interação com o usuário
        bot.chat();
    }
    // Método de saudação
    public void saudar() {
        System.out.println("Olá! Eu sou o AnchorsBot, assistente virtual da Anchorstec. Como posso te ajudar hoje?" );
    }
    public void chat() {
        //Receber comando do usuario
        Scanner scanner = new Scanner(System.in);
        // Verificar comando do usuario
        while (true) {  
            // Captura a entrada do usuário
            String comandoUsuario = scanner.nextLine();
            int escolha = 0;
            while (escolha != 4) {
                // Exibe o menu de opções
                System.out.println("Escolha uma opção:");
                System.out.println("1 - Solicitar orçamento");
                System.out.println("2 - Agendar uma reunião");
                System.out.println("3 - Suporte");
                System.out.println("4 - Sair");
                
                // Lê a entrada do usuário
                System.out.print("Digite sua escolha: ");
                escolha = scanner.nextInt();
    
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
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, tente novamente.");
                }
                System.out.println(); // Pula uma linha para melhorar a legibilidade
            }
    
            scanner.close();
            // Responde com base na entrada do usuário
            responder(comandoUsuario);
        }
    }
     // Método para gerar uma resposta
    public void responder(String input) {
        String resposta;

        // Respostas baseadas em palavras-chave
        if (input.contains("olá") || input.contains("oi")) {
            resposta = "Olá! Como você está?";
        } else if (input.contains("nome")) {
            resposta = "Eu me chamo AnchorsBot, sou assistente virtual da Anchorstec.";
        } else if (input.contains("preço") || input.contains("valor")) {
            resposta = "Eu sou apenas um programa, mas você pode verificar a previsão do tempo online!";
        } else {
            resposta = "Desculpe, não entendi. Pode reformular?";
        }      
        // Exibe a resposta
        System.out.println(resposta);
    }

    public static void solicitarOrcamento() {
        System.out.println("Você escolheu: Solicitar orçamento.");
        // Adicione aqui a lógica para solicitar orçamento
    }

    public static void agendarReuniao() {
        System.out.println("Você escolheu: Agendar uma reunião.");
        // Adicione aqui a lógica para agendar reunião
    }

    public static void suporte() {
        System.out.println("Você escolheu: Suporte.");
        // Adicione aqui a lógica para suporte
    }

}

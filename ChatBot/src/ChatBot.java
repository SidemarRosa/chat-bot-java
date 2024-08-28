import java.util.Scanner;

public class ChatBot {
    private Scanner scanner = new Scanner(System.in);
   
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
            // Verifica se o usuário quer sair
            if (comandoUsuario.equalsIgnoreCase("sair")) {
                System.out.println("Adeus! Foi bom falar com você.");
                break;
            }
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

}

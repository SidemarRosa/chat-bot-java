import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.format.DateTimeParseException;


public class ChatBot {
    private Scanner scanner;
    // Mapa para armazenar os horários já reservados (chave: LocalDateTime, valor: boolean)
    private Map<LocalDateTime, Boolean> horariosReservados;

    public ChatBot() {
        scanner = new Scanner(System.in);
        horariosReservados = new HashMap<>();
    }
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
            int escolha = lerOpcao();

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
                    System.out.println(" Obrigado pelo contato! Espero ter ajudado! Até mais!");
                    scanner.close();
                    return; // Sai do loop e encerra o chatbot
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
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
    // Lê a opção escolhida pelo usuário com validação
    private int lerOpcao() {
        int escolha = -1;
        try {
            escolha = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            // Opção inválida será tratada no switch
        }
        return escolha;
    }
    // Método para solicitar orçamento
    public void solicitarOrcamento() {
        System.out.println("\nVocê escolheu: Solicitar orçamento.");
        System.out.println("Escolha um dos serviços abaixo:");
        System.out.println("1 - Desenvolvimento de Site Institucional");
        System.out.println("2 - Desenvolvimento de Landing Pages");
        System.out.println("3 - Desenvolvimento de Ecommerce");
        System.out.println("4 - Desenvolvimento de Sistemas Web");
        System.out.print("Digite sua escolha: ");

        int escolhaServico = lerOpcao();

        switch (escolhaServico) {
            case 1:
                exibirDetalhesServico("Desenvolvimento de Site Institucional", 3000, "Um site institucional é a vitrine online da sua empresa. Criamos sites modernos e responsivos, que refletem a identidade da sua marca.");
                break;
            case 2:
                exibirDetalhesServico("Desenvolvimento de Landing Pages", 1500, "Uma landing page projetada para converter visitantes em leads ou clientes. Oferecemos páginas de alta conversão com design atraente e chamadas para ação eficazes.");
                break;
            case 3:
                exibirDetalhesServico("Desenvolvimento de Ecommerce", 5000, "Lojas virtuais completas para você vender seus produtos online. Nossos ecommerces são otimizados para garantir uma experiência de compra fluida e segura.");
                break;
            case 4:
                exibirMenuSistemasWeb();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
    // Exibe o submenu para Desenvolvimento de Sistemas Web
    private void exibirMenuSistemasWeb() {
        System.out.println("\nEscolha uma subcategoria de Sistema Web:");
        System.out.println("1 - ERP (Enterprise Resource Planning)");
        System.out.println("2 - CRM (Customer Relationship Management)");
        System.out.println("3 - Financeiro");
        System.out.println("4 - HelpDesk");
        System.out.println("5 - Sistema de Biblioteca");
        System.out.print("Digite sua escolha: ");

        int escolhaSubcategoria = lerOpcao();

        switch (escolhaSubcategoria) {
            case 1:
                exibirDetalhesServico("ERP (Enterprise Resource Planning)", 10000, "Sistemas ERP integram os principais processos de negócios de uma empresa, desde o financeiro até o gerenciamento de estoques.");
                break;
            case 2:
                exibirDetalhesServico("CRM (Customer Relationship Management)", 7500, "Um CRM ajuda a gerenciar o relacionamento com seus clientes, automatizando e organizando suas interações para melhorar a satisfação e fidelização.");
                break;
            case 3:
                exibirDetalhesServico("Financeiro", 6000, "Sistemas financeiros para gestão de contas a pagar, a receber, fluxo de caixa, e relatórios detalhados, otimizando o controle financeiro da sua empresa.");
                break;
            case 4:
                exibirDetalhesServico("HelpDesk", 4000, "Solução HelpDesk para suporte ao cliente, permitindo a gestão eficiente de tickets e atendimento, melhorando a qualidade e agilidade no suporte.");
                break;
            case 5:
                exibirDetalhesServico("Sistema de Biblioteca", 8000, "Sistemas de biblioteca online que facilitam a gestão de acervos, empréstimos e devoluções, com funcionalidades como pesquisa de títulos e reservas.");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
    // Método para exibir os detalhes do serviço selecionado
    private void exibirDetalhesServico(String nomeServico, double preco, String descricao) {
        System.out.println("\nDetalhes do serviço selecionado:");
        System.out.println("Serviço: " + nomeServico);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Descrição: " + descricao);
        System.out.println("Deseja solicitar este serviço? (sim/não)");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("sim")) {
            System.out.println("Orçamento solicitado para: " + nomeServico);
            // Aqui, você pode adicionar a lógica para prosseguir com o orçamento
        } else {
            System.out.println("Solicitação de orçamento cancelada.");
        }
    }
    // Método para solicitar orçamento sub menu dos sistemas web
    private void solicitarOrcamentoSistemasWeb() {
        System.out.println("\nSelecione o tipo de sistema web:");
        System.out.println("1 - ERP");
        System.out.println("2 - CRM");
        System.out.println("3 - Financeiro");
        System.out.println("4 - HelpDesk");
        System.out.println("5 - Sistema de biblioteca");
        System.out.print("Digite sua escolha: ");

        int escolhaSistema = lerOpcao();

        switch (escolhaSistema) {
            case 1:
                System.out.println("Você escolheu: Desenvolvimento de sistema ERP.");
                // Lógica para orçamento de sistema ERP
                break;
            case 2:
                System.out.println("Você escolheu: Desenvolvimento de sistema CRM.");
                // Lógica para orçamento de sistema CRM
                break;
            case 3:
                System.out.println("Você escolheu: Desenvolvimento de sistema Financeiro.");
                // Lógica para orçamento de sistema Financeiro
                break;
            case 4:
                System.out.println("Você escolheu: Desenvolvimento de sistema HelpDesk.");
                // Lógica para orçamento de sistema HelpDesk
                break;
            case 5:
                System.out.println("Você escolheu: Desenvolvimento de sistema de biblioteca.");
                // Lógica para orçamento de sistema de biblioteca
                break;
            default:
                System.out.println("Opção inválida. Retornando ao menu de sistemas web.");
                solicitarOrcamentoSistemasWeb();
        }
    }
    // Método para agendar reunião
    public void agendarReuniao() {
        System.out.println("\nVocê escolheu: Agendar uma reunião.");
        mostrarHorariosDisponiveis();

        System.out.print("Digite a data e hora desejada (dd/MM/yyyy HH:mm): ");
        String input = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        try {
            LocalDateTime horarioDesejado = LocalDateTime.parse(input, formatter);
            if (reservarHorario(horarioDesejado)) {
                System.out.println("\n Reunião agendada com sucesso para " + horarioDesejado.format(formatter));
            } else {
                System.out.println(" \n Não foi possível agendar a reunião. Horário já reservado ou inválido.");
            }
        } catch (DateTimeParseException e) {
            System.out.println(" \n Formato de data/hora inválido. Por favor, tente novamente.");
        }
    }
    // Método para suporte
    public void suporte() {
        System.out.println("\nVocê escolheu: Suporte.");
        // Implementar lógica de suporte
        // Por exemplo, direcionar para atendimento humano ou responder FAQs
    }
    // Função para mostrar horários disponíveis para Reuniões
    private void mostrarHorariosDisponiveis() {
    LocalDate hoje = LocalDate.now();
    LocalTime inicioDia = LocalTime.of(9, 0);
    LocalTime fimDia = LocalTime.of(18, 0);

    // Definir formatador com Locale para exibir dias da semana em português
    DateTimeFormatter formatterDiaSemana = DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy", new Locale("pt", "BR"));
    DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");

    System.out.println("\nHorários disponíveis para agendamento (próxima semana):");

    // Percorre os próximos 7 dias
    for (int i = 0; i < 7; i++) {
        LocalDate data = hoje.plusDays(i);
        
        // Verifica se o dia é entre segunda e sexta
        DayOfWeek diaSemana = data.getDayOfWeek();
        if (diaSemana != DayOfWeek.SATURDAY && diaSemana != DayOfWeek.SUNDAY) {
            // Formatar a data e o nome do dia da semana em português
            System.out.println("\n" + data.format(formatterDiaSemana) + ":");
            boolean diaTemDisponibilidade = false;

            // Percorre os horários de 9h às 18h
            for (LocalTime hora = inicioDia; hora.isBefore(fimDia); hora = hora.plusHours(1)) {
                LocalDateTime horario = LocalDateTime.of(data, hora);

                // Verifica se o horário já foi reservado
                if (!horariosReservados.getOrDefault(horario, false)) {
                    System.out.println(" - " + hora.format(formatterHora));
                    diaTemDisponibilidade = true;
                }
            }

            if (!diaTemDisponibilidade) {
                System.out.println("Nenhum horário disponível.");
            }
        }
    }
}
    // Função para reservar um horário
    private boolean reservarHorario(LocalDateTime horario) {
        // Verifica se o horário está dentro do período permitido
        LocalDate hoje = LocalDate.now();
        LocalDate umaSemanaDepois = hoje.plusWeeks(1);
        if (horario.toLocalDate().isBefore(hoje) || horario.toLocalDate().isAfter(umaSemanaDepois)) {
            System.out.println("\n A data selecionada está fora do período de agendamento permitido.");
            return false;
        }

        // Verifica se é um dia útil (segunda a sexta)
        DayOfWeek diaSemana = horario.getDayOfWeek();
        if (diaSemana == DayOfWeek.SATURDAY || diaSemana == DayOfWeek.SUNDAY) {
            System.out.println("\n Só é possível agendar reuniões de segunda a sexta-feira.");
            return false;
        }

        // Verifica se a hora está dentro do horário permitido
        LocalTime hora = horario.toLocalTime();
        if (hora.isBefore(LocalTime.of(9, 0)) || hora.isAfter(LocalTime.of(17, 0))) { // Último horário às 17h
            System.out.println("\n Horário fora do expediente (9h às 18h).");
            return false;
        }

        // Verifica se o horário já foi reservado
        if (horariosReservados.getOrDefault(horario, false)) {
            System.out.println("\n Esse horário já está reservado. Tente outro horario!");
            return false;
        }

        // Marca o horário como reservado
        horariosReservados.put(horario, true);
        return true;
    }
    }
    //Fim do codigo 
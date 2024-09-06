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
                    System.out.println("Saindo... Obrigado!");
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
        // Implementar lógica para solicitar orçamento
        // Por exemplo, coletar informações do usuário e armazenar
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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("\n Horários disponíveis para agendamento (próxima semana):");

        // Percorre os próximos 7 dias
        for (int i = 0; i < 7; i++) {
            LocalDate data = hoje.plusDays(i);
            
            // Verifica se o dia é entre segunda e sexta
            DayOfWeek diaSemana = data.getDayOfWeek();
            if (diaSemana != DayOfWeek.SATURDAY && diaSemana != DayOfWeek.SUNDAY) {
                System.out.println("\n" + diaSemana + ", " + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ":");
                boolean diaTemDisponibilidade = false;

                // Percorre os horários de 9h às 18h
                for (LocalTime hora = inicioDia; hora.isBefore(fimDia); hora = hora.plusHours(1)) {
                    LocalDateTime horario = LocalDateTime.of(data, hora);

                    // Verifica se o horário já foi reservado
                    if (!horariosReservados.getOrDefault(horario, false)) {
                        System.out.println(" - " + hora.format(DateTimeFormatter.ofPattern("HH:mm")));
                        diaTemDisponibilidade = true;
                    }
                }

                if (!diaTemDisponibilidade) {
                    System.out.println("\n Nenhum horário disponível.");
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
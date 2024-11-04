import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Consultorio consultorio = new Consultorio();
        Scanner scanner = new Scanner(System.in);
        boolean executando = true; // var de controle para o loop

        // opções
        while (executando) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar Paciente");
            System.out.println("2. Adicionar Médico");
            System.out.println("3. Agendar Consulta");
            System.out.println("4. Ver Histórico de Consultas do paciente");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // consome a nova linha deixada pelo nextInt()

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do paciente: ");
                    String nomePaciente = scanner.nextLine();
                    System.out.print("Digite o CPF do paciente: ");
                    String cpfPaciente = scanner.nextLine();

                    Paciente paciente = new Paciente(nomePaciente, cpfPaciente); // cria uma nova instancia de paciente
                    consultorio.cadastrarPaciente(paciente); // cadastra o paciente
                    System.out.println("Paciente cadastrado com sucesso.");
                    break;

                case 2:
                    System.out.print("Digite o nome do médico: ");
                    String nomeMedico = scanner.nextLine();
                    System.out.print("Digite a especialidade do médico: ");
                    String especialidadeMedico = scanner.nextLine();

                    Medico medico = new Medico(nomeMedico, especialidadeMedico); // cria uma nova instancia de medico
                    consultorio.cadastrarMedico(medico); // cadastra o medico
                    System.out.println("Médico cadastrado com sucesso.");
                    break;

                case 3:
                    System.out.print("Digite o nome do paciente para a consulta: ");
                    String nomePacienteConsulta = scanner.nextLine();
                    Paciente pacienteConsulta = null; // var para armazenar o paciente encontrado

                    // busca o paciente pelo nome na lista de pacientes do consultorio
                    for (Paciente p : consultorio.getPacientes()) {
                        if (p.getNome().equalsIgnoreCase(nomePacienteConsulta)) {
                            pacienteConsulta = p; // armazena o paciente encontrado
                            break;
                        }
                    }
                    if (pacienteConsulta == null) {
                        System.out.println("Paciente não encontrado.");
                        break;
                    }

                    System.out.print("Digite o nome do médico para a consulta: ");
                    String nomeMedicoConsulta = scanner.nextLine();
                    Medico medicoConsulta = null; // var para armazenar o medico encontrado

                    // busca o medico pelo nome na lista de médicos
                    for (Medico m : consultorio.getMedicos()) {
                        if (m.getNome().equalsIgnoreCase(nomeMedicoConsulta)) {
                            medicoConsulta = m; // armazena o medico encontrado
                            break;
                        }
                    }
                    if (medicoConsulta == null) {
                        System.out.println("Médico não encontrado.");
                        break;
                    }

                    System.out.print("Digite a data e hora da consulta (AAAA-MM-DDTHH:MM): ");
                    String dataHora = scanner.nextLine();
                    LocalDateTime dataHoraConsulta = LocalDateTime.parse(dataHora); // converte a string para um objeto LocalDateTime

                    System.out.print("Digite a descrição do tratamento: ");
                    String descricaoTratamento = scanner.nextLine();
                    Tratamento tratamento = new Tratamento(descricaoTratamento);

                    // associa o tratamento ao paciente
                    pacienteConsulta.adicionarTratamento(tratamento);


                    try{
                        // cria uma nova instsncia de consulta e tenta agendar no consultorio
                        Consulta consulta = new Consulta(pacienteConsulta, medicoConsulta, dataHoraConsulta);
                        consultorio.agendarConsulta(consulta);
                        pacienteConsulta.adicionarConsulta(consulta); // adiciona a consulta ao paciente
                        System.out.println("Consulta agendada com sucesso.");
                    } catch (MedicoIndisponivelException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Digite o nome do paciente: ");
                    String nomePacienteHistorico = scanner.nextLine();
                    Paciente pacienteHistorico = null;

                    for (Paciente p : consultorio.getPacientes()) {
                        if (p.getNome().equalsIgnoreCase(nomePacienteHistorico)) {
                            pacienteHistorico = p;
                            break;
                        }
                    }
                    if (pacienteHistorico == null) {
                        System.out.println("Paciente não encontrado.");
                    } else {
                        System.out.println("Histórico de Consultas do Paciente " + pacienteHistorico.getNome() + ":");
                        for (Consulta consulta : pacienteHistorico.getConsultas()) {
                            System.out.println("Data e Hora: " + consulta.getDataHora() + ", Médico: " + consulta.getMedico().getNome() + ", Status: " + consulta.getStatus());
                        }
                    }
                    break;    

                case 5:
                    System.out.println("Saindo...");
                    executando = false; // altera a var de controle para interromper o loop
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}

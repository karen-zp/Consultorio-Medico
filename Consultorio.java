import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Consultorio{
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<Consulta> consultas;

    public Consultorio(){
        pacientes = new ArrayList<>();
        medicos = new ArrayList<>();
        consultas = new ArrayList<>();
    }

     public List<Paciente> getPacientes(){
        return pacientes;
    }

    public List<Medico> getMedicos(){
        return medicos;
    }

    public void cadastrarPaciente(Paciente paciente){
        pacientes.add(paciente);
    }

    public void cadastrarMedico(Medico medico){
        medicos.add(medico);
    }

    // agenda a consuta e lança a exceção se o medico esta indisponivel
    public void agendarConsulta(Consulta consulta) throws MedicoIndisponivelException{
        if(medicoDisponivel(consulta.getMedico(), consulta.getDataHora())){
            consultas.add(consulta);
            consulta.agendar();
        } else {
            throw new MedicoIndisponivelException("Médico indisponível para consulta.");
        }
    }

    private boolean medicoDisponivel(Medico medico, LocalDateTime dataHoraConsulta){
        for(Consulta consulta : consultas){
            if(consulta.getMedico().equals(medico) && consulta.getDataHora().equals(dataHoraConsulta)){
                return false;
            }
        }
        return true;
    }

    // busca paciente pelo nome
    public void buscarPacientePorNome(String nome){
        for(Paciente paciente : pacientes){
            if(paciente.getNome().equalsIgnoreCase(nome)){
                System.out.println("Paciente encontrado: " + paciente.getNome());
                return;
            }
        }
        System.out.println("Paciente não encontrado.");
    }

    // busca medico pela especialidade
    public void buscarMedicoPorEspecialidade(String especialidade){
        for(Medico medico : medicos){
            if(medico.getEspecialidade().equalsIgnoreCase(especialidade)){
                System.out.println("Médico encontrado: " + medico.getNome());
                return;
            }
        }
        System.out.println("Médico não encontrado.");
    }
}

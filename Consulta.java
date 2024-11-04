import java.time.LocalDateTime;

public class Consulta implements Agendavel{
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime dataHora;
    private StatusConsulta status;

    public Consulta(Paciente paciente, Medico medico, LocalDateTime dataHora){
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
        this.status = StatusConsulta.AGENDADA;
    }

    public Paciente getPaciente(){
        return paciente;
    }

    public Medico getMedico(){
        return medico;
    }

    public LocalDateTime getDataHora(){
        return dataHora;
    }

    public StatusConsulta getStatus(){
        return status;
    }

    public void setStatus(StatusConsulta status){
        this.status = status;
    }

    @Override
    public void agendar(){
        System.out.println("Consulta agendada para o paciente " + paciente.getNome() + " com o médico " + medico.getNome() + " na data e hora " + dataHora);
    }
}

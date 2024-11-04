import java.util.ArrayList;
import java.util.List;

public class Medico{
    private String nome;
    private String especialidade;
    private List<Paciente> pacientes = new ArrayList<>();

    public Medico(String nome, String especialidade){
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public String getNome(){
        return nome;
    }

    public String getEspecialidade(){
        return especialidade;
    }

    public List<Paciente> getPacientes(){
        return pacientes;
    }

    public void adicionarPaciente(Paciente paciente){
        pacientes.add(paciente); // adiciona um paciente na lista
    }

    // realiza a consulta básica, sobrescrito nas subclasses
    public void realizarConsulta(Paciente paciente){
        System.out.println("Consulta realizada com o clínico geral.");
    }
}

import java.util.ArrayList;
import java.util.List;

public class Paciente{
    private String nome;
    private String cpf; 
    private List<Consulta> consultas = new ArrayList<>();
    private List<Tratamento> tratamentos = new ArrayList<>();

    public Paciente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }

    public List<Consulta> getConsultas(){
        return consultas;
    }

    public void adicionarConsulta(Consulta consulta){
        consultas.add(consulta); // adiciona uma consulta na lista
    }

    public List<Tratamento> getTratamentos(){
        return tratamentos;
    }

    public void adicionarTratamento(Tratamento tratamento){
        tratamentos.add(tratamento); // adiciona um tratamento na lista
    }
}

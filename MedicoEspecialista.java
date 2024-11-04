public class MedicoEspecialista extends Medico{
    public MedicoEspecialista(String nome, String especialidade){
        super(nome, especialidade);
    }

    @Override
    public void realizarConsulta(Paciente paciente){
        System.out.println("Consulta com o especialista em " + getEspecialidade() + " para o paciente " + paciente.getNome());
    }
}

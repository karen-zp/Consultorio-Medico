public class MedicoClinicoGeral extends Medico{
    public MedicoClinicoGeral(String nome){
        super(nome, "Clínico geral");
    }

    @Override
    public void realizarConsulta(Paciente paciente){
        System.out.println("Consulta com o clínico geral para o paciente " + paciente.getNome());
    }
}

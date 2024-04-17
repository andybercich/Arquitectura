package MedicosPacientes;

public class Pacientes extends Thread{

    private static int sintoma;

    public Pacientes(){
        sintoma = 0;
    }

    public void malestar(){

            if (sintoma == 0) {
                System.out.println("Me duele el brazo");
                sintoma++;
            } else if (sintoma == 1) {
                System.out.println("Me duele la cabeza");
                sintoma++;
            } else if (sintoma == 2) {
                System.out.println("Tengo fiebre");
                sintoma = 0;

            }
            Medicos.cuotaMedico-=1;


    }

}

package MedicosPacientes;

public class Medicos extends Thread{

    public static int cuotaMedico;

    public Medicos(){
        cuotaMedico = 20;
    }


    public static void atender(){
        System.out.println("Medico: Tome paracetamol");
        System.out.println("Siguiente paciente!!!");

    }



}

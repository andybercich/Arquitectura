package MedicosPacientes;

import java.util.ArrayList;

public class FilaHospital extends Thread{
    private Medicos medicoImpaciente;
    private Pacientes pacienteMolesto;


    public FilaHospital (){
        //Inicializp los objetos cuando se construye el objeto Fila
        medicoImpaciente = new Medicos();
        pacienteMolesto = new Pacientes();
    }


    public void run() {
        while (true) {

            synchronized (this) {

                    //System.out.println("Cuota médico "+ Medicos.cuotaMedico); Un mensaje que hice para guiarme

                    //Largo un mensaje para saber si se cargo el número de cuota médico

                    if (Medicos.cuotaMedico == 0) {

                        System.out.println("Cambio de turno. Recargando cuota del médico...");
                        Medicos.cuotaMedico = 20; // Reiniciar la cuota del médico
                        notifyAll(); // Notificar que la cuota del médico ha cambiado
                    }else{
                        pacienteMolesto.malestar();
                        medicoImpaciente.atender();
                    }

                try {
                    this.sleep(250);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

}

package MedicosPacientes;

public class VariasFilas extends Thread {

    private static Medicos medicoCompartido;
    private Pacientes pacientes;
    //Todo este bloque de código es el mismo excepto que cambia el objeto que quiero sincronizar, de pasar a this (en
    // el anteriro por si muchas filas querian ejecutar el run) a pasar a MedicoCOmpartido por lo que sería un
    // recurso compartido en el main, ya que cree las filas con el mismo objeto Medico

    public VariasFilas(Medicos m) {
        medicoCompartido = m;
        pacientes = new Pacientes();
    }

    public void run() {

        while (true) {

            //Sincronizando el mismo objeto medico entre las filas con synchronized

            synchronized (medicoCompartido) {

                    System.out.println("Esta es la fila "+ this.getName()+ " cuota médico: "+ Medicos.cuotaMedico);
                    // Mensaje de guia



                    if (Medicos.cuotaMedico == 0) {

                        System.out.println("Cambio de turno. ");
                        Medicos.cuotaMedico = 20;

                    }else {
                        pacientes.malestar();
                        medicoCompartido.atender();
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


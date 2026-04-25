import java.util.PriorityQueue;

public class SistemaHospital {

    PriorityQueue<Paciente> colaAlta = new PriorityQueue<>();
    PriorityQueue<Paciente> colaMedia = new PriorityQueue<>();
    PriorityQueue<Paciente> colaBaja = new PriorityQueue<>();

    int alta = 0;
    int media = 0;
    int baja = 0;

    int tiempo = 0;
    String mayorEspera = "";
    int maxTiempo = 0;

    public void registrarPaciente(Paciente p) {
        Triaje t = new Triaje();
        String nivel = t.determinarPrioridad(p);

        if (nivel.equals("ALTA")) {
            colaAlta.add(p);
        } else if (nivel.equals("MEDIA")) {
            colaMedia.add(p);
        } else {
            colaBaja.add(p);
        }
    }

    public void simularAtencion() {
        System.out.println("INICIO DE ATENCION");

        while (!colaAlta.isEmpty() || !colaMedia.isEmpty() || !colaBaja.isEmpty()) {

            // 3 de alta
            for (int i = 0; i < 3 && !colaAlta.isEmpty(); i++) {
                Paciente p = colaAlta.poll();
                tiempo++;
                System.out.println("[ALTA] " + p);
                alta++;

                if (tiempo > maxTiempo) {
                    maxTiempo = tiempo;
                    mayorEspera = p.getId();
                }
            }

            // 2 de media
            for (int i = 0; i < 2 && !colaMedia.isEmpty(); i++) {
                Paciente p = colaMedia.poll();
                tiempo++;
                System.out.println("[MEDIA] " + p);
                media++;

                if (tiempo > maxTiempo) {
                    maxTiempo = tiempo;
                    mayorEspera = p.getId();
                }
            }

            // 1 de baja
            if (!colaBaja.isEmpty()) {
                Paciente p = colaBaja.poll();
                tiempo++;
                System.out.println("[BAJA] " + p);
                baja++;

                if (tiempo > maxTiempo) {
                    maxTiempo = tiempo;
                    mayorEspera = p.getId();
                }
            }

            System.out.println("----");
        }

        System.out.println("NO QUEDAN PACIENTES");

        // estadísticas simples
        System.out.println("\nESTADISTICAS");
        System.out.println("Alta: " + alta);
        System.out.println("Media: " + media);
        System.out.println("Baja: " + baja);
        System.out.println("Mayor espera: " + mayorEspera);
    }
}
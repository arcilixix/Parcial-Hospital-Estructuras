public class Paciente implements Comparable<Paciente> {
    String id;
    int edad;
    String antecedentes;
    String dolencia;
    String signos;
    int dolor;
    String social;

    public Paciente(String id, int edad, String antecedentes, String dolencia, String signos, int dolor, String social) {
        this.id = id;
        this.edad = edad;
        this.antecedentes = antecedentes;
        this.dolencia = dolencia;
        this.signos = signos;
        this.dolor = dolor;
        this.social = social;
    }

    // 👇 AQUÍ lo agregas (debajo del constructor por ejemplo)
    public String getId() {
        return id;
    }

    @Override
    public int compareTo(Paciente otro) {
        if (this.dolor != otro.dolor) {
            return Integer.compare(otro.dolor, this.dolor);
        }
        return Integer.compare(otro.edad, this.edad);
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Dolor: " + dolor + " | Edad: " + edad + " | Motivo: " + dolencia;
    }
}
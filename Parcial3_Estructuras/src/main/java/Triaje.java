public class Triaje {
    public String determinarPrioridad(Paciente p) {

        if (p.signos.contains("85%") || p.signos.contains("89%") || p.dolencia.contains("torácico")) {
            return "ALTA";
        }
        if (p.dolencia.equalsIgnoreCase("Golpe en la cabeza") || p.dolor >= 8) {
            return "ALTA";
        }
        if ((p.edad >= 70 && p.social.equalsIgnoreCase("Vive solo")) || p.social.equalsIgnoreCase("Menor de edad")) {
            return "ALTA";
        }


        if (p.antecedentes.equalsIgnoreCase("Diabetes") || p.dolor >= 5 || p.dolencia.contains("Fiebre")) {
            return "MEDIA";
        }

        return "BAJA";
    }
}
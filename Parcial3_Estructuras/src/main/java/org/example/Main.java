import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        SistemaHospital hospital = new SistemaHospital();

        String jsonString = "["
                + "{\"id\":\"P1\",\"edad\":72,\"antecedentes\":\"Hipertensión\",\"dolencia\":\"Dolor torácico\",\"signos\":\"SatO2 89%\",\"dolor\":8,\"social\":\"Vive solo\"},"
                + "{\"id\":\"P2\",\"edad\":35,\"antecedentes\":\"Ninguno\",\"dolencia\":\"Fiebre persistente\",\"signos\":\"39.2\",\"dolor\":6,\"social\":\"Acompañado\"},"
                + "{\"id\":\"P3\",\"edad\":5,\"antecedentes\":\"Ninguno\",\"dolencia\":\"Golpe en la cabeza\",\"signos\":\"estables\",\"dolor\":7,\"social\":\"Menor de edad\"},"
                + "{\"id\":\"P4\",\"edad\":60,\"antecedentes\":\"Diabetes\",\"dolencia\":\"Dolor abdominal fuerte\",\"signos\":\"SatO2 93%\",\"dolor\":7,\"social\":\"Acompañado\"},"
                + "{\"id\":\"P5\",\"edad\":25,\"antecedentes\":\"Ninguno\",\"dolencia\":\"Dolor de cabeza leve\",\"signos\":\"normal\",\"dolor\":3,\"social\":\"Acompañado\"},"
                + "{\"id\":\"P6\",\"edad\":40,\"antecedentes\":\"Cáncer\",\"dolencia\":\"Dificultad respiratoria\",\"signos\":\"SatO2 85%\",\"dolor\":9,\"social\":\"Acompañado\"}"
                + "]";

        JSONArray listaPacientes = new JSONArray(jsonString);

        for (int i = 0; i < listaPacientes.length(); i++) {
            JSONObject json = listaPacientes.getJSONObject(i);
            Paciente p = new Paciente(
                    json.getString("id"),
                    json.getInt("edad"),
                    json.getString("antecedentes"),
                    json.getString("dolencia"),
                    json.getString("signos"),
                    json.getInt("dolor"),
                    json.getString("social")
            );
            hospital.registrarPaciente(p);
        }

        hospital.simularAtencion();
    }
}
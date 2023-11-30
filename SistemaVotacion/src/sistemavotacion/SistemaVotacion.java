/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemavotacion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author vans
 */
public class SistemaVotacion {

    private List<Candidato> candidatos;
    private List<Votante> votantes;
    private Map<String, String> votos;

    public SistemaVotacion() {
        this.candidatos = new ArrayList<>();
        this.votantes = new ArrayList<>();
        this.votos = new HashMap<>();
    }

    public void registrarVotante(String nombre) {
        this.votantes.add(new Votante(nombre));
    }

    public void agregarCandidato(String nombre) {
        this.candidatos.add(new Candidato(nombre));
    }

    public void realizarVoto(String votante, String candidato) {
        this.votos.put(votante, candidato);
    }

    public Map<String, Integer> contarVotos() {
        Map<String, Integer> resultados = new HashMap<>();

        for (String votante : this.votos.keySet()) {
            String candidato = this.votos.get(votante);

            if (!resultados.containsKey(candidato)) {
                resultados.put(candidato, 0);
            }

            resultados.put(candidato, resultados.get(candidato) + 1);
        }

        return resultados;
    }

    public static void main(String[] args) {
        SistemaVotacion sistemaVotacion = new SistemaVotacion();

        // Registramos dos votantes
        sistemaVotacion.registrarVotante("Juan");
        sistemaVotacion.registrarVotante("María");

        // Agregamos dos candidatos
        sistemaVotacion.agregarCandidato("Pedro");
        sistemaVotacion.agregarCandidato("María");

        // Simulamos el proceso de votación
        sistemaVotacion.realizarVoto("Juan", "Pedro");
        sistemaVotacion.realizarVoto("María", "Pedro");

        // Contamos los votos
        Map<String, Integer> resultados = sistemaVotacion.contarVotos();

        // Imprimimos los resultados
        System.out.println("Resultados de la elección:");
        for (String candidato : resultados.keySet()) {
            System.out.println("- " + candidato + ": " + resultados.get(candidato));
        }
    }
}

class Candidato {

    private String nombre;

    public Candidato(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

class Votante {

    private String nombre;

    public Votante(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}

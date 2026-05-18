package ejercicio3;

import java.util.List;

public class Solucion3 {
	
	/* public static Solucion3 create(GraphPath<---, ---> gp) { Para A* y BT
		TODO obtiene la lista de alternativas del camino y llama al otro factoria
	}*/

    public static Solucion3 create(List<Integer> ls) {
        return new Solucion3(ls);
    }

    private String camino;
    private Double totalTime, totalEffort, totalMns;

    private Solucion3(List<Integer> ls) {  // Lista de acciones/alternativas
    	this.totalTime = 0.0;
    	this.totalEffort = 0.0;
    	this.totalMns = 0.0;
    	
    	// Sabemos por tu clase Vertex3 que el inicio es el vértice 0
    	Integer actual = 0; 
    	
    	// Para ir guardando la ruta y luego formatearla
    	List<String> nodosCamino = new java.util.ArrayList<>();
    	nodosCamino.add(Datos3.getVertex(actual).nombre()); // O simplemente .toString()
    	
    	// Recorremos las decisiones tomadas (la lista de intersecciones destino)
    	for (Integer destino : ls) {
    		this.totalTime += Datos3.tiempo(actual, destino);
    		this.totalEffort += Datos3.esfuerzo(actual, destino);
    		
    		// Verificamos si pasamos de un monumento a otro
    		if (Datos3.sonMonumentos(actual, destino)) {
    			this.totalMns += 1.0; 
    		}
    		
    		nodosCamino.add(Datos3.getVertex(destino).nombre());
    		actual = destino;
    	}
    	
    	this.camino = "Camino: " + String.join(" -> ", nodosCamino);
    }
	@Override
    public String toString() {
    	String s1 = String.format("\nTiempos (total/maximo): %.1f / %.1f", totalTime, Datos3.maxTime);
    	String s2 = String.format("\nEsfuerzo total: %.1f", totalEffort);
    	String s3 = String.format("\nNº de monumentos visitados antes o despues de otro: %d", totalMns.intValue());
    	return camino+s1+s2+s3;
    }

}
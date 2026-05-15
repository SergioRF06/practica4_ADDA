package tests.ejercicio1;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import ejercicio1.Datos1;
import ejercicio1.Edge1;
import ejercicio1.Heuristic1;
import ejercicio1.Solucion1;
import ejercicio1.Vertex1;
import ejercicio1.Vertex1I;
import us.lsi.graphs.alg.AStar;
import us.lsi.graphs.virtual.EGraph;
import us.lsi.graphs.virtual.EGraph.Type;
import us.lsi.path.EGraphPath.PathType;

public class TestsAStar {

	public static void main(String[] args) {

	// Set up
	Locale.setDefault(Locale.of("en", "US"));

	for (Integer id_fichero = 1; id_fichero < 3; id_fichero++) {

		Datos1.iniDatos("datos_entrada/ejercicio1/DatosEntrada" + id_fichero + ".txt");
		System.out.println("\n\n>\tResultados para el test " + id_fichero + "\n");
//		Datos1.toConsole();

		// V�rtices clave

		Vertex1 start = Vertex1I.initial();

		// Grafo
		
		EGraph<Vertex1, Edge1> graph = 
				EGraph.virtual(start)
				.pathType(PathType.Sum)
				.type(Type.Max)
				.edgeWeight(x-> x.weight())
				.heuristic(Heuristic1::heuristic)
				.build();

		System.out.println("\n\n#### Ej1 Algoritmo Astar ####");
		
		AStar<Vertex1, Edge1,?> aStar = AStar.ofGreedy(graph);
		
		List<Integer> gp_as = aStar.search().get().getEdgeList().stream().map(x -> x.action())
				.collect(Collectors.toList()); // getEdgeList();
		Solucion1 s_as = Solucion1.create(gp_as);
		System.out.println(s_as);
	}

	}
}

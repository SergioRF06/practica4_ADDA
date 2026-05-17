package tests.ejercicio2;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.jgrapht.GraphPath;

import ejercicio2.Datos2;
import ejercicio2.Edge2;
import ejercicio2.Heuristic2;
import ejercicio2.Solucion2;
import ejercicio2.Vertex2;
import us.lsi.graphs.alg.AStar;
import us.lsi.graphs.virtual.EGraph;
import us.lsi.path.EGraphPath.PathType;
import us.lsi.graphs.virtual.EGraph.Type;


public class TestsAStar {

	public static void main(String[] args) throws IOException {


		// Set up
		Locale.setDefault(Locale.of("en", "US"));

		for (Integer id_fichero = 1; id_fichero < 4; id_fichero++) {

			Datos2.iniDatos("datos_entrada/ejercicio2/DatosEntrada" + id_fichero + ".txt");
			System.out.println("\n\n>\tResultados para el test " + id_fichero + "\n");
//			Datos2.toConsole();

			// V�rtices clave

			Vertex2 start = Vertex2.start();

			// Grafo
			
			EGraph<Vertex2, Edge2> graph = 
					EGraph.virtual(start)
					.pathType(PathType.Sum)
					.type(Type.Max)
					.edgeWeight(x-> x.weight())
					.heuristic(Heuristic2::heuristic)
					.build();

			System.out.println("\n\n#### Ej2 Algoritmo Astar ####");
			
			AStar<Vertex2, Edge2,?> aStar = AStar.ofGreedy(graph);
			

			var result = aStar.search();

			if (result.isEmpty()) {
			    System.out.println("No se ha encontrado ninguna solución válida para este test.");
			    continue; // Salta al siguiente id_fichero
			}

			GraphPath<Vertex2, Edge2> gp = result.get();
			
			List<Integer> gp_as = gp.getEdgeList().stream().map(x -> x.action())
					.collect(Collectors.toList()); // getEdgeList();
			
			Solucion2 s_as = Solucion2.create(gp_as);
			
			System.out.println(s_as);
			System.out.println(gp_as);

		}

	}
}
package tests.ejercicio2;

import java.io.IOException;
import java.util.Locale;
import java.util.Optional;

import org.jgrapht.GraphPath;

import ejercicio2.Datos2;
import ejercicio2.Edge2;
import ejercicio2.Heuristic2;
import ejercicio2.Solucion2;
import ejercicio2.Vertex2;
import us.lsi.graphs.alg.BT;
import us.lsi.graphs.alg.GreedyOnGraph;
import us.lsi.graphs.virtual.EGraph;
import us.lsi.graphs.virtual.EGraph.Type;
import us.lsi.path.EGraphPath.PathType;

public class TestsBT {

	public static void main(String[] args) throws IOException {
		// TODO Consulte los ejemplos del repositorio

		// Set up
		Locale.setDefault(Locale.of("en", "US"));

		for (Integer id_fichero = 1; id_fichero < 4; id_fichero++) {

			Datos2.iniDatos("datos_entrada/ejercicio2/DatosEntrada" + id_fichero + ".txt");
			System.out.println("=============");
			System.out.println("\tResultados para el test " + id_fichero + "\n");
			
//			Datos2.toConsole("ficheros/p4/multiconjuntos" + id_fichero + ".txt");

			// V�rtices clave

			Vertex2 start = Vertex2.start();

			// Grafo

			

			System.out.println("\n#### Algoritmo BT ####");
			
			// Algoritmo BT
			
			EGraph<Vertex2, Edge2> graph =
					EGraph.virtual(start)
					.pathType(PathType.Sum)
					.type(Type.Max)
					.edgeWeight(x -> x.weight())
					.heuristic(Heuristic2::heuristic)
					.build();
			
			
			GreedyOnGraph<Vertex2, Edge2> rr = GreedyOnGraph.of(graph);
			
			GraphPath<Vertex2, Edge2> r = rr.path();
			
			System.out.println("Voraz = "+r.getWeight()+"  == "+Solucion2.create(r));
			
			BT<Vertex2, Edge2, Solucion2> bta = BT.of(graph,
					Solucion2::create, null, null, true);

			if (rr.isSolution(r)) {
				bta = BT.of(graph, Solucion2::create, r.getWeight(), r, true);
			}
			Optional<GraphPath<Vertex2, Edge2>> gp = bta.search();
			System.out.println(Solucion2.create(gp.get()));
			
//			System.out.println(bta.path.getEdgeList().stream().map(x -> x.action())
//					.collect(Collectors.toList()));
			
			
//			GraphColors.toDot(bta.graph(), "ficheros_generados/p4/ejemplo2/multiconjuntosBTGraph.gv", 
//					v -> v.toGraph(),
//					e -> e.action().toString(), 
//					v -> GraphColors.colorIf(Color.red, Vertex2.goal().test(v)),
//					e -> GraphColors.colorIf(Color.red, bta.optimalPath.getEdgeList().contains(e)));

		}

	}	
}
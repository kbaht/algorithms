package graph

class Edge<T> {
    def from
    def to

    Edge(T from, T to) {
        this.from = from
        this.to = to
    }
}

class WeightedEdge<T, W> extends Edge<T> {
    def weight

    WeightedEdge(T from, T to, W weight) {
        super(from, to)
        this.weight = weight
    }
}

class Graph<T, E> {
    protected Map<T, List<E>> adj = new HashMap<>()

    Set<T> vertices() {
        return adj.keySet()
    }

    List<E> neighbour(T vertex) {
        return adj.get(vertex)
    }

}

class UndirectedGraph<T> extends Graph<T, T> {
    void addEdge(T u, T v) {
        if (adj.get(u) == null) {
            adj.put(u, new ArrayList<>())
        }
        if (adj.get(v) == null) {
            adj.put(v, new ArrayList<>())
        }
        adj.get(u).add(v)
        adj.get(v).add(u)
    }
}

class DirectedGraph<T> extends Graph<T, Edge<T>> {
    void addEdge(Edge<T> edge) {
        if (adj.get(edge.from) == null) {
            adj.put(edge.from, new ArrayList<>())
        }
        adj.get(edge.from).add(edge)
    }
}

class WeightedDiGraph<T> extends DirectedGraph<T> {}
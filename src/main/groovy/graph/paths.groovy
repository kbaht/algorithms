package graph

def asyclicSp(WeightedDiGraph graph, start) {
    def edgeTo = []
    def distTo = [:]
    for (vertex in graph.vertices()) {
        distTo[vertex] = Double.POSITIVE_INFINITY
    }
    distTo[start] = 0.0
    def top = new dfs()
    def sorted = top.topologicalSort(graph)
    for (vertex in sorted) {
        relax(graph, vertex, distTo, edgeTo)
    }
    return distTo
}

def relax(WeightedDiGraph graph, vertex, distTo, edgeTo) {
    for (WeightedEdge edge in graph.neighbour(vertex)) {
        def to = edge.to
        if (distTo[to] > distTo[vertex] + edge.weight) {
            distTo[to] = distTo[vertex] + edge.weight
            edgeTo[to] = edge
        }
    }
}

def dijkstra(WeightedDiGraph graph, start) {
    def edgeTo = []
    def distTo = [:]
    def pq = new PriorityQueue()
    for (vertex in graph.vertices()) {
        pq.add(Double.POSITIVE_INFINITY)
    }
    pq.add(0.0)
    while (!pq.empty) {
        relaxDij(graph, pq.remove(), pq, distTo, edgeTo)
    }
}

def relaxDij(WeightedDiGraph p, vertex, PriorityQueue pq, distTo, edgeTo) {
    for (WeightedEdge edge in graph.neighbour(vertex)) {
        def to = edge.to
        if (distTo[to] > distTo[vertex] + edge.weight) {
            distTo[to] = distTo[vertex] + edge.weight
            edgeTo[to] = edge
            if (pq.contains(to)) {
                pq.
            }
        }
    }
}

def g = new WeightedDiGraph()
g.addEdge(new WeightedEdge(5, 4, 0.35))
g.addEdge(new WeightedEdge(5, 7, 0.28))
g.addEdge(new WeightedEdge(5, 1, 0.32))
g.addEdge(new WeightedEdge(4, 7, 0.37))
g.addEdge(new WeightedEdge(4, 0, 0.38))
g.addEdge(new WeightedEdge(0, 2, 0.26))
g.addEdge(new WeightedEdge(3, 7, 0.39))
g.addEdge(new WeightedEdge(1, 3, 0.29))
g.addEdge(new WeightedEdge(7, 2, 0.34))
g.addEdge(new WeightedEdge(6, 2, 0.40))
g.addEdge(new WeightedEdge(3, 6, 0.52))
g.addEdge(new WeightedEdge(6, 0, 0.58))
g.addEdge(new WeightedEdge(6, 4, 0.93))
g.addEdge(new WeightedEdge(2, 2, 0.00))
println(asyclicSp(g, 5, 2))


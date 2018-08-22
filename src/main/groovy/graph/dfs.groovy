package graph

class DFSResult {
    def parent = [:]
    def startTime = [:]
    def finishTime = [:]
    def edges = [:]
    def order = []
    def t = 0
}

def dfs(Graph g) {
    def res = new DFSResult()
    for (vertex in g.vertices()) {
        if (!res.parent.containsKey(vertex)) {
            dfsVisit(g, vertex, res)
        }
    }
    return res
}


def dfsVisit(Graph g, vertex, DFSResult res, parent = null) {
    res.parent[vertex] = parent
    res.t += 1
    res.startTime[vertex] = res.t
    if (parent != null) {
        res.edges[new Tuple(parent, vertex)] = 'tree'
    }
    for (Edge edge in g.neighbour(vertex)) {
        if (!res.parent.containsKey(edge.to)) {
            dfsVisit(g, edge.to, res, vertex)
        } else if (!res.finishTime.containsKey(edge.to)) {
            res.edges[new Tuple(vertex, edge.to)] = 'back'
        } else if (res.startTime[vertex] < res.startTime[edge.to]) {
            res.edges[new Tuple(vertex, edge.to)] = 'forward'
        } else res.edges[new Tuple(vertex, edge.to)] = 'cross'
    }
    res.t += 1
    res.finishTime[vertex] = res.t
    res.order.add(vertex)
}

def topologicalSort(DirectedGraph g) {
    def result = dfs(g)
    return result.order.reverse()
}

def dg = new DirectedGraph()
dg.addEdge(new Edge(0, 1))
dg.addEdge(new Edge(0, 4))
dg.addEdge(new Edge(1, 2))
dg.addEdge(new Edge(1, 5))
dg.addEdge(new Edge(2, 4))
dg.addEdge(new Edge(2, 5))
dg.addEdge(new Edge(2, 6))
dg.addEdge(new Edge(3, 5))
dg.addEdge(new Edge(4, 6))
dg.addEdge(new Edge(5, 6))
dg.addEdge(new Edge(6, 7))
print(topologicalSort(dg))

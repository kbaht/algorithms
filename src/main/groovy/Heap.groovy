def makeHeap(data) {
    for (i in 0..<data.size()) {
        def idx = i
        while (idx != 0) {
            def parent = (idx - 1).intdiv(2)
            if (data[idx] <= data[parent]) break
            def temp = data[idx]
            data[idx] = data[parent]
            data[parent] = temp
            idx = parent
        }
    }
    return data
}

def data = [3, 1, 2, 7, 5, 4]
println(makeHeap(data))
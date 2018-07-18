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

def removeTopItem(data, count) {
    def result = data[0]
    data[0] = data[count - 1]
    def idx = 0
    while (true) {
        def child1 = 2 * idx + 1
        def child2 = 2 * idx + 2
        if (child1 >= count) child1 = idx
        if (child2 >= count) child2 = idx
        if (data[idx] >= data[child1] &&
                data[idx] >= data[child2]) {
            break
        }
        def swap_child = child2
        if (data[child1] > data[child2]) {
            swap_child = child1
        }
        def temp = data[idx]
        data[idx] = data[swap_child]
        data[swap_child] = temp
        idx = swap_child
    }
    return result
}

def heapSort(data) {
    makeHeap(data)
    for (i in (data.size() - 1)..<0) {
        def value = removeTopItem(data, i + 1)
        data[i] = value
    }
    return data
}

def data = [3, 1, 2, 7, 5, 4]
println(heapSort(data))
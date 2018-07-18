def maxHeapify(data, idx, heapSize) {
    def left = 2 * idx + 1
    def right = 2 * idx + 2
    def largest = idx
    if (left < heapSize && data[left] > data[idx]) {
        largest = left
    }
    if (right < heapSize && data[right] > data[largest]) {
        largest = right
    }

    if (largest != idx) {
        def temp = data[largest]
        data[largest] = data[idx]
        data[idx] = temp
        data = maxHeapify(data, largest, heapSize)
    }
    return data
}

def buildMaxHeap(data) {
    def start = data.size().intdiv(2) - 1
    for (i in start..0) {
        data = maxHeapify(data, i, data.size())
    }
    return data
}

def heapSort(data) {
    data = buildMaxHeap(data)
    def heapSize = data.size()
    while (heapSize != 0) {
        def temp = data[heapSize - 1]
        data[heapSize - 1] = data[0]
        data[0] = temp
        heapSize--
        data = maxHeapify(data, 0, heapSize)
    }
    return data
}

def data = [3, 1, 2, 7, 5, 4]
println(heapSort(data))
def insertionSort(data) {
    for (i in 1..data.size() - 1) {
        def key = data[i]
        def j = i - 1
        while (data[j] > key && j >= 0) {
            data[j + 1] = data[j]
            j--
        }
        data[j + 1] = key
    }
    return data
}

def selectionSort(data) {
    for (i in 0..data.size() - 2) {
        def min = i
        for (j in i + 1..data.size() - 1) {
            if (data[j] < data[min]) {
                min = j
            }
        }
        if (min != i) {
            def temp = data[i]
            data[i] = data[min]
            data[min] = temp
        }
    }
    return data
}

def bubbleSort(data) {
    for (i in 0..<data.size()) {
        def isSorted = true
        for (j in 1..<data.size() - i) {
            if (data[j - 1] > data[j]) {
                def temp = data[j]
                data[j] = data[j - 1]
                data[j - 1] = temp
                isSorted = false
            }
        }
        if (isSorted) {
            break
        }
    }
    return data
}

def data = [3, 1, 2, 7, 5, 4]
println(bubbleSort(data))
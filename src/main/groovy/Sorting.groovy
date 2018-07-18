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
}

def quickSort(data, start, end) {
    if (start >= end) return
    def divider = data[start]
    def lo = start
    def hi = end
    for (; ;) {
        while (data[hi] >= divider) {
            hi--
            if (hi <= lo) break
        }
        if (hi <= lo) {
            data[lo] = divider
            break
        }
        data[lo] = data[hi]
        lo++
        while (data[lo] < divider) {
            lo++
            if (lo >= hi) break
        }
        if (lo >= hi) {
            lo = hi
            data[hi] = divider
            break
        }
        data[hi] = data[lo]
    }
    quickSort(data, start, lo - 1)
    quickSort(data, lo + 1, end)
}

def mergeSort(data, scratch, start, end) {
    if (start == end) return
    def midpoint = (start + end).intdiv(2)
    mergeSort(data, scratch, start, midpoint)
    mergeSort(data, scratch, midpoint + 1, end)

    def leftIdx = start
    def rightIdx = midpoint + 1
    def scratchIdx = leftIdx

    while ((leftIdx <= midpoint) && (rightIdx <= end)) {
        if (data[leftIdx] <= data[rightIdx]) {
            scratch[scratchIdx] = data[leftIdx]
            leftIdx++
        } else {
            scratch[scratchIdx] = data[rightIdx]
            rightIdx++
        }
        scratchIdx++
    }
    for (int idx = leftIdx; idx <= midpoint; idx++) {
        scratch[scratchIdx] = data[idx]
        scratchIdx++
    }
    for (int idx = rightIdx; idx <= end; idx++) {
        scratch[scratchIdx] = data[idx]
        scratchIdx++
    }
    for (idx in start..end) {
        data[idx] = scratch[idx]
    }
}

def countingSort(data, int maxValue) {
    def counts = new int[maxValue + 1]

    for (i in 0..<data.size()) {
        counts[data[i]]++
    }

    def idx = 0

    for (i in 0..maxValue) {
        for (j in 0..<counts[i]) {
            data[idx] = i
            idx++
        }
    }
}
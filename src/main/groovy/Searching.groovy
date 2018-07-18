//Алгоритмы поиска для отсортированных массивов

def linearSearch(data, target) {
    for (i in 0..<data.size()) {
        if (data[i] == target) {
            return i
        }
        if (data[i] > target) return -1
    }
    return -1
}

def binarySearch(data, target) {
    def min = 0
    def max = data.size() - 1
    while (min <= max) {
        def mid = (min + max).intdiv(2)
        if (target < data[mid]) max = mid - 1
        else if (target > data[mid]) min = mid + 1
        else return mid
    }
    return -1
}

def interpolationSearch(data, target) {
    def min = 0
    def max = data.size() - 1
    println(data)
    while (min <= max) {
        if (data[max] - data[min] == 0) return -1
        def mid = min + ((max - min) * (target - data[min])).intdiv(data[max] - data[min])
        println "$mid = $min + (($max - $min) * ($target - ${data[min]})).intdiv(${data[max]} - ${data[min]})"
        mid = (int) mid % max

        if (target < data[mid]) {
            max = mid - 1
        } else if (target > data[mid]) min = mid + 1
        else return mid
    }
    return -1
}
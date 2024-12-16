# Maths

Geometric: `Sn = 1+r+r^2+...+r^{n-1}=\frac{r^n-1}{r-1}`
Arithmetric: `Sn = n(\frac{a_1+a_n}{2})`

# Time complexity

Big notations: `T(n) in O(g(n)) iff exists c > 0 st. T(n)<=c.g(n) for all n>n_0`
Small notations: `T(n) in o(g(n)) if for all c > 0 exists n_0 >=0  st. T(n)<c.g(n) for all n > n_0`

Sum of square numbers: `Theta(n^3)`
Sum of numbers: `Theta(n^2)`

Lower bound comparison sort: `log(n!) = Theta(nlogn)`

# Hash tables

Array: A `O(1)` I `O(n)`
Hash table: AI `Theta(1) O(n)`

`a = n / m` where m is the size of the table

**Averages**
Chaining:

- `Sn = 1 + a / 2`
- `Un = a`
- Space: `m(p) + n(p+e)`

Open addressing:

- `Sn=1/2(1+1/1-a)`
- `Un=1/2(1+1/(1-a)^2)`
- Space: `m(e)`

# AVL balancing

```py
if B(T) > 1:
    if B(T.left) < 0: leftRotate(T.left)
    rightRotate(T)
if B(T) < 1:
    if B(T.right) > 0: rightRotate(T.right)
    leftRotate(t)
```

# Heaps

left child: `2i+1`
right child: `2i+2`

Heapify: `O(logn)`

```py
def heapify(node):
    if node children c greater than node value:
        swap node and children
        heapify(largest)
```

Build heap: `O(n)`

```py
def build_heap(array):
    for i in array from n/2-1 backwards:
        heapify(i)
```

# Algorithms

## Traversal

**DFS**:

- Preorder: root->left->right
- Inorder: left->root->right
- Postorder: left->right->root

**BFS**: Visit node from closest to furthest

```py
def BFS(T):
    q = Queue()
    q.enqueue(T.root)
    queued = [T.root]
    while q not empty:
        current = q.dequeue()
        print(current)
        for children of current:
            if child is not visited:
                q.enqueue(child)
                queued.push(child)
```

## Search for

**jump**: `O(\sqrt(n))`

```py
def jump(array, n, x):
    size = sqrt(n)
    for i in range(n) interval size:
        if array[i] > x:
            for j in range(0,size):
                if array[i-j] == x:
                    return i-j
```

**binary** `O(logn)`

```py
def binary(array, n, x):
    mid = n // 2
    val = array[mid]
    if x == val: return mid
    if x < val:
        return binary(array before mid, mid, x)
    else:
        return binary(array after mid, n-1-mid, x)
```

**get k-smallest elements**

```py
def ksmallest(array, k):
    minheap = Heap()
    for i in range(k) reversed:
        array[i] = heapify(array, i)
    for i, x in array after k:
        if x > array[0]:
            array[0] = x
            heapify(array, i)
    return array from 0 to k
```

**kth smallest element**: `Theta(n) O(n^2)`

```py
def quickselect(array, k):
    if !array[1] return array[0]

    pi = partition(array)

    if pi == k - 1: return array[pi]

    if pi < k - 1:
        return quickselect(array after pi, k)
    else:
        return quickselect(array before pi, k)
```

## Sorting

**Selection**: `O(n^2)`

```py
def selection(array, n):
    for i in array:
        smallest = i
        for j in array after i:
            if array[smallest] > array[j]:
                smallest = j
        swap(array, smallest, i)
```

**Bubble**: `O(n^2) Omega(n)` [STABLE]

Best case when already sorted

```py
def bubble(a, n):
    for i in a:
        swapped = False
        for j in a before i - n - 1:
            if a[j] > a[j+1]:
                swap(a, j, j+1)
        if not swapped break
```

**Insertion**: `O(n^2) Omega(n)` [STABLE]

```py
def insertion(a, n):
    for i in a from 1:
        for j in a before i:
            if a[j] > a[i]:
                swap(a, i, j)
            else:
                break
```

**Heap**: `O(nlogn) // O(1)`

```py
def heapsort(a, n):
    create_max_heap(a)

    for i in a:
        swap(a, 0, n-i)
        heapify(a from 0 to n-i-1)
```

**Merge**: `O(nlogn) // O(n)` [STABLE]

```py
def mergesort(a, n):
    def merge(a1, a2):
        result = []
        while a1 and a2:
            if a1[0] < a2[0]:
                result.push(a1.pop(0))
            else:
                result.push(a1.pop(0))
        return result + a1 + a2

    if n < 2 return a
    mid = n // 2
    return merge(mergesort(a before mid, mid), mergesort(a from mid, n - mid))
```

**Quick**: `Theta(nlogn) O(n^2) // O(logn) call stack`

```py
def quicksort(a):
    def partition(a):
        pi = random i from a
        swap = -1
        for i in a:
            if a[i] <= a[pi]:
                swap += 1
                swap(a, swap, i)
        pa = swap + 1
        swap(a, pi, pa)
        return pa

    if len(a) < 2 return
    pi = partition(a)
    quicksort(a before pivot)
    quciksort(a after pivot)
```

**Count**: `O(n+k) // O(n+k)`

```py
def count(a, k):
    counter = Array(k)
    for i, x in a:
        counter[x] += 1

    for i in counter after 0:
        counter[i] += counter[i-1]

    result = Array(len(a))
    for x in a:
        result[counter[x]] = x
        counter[x] -= 1

    return result
```

**Radix**: `O(d(n+k)) // O(n+k)`

```py
function radix_sort(array, b=10):
    function countin_sort_exp(i):
        function get_key(n):
            return ith digit of n in base b (0 based)
            # (n // b**i) % b

        counter = Array(b)
        for i in array:
            key = get_key(i)
            counter[key] += 1

            for i in counter after 0:
                counter[i] += counter[i-1]

            result = Array(len(array))
            for x in array:
                key = get_key(x)
                result[counter[key]] = x
                counter[key] -= 1
            array = result

    d = len(max(array))

    for i from 0 to d - 1:
        counting_sort_exp(i)
```

## K-sorting

**By selection sort** `O(kn) // O(1)`

```py
def ksortselection(a, k):
    for i in a:
        min = i
        for j from 0 to k:
            if a[min] > a[j]:
                min = j
        swap(a, min, i)
```

**By heap** `O(n log k) // O(k)`

```py
def ksortheap(a,k):
    minheap = Heap(k)

    for i from 0 to k-1:
        minheap.push(a[i])

    i = 0
    for x in a from k:
        a[i] = minheap.pop()
        minheap.push(x)
        i += 1

    while heap:
        a[i] = minheap.pop()
        i += 1
```

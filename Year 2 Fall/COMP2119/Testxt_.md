# Maths

Geometric:
Arithmetric:

# Time complexity

Big notations:
Small notations:

Sum of square numbers:
Sum of numbers:

Lower bound comparison sort:

# Hash tables

Array: A ` ` I ` `
Hash table: AI ` `

`a = ` where m is the

**Averages**
Chaining:

- `Sn = `
- `Un = `
- Space: ` `

Open addressing:

- `Sn = `
- `Un = `
- Space: ` `

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

left child: ` `
right child: ` `

Heapify: `O()`

```py
def heapify(node):



```

Build heap: `O()`

```py
def build_heap(array):


```

# Algorithms

## Traversal

**DFS**:

- Preorder:
- Inorder:
- Postorder:

**BFS**:

```py
def BFS(T):










```

## Search for

**jump**: `O()`

```py
def jump(array, n, x):






```

**binary** `O()`

```py
def binary(array, n, x):







```

**get k-smallest elements**

```py
def ksmallest(array, k):








```

**kth smallest element**: `Theta() O()`

```py
def quickselect(array, k):










```

## Sorting

**Selection**: ` `

```py
def selection(array, n):






```

**Bubble**: ` `

Best case when already sorted

```py
def bubble(a, n):






```

**Insertion**: ` `

```py
def insertion(a, n):






```

**Heap**: ` `

```py
def heapsort(a, n):





```

**Merge**: ` `

```py
def mergesort(a, n):












```

**Quick**: `Theta(nlogn) O(n^2)`

```py
def quicksort(a):
















```

**Count**: ` `

```py
def count(a, k):












```

**Radix**: ` `

```py
function radix_sort(array, b=10):
    function countin_sort_exp(i):
        function get_key(n):






















```

## K-sorting

**By selection sort** ` `

```py
def ksortselection(a, k):






```

**By heap** ` `

```py
def ksortheap(a,k):














```

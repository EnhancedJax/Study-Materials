def Swap(S, a, b):
    S[a], S[b] = S[b], S[a]


def Reorder(S):
    """
    Explaination:

    We use three indices to keep track of the next positions where -1, 0, and 1 should go. We iterate through the array starting with 0index.
    If S[zero] == -1:
    -> Swap -1 and 0.
    -> Increment both -1 and 0 because both pointers now point to processed elements.
    If S[zero] == 0:
    -> 0 is incremented to check next element as current is correctly placed.
    If S[zero] == 1:
    -> Swap 0 and 1.
    -> Decrement 1, without incrementing 0, because the newly placed 1 element should be processed to see if it is correct or should be in -1.

    The algorithm considers each element once, as we never revisits processed elements. Note that at S[zero] == 1, we would not increase 0, but the processed element is a new element that is unprocessed, so the statement holds true. Therefore, the time complexity is O(n).
    """
    n = len(S)
    n_one = 0  # where the next -1 should go
    zero = 0  # where the next 0 should go
    one = n - 1  # where the next 1 should go
    while zero <= one:  # zero is the current element as well
        if S[zero] == -1:
            Swap(S[n_one], S[zero])
            n_one = n_one + 1
            zero = zero + 1
        elif S[zero] == 0:
            zero = zero + 1
        else:  # S[zero] == 1
            Swap(S[zero], S[one])
            one = one - 1
    return S


if __name__ == "__main__":
    S = [1, -1, -1, 1, 0, 1, -1, 0, 1, 0]
    print(Reorder(S))
    S = [1, -1, 1, -1, -1]
    print(Reorder(S))
    S = [1, -1, 1, -1, 1]
    print(Reorder(S))

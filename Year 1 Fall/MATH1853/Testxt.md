//======////======////======////======////======////======//

# Part 1 - Matrices
## Vectors
Unit vector:    a / ||a||
Dot product:    a b = x1*x2 ... y1y2
prep.:          ab = 0

## Determinant [->det]
det 2x2:                ad - bc
det (row-echelon form): product of diagonals

|A| = 0 when:
1. Matrix has identical rows
2. Linear system has non-zero solutions

|AT| = |A|
|A^n^m| = |A^n|^m

## Dependent matrixes [det->dep]
Vectors are dependent if:
1. |A| = 0
2. Full row of 0

## Inverse [det->inv]
Matrix inverse:         A | I
Matrix inverse 2x2:     1/|A| * (d -b // -c a)
No inverse if:          |A| = 0

## Orthgonal [vec,trans->proj,orth]
Orthogonal projection of a -> b:    projba = (ab/bTb)
Component c of a perp. to vector b: c = a - projba
Linear combination of v by a,b:     v = projav + projbv
Orthnormal matrix:                  AA^T = I

## Eigenpairs [proj->eigen]
Eigen expression:   Ax=λx
Rearrange:          (A-Iλ)v=0
AM: Occurance of same λ 
PM: Size of nullspace for v
if PM > 1: find other vector then 1

## Diagonalization [eigen->diag]
Condition: AM = GM

Eigendecomposition: V-1AV = D -> A=VDV-1
    D = diagonal λ
    V = vector v

Ak = V Dk V-1
Dk = diagonals powered

Spectral decomposition: A=A^T => A=VDV^T = λxx^T + ...

## Vector span [dep->span]
span(A): Number of non-zero rows - dimension
matrix span is same if: Aγ ( γ as linear combination ) is the same
vector span is same if: Linearly dependent

## Quadratic form [eigen->def,minax]
Positive definite:  λ > 0
Negative definite:  λ < 0
Otherwise:          Indefinite
Semi if:            >=

Minimum of quadratic: λ_max {xAx^T:||x|| = 1}

## 2D space
Expressing 2D space: |x-x1 y-y1, B-A|=0

## Diffience and diffiential equations [eigen->diff]
Given x0 or x(0), solve for x[k+1] or x(t):
1. Solve eigen
2. xk = cvλ^k + ... cnvn(λn)^k
   x(t): λ^k -> e^(λt)
3. Solve c by augmented matrix (v1...vn|x(0))

//======////======////======////======////======////======//

# Part 2 - Imaginary numbers
z       = a + bi
|z|     = sqrt(a2 + b2)
conj(z) = a - bi
arg(z)  = θ = 2tan^-1(b/(a+|z|))

polar form:     z = |z|(cosθ + isinθ)
negative polar: cos θ - isin θ 
euler:          z = e^θi
1 + i=          sqrt(2) e^ipi/4

## Complex roots
for zn = k, solution: w = e^(2πi/n), kw0 ... kwn-1

## Image under function
1. f(D) = {f(g):}
2. let f(g) -> a + bi
3. z -> x + yi, find x:a and y:b
4. sub x,y -> f(D)
* |z| > 0 : circle with radius > 0

//======////======////======////======////======////======//

# Part 3 - Probability and statistics
## Permutations and combinations
nCr = n!/r!(n-r)!
Usage: The number of outcomes pick r from n independent of order
Pascal's rule: (n+1 r)=(n r) + (n r-1)

## Probability
P(A|B) = P(ANB)/P(B)
Indepedent: P(ANB) = P(A)*P(B)

E(X2)  = Σ(x2 P(X=x))
E(X+Y) = E(X) + E(Y)
Var(X) = E(X2) - E(X)2

∫f(x)    = 1
P(b>X>a) = ∫{ba}f(x)dx
E(Xn)    = ∫{ ∞ }x^nf(x)dx

for Y = aX + b
E(Y)   = aE(X) + b
Var(Y) = a2 Var(x)

If X and Y are independent:
Var(X+Y) = Var(X) + Var(Y)
E(XY)    = E(X) * E(Y)

Joint distribution:
E(X+Y)   = Σ((x+y) P(X=x, Y=y))
E((XY)2) = Σ(x2y2 P(X=x, Y=y))

For multiple random variables:
E(meanX)    = E(X) + ... + E(Xn) / n = nE(X) / n
Var(meanX)  = nVar(X) / n2 = Var(X) / n

## Distributions
*Expo*
Dist:   λe^(-λk)
E:      λ^-1
Var:    λ^-2
e^x = Σ^inf_i=0{x^i/i!}

*Ber*
E:      p   
Var:    p(1-p)

*B*: x in n
Dist:   (n x) p^x q^(n-x)
E:      np
Var:    np(1-p)

*Geometric*: 1st at x
Dist:   p q^x-1
E:      1/p
Var:    (1-p)/p2
Sum P(X > m) = Σ^inf_x=m{pq^m} = (1-p)^x

*NB*: rth at x
Dist:   (x-1 n-1)p^n q^x-n
E:      n/p
Var:    n(1-p)/p2

*Po*: x in interval
Dist:   λ^x/x! e^-λ 
E:      λ
Var:    λ 

*N*
Standardization: x - μ / σ
Z1 + Z2 -> N( μ + μ , σ + σ )

## Hypothesis
Critical interval: [meanX ± Z{cl/2} * σ / sqrt(n)]
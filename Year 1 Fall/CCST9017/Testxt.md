# Non-coop games
Dominant Strategy Equilibrium: All players have an unchanging DS
Nash Equilibrium: If no single player changes their strat given that others don't

### Properties: 
* DSE <= NE
* Every non-coop game has a MNE

To find the mixed nash equilibrium probabilites (p, q) for players A and B:
1. EA(1, q) = EA(0, q)
2. EB(p, 1) = EB(p, 0)

//============================================================//
# Coop games
Coalitional form (N;v) 
N: Grand coalition
v(S) is the value of the coalition S
symmetric players: v(i) = v(j)
null player: v(i) = 0

## Shapley value
Shap = Σ( all_perm[v(N{i,a} u i) - v(N{i,a})] ) / n!
N represents: set of players before i
a represents: specific permutation

//============================================================//
# Infectious disease modelling
Removed class: People who recovered, are immune or had died

ΔS = -αSI
ΔI = (αSt - y)I
ΔR = γI
* infectious <-> α
* γ^-1 is the average duration of infectious period
* ΔI > 0 -> infection grows

Reproduction number R0 = aS0/y

SIR / N = sir
[SIR]a -> [sir]β 
β: contact rate, contact = trasmission
α = β / γ
S0 = N -> R0 = α

## Vaccinations
To ensure herd immunity, population vaccinated = (1 - 1/α) / efficacy

//============================================================//
# Adjusted winner procedure
1. Award each item to person who values it most
2. Identify who has fewer points to split items to
3. Get give/reci value ratio -> identify lowest
4. Split item to make points even

//============================================================//
# Error-Control codes
Code rate: Data / codeword length

## Hamming code
Value 124 = XOR
Operated values: 357 367 567
Distance: bits differ from codewords
    Minimum distance = 3
Corrected codeword: the closest distance to original

//============================================================//
# Secret codes
a%b=r -> a ≡ r(mod b)
if a ≡ b, p ≡ q:
* a+p ≡ b+q
* ap ≡ bq

## RSA
Co-prime: numbers share no common factors
1. Define prime numbers p,q
2. n = pq, m = (p-1)(q-1)
3. e:
    m > e > 1
    co-prime with n
4. de%m = 1
    d = 1 + km / e
* e-key (n, e)
* d-key (n, d)
ciphertext D = C^e % n (encrypt C)
plaintext C = D^d % n (decrypt D)

//============================================================//
# Internet search (matrix)
Ni = number of outward links
Wi = 1/Ni
bi,j = Wj if (i has backlink form j) else 0

A = [0 \\ 0, row i col j]
* Num of elements in row = n-backlinks to page i
* Num of elements in col = n-outlinks from page j
* Sum row = x{1, i}
* Sum col = 1
* Calc x: x[k] = Ax[k-1]

//============================================================//
# Machine learning

## Information gain
D = (p, 1-p):
* p:        p=D.count(True)/len(D)
* Expected: I(D)=-Σ(dlog2d)
* Needed:   IA(D)=Σ(p{D->v} * I(pv, 1-pv))
* Gain:     IG=I-IA

## Clustering and SVM
Linearly separable: Points can be separated by a straiht line
k-means algorithm steps:
1. Select k random centroids
---- rpt ----
2. Calculate other point dist to centroid -> closest cluster
3. Update each centroid as mean of points
-- rpt end --
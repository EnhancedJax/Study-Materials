# UNOFFICIAL SOLUTION FOR 22DEC ENGG1330 Paper #

'''
PART A
'''
#1
i = 42
ii = i//2
print("Q01:", i, ii, i/ii, i//ii, i%ii)

#2
a = 2.0
b = a + 1
print("Q02:", 2**256%2, -1.0**18, a*b**b)

#3
x = 12.345
print("Q03:", x, str(x)*2, f'{x:.2f}')

#4
ar = 2, 3
for i in range(5, 15, 4):
    ar += i,
print("Q04:", ar)

#5
ar = [2, 3]
for i in range(15, 5, -4):
    ar += i,
print("Q05:", ar[::-1])

#6
b = [21]
a = [42, b]
b = [2]
print("Q06:", a)

#7
x = [1, 2, 3]
xx = x[1:]
x[2] = 42
print("Q07:", xx, x)

#8
d = {}
for i in range(5):
    d[i] = i**2
print("Q08:", d)

#9
doc = '<html>Hello world!!!</html>'
print("Q09:", doc.lower().strip('<>html'))

#10
s = ''
ii = 7
while True:
    i = ii
    while i>2:
        i -= 3
        s += str(i)+'+'
    s += str(i)+'-'
    ii += 1
    if ii%2:
        break
print("Q10:", s)

#11
def a(c):
    c += 1
    return c
def b(c):
    c += 3
    d = a(c)
    d += c
    return d
def c(a):
    a += 2
    return b(a)
print("Q11:", c(6))

#12
def r(p, s):
    s[0] += str(p)
    if p<7:
        r(p+1, s)
        p = p+1
        s[0] += str(p)
p = 5
s = ['']
r(p, s)
print("Q12:", p, s)

#13
n = 'Schnieders'
s = ''
for v in n:
    l=[i for i, w in enumerate(n) if w==v]
    s += str(l[-1])
print("Q13:", s)

#14
def x(a):
    if a:
        return str(a)
    else:
        return ''
s = ''
for i in range(5, 0, -4):
    for ii in range(0, i, 4):
        for iii in range(3):
                s += x(i)
        s += x(ii)
    s += x(iii)
print("Q14:", s)

'''
Q01: 42 21 2.0 2 0
Q02: 0 -1.0 54.0
Q03: 12.345 12.34512.345 12.35
Q04: (2, 3, 5, 9, 13)
Q05: [7, 11, 15, 3, 2]
Q06: [42, [21]]
Q07: [2, 3] [1, 2, 42]
Q08: {0: 0, 1: 1, 2: 4, 3: 9, 4: 16}
Q09: ello world!!!</
Q10: 4+1+1-5+2+2-
Q11: 23
Q12: 5 ['56776']
Q13: 0123476789
Q14: 555555421112
'''
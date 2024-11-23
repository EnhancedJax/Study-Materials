l = [] # [v, v, v]
d = {} # {k: v, k: v}
t = () # (v, v, v)
s = 's'
f = 3.1415
i = 3

i = i % 2 # % -> modulus (remainder) -> 1
11.0 // 5 # 2.0
11 // 5 # 2

# declare function
def func_name(param):
    return 'value to return'

# read file
for line in open('path', 'r').readlines():
    pass

# add to list
l.append('value') # same object btw
l = l + 'value' # diff object
l.insert('index', 'value') # insert value at index -> l[index] = val
l += 'balls' # ['b', 'a', 'l', 'l', 's']
l += ['0', '1'] # ['0', '1']
# sort a list
l.sort()
l = sorted(l)
# reverse a list
l.reverse()
l = reversed(l)
# remove from list
l.pop('index')

# list comprehension
method = '[expression for item in list if condition]'
l = [0, -1, 2]
l_negatives = [n for n in l if n < 0] # [-1]

# get index from value
l.index('value')

# range
method = range('start (inclusive)', 'stop (exclusive)', 'step') # gives class
list(range(1, 4))       # [1, 2, 3]
list(range(4))          # [0, 1, 2, 3]
list(range(-1, 0))      # [-1]
list(range(0, 10, 2))   # [0, 2, 4, 6, 8]

# Slicing iterables
method = 'l[start(inclusive):end(exclusive):step]' # step default = 1 (increment)
'l[start:stop]'         # items start through stop-1
'l[start:]'             # items start through the rest of the array
'l[:stop]'              # items from the beginning through stop-1
'l[:]'                  # a copy of the whole array
'l[start:stop:step]'    # start through not past stop, by step

# Replacing string
s = s.replace('word', 'replaced')
# Replacing string at index
index = 1
replaced_at_index = l[:index] + 'string' + l[index+1:]

# Strings
s = s.upper()
s = s.lower()
len(s) # gets length of string or any iterable

s = s.strip('chars') # matches any char from chars, and removes until reaching not match
'SuperBallsper'.strip('Super') #Balls

print(f'{'123':0>10}') # 0000000123
print(f'{'123':0^10}') # 0000123000
print(f'{'123':0<10}') # 1230000000

print(f'{{7 + 4}}')     # {7 + 4}
print(f'{{{7 + 4}}}')   # 11

# formatting floats
n = f
print(f'Number round to 3 dp: {n:.3f}') # Number round to 3 dp: 3.142

# Dealing with lists
try: # run the following and ignore if have errors
    pass
except: # if things ran have no errors
    pass

# char <-> ASCII id
char = 'x'
chr(ord(char)) # x 

# Mutability
def f():
    a[1] = 6
    a[2] = 2
    i = 3

a = [1, 2, 3]
i = 2
f(a, i)
print(a, i) # prints [1, 6, 2] 2, as lists are mutable while string / int aren't

a[0] = 'x' # modifies object
a.something # modifies object
a = [...] # creates new list object
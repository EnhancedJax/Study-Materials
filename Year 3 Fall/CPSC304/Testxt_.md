# 1

cKeys: 
pKey: 
superKeys: 

Many-One: 

IsA: Superclass:
    Lowerbound: 
    Upperbound: 

# 2 

...

# 3 

Trivial FD: 
Standard form: 

Inference rules:
    Reflexive: 
    Transitive: 
    Augmentation: 
    Union: 
    Decomposition: 

1NF: 
2NF: 
BCNF: 
3NF: 

? stricter than ?. 
? guarantees no redundancy, ? preserves all FDs

## Decomposition BCNF
1. 
2. 
3. 
    a. 
        - 
        - 
    b. 
    c. 
4. 

## Minimal cover
1. 
2. 
3. 

## Decomposition 3NF

- Lossless join method
    1. 
    2. 
    3. 

- Synthesis method
    1. 
    2. 
    3. 
    4. 

# 4

* selection, projection, union, intersection, set difference
* cartesian product: same named attr, refer by position index only
* rename: \rho(E1, E) or \rho(attr -> newname, E) 
* natural join: matching values in same-named attrs
* division: 

# 5

```sql
create table name (
    id char(10) primary key,
    -- attr not nuill
    ...
    -- foreign key with on delete and on update
)
```

```sql
-- assertion

-- view
```

* where before grouping
* null values: aggr ignore? 
    * count(*) 
    * count(attr) 
    * count(distinct attr) 
* % any seq
* _ any single char

* LEFT / RIGHT / FULL OUTER JOIN: includes unmatched rows with NULLs, keeping all rows from 

Conversion: R(a,b) / S(b)
```sql

```

```sql
-- insert by vlues
-- insert bu select
```
* Can add `(a1, a2, ...)` after `tablename` to specify columns

```sql
-- update table

-- delete table
```

# 6

Conversion: R(a,b) / S(b)
```
```

Recursion: find all ancestors: from Parent(parent, child):
```
Base: 
Recurse: 
```
* Continues until recursion head no longer have new results

# 7

Star schema: 

## OLAP queries

* Roll-up: 
* Drill-down: 
* Slice: 
* Dice: 
* Pivot: 

## Data cube

* `group by` combinations for n dimensions: 
* Cube size: for all dimensions i, 
* Dense cube: 
* Sparse cube size: 

## Materialization

Benefit: 
```python

```
* where subview

# 8

Pattern in data:
* Valid: 
* Novel: 
* Useful: 
* Understandable: 

Assocaition rules:
* Support: s% of t \in T 
* Confidence: c% of t \in T 
* Valid: 

Itemsets:
* Frequent: 
* n items: 

Apriori algorithm:
1. 
2. 
    a. 
    b. 
    c. 
3. 
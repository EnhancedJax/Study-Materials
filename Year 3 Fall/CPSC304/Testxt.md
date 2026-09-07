# 1

cKeys: Minimal attr sets 
pKey: Chosen from cKeys
superKeys: attr sets that contains a cKey

Many-One: Course -> WorksIn - Profs: Each course at most one prof

IsA: Superclass:
    Lowerbound: Total / Covering >= 1, Partial >= 0
    Upperbound: Disjoint <= 1, Overlapping n

# 2 

...

# 3 

Trivial FD: AB -> B
Standard form: A -> XY => A -> X and A -> Y

Inference rules:
    Reflexive: A -> A
    Transitive: A -> B, B -> C => A -> C
    Augmentation: A -> B => AC -> BC
    Union: A -> B, A -> C => A -> BC
    Decomposition: A -> BC => A -> B, A -> C

1NF: Atomic attr values
2NF: No subset of key -> non-prime
BCNF: X superkey
3NF: BCNF or Y is part of a key

BCNF stricter than 3NF. 
BCNF guarantees no redundancy, 3NF preserves all FDs

## Decomposition BCNF
1. Find all keys
2. Filter out all BCNF FDs
3. Repeat:
    a. Pick X -> Y not BCNF:
        - R1 = XY
        - R2 = R - Y
    b. Project FDs (inc. implied FDs) onto R1 and R2
    c. FDs on relationships not BCNF, repeat
4. Select leafs

## Minimal cover
1. Standard form
2. Minimize dependencies, do not remove FDs
3. Delete redunant FDs

## Decomposition 3NF

- Lossless join method
    1. Minimal cover
    2. Decompose to BCNF
    3. For each FD X -> Y lost during decomposition, add R = XY

- Synthesis method
    1. Minimal cover
    2. For each FD X -> Y, create R = XY
    3. If no relation contains key in R, add R = key
    4. Remove redundant relations (if R1 subset of R2, remove R1)

# 4

* selection, projection, union, intersection, set difference
* cartesian product: same named attr, refer by position index only
* rename: \rho(E1, E) or \rho(attr -> newname, E) 
* natural join: matching values in same-named attrs
* division: (a,b) is in R for every b in S

# 5

```sql
create table name (
    id char(10) primary key,
    attr int not null,
    ...
    foreign key (attr) references othertable(otherattr) on update cascade on delete set null
)
```

```sql
create assertion name check (condition);

create view viewname as select;
```

* where before grouping
* aggregate functions ignore null values except:
    * count(*) includes null
    * count(attr) count non-NULL values
    * count(distinct attr) count non-NULL distinct values
* % any seq
* _ any single char

* LEFT / RIGHT / FULL OUTER JOIN: includes unmatched rows with NULLs, keeping all rows from from/joined/both tables

Conversion: R(a,b) / S(b)
```sql
select distinct R1.a from R 1 -- a
where not exists (
    select S.b from S -- b
    except 
    select R2.b from R R2  -- b
    where R1.a = R2.a -- a = a
)
```

```sql
insert into tablename values (v1, ...);
insert into tablename select ...;
```
* Can add `(a1, a2, ...)` after `tablename` to specify columns

```sql
update tablename set a1 = 1, ...
where condition;

delete from tablename
where condition;
```

# 6

Conversion: R(a,b) / S(b)
```
W(a, b) :- NOT R(a, b, _)
B(a) :- R(a, _), S(b, _), NOT R(a, b)
G(a) :- R(a, _), NOT Bad(a)
```

Recursion:
```
Base: Ancestor(A, C) :- Parent(A, C)
Recurse: Ancestor(A, C) :- Parent(A, B), Ancestor(B, C)
```
* Continues until recursion head no longer have new results

# 7

Star schema: 1 fact table + dimension tables

## OLAP queries

* Roll-up: `group by` less detail
* Drill-down: `group by` more detail
* Slice: `where` on one dimension
* Dice: `where` on multiple dimensions
* Pivot: rotate data axes

## Data cube

* 2^n `group by` combinations for n dimensions
* Cube size: Product of all distinct values (d_i + 1) for all dimensions i
* Dense cube: cells > p% filled with data
* Sparse cube size: sparsity factor * dense cube size

## Materialization

Benefit: 
```python
(size(cma(view)) - size(view)) * ([for v in subview].sum(wl(v)))
```
* subview includes view itself

# 8

Pattern in data:
* Valid: Hold in general
* Novel: Not known beforehand
* Useful: Actionable knowledge
* Understandable: Easily interpreted

Assocaition rules:
* Support: s% of t \in T contain X and Y
* Confidence: c% of t \in T that contain X also contain Y
* Valid: s and c exceed s_min and c_min

Itemsets:
* Frequent: items s >= s_min
* n items: 2^n - 1 itemsets

Apriori algorithm:
1. Find F_1
2. Loop k from 2 to max itemset size
    a. Only using F_K-1, generate C_k
    b. Determine support for each C_k
    c. F_k = {c in C_k | support(c) >= s_min}
3. Return union of all F_k








---


select title from show where year=1995
Ans(t) :- Show(_, t, _, _, 1955)

select distinct d.name, c.name from dancer d join role r on r.did = d.did join show s on s.sid = r.sid join company c on r.company = c.name
where s.title = "Swan Lake" and r.role = "Black Swan"
Ans(dname, cname) :- Dancer(did, dname, _, _), Show(sid, "Swan Lake", _, _, _), Role(did, sid, "Black Swan", cname)

select distinct d.name from dancer d natural join role r natural join show s where s.choreographer = "Foss"
except
select distinct d.name from dancer d natural join role r natural join show s where s.choreographer = "Robbins"

DancerFoss(dname) :- Dancer(did, dname, _, _), Show(sid, _ "Foss", _ ,_), Role(did, sid, _, _)
DancerRobbins(dname) :- Dancer(did, dname, _, _), Show(sid, _ "Robbins", _ ,_), Role(did, sid, _, _)
Ans(dname) :- DancerFoss(dname), not DancerRobbins(dname)

select distinct d.did, d.name from dancer d join role r on d.did = r.did 
group by d.did where d.birthyear <= 1955 having count(distinct r.sid) >= 2

D(did, dname) :- Dancer(did, dname, dby, _), dby <= 1995
Did2Show(did) :- Role(did, sid1, _, _), Role(did, sid2, _, _), sid1 <> sid2
Ans(did, dname) :- D(did, dname), Did2Show(did)

select distinct d.name, r.company from dancer d join role r on d.did = r.did join company c on c.name = r.company where d.country <> c.countryOfBirth

Ans(dname, cname) :- Dancer(did, dname, _, dcountry), Role(did, _, _, cname), Company(cname, _, ccountry), ccountry <> dcountry

(did, cname) / cname
create view dids as
select distinct did from role r1
where not exists (
    select cname from company
    except
    select r2.company as cname from role r2
    where r1.did = r2.did
)

select d.name from dancers d where d.did in (select * from dids)

Bad(did) :- Role(did, _, _, _), Company(cname, _, _), not Role(did, _, _, cname)
Dids(did) :- Role(did, _, _, _), not Bad(did)
Ans(dname) :- Dids(did), Dancer(did, dname, _, _)

select d.name from dancer d join role r on r.did = d.did group by (r.did, d.name) having count(distinct r.company) = 1

AllDancersAtLeastOneCompany(dname) :- Dancer(did, dname, _, _), Role(did, _, _, _)
AllDancersMoreThanOneComapny(dname) :- Dancer(did, dname, _, _), Role(did, _, _, c1), Role(did, _, _, c2), c1 <> c2
AllDancersOnlyOneCompany(dname) :- AllDancersAtLeastOneCompany(dname), not AllDancersMoreThanOneComapny(dname)
/* ---------------------------------- */
/*           Java stack heap          */
/* ---------------------------------- */
"""
STACK & STACK FRAME:
- Stores method calls (local vars, params)
- Pushed to top when called, popped when done
- Topmost is running
- Fast access, limited size
HEAPS:
- Stores objs (instances) & instance vars
- Slower access, larger size
- Managed by Garbage Collector: auto frees memory when objs are no longer referenced
"""
Obj obj = new Obj();
// the obj ref var is stored in the running stack frame
// the obj instance is stored in the heap

/* --------- Live and death --------- */
"""
Local var -> Until method completes (scope)
Instance var -> With object
Objects -> Until last live reference gone 
(out of scope is ok)
""" 
// Ways to remove obj ref:

"""1. Out of scope permanently"""
void method() {
    Obj obj = new Obj(); // obj is live
} // obj is dead

"""2. Nullify"""
Obj obj = new Obj();
obj = null; // obj is dead

"""3. Reassign"""
Obj obj = new Obj(); // obj is live
obj = new Obj(); // old obj is dead
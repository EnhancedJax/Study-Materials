def bfs(mtx, start):
    q = Queue()
    
    q.enqueue(start) # queue start node
    qd = [start]
    
    while not q.isEmpty():
        cur = q.dequeue() # visit node
        print(cur)
        for x in mtx[cur]:
            if x not in qd:    # if not queued
                q.enqueue(x)  # put in queue
                qd.append(x)   # mark as queued
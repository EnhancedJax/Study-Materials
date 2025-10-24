# Design of internet

## Protocols

Set of rules defining:

- Roles of entities
- Format and order
- Actions on event

### Stack

Layers

1. Application - Format for recipient
2. Transport - Identify process, order, recovering
3. Network - Route data to destination, port
4. Link - Route data between adjacent devices
5. Physical - Encode data

# Network performance

Size: 2^10 KMG
Rates: 10^3 KMG

## Metrics

Bandwidth
Throughput - Data / Time
Goodput - Useful data / Time
Latency
RTT
Jitter - Variance in latency

## Delay

Traffic intensity U = La/R

- Processing delay: Find where to send packet
- Queuing delay: (S/1-U)-S
- Transmission delay: Data: Packet size / Transfer rate
- Propagation delay: Physical: Distance / Propagation speed

# Application-layer protocols

## TCP vs UDP

TCP:
Nature: Connection based
Ordered: Yes
Flow control: Yes
Delays: Higher
Loss: No
Named: Reliable stream

Examples: File transfer, web, mail, social, text

## Sockets

Communication between application and transport layer

## Web HTTP

Transport: TCP

1.0: 2 per object
1.1: 1 connection, 1 per object
Pipelining: 1 connection, 1 html, 1 for all objects

Cookies: One line, request will include cookies

Cache and validation: 3 for connectinon and reqest

Conditional get: request page only if modified since

## DNS

### Hierarchical design and scalability

### Local name server and DNS lookups

### Caching

### Records

# Design of internet

### Stack

Layers

1. 
2. 
3. 
4. 
5. 

# Network performance

Size: 
Rates: 

## Metrics

Bandwidth
Throughput - 
Goodput - 
Latency
RTT
Jitter - 

## Delay

Average service time S = L/R
Traffic intensity U = aS

- Processing delay: time to find destination
- Queuing delay: S/1-U - S
- Transmission delay: data / rate
- Propagation delay: distance / time

# Application-layer protocols

## TCP vs UDP

* TCP
Nature: Connection based
Ordered: Yes
Flow control: Yes
Delays: Higher
Loss: None
Named: reliable stream

Examples: 

## Sockets

Communication between application and transport layer

## Web HTTP

Transport protocol: TCP

1.0: 2 per object
1.1: 1 connection, 1 per object
Pipelining: 1 connection, 1 html, 1 for all objects

Cookies: one line, included in header on each request

Cache and validation: 

Conditional get: ifmodifiedsince after only request

## DNS

Resolve query from host to local, then iteratively from root, tld, athoritative, then return to host

## Email

SMTP: push, server to server
POP3: pull and delete
IMAP: pull and keep

## Peer-to-peer

Time to transfer files:
Client-server: u_s, d_i, for i in [1, N]
t_i = F/min(u_s, d_i)
One by one: sum t_i
Parallel: max t_i

Peer-to-peer: File size F, Number of clients N, Total u/d goodput U_T, D_T, d_i, missing portion of file λ
Time required: min(NFlambda/U_T, FNLambda/D_T, Flambda/min d_i)

# Transport-layer protocols

## Checksums

1. Sum all with overflow wrapped
2. One's complemenet
3. If + checksum all 1 no error
* Cannot detect same column fliped bits

## Reliable data transfer

ABP: stop and wait

Sliding window protocols:
- Inputs:
    timeout,SWS,RWS,K seq numbers of 2^k bits

GBN: 
*                                   Cumulative acks
* Receiver expect                   Only next unreceived seq
* Retransmission on timeout         all sent in window
*                                   SWS <= K + 1, RWS = 1
* Protects strongly for             lost ACKs
* SWS ^                             time cost of errors ^

SR:
*                                   Individual ACKs
* Receiver expect                   Out of order seq
* Retransmission on timeout         only lost segments
*                                   SWS + RWS <= K
* Protects strongly for             lost data
* SWS ^                             space cost of errors ^

Flow control:
* slow receiver
* ACK contains info about handling of data of receiver
* sender adjust

Congestion control:
* slow traffic
* sender monitors network and reduce SWS
* increase when most ACK received

## TCP

* Seq: This is...
* ACK: I want ...
* Flag: except connection establishment

Retransmission: 
* timer for first unACK byte, resned
* if 4 of the same ACK received, resend

Control:
* Detect congestion by retransmission
* Sender: congestion window in bytes
    SWS = min(congestion window, rws)
* Congest: cut window in half
* Clear: increase one by one
* Slow start: start with one, increase on each ACK

Establishment:
1. C - SYN seq=ISN, flag = 0
2. S - SYN/ACK seq = ISN
3. C - ACK + DATA

Termination:
1. C - FIN
2. S - ACK, wait and close connection
3. S - FIN
4. C - ACK + timed wait for server fIN if this ack lost

## QUIC

* UDP based reliable transport
* Multiplexing without head of line blocking
* 0-RTT connection establishment
* Integrated security (TLS 1.3) 

# Network layer

ASes connected at IXP

* Data plane: forwarding packets
* Control plane: routing protocols

IPv4: 32 bits 
- Network address + Host address
- Host address: all 0s (itself), all 1s (broadcast)
- Network bit size: Num bits of network address

- Num hosts: 2^(32-network bits) - 2
    Except /31: 2 hosts

IPv6: 128 bit xxxx:xxxx...
- Network + Subnet + Interface
- Leading zeros of each block omitted
- 1 consecutive seq of 0 blocks replaced with ::

Check if in current IP subnet:
1. binary
2. AND between IP and net mask -> network address
3. between range all 0 (local) all 1

Range of CIDR:
* start: all 0
* end: all 1

Aggregation: Decrease network bit size
1. All common leading bits set as new network bit size
2. REmaining bits to 0 for start, 1 for end

Subnetting: Increase network bit size
1. Check number of address required, subnet bit size by 2^{32-k}, 2^k is the number of required address

## Routing

Forwarding table:
- Mapping (CIDR -> link)
- Input: Destination IP
- Process: Longest prefix matching

### IGPs

Link state protocol:
    Communcation between all routers time: N(N-1)
    Forward table update cost:
        Simple: O(N^2)
        Dijkstra: L + NLOGN

### EGPs

Path vector routing:
* reachablitty info
Prefix BGP path includes:
- destination network
- AS path
- first hop router
Operations:
- Announcement
- Forwarding: Add self to AS path, change first hop, foward ot neighbours

Hot potato routing: A to B
1. InterAS -> Reachable B?
2. Least-cost path -> Border router
3. Fwd table -> interface border router
4. Interface B -> Fwd Table
5. 

## NAT

* Mapping (src IP:port, dest IP:port, protocol, NAT IP:port)
* Changes only the dest IP port
* Works for _ protocols transport protocols as well

# Link layer
* Framing: datagram -> frames
* Link access: control access to physical shared medium
* Reliable delivery: retransmission, erorr detectin

* MAC changes through: router sends
* Single bit parity check: + 1 to be even
* Two dimensional parity check: (row, column, overall) even
* CRC: d, bitstring b, crc bit size s:
    1. add s 0 behind d
    2. d / b by long division XOR( 1,0 -> 1)
    3. remainder is the cRC

## Switch forwarding table 
Mapping: (MAC,interface,timestmap)
Input frame format: (SMAC,DMAC,type,interface)
Process:
1. Source:
    SMAC in table ? replace : add
2. Destination:
    DMAC not in table ? send to all except I : I!=I0 ? send to I0 : ignore

## ARP request
A send to another host with unknown MAC
1. B = inside lan ? B addr : gateway addr
2. ARP request source: A, dest: B, dest mac: FF
3. ARP response srouce: B, dest: A

ARP poisoning: chagne mac

## DHCP
Dynamic assign IP addresses, UDP. Get:
1. ip
2. subnet mask
3. default gateway addr
4. dns server addr
5. lease time
    new REQUEST when half pass, send each half when done: DHCPRELEASE

new device process:
1. C-S discover 0.68 255.67 0.
2. S-C offer self.67 255.68 offered
3. C-S request 0.68 255.67 offered
4. S-C ack self.67 255.68 offered

## VLAN
* Logically separate LANs that share the same physical switch infra
* Switches under switches for link: bottleneck by link rate / num devices under link

# Security

Attacks on confidentiality:

* Attacker access
* Ciphertext-only: K(m)
* Known-plaintext: K(m) m
* Chosen-plaintext: K(x)

## Symmetric key encryption
* key: uses same key for encryption and decryption
* Substitution: cost to decrypt = 26!(26-k)! k distinct

Diffie-hellman key exchange:
* To share key over insecure channel, suffer from mitm attack by interception and replacing public keys
1. share large p, base g
2. A secret a, A = g^a mod p
3. B secret B, B = g^b mod p
4. shared B^a mod p
5. A^b mod p

## Asymmetric key encryption

A to send x to b:
Confidentiality: +B
Auth: -A

RSA:
Large primes p q
1 < e < z





## Message integrity

Signed message:
* A send (m, -A(H(m))) to B. B compute H_B(m) = +A(-A(H(m)))

Message authentication code MAC
* A send m and h = H(m+s). B compute H_B(m+s) and match with h

CA: Trsuted 3rd party digital certificate, bind public keys to entities, signed by CA's private key

Nonce:
1. B random nubmer to a
2. A sends K^-sN to B

Security levels triangle: confidentiality, auth, replay
nothing, key, key id, key id nonce

## Security protocol

1. Handshake
    a. establish TCP connection
    b. verify ID through certificates
    c. session keys exchange
2. Key derivation
    - K_A, K_B 
    - M_A M_B
3. Data transfer and connection termination
    message m, length l A to B, termination flag f
    Data form: 
    Subjective to:
    - 
    - 
    - Safe:                 

## VPN
Info message:
* Leaving VPN: srcIP: src VPN, destIP: dest VPN
* Arriving VPN: srcIP: original src, destIP: original dest

Communication between abitary peers must ensure confidentiality, integrity, and sender authentication. Includes:
– TLS (Transport layer security): symmetric encryption, MAC, public key encryption and cer-
tificate (application)
– IPSec: (network)
– QUIC: (transport) (like TLS but over UDP)
– GRE, SSL, SSH: (application)
– PGP: (application)

Communication with public answers must ensure integrity and sender authentication only. Includes:
– DNSSEC: (application)
– BGPsec: (application)

Firewalls packet filtering:
- Stateless: 
- Stateful: 
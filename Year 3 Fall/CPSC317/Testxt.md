# Design of internet

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

Average service time S = L / R
Traffic intensity U = La/R
U > 1: Queue grow, need to drop significant number of packets
U = 1: if traffic is bursty still need to drop

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

Resolve query from host to local, then iteratively from root, tld, athoritative, then return to host

## Email

SMTP: Between mail servers, push
POP3: Pull & delete
IMAP: Pull & keep

## Peer-to-peer

Time to transfer files:
Client-server: u_s, d_i, for i in [1, N]
t_i = F/min(u_s, d_i)
One by one: sum t_i, parallel: max t_i

Peer-to-peer: File size F, Number of clients N, Total u/d goodput U_T, D_T, d_i, missing portion of file λ
Time required: max{NFλ/U_T, NFλ/D_T, Fλ/min d_i}

# Transport-layer protocols

## Checksums

1. Add up all words, wrap around any overflow
2. Take 1's complement
3. Checksum + sum = all 1 -> no error
* Cannot detect two bits of same column flipped

## Reliable data transfer

ABP: Stop and wait, timeout

Sliding window protocols:
- Input:
    Timeout, Window sizes SWS, RWS, K sequence numbers or 2^k bits

GBN: 
*                                   Cumulative ACK
* Receiver expect                   next unreceived seq
* Retransmission on timeout         all in window
*                                   SWS <= K - 1, RWS = 1
* Protects strongly for             lost ACKs
* SWS ^                             Time cost of errors ^ 

SR:
*                                   Individual ACK
* Receiver expect                   out of order
* Retransmission on timeout         missing only
*                                   SWS + RWS <= K
* Protects strongly for             lost data
* SWS ^                             Space cost of errors ^ 

Flow control:
* Handles slow receiver
* Receiver sends info on handlable data through ACK
* Sender adjust based

Congestion control:
* Handles too much data for network
* Sender monitors network and reduce SWS
* Increase when most received

## TCP

* Seq: This byte position
* ACK: Next wanted byte position
* Flag: Except connection establishment

Retransmission: 
* timer for first unACKed byte, resend
* If 4 of same ACK recevied, resend unACKed byte

Control:
* Detect congestion by retransmission
* Sender: congestion window in bytes
    SWS = min (cWnd, RWS)
* Congest: Cut cWnd half
* Clear: Increase by 1 seg per RTT
* Slow start: Start cWnd = 1 increase cWnd by 1 seg per ACK

Establishment:
1. C - SYN seq=ISN FLAG=0
2. S - SYN/ACK seq=ISN
3. C - ACK + data

Termination:
1. C - FIN
2. S - ACK, wait and close connection, 
3. S - FIN
4. C - ACK + "Timed wait" (Resend ACK when server resends FIN when last ACK lost)

## QUIC

* UDP based reliable transport
* Multiplexing without head of line blocking
* 0-RTT connection establishment
* Integrated security (TLS 1.3) 

# Network layer

ASes connected at Internet Exchange Points (IXPs)

* Data plane: Forwarding packets
* Control plane: Routing protocols

IPv4: 32 bits 
- Network address + Host address
- Host address: all 0s (itself), all 1s (broadcast)
- Network bit size: Num bits of network address

- Num hosts: 2^(32 - network bits) - 2
    Except /31: 2 hosts

IPv6: 128 bit xxxx:xxxx...
- Network + Subnet + Interface
- Leading zeros of each block omitted
- 1 consecutive seq of 0 blocks replaced with ::

Check if in current IP subnet:
1. Convert to binary
2. AND between IP address and netmask -> network address
3. In subnet if between network and broadcast

Range of CIDR:
* start: Set host bits to 0
* end: Set host bits to 1

Aggregation: Decrease network bit size
1. All cmmon leading bits, set as new network bit size
2. Remaining bits to 0 for start, 1 for end

Subnetting: Increase network bit size
1. Check each number of address required, find subnet network bit size by 2^{32 - k}, where 2^k is number of required addresses rounded up to nearest power of 2

## Routing

Forwarding table:
- Mapping CIDR range -> Link
- Input: Destination IP
- Process: Longest prefix matching

### IGPs

Link state protocol:
    Communcation between all routers: N(N-1)
    Forward table update cost:
        Simple: O(N^2)
        Dijkstra: O(L + NlogN) for L links

### EGPs

Path vector routing:
* Reahability info
Prefix BGP path includes:
- Destination netwrok
- AS path
- First hop router
Operations:
- Announcement
- Forward: Receive announcement, add own AS number to path, forward to neighbours

Hot potato routing:
1. InterAS -> Reachable B?
2. Least-cost path -> border router
3. Fwd table -> Interface border router
4. B,interface -> Fwd table

## NAT

* Mapping (internal IP:port, remote IP:port, protocol, NAT IP:port)
* Chagne dest IP:port : size payload unchanged
* Works for transport protocols TCP UDP

# Link layer
* Framing: Encapsulating network layer datagrams into frames
* Link access: control access to shared physical medium (e.g. CSMA/CD)
* Reliable delivery: retransmission, erorr detection etc.

* MAC changes through each router send
* Single bit parity check: add 1 to be even
* Two dimensional parity check: (each row, column, overall)
* CRC: d, bitstring b, crc bit size s:
    1. Add s zeros to da t end to be s_2
    2. Divide s_2 by b using XOR (01->1) long division
    3. Remainer is CRC bits

## Switch forwarding table 
Mapping: (MAC, interface, timestamp)
Input frame format: (sMAC, dMAC, type, interface I)
Process:
1. Source:
    sMAC in table ? replace row : add
2. Destination:
    dMAC not in table ? send to all except I :
        matching row I_0 != I ? 
            send to I_0 : drop

## ARP
A send to another host with unknown MAC
1. B = Send inside LAN ? Dest : Gateway
2. [ARPreq] Source IP:MAC = A, Dest IP = B, Dest MAC = FF:FF:FF:FF:FF:FF
3. [ARPres] Source IP:MAC = B, Dest IP:MAC = A

ARP poisoning: change mac to trudy

## DHCP
Dynamic assign IP addresses, UDP. Get:
1. IP
2. subnet mask
3. default gateway address
4. DNS server address
5. lease time
    new REQUEST when half lease, repeat after some time. RELEASE when done

new device process:
1. C-S [DISCOVER] src: 0.:68, dst: 255.:67, yiaddr: 0.
2. S-C [OFFER] src: S:67, dst: 255.:68, yiaddr: offered IP
3. C-S [REQUEST] src: 0.:68, dst: 255.:67, yiaddr: offered IP
4. S-C [ACK] src: S:67, dst: 255.:68, yiaddr: offered IP

## VLAN
* Logically separate LANs that share the same physical switch infra
* Switches under switches for link: bottleneck bandwidth / number of hosts

# Security

Attacks on confidentiality:

* Attacker access
* Ciphertext-only: K(m)
* Known-plaintext: K(m), m
* Chosen-plaintext: K(x)

## Symmetric key encryption
* same key used for enc decr
* Substitution: cost to decrypt = 26!/(26-n)!

Diffie-hellman key exchange:
* To share key over insecure channel, suffer from MITM attack by interception and replacing public keys
1. Share large p, base g
2. A secret integer a, send A = g^a mod p
3. B secret integer b, send B = g^b mod p
4. A compute s = B^a mod p (shared secret)
5. B compute s = A^b mod p

## Asymmetric key encryption

A to send x to b:
Confidentiality: +B [K^+_B(x)]
Auth: -A [K^-_A(x)]
Both: -A+B [K^-_A(K^+_B(x))]

RSA:
1. Choose large primes p, q
2. Compute n = p*q, z = (p-1)(q-1)
3. Choose e: 1 < e < z, no common facots with z
4. Compute d: d*e mod z = 1
5. Public key: (e, n), Private key: (d, n)
6. Encrypt: c = m^e mod n, Decrypt: m = c^d mod n

## Message integrity

Message authentication code MAC
* A send m and h = H(m + s). B compute H_B(m + s) and check if equal to h

CA: Trsuted 3rd party digital certificate, bind public keys to entities, signed by CA's private key

Nonce:
1. B send random nonce N to A
2. A sends by K^-_s(N) to B

Security levels triangle: confidentiality, auth, replay resistance
Nothing, key, key id, key id nonce

## Security protocol

1. Handshake
    a. Establish TCP connection
    b. Verify id thru certificates
    c. Session keys exchange
2. Key derivation
    - K_A, K_B 
    - M_A M_B
3. Data transfer and connection termination
    message m, length l A to B, termination flag f
    Form {H(K_A(...) + M_A + ...), K_A(...)}
    Subjective to:
    - Reordering replay:    l,m / . / l,m
    - Truncation:           l,m / + n / l,m
    - Safe:                 l,f,m / + n / l,f,m

## VPN
Info message:
* Leaving VPN: srcIP: VPN, destIP: dest VPN router
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
- Stateless: Packet-by-packet on ACL
- Stateful: Keep track of connection state
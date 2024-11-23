//======////======////======////======////======////======//

# Semi-conductors and electronics
Active devices: Can control charge flow electrically
Compounds for semi-c: III - V

## One type of doping
Type                    n-type
Dopant:                 V elements
Free majority carrier:  e-

Carriers: both e and holes

## Diodes
Circuit symbol points to: N-type material (forward bias)
Function: Only conduct in one direction
Forward direction relationship: ID = IS * e ^ (VD/VT)

## BJTs
Active region: VBE > 0, VBC<0
Ic = βIb
Ie = Ic + Ib
Ic = Is * e VBE / Vt
If VB = 0: Current does not flow

## MOSFETS
n-MOSFET carriers: e-
CMOS: 
* on: p-subtrate
* NMOS turns on when: +ve V
* PMOS turns on when: -ve V

Comparing with BJT:
+ Lower gm
+ Lower power consump
+ Less heat dissipation
+ Higher noise immunity
+ Higher switching speed
+ Higher packing density

## Optoelectronics
### Absorption
1. exite e req Eg
2. e absorbs photon to excite, create e in conduct and hole in valence
Recombination: When the hole and e recombine -> photons

### LEDS
Electroluminsence: e cross np junction -> recombination -> light
Light wavelength: Photon energy

//======////======////======////======////======////======//

# Communications

## Modulation
Carrier signal: Carry info, does not contain
Sidebands:
* fUSB = fC + fM
* fLSB = fC - fM

## AM vs FM
+ Noise immunity
+ Higher efficiency
- Excessive spectrum use
- Complex circut

## Multiplexing
Is: Transmit more signals over single channel
FDM: Different modulators use slightly different f for carriers over part of the bandwidth
TDM: Signals take turns trasmitting over entire bandwidth

## Optical communication
Light used: Infrared
TIR: incidence > critical angle
Critical angle formula: sinC = n2 / n1
Dispersion because: Delay in light travelling in longest path to reach the end

//======////======////======////======////======////======//

# Computer system, programming and networking
ALU: Executes instructions
CU: Determine what to do based on instructions
Register: Stores small data
Cache memory: Lower layers have less latency -> efficiency

## Stored program computers
Is: Stores both program instruction and data in same memory storage
+ Data and instruction same way access
- Bottleneck memory access pseed
- Idle CPU when accessing memory

## Performance
Factor (speeds) affecting performance of a computer:
1. CPU clock
2. Bus
3. Memory-access

## Program running cycle
1. CU fetches instruction from main mem
2. CU decodes + move data to ALU
3. ALU executes instructions

//======////======////======////======////======////======//

# Data, logic gates & binary computation

## Negative binary
Sign magnitude: Leftmost to 1
Two's complement: Invert bits + 1

## Logic gates
Func    Symb        Boolean     Truth
NOT     Dot         bar         Flip
AND     Round       times       0001
OR      Point       plus        0111
XOR     backLine    circplus    0110

## Floating point numbers
Value = s*2^-e

//======////======////======////======////======////======//

# Modern CE applications
AI must:
1. Efficiently handle large amounts of data
2. Process data simutaneously from multiple sources
3. Organice data -> insights
4. Learn and update constantly
5. Respond in real time conditions

IoT: Obj w/ sensors that connect and exchange data with other devices over network
Enabling tech:
1. Computing
2. Networking

//======////======////======////======////======////======//

# Fundamentals of electricity
I = Qt
P = E/t = IV
V = IR
R = pL/A
C = Q / V
E = 1/2 CV2
E = 1/2 LI2
Resistance by color code: R = AB * C * (±tol%)


//======////======////======////======////======////======//

# Resistor, Inductor, Capacitor & Circuits
In series:
    I: Same
    V: Sum = emf
    Rt = sumR
    Ct = (sumC-1)-1
    Lt = sumL
In parallel: Opposite

Voltmeter direction: -+ <-> +-

## Capacitors and inductors
Same functionalities:
* Stores E
* Filter noise in signal
Different function:
    C: AC DC Coupling / Decoupling
    L: Block AC bypass DC
V&I-t graphs in AC circuit:
    C: 1/4 cycle lead
    L: 1/4 cycle lag

## Start to delta transformation (Resistances)
Star:   Rn = Rn.Rn./sumR
Delta:  Rnm = Rn + Rm + RnRm/R.

//======////======////======////======////======////======//

# Electric Power Systems

## Distribution systems
RMS = Vph
Peak = Vp

RMS:        Vph = 1/sqrt2 Vp
Average:    Vav = 2/pi Vp
Peak2peak:  Vpp = 2 Vp

### Balanced three phase systems
Uab,bc,ca = sqrt(3) Ux

## Transformers
Turn ratio N = np/ns = vp/vs = is/ip

## Reliability
Forced outage rate: FOR = Tout / Tt
Availability of a unit: AV = 1 - FOR

//======////======////======////======////======////======//

# Renewable Energy Systems

### Solar cells
* Temperature: T inc P,V dec
* Irradiance: I inc P, I inc
Series of solar cells: Only allows minimum current to pass through

//======////======////======////======////======////======//
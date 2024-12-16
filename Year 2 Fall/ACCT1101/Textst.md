Supplies, Inventory, Prepaid expense || buildings

# Discounts and debts

## Discounts

Three types of discount accounts:

- Credit card discount: Merchant fee
- Sales discount: rate/day, n/day
- Sales returns and allowances: Returned goods or price sales

* They are contra revenues

## Bad debt

End of period: Bad debt expense / Allowance
During period: Allowance for doubtful accounts / Accounts receivables

Estimation methods:

- **Percentage of sales** credit sales \* rate -> bad debt expense
- **Aging method** category: amount \* rate -> ending balance allowance
- Allowance for doubtful accounts is contra asset of accounts receivables

# Inventory

- **Perpetual** Update inventory real time
  Restock: Inventory / Cash
  Sale: COGS / Inventory
  End: ..

- **Periodic** Update inventory at the end of the period
  Restock: Purchases / Cash
  Sale: ..
  End: Inventory / Purchases, Inventory / COGS

## Cost flow assumptions, table

Three types of assumptions:

- FIFO
- LIFO
- AVCO (Total cost / units)

Rising prices: LIFO lower income lower tax

Table colums and rows:

- Date, Action, Quantitiy, Unit cost, Total cost
- Start | Purchase -> Goods available for sale -> Sales | End

## Lower of cost or NRV

NRV = Selling - COGS

**Write-down**: If `NRV < Cost`, write down inventory `(cost-nrv)units`

## Free on board

Two types of ownership transfer:

- Destination: Arrived
- Shipping point: Left origin

# Depreciation

End: depreciation expense / accumulated depreciation
AD is contra asset

Pt = Total production
Pa = Annual production

Straight line: `(cost - residual) / life`
UoProduction: `(cost - residual) (Pa / Pt)`
Double-declining: `2 (cost-ad) / life`

## Disposal

1. Record DE this period
2. Write-off all AD, record Cash / Asset, record gain / lose revenue

## Amoritzation

Types of intangibles decided at purchase:

- Definite life: Amoritzed
- Indefinite life: Tested for impairment

Straight line: `cost / useful`
Impairment: `carrying - fair`

# Reporting long term liabiltiies

Potential liabilities:
| Probable, estimable | |
| YY | record |
| RX | disclose |
| NX | nothing |

FV future value, i interest rate, n periods
Lump sum: Single payment
Annuity: Series of equal payments at regular time

- **Present value of lump sump** `PV = FV (1 + i)^-n`
- **Present value of annuities** `PV = PMT T(n,i)`

# SE

Sets of stocks:

```py
[Authorized[Issued[Outstanding, Treasury, Preferred]][Unissued]]
```

CS = `n shares * par value`
APC = `amount - CS`

Issue: Cash / CS APC
Declare dividends: Retained earnings / Dividends payable
Repurchase: Treasury / Cash

Treasury is a contra-equity account

PD = `rate% * par * number`
CD = `D - PD`

# Cash flow statement

Cash flows

- O: Revenue generating activites
- I: Purchase / sale of long term assets outside core operations
- F: Changes in shares, borrow money, repay long term debt

Preparing:

- O: Net income + non cash expenses + gain on sale of non-current A - dAL

<!--
# Ratios

## Profitability ratios

- Net Profit Margin: `Net Income : Revenue`
- Gross profit margin: `(Net income - COGS) : Revenue`
- ROA: `Net Income : Total Assets`
- ROE: `Net Income : Average Equity`
- EPS: `Net Income : Shares Outstanding`
- Quality of Income: `O Cash Flow : Net income`

## Asset turnover ratios

- Total Asset Turnover: `Operating revenue : Total Assets (sales:)`
- Fixed Asset Turnover: `Net Sales : Fixed Assets`
- Receivable Turnover: `Net Sales : Receivables`
- Inventory Turnover: `COGS : Inventory`
- Average days to Sell Inventory: `365 : Inventory Turnover`

## Liquidity ratios

- Cash: `Cash Eqv. : Current Liabilities`
- Current: `Current Assets : Current Liabilities`
- Quick: `(Current Assets - Inventory) : Current Liabilities`

## Solvency ratios

- Debt to Equity: `Total Liabilities : Total Equity`
- Time interest earned: `NI + Interest Expense + Income tax Expense : Interest Expense`
- Cash coverage: `O Cash Flow : Interest Expense`

## Market ratios

- Dividend yield: `Dividend : Market price (per share)`
- P/E: `Market price : Earnings (per share)` -->

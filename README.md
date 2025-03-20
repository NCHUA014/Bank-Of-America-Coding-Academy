# Bank-Of-America-Coding-Academy
2 questions were given. Here are my solutions

First question: 
parties:
- party id
- jurisdiction
- client type
- sanction status

Instruments:
- instrumentID
- InstrumentType
- Allowed Jurisdiction

InstrumentPermissions:
- ClientType
- InstrumentTypes

Given the following information, we code a function: isEligibleToTrade(PartyID, InstrumentID) which checks:
- if there is sanctions, we will not trade
- check whether party is within allowed jurisdiction with instrument
- Check if client type is permitted to use the instrument type.
If passes all these 3 cases, trade is eligible.

Since banks need to check this quickly, using this algorithm saves time and efficiency.

Second question:
Given a list of buyers and sellers with the quantity given for each price, see which price leads to the most amount of sales, and hence, largest amount of commissions from revenue (a percentage).

Bidders (buyers) will be willing to buy stocks that are below their expected price
Askers (sellers) will be willing to sell their stocks at the higher price than their expected price.

Using this logic, find out which price yields highest revenue.

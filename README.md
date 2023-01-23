## Customer Support service (us22po_fc_service)
### This is one of the mine project that include in the "java spring-boot" curse.

#### Description:
MicThe system has as main functionality is to convert a price for a product based on currency.
Price
A price object contains europrice and currency.
Endpoints
The service should provide the following endpoints:
• Get converted price
POST /api/v1/price
The price is calculated as the original price divided by the exchange rate. The price in the business
database is assumed to be in Euro.
The currency is provided as price object as a request data. The endpoint returns a String
representation of the resulting price.

#### Dependencies: externa endpoint
- https://api.exchangerate.host/
- https://www.ecb.europa.eu/ (not use)


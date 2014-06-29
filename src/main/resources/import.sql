insert into APSUser (id, password, username) values (1, 'john', 'john')

insert into BillingCycle (id, cycle) values (1, 'WEEKLY')
insert into BillingCycle (id, cycle) values (2, 'MONTHLY')

insert into Company (id, name, billingCycle_id) values (1, 'VODACOM', 1)
insert into Company (id, name, billingCycle_id) values (2, 'STANDARD BANK', 2)

insert into Status (id, description) values (1, 'ACTIVE')
insert into Status (id, description) values (2, 'INACTIVE')
insert into Status (id, description) values (3, 'TRYING')

insert into Statement (id, accountNumber, statementNumber, openingBalance, closingBalance, discount, statement) values (1, '1234567','0021', 'R3992', 'R4002', 'R54', 'vodacom_15_06.xml')
insert into Statement (id, accountNumber, statementNumber, openingBalance, closingBalance, discount, statement) values (2, '5667390','091', 'R5427', 'R677', 'R908', 'master_card_15_06.xml')

insert into ReturnCode (id, code,description, apsdescription) values(1, '200', 'OK', 'Scraped.')
insert into ReturnCode (id, code,description, apsdescription) values(2, '301', 'Moved Permanently', 'The Website has Changed, please verify website URL')
insert into ReturnCode (id, code,description, apsdescription) values(3, '401', 'Unauthorised', 'Invalid Login credentials, please update login credentials')
insert into ReturnCode (id, code,description, apsdescription) values(4, '403', 'Forbidden', 'Please sign up for e billing')
insert into ReturnCode (id, code,description, apsdescription) values(5, '404', 'Not Found', 'The website is temporarily unavailable')
insert into ReturnCode (id, code,description, apsdescription) values(6, '408', 'Request Timeout', 'Timeout, scraper will reschedule')
insert into ReturnCode (id, code,description, apsdescription) values(7, '500' ,'Internal Server Error', 'Server Down, scraper rescheduled')
insert into ReturnCode (id, code,description, apsdescription) values(8, '503', 'Service Unavailable', 'Error, scraper rescheduled')

insert into CompanyAccount (id, accountNumber, apsUser_id, company_id, statement_id, status_id) values (1, '1234567', 1, 1, 1, 1)
insert into CompanyAccount (id, accountNumber, apsUser_id, company_id, statement_id, status_id) values (2, '5667390', 1, 2, 2, 1)

insert into TelcoStatement (id, telephoneNumber, serviceCharges, callCharges, totalNumberOfCalls, totalCallDuration) values (1, '0781655485','R45', 'R390', '14', '80 mins')
insert into CreditCardStatement (id, cardType, creditAvailable, creditLimit, interestRate, minimumAmountDue) values (1, 'MASTER CARD','R450000', 'R500000', '21%', 'R3896')
insert into ScrapingEventAuditLog (id, scrapeDate, apsUser_id, company_id, returnCode_id) values (1, '2014-06-24', 1, 1, 1)

insert into ScraperInfo(id,apsUser_id,url,xmlResultFile) values(1,1,"http://www.telco.co.za","C:/enterprise/wildfly-8.0.0.Final/standalone/tmp/InputData/telco.xml");
insert into ScraperInfo(id,apsUser_id,url,xmlResultFile) values(2,1,"http://www.creditcard.co.za","C:/enterprise/wildfly-8.0.0.Final/standalone/tmp/InputData/creditcard.xml");
insert into ScraperInfo(id,apsUser_id,url,xmlResultFile) values(3,1,"http://www.municipality.co.za","C:/enterprise/wildfly-8.0.0.Final/standalone/tmp/InputData/municipality.xml");
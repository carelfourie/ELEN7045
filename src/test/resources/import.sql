insert into Member (id, name, email, phone_number) values (1, 'John Smith', 'john.smith@mailinator.com', '2125551212') 
insert into APSUser (id, password, username) values (1, 'john', 'john')
insert into BillingCycle (id, cycle) values (1, 'MONTHLY')
insert into Company (id, name, billingCycle_id) values (1, 'VODACOM', 1)
insert into Status (id, description) values (1, 'ACTIVE')
insert into Status (id, description) values (2, 'INACTIVE')
insert into Status (id, description) values (3, 'TRYING')
insert into Statement (id, statement) values (1, 'vodacom_15_06.xml')
insert into ReturnCode (id, code,description, apsdescription) values(1, '200', 'OK', 'ALL IZ WELL')
insert into ReturnCode (id, code,description, apsdescription) values(2, '301', 'Moved Permanently', 'The Website has Changed, please verify website URL')
insert into ReturnCode (id,code,description, apsdescription) values(3,'401', 'Unauthorised', 'Invalid Login credentials, please update login credentials')
insert into ReturnCode (id,code,description, apsdescription) values(4,'403', 'Forbidden', 'Please sign up for e billing')
insert into ReturnCode (id,code,description, apsdescription) values(5,'404', 'Not Found', 'The website is temporarily unavailable')
insert into ReturnCode (id,code,description, apsdescription) values(6,'408', 'Request Timeout', 'Timeout, scraper will reschedule')
insert into ReturnCode (id,code,description, apsdescription) values(7,'500' ,'Internal Server Error', 'Server Down, scraper rescheduled')
insert into ReturnCode (id,code,description, apsdescription) values(8,'503', 'Service Unavailable', 'Error, scraper rescheduled')
insert into CompanyAccount (id, accountNumber, apsUser_id, company_id, statement_id, status_id) values (1, '1234567', 1, 1, 1, 1)
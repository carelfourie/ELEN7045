--
-- JBoss, Home of Professional Open Source
-- Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

-- You can use this file to load seed data into the database using SQL statements

insert into Member (id, name, email, phone_number) values (1, 'John Smith', 'john.smith@mailinator.com', '2125551212') 
insert into APSUser (id, password, username) values (1, 'john', 'john')
insert into BillingCycle (id, cycle) values (1, 'MONTHLY')
insert into Company (id, name, billingCycle_id) values (1, 'VODACOM', 1)
insert into Status (id, description) values (1, 'OPEN')
insert into Statement (id, statement) values (1, 'vodacom_15_06.xml')
insert into CompanyAccount (id, accountNumber, apsUser_id, company_id, statement_id, status_id) values (1, '1234567', 1, 1, 1, 1)

insert into Member (id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.com', '2125551212') 
insert into APSUser (id, password, username) values (0, 'john', 'john')
insert into BillingCycle (id, cycle) values (0, 'MONTHLY')
insert into Company (id, name, billingCycle_id) values (0, 'VODACOM', 0)
insert into Status (id, description) values (0, 'ACTIVE')
insert into Status (id, description) values (1, 'INACTIVE')
insert into Status (id, description) values (2, 'TRYING')
insert into Statement (id, statement) values (0, 'vodacom_15_06.xml')
insert into ReturnCode (id, code,description, apsdescription) values(0, '200', 'OK', 'ALL IZ WELL')
insert into ReturnCode (id, code,description, apsdescription) values(0, '301', 'Moved Permanently', 'The Website has Changed, please verify website URL')
insert into ReturnCode (id,code,description, apsdescription) values(1,'401', 'Unauthorised', 'Invalid Login credentials, please update login credentials')
insert into ReturnCode (id,code,description, apsdescription) values(2,'403', 'Forbidden', 'Please sign up for e billing')
insert into ReturnCode (id,code,description, apsdescription) values(3,'404', 'Not Found', 'The website is temporarily unavailable')
insert into ReturnCode (id,code,description, apsdescription) values(4,'408', 'Request Timeout', 'Timeout, scraper will reschedule')
insert into ReturnCode (id,code,description, apsdescription) values(5,'500' ,'Internal Server Error', 'Server Down, scraper rescheduled')
insert into ReturnCode (id,code,description, apsdescription) values(6,'503', 'Service Unavailable', 'Error, scraper rescheduled')
insert into CompanyAccount (id, accountNumber, apsUser_id, company_id, statement_id, status_id) values (0, '1234567', 0, 0, 0, 0)


/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package za.ac.wits.eie.ELEN7045.aps.test;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;

import za.ac.wits.eie.ELEN7045.aps.model.Member;
import za.ac.wits.eie.ELEN7045.aps.service.MemberRegistration;
import za.ac.wits.eie.ELEN7045.aps.test.base.BaseTest;

@RunWith(Arquillian.class)
public class MemberRegistrationTest extends BaseTest {

	@Inject
	Logger log;

	@Inject
	MemberRegistration memberRegistration;

	@Test
	public void test() throws Exception {
		Member member = new Member();
		member.setName("Jane Doe");
		member.setEmail("jane@mailinator.com");
		member.setPhoneNumber("2125551234");
		memberRegistration.register(member);
		assertNotNull(member.getId());
		log.info(member.getName() + " was persisted with id " + member.getId());
	}
}

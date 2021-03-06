/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springsource.restbucks.payment;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.joda.time.LocalDate;
import org.joda.time.Months;
import org.joda.time.Years;
import org.junit.Test;

/**
 * Unit tests for {@link CreditCard}.
 * 
 * @author Oliver Gierke
 */
public class CreditCardUnitTest {

	static final CreditCardNumber NUMBER = new CreditCardNumber("1234123412341234");

	@Test
	public void discoversExpiredCreditCard() {

		CreditCard creditCard = new CreditCard(NUMBER, "Oliver Gierke", Months.ELEVEN, Years.years(2016));

		assertThat(creditCard.isValid(new LocalDate()), is(true));
		assertThat(creditCard.isValid(new LocalDate(2016, 12, 1)), is(false));
	}
}

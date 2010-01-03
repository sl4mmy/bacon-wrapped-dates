/*
 * Copyright (c) 2010, Kent R. Spillner <kspillner@acm.org>
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
package mmmmm.bacon.timezones;

import junit.framework.JUnit4TestAdapter;
import mmmmm.bacon.TimeZone;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TimeZoneTests {

        @Test
        public void shouldDefaultToUTC() throws Exception {
                final TimeZone timeZone = new TimeZone();

                assertEquals(java.util.TimeZone.getTimeZone("UTC"), timeZone.toJavaUtilTimeZone());
        }

        @Test
        public void shouldCreateTimeZoneFromName() throws Exception {
                final TimeZone timeZone = new TimeZone("US/Central");

                assertEquals(java.util.TimeZone.getTimeZone("US/Central"), timeZone.toJavaUtilTimeZone());
        }

        @Test
        public void shouldThrowIllegalArgumentExceptionWhenNameIsNull() throws Exception {
                try {
                        new TimeZone(null);
                        fail("should throw InvalidArgumentException when name is null");
                } catch (IllegalArgumentException e) {
                        assertEquals("TimeZone id cannot be null", e.getMessage());
                }
        }

        @Test
        public void shouldThrowIllegalArgumentExceptionWhenNameIsEmpty() throws Exception {
                try {
                        new TimeZone("");
                        fail("should throw IllegalArgumentException when name is empty");
                } catch (IllegalArgumentException e) {
                        assertEquals("TimeZone id cannot be empty", e.getMessage());
                }
        }

        @Test
        public void shouldThrowIllegalArgumentExceptionWhenNameIsBlank() throws Exception {
                try {
                        new TimeZone(" \t\r\n");
                        fail("should throw IllegalArgumentException when name is blank");
                } catch (IllegalArgumentException e) {
                        assertEquals("TimeZone id cannot be blank", e.getMessage());
                }
        }

        public static junit.framework.Test suite() throws Exception {
                return new JUnit4TestAdapter(TimeZoneTests.class);
        }
}

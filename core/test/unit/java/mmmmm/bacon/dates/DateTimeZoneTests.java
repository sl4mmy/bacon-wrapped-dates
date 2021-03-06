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
package mmmmm.bacon.dates;

import junit.framework.JUnit4TestAdapter;
import mmmmm.bacon.Date;
import mmmmm.bacon.TimeZone;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DateTimeZoneTests {

        @Test
        public void shouldBeInUTCTimeZoneByDefault() throws Exception {
                final Date date = new Date();

                Assert.assertEquals(new TimeZone(), date.getTimeZone());
        }

        @Test
        public void shouldBeInGivenTimeZone() throws Exception {
                final Date date = new Date(new TimeZone("US/Central"));

                assertEquals(new TimeZone("US/Central"), date.getTimeZone());
        }

        @Test
        public void shouldCreateNewDateInGivenTimeZoneWhenConvertingDateToDifferentTimeZone() throws Exception {
                final Date date = new Date(new TimeZone("US/Eastern"));

                assertEquals(new TimeZone("US/Pacific"), date.in(new TimeZone("US/Pacific")).getTimeZone());
        }

        @Test
        public void shouldNotModifyOwnTimeZoneWhenConvertingDateToDifferentTimeZone() throws Exception {
                final Date date = new Date(new TimeZone("US/Eastern"));

                date.in(new TimeZone("US/Pacific"));

                assertEquals(new TimeZone("US/Eastern"), date.getTimeZone());
        }

        public static junit.framework.Test suite() throws Exception {
                return new JUnit4TestAdapter(DateTimeZoneTests.class);
        }
}

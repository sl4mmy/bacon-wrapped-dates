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

public class TimeZoneEqualityTests {

        @Test
        public void shouldBeEqualToSelf() throws Exception {
                final TimeZone self = new TimeZone();

                assertEquals(true, self.equals(self));
        }

        @Test
        public void shouldNotBeEqualToNull() throws Exception {
                final TimeZone self = new TimeZone();

                assertEquals(false, self.equals(null));
        }

        @Test
        public void shouldNotBeEqualToInstancesOfIncompatibleTypes() throws Exception {
                final TimeZone self = new TimeZone();

                assertEquals(false, self.equals(new Object()));
        }

        @Test
        public void shouldBeEqualToDifferentInstancesOfSameTypeWithEqualValues() throws Exception {
                final TimeZone left = new TimeZone("US/Central");
                final TimeZone right = new TimeZone("US/Central");

                assertEquals(true, left.equals(right));
        }

        @Test
        public void shouldNotBeEqualToDifferentInstancesOfSameTypeWithDifferentValues() throws Exception {
                final TimeZone left = new TimeZone("US/Eastern");
                final TimeZone right = new TimeZone("US/Pacific");

                assertEquals(false, left.equals(right));
        }

        @Test
        public void shouldBeSymmetric() throws Exception {
                final TimeZone left = new TimeZone();
                final TimeZone right = new TimeZone();

                assertEquals(true, left.equals(right));
                assertEquals(true, right.equals(left));
        }

        @Test
        public void shouldBeTransitive() throws Exception {
                final TimeZone left = new TimeZone();
                final TimeZone middle = new TimeZone();
                final TimeZone right = new TimeZone();

                assertEquals(true, left.equals(middle));
                assertEquals(true, middle.equals(right));
                assertEquals(true, left.equals(right));
        }

        public static junit.framework.Test suite() throws Exception {
                return new JUnit4TestAdapter(TimeZoneEqualityTests.class);
        }
}

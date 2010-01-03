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
package mmmmm.bacon;

/**
 * Understands local offsets from UTC.
 */
public class TimeZone {

        private final java.util.TimeZone timeZone;

        public TimeZone() {
                this("UTC");
        }

        public TimeZone(final String id) {
                if (id == null) {
                        throw new IllegalArgumentException("TimeZone id cannot be null");
                } else if ("".equals(id)) {
                        throw new IllegalArgumentException("TimeZone id cannot be empty");
                } else if ("".equals(id.trim())) {
                        throw new IllegalArgumentException("TimeZone id cannot be blank");
                }

                timeZone = java.util.TimeZone.getTimeZone(id);
        }

        public java.util.TimeZone toJavaUtilTimeZone() {
                return timeZone;
        }

        @Override
        public boolean equals(final Object other) {
                if (this == other) {
                        return true;
                }

                if (!(other instanceof TimeZone)) {
                        return false;
                }

                final TimeZone otherTimeZone = (TimeZone) other;
                return toJavaUtilTimeZone().equals(otherTimeZone.toJavaUtilTimeZone());
        }

        @Override
        public int hashCode() {
                return timeZone.hashCode();
        }
}

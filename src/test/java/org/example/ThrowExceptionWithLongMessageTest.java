package org.example;

import org.junit.jupiter.api.Test;

class ThrowExceptionWithLongMessageTest {

    @Test
    public void example() {
        Inner.throwException(1000);
    }
        
    public static class Inner {
        public static void throwException(final int messageLen) {
            final var sb = new StringBuilder();
            for (int i = 0; i < messageLen; i++) {
                sb.append("A");
            }
            throw new IllegalStateException(sb.toString());
        }
    }
}

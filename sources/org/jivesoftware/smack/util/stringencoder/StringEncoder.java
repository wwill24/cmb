package org.jivesoftware.smack.util.stringencoder;

public interface StringEncoder<O> {
    O decode(String str);

    String encode(O o10);
}

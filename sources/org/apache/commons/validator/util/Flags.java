package org.apache.commons.validator.util;

import java.io.Serializable;

public class Flags implements Serializable, Cloneable {
    private static final long serialVersionUID = 8481587558770237995L;
    private long flags;

    public Flags() {
        this.flags = 0;
    }

    public void clear() {
        this.flags = 0;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new RuntimeException("Couldn't clone Flags object.");
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Flags)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (this.flags == ((Flags) obj).flags) {
            return true;
        }
        return false;
    }

    public long getFlags() {
        return this.flags;
    }

    public int hashCode() {
        return (int) this.flags;
    }

    public boolean isOff(long j10) {
        return (j10 & this.flags) == 0;
    }

    public boolean isOn(long j10) {
        return (this.flags & j10) == j10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(Long.toBinaryString(this.flags));
        for (int length = 64 - sb2.length(); length > 0; length--) {
            sb2.insert(0, "0");
        }
        return sb2.toString();
    }

    public void turnOff(long j10) {
        this.flags = (~j10) & this.flags;
    }

    public void turnOffAll() {
        this.flags = 0;
    }

    public void turnOn(long j10) {
        this.flags = j10 | this.flags;
    }

    public void turnOnAll() {
        this.flags = -1;
    }

    public Flags(long j10) {
        this.flags = j10;
    }
}

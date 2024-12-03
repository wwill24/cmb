package com.google.android.gms.fido.fido2.api.common;

public final class zzas extends Exception {
    public zzas(String str) {
        super(String.format("User verification requirement %s not supported", new Object[]{str}));
    }
}

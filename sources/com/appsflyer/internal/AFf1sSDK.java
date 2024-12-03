package com.appsflyer.internal;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public final class AFf1sSDK {
    public final List<AFf1uSDK> values = new ArrayList();

    public final synchronized void AFKeystoreWrapper(AFf1uSDK aFf1uSDK) {
        this.values.add(aFf1uSDK);
    }

    @NonNull
    public final synchronized AFf1uSDK[] values() {
        return (AFf1uSDK[]) this.values.toArray(new AFf1uSDK[0]);
    }
}

package com.leanplum;

import com.leanplum.internal.ApiConfigLoader;

public final /* synthetic */ class l implements ApiConfigLoader.KeyListener {
    public final void onKeysLoaded(String str, String str2) {
        Leanplum.setAppIdForProductionMode(str, str2);
    }
}

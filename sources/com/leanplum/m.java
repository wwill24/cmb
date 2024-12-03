package com.leanplum;

import com.leanplum.internal.ApiConfigLoader;

public final /* synthetic */ class m implements ApiConfigLoader.KeyListener {
    public final void onKeysLoaded(String str, String str2) {
        Leanplum.setAppIdForDevelopmentMode(str, str2);
    }
}

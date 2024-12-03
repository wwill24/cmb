package com.mparticle.internal;

import kotlin.Metadata;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/mparticle/internal/SideloadedKit;", "", "Lorg/json/b;", "getJsonConfig", "", "kitId", "", "getName", "android-core_release"}, k = 1, mv = {1, 7, 1})
public interface SideloadedKit {
    b getJsonConfig();

    String getName();

    int kitId();
}

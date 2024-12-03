package com.leanplum.migration;

import com.leanplum.internal.Log;
import com.leanplum.internal.Request;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/Exception;", "kotlin.jvm.PlatformType", "error"}, k = 3, mv = {1, 4, 2})
final class MigrationManager$fetchStateAsync$1 implements Request.ErrorCallback {
    final /* synthetic */ Function1 $callback;

    MigrationManager$fetchStateAsync$1(Function1 function1) {
        this.$callback = function1;
    }

    public final void error(Exception exc) {
        Log.d("Error getting migration state", exc);
        this.$callback.invoke(Boolean.FALSE);
    }
}

package com.leanplum.migration;

import com.leanplum.internal.RequestSender;
import com.leanplum.internal.VarCache;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
final class MigrationManager$handleStateTransition$1 implements Runnable {
    public static final MigrationManager$handleStateTransition$1 INSTANCE = new MigrationManager$handleStateTransition$1();

    MigrationManager$handleStateTransition$1() {
    }

    public final void run() {
        RequestSender.getInstance().sendRequests();
        VarCache.clearUserContent();
        VarCache.saveDiffs();
    }
}

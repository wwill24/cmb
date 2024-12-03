package com.leanplum.migration;

import com.leanplum.internal.Log;
import com.leanplum.internal.Request;
import com.leanplum.migration.model.MigrationConfig;
import com.leanplum.migration.model.MigrationState;
import com.leanplum.migration.model.ResponseData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lorg/json/b;", "kotlin.jvm.PlatformType", "it", "", "response", "(Lorg/json/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
final class MigrationManager$fetchStateAsync$2 implements Request.ResponseCallback {
    final /* synthetic */ Function1 $callback;

    MigrationManager$fetchStateAsync$2(Function1 function1) {
        this.$callback = function1;
    }

    public final void response(b bVar) {
        Log.d("Migration state response: " + bVar, new Object[0]);
        ResponseHandler responseHandler = new ResponseHandler();
        j.f(bVar, "it");
        ResponseData handleMigrateStateContent = responseHandler.handleMigrateStateContent(bVar);
        if (handleMigrateStateContent != null) {
            MigrationState state = MigrationManager.getState();
            MigrationConfig.INSTANCE.update(handleMigrateStateContent);
            MigrationManager.INSTANCE.handleStateTransition(state, MigrationManager.getState());
        }
        this.$callback.invoke(Boolean.TRUE);
    }
}

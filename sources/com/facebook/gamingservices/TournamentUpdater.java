package com.facebook.gamingservices;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.bolts.TaskCompletionSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/TournamentUpdater;", "", "()V", "update", "Lcom/facebook/bolts/TaskCompletionSource;", "", "tournament", "Lcom/facebook/gamingservices/Tournament;", "score", "", "identifier", "", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TournamentUpdater {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.lang.Exception] */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: update$lambda-0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m110update$lambda0(com.facebook.bolts.TaskCompletionSource r3, com.facebook.GraphResponse r4) {
        /*
            java.lang.String r0 = "$task"
            kotlin.jvm.internal.j.g(r3, r0)
            java.lang.String r0 = "response"
            kotlin.jvm.internal.j.g(r4, r0)
            com.facebook.FacebookRequestError r0 = r4.getError()
            java.lang.String r1 = "Graph API Error"
            r2 = 0
            if (r0 == 0) goto L_0x0039
            com.facebook.FacebookRequestError r0 = r4.getError()
            if (r0 != 0) goto L_0x001b
            r0 = r2
            goto L_0x001f
        L_0x001b:
            com.facebook.FacebookException r0 = r0.getException()
        L_0x001f:
            if (r0 == 0) goto L_0x0030
            com.facebook.FacebookRequestError r4 = r4.getError()
            if (r4 != 0) goto L_0x0028
            goto L_0x002c
        L_0x0028:
            com.facebook.FacebookException r2 = r4.getException()
        L_0x002c:
            r3.setError(r2)
            return
        L_0x0030:
            com.facebook.gamingservices.GraphAPIException r4 = new com.facebook.gamingservices.GraphAPIException
            r4.<init>(r1)
            r3.setError(r4)
            return
        L_0x0039:
            org.json.b r4 = r4.getJSONObject()
            if (r4 != 0) goto L_0x0040
            goto L_0x0046
        L_0x0040:
            java.lang.String r0 = "success"
            java.lang.String r2 = r4.optString(r0)
        L_0x0046:
            if (r2 == 0) goto L_0x0062
            int r4 = r2.length()
            if (r4 != 0) goto L_0x0050
            r4 = 1
            goto L_0x0051
        L_0x0050:
            r4 = 0
        L_0x0051:
            if (r4 == 0) goto L_0x0054
            goto L_0x0062
        L_0x0054:
            java.lang.String r4 = "true"
            boolean r4 = r2.equals(r4)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r3.setResult(r4)
            return
        L_0x0062:
            com.facebook.gamingservices.GraphAPIException r4 = new com.facebook.gamingservices.GraphAPIException
            r4.<init>(r1)
            r3.setError(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gamingservices.TournamentUpdater.m110update$lambda0(com.facebook.bolts.TaskCompletionSource, com.facebook.GraphResponse):void");
    }

    public final TaskCompletionSource<Boolean> update(Tournament tournament, Number number) {
        j.g(tournament, "tournament");
        j.g(number, "score");
        return update(tournament.identifier, number);
    }

    public final TaskCompletionSource<Boolean> update(String str, Number number) {
        j.g(str, "identifier");
        j.g(number, "score");
        AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.isExpired()) {
            throw new FacebookException("Attempted to fetch tournament with an invalid access token");
        }
        if (currentAccessToken.getGraphDomain() != null && j.b(FacebookSdk.GAMING, currentAccessToken.getGraphDomain())) {
            TaskCompletionSource<Boolean> taskCompletionSource = new TaskCompletionSource<>();
            String p10 = j.p(str, "/update_score");
            Bundle bundle = new Bundle();
            bundle.putInt("score", number.intValue());
            new GraphRequest(currentAccessToken, p10, bundle, HttpMethod.POST, new j(taskCompletionSource), (String) null, 32, (DefaultConstructorMarker) null).executeAsync();
            return taskCompletionSource;
        }
        throw new FacebookException("User is not using gaming login");
    }
}

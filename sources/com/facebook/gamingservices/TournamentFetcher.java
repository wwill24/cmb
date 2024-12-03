package com.facebook.gamingservices;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.bolts.TaskCompletionSource;
import com.google.gson.d;
import com.google.gson.e;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import org.json.JSONException;
import org.json.a;
import org.json.b;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¨\u0006\u0007"}, d2 = {"Lcom/facebook/gamingservices/TournamentFetcher;", "", "()V", "fetchTournaments", "Lcom/facebook/bolts/TaskCompletionSource;", "", "Lcom/facebook/gamingservices/Tournament;", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TournamentFetcher {
    /* access modifiers changed from: private */
    /* renamed from: fetchTournaments$lambda-1  reason: not valid java name */
    public static final void m107fetchTournaments$lambda1(TaskCompletionSource taskCompletionSource, GraphResponse graphResponse) {
        FacebookException facebookException;
        j.g(taskCompletionSource, "$task");
        j.g(graphResponse, "response");
        if (graphResponse.getError() != null) {
            FacebookRequestError error = graphResponse.getError();
            FacebookException facebookException2 = null;
            if (error == null) {
                facebookException = null;
            } else {
                facebookException = error.getException();
            }
            if (facebookException != null) {
                FacebookRequestError error2 = graphResponse.getError();
                if (error2 != null) {
                    facebookException2 = error2.getException();
                }
                taskCompletionSource.setError(facebookException2);
                return;
            }
            taskCompletionSource.setError(new GraphAPIException("Graph API Error"));
            return;
        }
        try {
            b jSONObject = graphResponse.getJSONObject();
            if (jSONObject == null) {
                taskCompletionSource.setError(new GraphAPIException("Failed to get response"));
                return;
            }
            a jSONArray = jSONObject.getJSONArray("data");
            if (jSONArray != null) {
                if (jSONArray.o() >= 1) {
                    d b10 = new e().b();
                    String aVar = jSONArray.toString();
                    j.f(aVar, "data.toString()");
                    Object k10 = b10.k(aVar, Tournament[].class);
                    j.f(k10, "gson.fromJson(dataString, Array<Tournament>::class.java)");
                    taskCompletionSource.setResult(l.p0((Object[]) k10));
                    return;
                }
            }
            o oVar = o.f32141a;
            String format2 = String.format(Locale.ROOT, "No tournament found", Arrays.copyOf(new Object[]{Integer.valueOf(jSONArray.o()), 1}, 2));
            j.f(format2, "java.lang.String.format(locale, format, *args)");
            taskCompletionSource.setError(new GraphAPIException(format2));
        } catch (JSONException e10) {
            taskCompletionSource.setError(e10);
        }
    }

    public final TaskCompletionSource<List<Tournament>> fetchTournaments() {
        boolean z10;
        TaskCompletionSource<List<Tournament>> taskCompletionSource = new TaskCompletionSource<>();
        Bundle bundle = new Bundle();
        AccessToken.Companion companion = AccessToken.Companion;
        AccessToken currentAccessToken = companion.getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.isExpired()) {
            throw new FacebookException("Attempted to fetch tournament with an invalid access token");
        }
        if (currentAccessToken.getGraphDomain() == null || !j.b(FacebookSdk.GAMING, currentAccessToken.getGraphDomain())) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            GraphRequest graphRequest = new GraphRequest(companion.getCurrentAccessToken(), "me/tournaments", bundle, HttpMethod.GET, new g(taskCompletionSource), (String) null, 32, (DefaultConstructorMarker) null);
            graphRequest.setParameters(bundle);
            graphRequest.executeAsync();
            return taskCompletionSource;
        }
        throw new FacebookException("User is not using gaming login");
    }
}

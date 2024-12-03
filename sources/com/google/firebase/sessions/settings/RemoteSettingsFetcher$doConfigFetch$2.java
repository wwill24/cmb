package com.google.firebase.sessions.settings;

import gk.g;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;
import org.json.b;

@d(c = "com.google.firebase.sessions.settings.RemoteSettingsFetcher$doConfigFetch$2", f = "RemoteSettingsFetcher.kt", l = {68, 70, 73}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/k0;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class RemoteSettingsFetcher$doConfigFetch$2 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $headerOptions;
    final /* synthetic */ Function2<String, c<? super Unit>, Object> $onFailure;
    final /* synthetic */ Function2<b, c<? super Unit>, Object> $onSuccess;
    int label;
    final /* synthetic */ RemoteSettingsFetcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RemoteSettingsFetcher$doConfigFetch$2(RemoteSettingsFetcher remoteSettingsFetcher, Map<String, String> map, Function2<? super b, ? super c<? super Unit>, ? extends Object> function2, Function2<? super String, ? super c<? super Unit>, ? extends Object> function22, c<? super RemoteSettingsFetcher$doConfigFetch$2> cVar) {
        super(2, cVar);
        this.this$0 = remoteSettingsFetcher;
        this.$headerOptions = map;
        this.$onSuccess = function2;
        this.$onFailure = function22;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new RemoteSettingsFetcher$doConfigFetch$2(this.this$0, this.$headerOptions, this.$onSuccess, this.$onFailure, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((RemoteSettingsFetcher$doConfigFetch$2) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            URLConnection openConnection = this.this$0.settingsUrl().openConnection();
            j.e(openConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setRequestProperty("Accept", "application/json");
            for (Map.Entry next : this.$headerOptions.entrySet()) {
                httpsURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            int responseCode = httpsURLConnection.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = httpsURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder sb2 = new StringBuilder();
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                while (true) {
                    T readLine = bufferedReader.readLine();
                    ref$ObjectRef.element = readLine;
                    if (readLine == null) {
                        break;
                    }
                    sb2.append(readLine);
                }
                bufferedReader.close();
                inputStream.close();
                b bVar = new b(sb2.toString());
                Function2<b, c<? super Unit>, Object> function2 = this.$onSuccess;
                this.label = 1;
                if (function2.invoke(bVar, this) == d10) {
                    return d10;
                }
            } else {
                Function2<String, c<? super Unit>, Object> function22 = this.$onFailure;
                String str = "Bad response code: " + responseCode;
                this.label = 2;
                if (function22.invoke(str, this) == d10) {
                    return d10;
                }
            }
        } else if (i10 == 1 || i10 == 2) {
            try {
                g.b(obj);
            } catch (Exception e10) {
                Function2<String, c<? super Unit>, Object> function23 = this.$onFailure;
                String message = e10.getMessage();
                if (message == null) {
                    message = e10.toString();
                }
                this.label = 3;
                if (function23.invoke(message, this) == d10) {
                    return d10;
                }
            }
        } else if (i10 == 3) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f32013a;
    }
}

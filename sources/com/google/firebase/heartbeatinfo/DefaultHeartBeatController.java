package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.util.Base64OutputStream;
import androidx.annotation.NonNull;
import androidx.core.os.n;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;
import org.json.a;
import org.json.b;

public class DefaultHeartBeatController implements HeartBeatController, HeartBeatInfo {
    private final Context applicationContext;
    private final Executor backgroundExecutor;
    private final Set<HeartBeatConsumer> consumers;
    private final Provider<HeartBeatInfoStorage> storageProvider;
    private final Provider<UserAgentPublisher> userAgentProvider;

    private DefaultHeartBeatController(Context context, String str, Set<HeartBeatConsumer> set, Provider<UserAgentPublisher> provider, Executor executor) {
        this((Provider<HeartBeatInfoStorage>) new d(context, str), set, executor, provider, context);
    }

    @NonNull
    public static Component<DefaultHeartBeatController> component() {
        Qualified<Executor> qualified = Qualified.qualified(Background.class, Executor.class);
        return Component.builder(DefaultHeartBeatController.class, (Class<? super T>[]) new Class[]{HeartBeatController.class, HeartBeatInfo.class}).add(Dependency.required((Class<?>) Context.class)).add(Dependency.required((Class<?>) FirebaseApp.class)).add(Dependency.setOf((Class<?>) HeartBeatConsumer.class)).add(Dependency.requiredProvider((Class<?>) UserAgentPublisher.class)).add(Dependency.required((Qualified<?>) qualified)).factory(new c(qualified)).build();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ DefaultHeartBeatController lambda$component$3(Qualified qualified, ComponentContainer componentContainer) {
        return new DefaultHeartBeatController((Context) componentContainer.get(Context.class), ((FirebaseApp) componentContainer.get(FirebaseApp.class)).getPersistenceKey(), componentContainer.setOf(HeartBeatConsumer.class), componentContainer.getProvider(UserAgentPublisher.class), (Executor) componentContainer.get(qualified));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String lambda$getHeartBeatsHeader$1() throws Exception {
        GZIPOutputStream gZIPOutputStream;
        String byteArrayOutputStream;
        synchronized (this) {
            HeartBeatInfoStorage heartBeatInfoStorage = this.storageProvider.get();
            List<HeartBeatResult> allHeartBeats = heartBeatInfoStorage.getAllHeartBeats();
            heartBeatInfoStorage.deleteAllHeartBeats();
            a aVar = new a();
            for (int i10 = 0; i10 < allHeartBeats.size(); i10++) {
                HeartBeatResult heartBeatResult = allHeartBeats.get(i10);
                b bVar = new b();
                bVar.put("agent", (Object) heartBeatResult.getUserAgent());
                bVar.put("dates", (Object) new a((Collection<?>) heartBeatResult.getUsedDates()));
                aVar.E(bVar);
            }
            b bVar2 = new b();
            bVar2.put("heartbeats", (Object) aVar);
            bVar2.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, (Object) "2");
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream2, 11);
            try {
                gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                gZIPOutputStream.write(bVar2.toString().getBytes("UTF-8"));
                gZIPOutputStream.close();
                base64OutputStream.close();
                byteArrayOutputStream = byteArrayOutputStream2.toString("UTF-8");
            } catch (Throwable th2) {
                try {
                    base64OutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        return byteArrayOutputStream;
        throw th;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ HeartBeatInfoStorage lambda$new$2(Context context, String str) {
        return new HeartBeatInfoStorage(context, str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Void lambda$registerHeartBeat$0() throws Exception {
        synchronized (this) {
            this.storageProvider.get().storeHeartBeat(System.currentTimeMillis(), this.userAgentProvider.get().getUserAgent());
        }
        return null;
    }

    @NonNull
    public synchronized HeartBeatInfo.HeartBeat getHeartBeatCode(@NonNull String str) {
        long currentTimeMillis = System.currentTimeMillis();
        HeartBeatInfoStorage heartBeatInfoStorage = this.storageProvider.get();
        if (heartBeatInfoStorage.shouldSendGlobalHeartBeat(currentTimeMillis)) {
            heartBeatInfoStorage.postHeartBeatCleanUp();
            return HeartBeatInfo.HeartBeat.GLOBAL;
        }
        return HeartBeatInfo.HeartBeat.NONE;
    }

    public Task<String> getHeartBeatsHeader() {
        if (!n.a(this.applicationContext)) {
            return Tasks.forResult("");
        }
        return Tasks.call(this.backgroundExecutor, new a(this));
    }

    public Task<Void> registerHeartBeat() {
        if (this.consumers.size() <= 0) {
            return Tasks.forResult(null);
        }
        if (!n.a(this.applicationContext)) {
            return Tasks.forResult(null);
        }
        return Tasks.call(this.backgroundExecutor, new b(this));
    }

    DefaultHeartBeatController(Provider<HeartBeatInfoStorage> provider, Set<HeartBeatConsumer> set, Executor executor, Provider<UserAgentPublisher> provider2, Context context) {
        this.storageProvider = provider;
        this.consumers = set;
        this.backgroundExecutor = executor;
        this.userAgentProvider = provider2;
        this.applicationContext = context;
    }
}

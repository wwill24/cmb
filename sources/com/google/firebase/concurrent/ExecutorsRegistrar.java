package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Lazy;
import com.google.firebase.components.Qualified;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

@SuppressLint({"ThreadPoolCreation"})
public class ExecutorsRegistrar implements ComponentRegistrar {
    static final Lazy<ScheduledExecutorService> BG_EXECUTOR = new Lazy<>(new s());
    static final Lazy<ScheduledExecutorService> BLOCKING_EXECUTOR = new Lazy<>(new u());
    static final Lazy<ScheduledExecutorService> LITE_EXECUTOR = new Lazy<>(new t());
    static final Lazy<ScheduledExecutorService> SCHEDULER = new Lazy<>(new v());

    private static StrictMode.ThreadPolicy bgPolicy() {
        StrictMode.ThreadPolicy.Builder detectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        int i10 = Build.VERSION.SDK_INT;
        detectNetwork.detectResourceMismatches();
        if (i10 >= 26) {
            StrictMode.ThreadPolicy.Builder unused = detectNetwork.detectUnbufferedIo();
        }
        return detectNetwork.penaltyLog().build();
    }

    private static ThreadFactory factory(String str, int i10) {
        return new CustomThreadFactory(str, i10, (StrictMode.ThreadPolicy) null);
    }

    private static StrictMode.ThreadPolicy litePolicy() {
        return new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    }

    /* access modifiers changed from: private */
    public static ScheduledExecutorService scheduled(ExecutorService executorService) {
        return new DelegatingScheduledExecutorService(executorService, SCHEDULER.get());
    }

    public List<Component<?>> getComponents() {
        return Arrays.asList(new Component[]{Component.builder(Qualified.qualified(Background.class, ScheduledExecutorService.class), (Qualified<? super T>[]) new Qualified[]{Qualified.qualified(Background.class, ExecutorService.class), Qualified.qualified(Background.class, Executor.class)}).factory(new o()).build(), Component.builder(Qualified.qualified(Blocking.class, ScheduledExecutorService.class), (Qualified<? super T>[]) new Qualified[]{Qualified.qualified(Blocking.class, ExecutorService.class), Qualified.qualified(Blocking.class, Executor.class)}).factory(new p()).build(), Component.builder(Qualified.qualified(Lightweight.class, ScheduledExecutorService.class), (Qualified<? super T>[]) new Qualified[]{Qualified.qualified(Lightweight.class, ExecutorService.class), Qualified.qualified(Lightweight.class, Executor.class)}).factory(new q()).build(), Component.builder(Qualified.qualified(UiThread.class, Executor.class)).factory(new r()).build()});
    }

    private static ThreadFactory factory(String str, int i10, StrictMode.ThreadPolicy threadPolicy) {
        return new CustomThreadFactory(str, i10, threadPolicy);
    }
}

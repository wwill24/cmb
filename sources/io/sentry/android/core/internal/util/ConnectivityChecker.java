package io.sentry.android.core.internal.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import io.sentry.SentryLevel;
import io.sentry.android.core.i0;
import io.sentry.h0;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class ConnectivityChecker {

    public enum Status {
        CONNECTED,
        NOT_CONNECTED,
        NO_PERMISSION,
        UNKNOWN
    }

    private static Status a(Context context, ConnectivityManager connectivityManager, h0 h0Var) {
        if (!i.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            h0Var.c(SentryLevel.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return Status.NO_PERMISSION;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            h0Var.c(SentryLevel.INFO, "NetworkInfo is null, there's no active network.", new Object[0]);
            return Status.NOT_CONNECTED;
        } else if (activeNetworkInfo.isConnected()) {
            return Status.CONNECTED;
        } else {
            return Status.NOT_CONNECTED;
        }
    }

    public static Status b(Context context, h0 h0Var) {
        ConnectivityManager e10 = e(context, h0Var);
        if (e10 == null) {
            return Status.UNKNOWN;
        }
        return a(context, e10, h0Var);
    }

    @SuppressLint({"ObsoleteSdkInt", "MissingPermission", "NewApi"})
    public static String c(Context context, h0 h0Var, i0 i0Var) {
        boolean z10;
        ConnectivityManager e10 = e(context, h0Var);
        if (e10 == null) {
            return null;
        }
        boolean z11 = false;
        if (!i.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            h0Var.c(SentryLevel.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return null;
        }
        boolean z12 = true;
        if (i0Var.d() >= 23) {
            Network activeNetwork = e10.getActiveNetwork();
            if (activeNetwork == null) {
                h0Var.c(SentryLevel.INFO, "Network is null and cannot check network status", new Object[0]);
                return null;
            }
            NetworkCapabilities networkCapabilities = e10.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities == null) {
                h0Var.c(SentryLevel.INFO, "NetworkCapabilities is null and cannot check network type", new Object[0]);
                return null;
            }
            boolean hasTransport = networkCapabilities.hasTransport(3);
            z10 = networkCapabilities.hasTransport(1);
            z12 = networkCapabilities.hasTransport(0);
            z11 = hasTransport;
        } else {
            NetworkInfo activeNetworkInfo = e10.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                h0Var.c(SentryLevel.INFO, "NetworkInfo is null, there's no active network.", new Object[0]);
                return null;
            }
            int type = activeNetworkInfo.getType();
            if (type == 0) {
                z10 = false;
            } else if (type != 1) {
                if (type != 9) {
                    z10 = false;
                } else {
                    z10 = false;
                    z11 = true;
                }
                z12 = z10;
            } else {
                z10 = true;
                z12 = false;
            }
        }
        if (z11) {
            return "ethernet";
        }
        if (z10) {
            return "wifi";
        }
        if (z12) {
            return "cellular";
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    public static String d(NetworkCapabilities networkCapabilities, i0 i0Var) {
        if (i0Var.d() < 21) {
            return null;
        }
        if (networkCapabilities.hasTransport(3)) {
            return "ethernet";
        }
        if (networkCapabilities.hasTransport(1)) {
            return "wifi";
        }
        if (networkCapabilities.hasTransport(0)) {
            return "cellular";
        }
        return null;
    }

    private static ConnectivityManager e(Context context, h0 h0Var) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            h0Var.c(SentryLevel.INFO, "ConnectivityManager is null and cannot check network status", new Object[0]);
        }
        return connectivityManager;
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static boolean f(Context context, h0 h0Var, i0 i0Var, ConnectivityManager.NetworkCallback networkCallback) {
        if (i0Var.d() < 24) {
            h0Var.c(SentryLevel.DEBUG, "NetworkCallbacks need Android N+.", new Object[0]);
            return false;
        }
        ConnectivityManager e10 = e(context, h0Var);
        if (e10 == null) {
            return false;
        }
        if (!i.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            h0Var.c(SentryLevel.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return false;
        }
        e10.registerDefaultNetworkCallback(networkCallback);
        return true;
    }

    @SuppressLint({"NewApi"})
    public static void g(Context context, h0 h0Var, i0 i0Var, ConnectivityManager.NetworkCallback networkCallback) {
        ConnectivityManager e10;
        if (i0Var.d() >= 21 && (e10 = e(context, h0Var)) != null) {
            e10.unregisterNetworkCallback(networkCallback);
        }
    }
}

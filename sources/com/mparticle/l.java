package com.mparticle;

import android.content.ContentValues;
import android.os.Message;
import androidx.annotation.NonNull;
import com.mparticle.SdkListener;
import com.mparticle.identity.AliasResponse;
import com.mparticle.internal.InternalSession;
import org.json.b;

public interface l {

    /* renamed from: a  reason: collision with root package name */
    public static final l f22606a = new a();

    class a implements l {
        a() {
        }

        public void onAliasRequestFinished(AliasResponse aliasResponse) {
        }

        public void onCompositeObjects(Object obj, Object obj2) {
        }

        public void onEntityStored(Long l10, String str, ContentValues contentValues) {
        }

        public void onKitApiCalled(int i10, Boolean bool, Object... objArr) {
        }

        public void onKitApiCalled(String str, int i10, Boolean bool, Object... objArr) {
        }

        public void onKitConfigReceived(int i10, String str) {
        }

        public void onKitDetected(int i10) {
        }

        public void onKitExcluded(int i10, String str) {
        }

        public void onKitStarted(int i10) {
        }

        public void onNetworkRequestFinished(SdkListener.Endpoint endpoint, String str, b bVar, int i10) {
        }

        public void onNetworkRequestStarted(SdkListener.Endpoint endpoint, String str, b bVar, Object... objArr) {
        }

        public void onSessionUpdated(InternalSession internalSession) {
        }

        public void onThreadMessage(String str, Message message, boolean z10) {
        }
    }

    void onAliasRequestFinished(AliasResponse aliasResponse);

    void onCompositeObjects(Object obj, Object obj2);

    void onEntityStored(Long l10, String str, ContentValues contentValues);

    void onKitApiCalled(int i10, Boolean bool, Object... objArr);

    void onKitApiCalled(String str, int i10, Boolean bool, Object... objArr);

    void onKitConfigReceived(int i10, String str);

    void onKitDetected(int i10);

    void onKitExcluded(int i10, String str);

    void onKitStarted(int i10);

    void onNetworkRequestFinished(SdkListener.Endpoint endpoint, String str, b bVar, int i10);

    void onNetworkRequestStarted(SdkListener.Endpoint endpoint, String str, b bVar, Object... objArr);

    void onSessionUpdated(InternalSession internalSession);

    void onThreadMessage(@NonNull String str, @NonNull Message message, boolean z10);
}

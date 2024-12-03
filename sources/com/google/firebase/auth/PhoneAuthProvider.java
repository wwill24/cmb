package com.google.firebase.auth;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthOptions;
import fe.a;
import java.util.concurrent.TimeUnit;

public class PhoneAuthProvider {
    @NonNull
    public static final String PHONE_SIGN_IN_METHOD = "phone";
    @NonNull
    public static final String PROVIDER_ID = "phone";
    private final FirebaseAuth zza;

    public static class ForceResendingToken extends AbstractSafeParcelable {
        @NonNull
        public static final Parcelable.Creator<ForceResendingToken> CREATOR = new zzd();

        ForceResendingToken() {
        }

        @NonNull
        public static ForceResendingToken zza() {
            return new ForceResendingToken();
        }

        public final void writeToParcel(@NonNull Parcel parcel, int i10) {
            a.b(parcel, a.a(parcel));
        }
    }

    public static abstract class OnVerificationStateChangedCallbacks {
        private static final he.a zza = new he.a("PhoneAuthProvider", new String[0]);

        public void onCodeAutoRetrievalTimeOut(@NonNull String str) {
            zza.e("Sms auto retrieval timed-out.", new Object[0]);
        }

        public void onCodeSent(@NonNull String str, @NonNull ForceResendingToken forceResendingToken) {
        }

        public abstract void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential);

        public abstract void onVerificationFailed(@NonNull FirebaseException firebaseException);
    }

    private PhoneAuthProvider(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    @NonNull
    public static PhoneAuthCredential getCredential(@NonNull String str, @NonNull String str2) {
        return PhoneAuthCredential.zzc(str, str2);
    }

    @NonNull
    @Deprecated
    public static PhoneAuthProvider getInstance() {
        return new PhoneAuthProvider(FirebaseAuth.getInstance(FirebaseApp.getInstance()));
    }

    @NonNull
    @Deprecated
    public static PhoneAuthProvider getInstance(@NonNull FirebaseAuth firebaseAuth) {
        return new PhoneAuthProvider(firebaseAuth);
    }

    public static void verifyPhoneNumber(@NonNull PhoneAuthOptions phoneAuthOptions) {
        p.k(phoneAuthOptions);
        phoneAuthOptions.zzb().zzU(phoneAuthOptions);
    }

    @Deprecated
    public void verifyPhoneNumber(@NonNull String str, long j10, @NonNull TimeUnit timeUnit, @NonNull Activity activity, @NonNull OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        PhoneAuthOptions.Builder newBuilder = PhoneAuthOptions.newBuilder(this.zza);
        newBuilder.setPhoneNumber(str);
        newBuilder.setTimeout(Long.valueOf(j10), timeUnit);
        newBuilder.setActivity(activity);
        newBuilder.setCallbacks(onVerificationStateChangedCallbacks);
        verifyPhoneNumber(newBuilder.build());
    }

    @Deprecated
    public void verifyPhoneNumber(@NonNull String str, long j10, @NonNull TimeUnit timeUnit, @NonNull Activity activity, @NonNull OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, ForceResendingToken forceResendingToken) {
        PhoneAuthOptions.Builder newBuilder = PhoneAuthOptions.newBuilder(this.zza);
        newBuilder.setPhoneNumber(str);
        newBuilder.setTimeout(Long.valueOf(j10), timeUnit);
        newBuilder.setActivity(activity);
        newBuilder.setCallbacks(onVerificationStateChangedCallbacks);
        if (forceResendingToken != null) {
            newBuilder.setForceResendingToken(forceResendingToken);
        }
        verifyPhoneNumber(newBuilder.build());
    }
}

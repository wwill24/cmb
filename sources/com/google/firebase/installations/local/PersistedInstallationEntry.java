package com.google.firebase.installations.local;

import androidx.annotation.NonNull;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import com.google.firebase.installations.local.PersistedInstallation;

public abstract class PersistedInstallationEntry {
    @NonNull
    public static PersistedInstallationEntry INSTANCE = builder().build();

    public static abstract class Builder {
        @NonNull
        public abstract PersistedInstallationEntry build();

        @NonNull
        public abstract Builder setAuthToken(String str);

        @NonNull
        public abstract Builder setExpiresInSecs(long j10);

        @NonNull
        public abstract Builder setFirebaseInstallationId(@NonNull String str);

        @NonNull
        public abstract Builder setFisError(String str);

        @NonNull
        public abstract Builder setRefreshToken(String str);

        @NonNull
        public abstract Builder setRegistrationStatus(@NonNull PersistedInstallation.RegistrationStatus registrationStatus);

        @NonNull
        public abstract Builder setTokenCreationEpochInSecs(long j10);
    }

    @NonNull
    public static Builder builder() {
        return new AutoValue_PersistedInstallationEntry.Builder().setTokenCreationEpochInSecs(0).setRegistrationStatus(PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION).setExpiresInSecs(0);
    }

    public abstract String getAuthToken();

    public abstract long getExpiresInSecs();

    public abstract String getFirebaseInstallationId();

    public abstract String getFisError();

    public abstract String getRefreshToken();

    @NonNull
    public abstract PersistedInstallation.RegistrationStatus getRegistrationStatus();

    public abstract long getTokenCreationEpochInSecs();

    public boolean isErrored() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.REGISTER_ERROR;
    }

    public boolean isNotGenerated() {
        if (getRegistrationStatus() == PersistedInstallation.RegistrationStatus.NOT_GENERATED || getRegistrationStatus() == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION) {
            return true;
        }
        return false;
    }

    public boolean isRegistered() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.REGISTERED;
    }

    public boolean isUnregistered() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.UNREGISTERED;
    }

    public boolean shouldAttemptMigration() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION;
    }

    @NonNull
    public abstract Builder toBuilder();

    @NonNull
    public PersistedInstallationEntry withAuthToken(@NonNull String str, long j10, long j11) {
        return toBuilder().setAuthToken(str).setExpiresInSecs(j10).setTokenCreationEpochInSecs(j11).build();
    }

    @NonNull
    public PersistedInstallationEntry withClearedAuthToken() {
        return toBuilder().setAuthToken((String) null).build();
    }

    @NonNull
    public PersistedInstallationEntry withFisError(@NonNull String str) {
        return toBuilder().setFisError(str).setRegistrationStatus(PersistedInstallation.RegistrationStatus.REGISTER_ERROR).build();
    }

    @NonNull
    public PersistedInstallationEntry withNoGeneratedFid() {
        return toBuilder().setRegistrationStatus(PersistedInstallation.RegistrationStatus.NOT_GENERATED).build();
    }

    @NonNull
    public PersistedInstallationEntry withRegisteredFid(@NonNull String str, @NonNull String str2, long j10, String str3, long j11) {
        return toBuilder().setFirebaseInstallationId(str).setRegistrationStatus(PersistedInstallation.RegistrationStatus.REGISTERED).setAuthToken(str3).setRefreshToken(str2).setExpiresInSecs(j11).setTokenCreationEpochInSecs(j10).build();
    }

    @NonNull
    public PersistedInstallationEntry withUnregisteredFid(@NonNull String str) {
        return toBuilder().setFirebaseInstallationId(str).setRegistrationStatus(PersistedInstallation.RegistrationStatus.UNREGISTERED).build();
    }
}

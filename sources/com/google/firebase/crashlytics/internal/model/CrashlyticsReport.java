package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_ApplicationExitInfo;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_CustomAttribute;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload_File;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application_Organization;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Device;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Device;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Log;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_OperatingSystem;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_User;
import com.google.firebase.encoders.annotations.Encodable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.charset.Charset;

@Encodable
public abstract class CrashlyticsReport {
    /* access modifiers changed from: private */
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static abstract class ApplicationExitInfo {

        public static abstract class BuildIdMappingForArch {

            public static abstract class Builder {
                @NonNull
                public abstract BuildIdMappingForArch build();

                @NonNull
                public abstract Builder setArch(@NonNull String str);

                @NonNull
                public abstract Builder setBuildId(@NonNull String str);

                @NonNull
                public abstract Builder setLibraryName(@NonNull String str);
            }

            @NonNull
            public static Builder builder() {
                return new AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch.Builder();
            }

            @NonNull
            public abstract String getArch();

            @NonNull
            public abstract String getBuildId();

            @NonNull
            public abstract String getLibraryName();
        }

        public static abstract class Builder {
            @NonNull
            public abstract ApplicationExitInfo build();

            @NonNull
            public abstract Builder setBuildIdMappingForArch(ImmutableList<BuildIdMappingForArch> immutableList);

            @NonNull
            public abstract Builder setImportance(@NonNull int i10);

            @NonNull
            public abstract Builder setPid(@NonNull int i10);

            @NonNull
            public abstract Builder setProcessName(@NonNull String str);

            @NonNull
            public abstract Builder setPss(@NonNull long j10);

            @NonNull
            public abstract Builder setReasonCode(@NonNull int i10);

            @NonNull
            public abstract Builder setRss(@NonNull long j10);

            @NonNull
            public abstract Builder setTimestamp(@NonNull long j10);

            @NonNull
            public abstract Builder setTraceFile(String str);
        }

        @NonNull
        public static Builder builder() {
            return new AutoValue_CrashlyticsReport_ApplicationExitInfo.Builder();
        }

        public abstract ImmutableList<BuildIdMappingForArch> getBuildIdMappingForArch();

        @NonNull
        public abstract int getImportance();

        @NonNull
        public abstract int getPid();

        @NonNull
        public abstract String getProcessName();

        @NonNull
        public abstract long getPss();

        @NonNull
        public abstract int getReasonCode();

        @NonNull
        public abstract long getRss();

        @NonNull
        public abstract long getTimestamp();

        public abstract String getTraceFile();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Architecture {
        public static final int ARM64 = 9;
        public static final int ARMV6 = 5;
        public static final int ARMV7 = 6;
        public static final int UNKNOWN = 7;
        public static final int X86_32 = 0;
        public static final int X86_64 = 1;
    }

    public static abstract class Builder {
        @NonNull
        public abstract CrashlyticsReport build();

        @NonNull
        public abstract Builder setAppExitInfo(ApplicationExitInfo applicationExitInfo);

        @NonNull
        public abstract Builder setAppQualitySessionId(String str);

        @NonNull
        public abstract Builder setBuildVersion(@NonNull String str);

        @NonNull
        public abstract Builder setDisplayVersion(@NonNull String str);

        @NonNull
        public abstract Builder setFirebaseInstallationId(String str);

        @NonNull
        public abstract Builder setGmpAppId(@NonNull String str);

        @NonNull
        public abstract Builder setInstallationUuid(@NonNull String str);

        @NonNull
        public abstract Builder setNdkPayload(FilesPayload filesPayload);

        @NonNull
        public abstract Builder setPlatform(int i10);

        @NonNull
        public abstract Builder setSdkVersion(@NonNull String str);

        @NonNull
        public abstract Builder setSession(@NonNull Session session);
    }

    public static abstract class CustomAttribute {

        public static abstract class Builder {
            @NonNull
            public abstract CustomAttribute build();

            @NonNull
            public abstract Builder setKey(@NonNull String str);

            @NonNull
            public abstract Builder setValue(@NonNull String str);
        }

        @NonNull
        public static Builder builder() {
            return new AutoValue_CrashlyticsReport_CustomAttribute.Builder();
        }

        @NonNull
        public abstract String getKey();

        @NonNull
        public abstract String getValue();
    }

    public static abstract class FilesPayload {

        public static abstract class Builder {
            public abstract FilesPayload build();

            public abstract Builder setFiles(ImmutableList<File> immutableList);

            public abstract Builder setOrgId(String str);
        }

        public static abstract class File {

            public static abstract class Builder {
                public abstract File build();

                public abstract Builder setContents(byte[] bArr);

                public abstract Builder setFilename(String str);
            }

            @NonNull
            public static Builder builder() {
                return new AutoValue_CrashlyticsReport_FilesPayload_File.Builder();
            }

            @NonNull
            public abstract byte[] getContents();

            @NonNull
            public abstract String getFilename();
        }

        @NonNull
        public static Builder builder() {
            return new AutoValue_CrashlyticsReport_FilesPayload.Builder();
        }

        @NonNull
        public abstract ImmutableList<File> getFiles();

        public abstract String getOrgId();

        /* access modifiers changed from: package-private */
        public abstract Builder toBuilder();
    }

    public static abstract class Session {

        public static abstract class Application {

            public static abstract class Builder {
                @NonNull
                public abstract Application build();

                @NonNull
                public abstract Builder setDevelopmentPlatform(String str);

                @NonNull
                public abstract Builder setDevelopmentPlatformVersion(String str);

                @NonNull
                public abstract Builder setDisplayVersion(@NonNull String str);

                @NonNull
                public abstract Builder setIdentifier(@NonNull String str);

                @NonNull
                public abstract Builder setInstallationUuid(@NonNull String str);

                @NonNull
                public abstract Builder setOrganization(@NonNull Organization organization);

                @NonNull
                public abstract Builder setVersion(@NonNull String str);
            }

            public static abstract class Organization {

                public static abstract class Builder {
                    @NonNull
                    public abstract Organization build();

                    @NonNull
                    public abstract Builder setClsId(@NonNull String str);
                }

                @NonNull
                public static Builder builder() {
                    return new AutoValue_CrashlyticsReport_Session_Application_Organization.Builder();
                }

                @NonNull
                public abstract String getClsId();

                /* access modifiers changed from: protected */
                @NonNull
                public abstract Builder toBuilder();
            }

            @NonNull
            public static Builder builder() {
                return new AutoValue_CrashlyticsReport_Session_Application.Builder();
            }

            public abstract String getDevelopmentPlatform();

            public abstract String getDevelopmentPlatformVersion();

            public abstract String getDisplayVersion();

            @NonNull
            public abstract String getIdentifier();

            public abstract String getInstallationUuid();

            public abstract Organization getOrganization();

            @NonNull
            public abstract String getVersion();

            /* access modifiers changed from: protected */
            @NonNull
            public abstract Builder toBuilder();

            /* access modifiers changed from: package-private */
            @NonNull
            public Application withOrganizationId(@NonNull String str) {
                Organization.Builder builder;
                Organization organization = getOrganization();
                if (organization != null) {
                    builder = organization.toBuilder();
                } else {
                    builder = Organization.builder();
                }
                return toBuilder().setOrganization(builder.setClsId(str).build()).build();
            }
        }

        public static abstract class Builder {
            @NonNull
            public abstract Session build();

            @NonNull
            public abstract Builder setApp(@NonNull Application application);

            @NonNull
            public abstract Builder setAppQualitySessionId(String str);

            @NonNull
            public abstract Builder setCrashed(boolean z10);

            @NonNull
            public abstract Builder setDevice(@NonNull Device device);

            @NonNull
            public abstract Builder setEndedAt(@NonNull Long l10);

            @NonNull
            public abstract Builder setEvents(@NonNull ImmutableList<Event> immutableList);

            @NonNull
            public abstract Builder setGenerator(@NonNull String str);

            @NonNull
            public abstract Builder setGeneratorType(int i10);

            @NonNull
            public abstract Builder setIdentifier(@NonNull String str);

            @NonNull
            public Builder setIdentifierFromUtf8Bytes(@NonNull byte[] bArr) {
                return setIdentifier(new String(bArr, CrashlyticsReport.UTF_8));
            }

            @NonNull
            public abstract Builder setOs(@NonNull OperatingSystem operatingSystem);

            @NonNull
            public abstract Builder setStartedAt(long j10);

            @NonNull
            public abstract Builder setUser(@NonNull User user);
        }

        public static abstract class Device {

            public static abstract class Builder {
                @NonNull
                public abstract Device build();

                @NonNull
                public abstract Builder setArch(int i10);

                @NonNull
                public abstract Builder setCores(int i10);

                @NonNull
                public abstract Builder setDiskSpace(long j10);

                @NonNull
                public abstract Builder setManufacturer(@NonNull String str);

                @NonNull
                public abstract Builder setModel(@NonNull String str);

                @NonNull
                public abstract Builder setModelClass(@NonNull String str);

                @NonNull
                public abstract Builder setRam(long j10);

                @NonNull
                public abstract Builder setSimulator(boolean z10);

                @NonNull
                public abstract Builder setState(int i10);
            }

            @NonNull
            public static Builder builder() {
                return new AutoValue_CrashlyticsReport_Session_Device.Builder();
            }

            @NonNull
            public abstract int getArch();

            public abstract int getCores();

            public abstract long getDiskSpace();

            @NonNull
            public abstract String getManufacturer();

            @NonNull
            public abstract String getModel();

            @NonNull
            public abstract String getModelClass();

            public abstract long getRam();

            public abstract int getState();

            public abstract boolean isSimulator();
        }

        public static abstract class Event {

            public static abstract class Application {

                public static abstract class Builder {
                    @NonNull
                    public abstract Application build();

                    @NonNull
                    public abstract Builder setBackground(Boolean bool);

                    @NonNull
                    public abstract Builder setCustomAttributes(@NonNull ImmutableList<CustomAttribute> immutableList);

                    @NonNull
                    public abstract Builder setExecution(@NonNull Execution execution);

                    @NonNull
                    public abstract Builder setInternalKeys(@NonNull ImmutableList<CustomAttribute> immutableList);

                    @NonNull
                    public abstract Builder setUiOrientation(int i10);
                }

                public static abstract class Execution {

                    public static abstract class BinaryImage {

                        public static abstract class Builder {
                            @NonNull
                            public abstract BinaryImage build();

                            @NonNull
                            public abstract Builder setBaseAddress(long j10);

                            @NonNull
                            public abstract Builder setName(@NonNull String str);

                            @NonNull
                            public abstract Builder setSize(long j10);

                            @NonNull
                            public abstract Builder setUuid(String str);

                            @NonNull
                            public Builder setUuidFromUtf8Bytes(@NonNull byte[] bArr) {
                                return setUuid(new String(bArr, CrashlyticsReport.UTF_8));
                            }
                        }

                        @NonNull
                        public static Builder builder() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.Builder();
                        }

                        @NonNull
                        public abstract long getBaseAddress();

                        @NonNull
                        public abstract String getName();

                        public abstract long getSize();

                        @Encodable.Ignore
                        public abstract String getUuid();

                        @Encodable.Field(name = "uuid")
                        public byte[] getUuidUtf8Bytes() {
                            String uuid = getUuid();
                            if (uuid != null) {
                                return uuid.getBytes(CrashlyticsReport.UTF_8);
                            }
                            return null;
                        }
                    }

                    public static abstract class Builder {
                        @NonNull
                        public abstract Execution build();

                        @NonNull
                        public abstract Builder setAppExitInfo(@NonNull ApplicationExitInfo applicationExitInfo);

                        @NonNull
                        public abstract Builder setBinaries(@NonNull ImmutableList<BinaryImage> immutableList);

                        @NonNull
                        public abstract Builder setException(@NonNull Exception exception);

                        @NonNull
                        public abstract Builder setSignal(@NonNull Signal signal);

                        @NonNull
                        public abstract Builder setThreads(@NonNull ImmutableList<Thread> immutableList);
                    }

                    public static abstract class Exception {

                        public static abstract class Builder {
                            @NonNull
                            public abstract Exception build();

                            @NonNull
                            public abstract Builder setCausedBy(@NonNull Exception exception);

                            @NonNull
                            public abstract Builder setFrames(@NonNull ImmutableList<Thread.Frame> immutableList);

                            @NonNull
                            public abstract Builder setOverflowCount(int i10);

                            @NonNull
                            public abstract Builder setReason(@NonNull String str);

                            @NonNull
                            public abstract Builder setType(@NonNull String str);
                        }

                        @NonNull
                        public static Builder builder() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.Builder();
                        }

                        public abstract Exception getCausedBy();

                        @NonNull
                        public abstract ImmutableList<Thread.Frame> getFrames();

                        public abstract int getOverflowCount();

                        public abstract String getReason();

                        @NonNull
                        public abstract String getType();
                    }

                    public static abstract class Signal {

                        public static abstract class Builder {
                            @NonNull
                            public abstract Signal build();

                            @NonNull
                            public abstract Builder setAddress(long j10);

                            @NonNull
                            public abstract Builder setCode(@NonNull String str);

                            @NonNull
                            public abstract Builder setName(@NonNull String str);
                        }

                        @NonNull
                        public static Builder builder() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.Builder();
                        }

                        @NonNull
                        public abstract long getAddress();

                        @NonNull
                        public abstract String getCode();

                        @NonNull
                        public abstract String getName();
                    }

                    public static abstract class Thread {

                        public static abstract class Builder {
                            @NonNull
                            public abstract Thread build();

                            @NonNull
                            public abstract Builder setFrames(@NonNull ImmutableList<Frame> immutableList);

                            @NonNull
                            public abstract Builder setImportance(int i10);

                            @NonNull
                            public abstract Builder setName(@NonNull String str);
                        }

                        public static abstract class Frame {

                            public static abstract class Builder {
                                @NonNull
                                public abstract Frame build();

                                @NonNull
                                public abstract Builder setFile(@NonNull String str);

                                @NonNull
                                public abstract Builder setImportance(int i10);

                                @NonNull
                                public abstract Builder setOffset(long j10);

                                @NonNull
                                public abstract Builder setPc(long j10);

                                @NonNull
                                public abstract Builder setSymbol(@NonNull String str);
                            }

                            @NonNull
                            public static Builder builder() {
                                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.Builder();
                            }

                            public abstract String getFile();

                            public abstract int getImportance();

                            public abstract long getOffset();

                            public abstract long getPc();

                            @NonNull
                            public abstract String getSymbol();
                        }

                        @NonNull
                        public static Builder builder() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.Builder();
                        }

                        @NonNull
                        public abstract ImmutableList<Frame> getFrames();

                        public abstract int getImportance();

                        @NonNull
                        public abstract String getName();
                    }

                    @NonNull
                    public static Builder builder() {
                        return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution.Builder();
                    }

                    public abstract ApplicationExitInfo getAppExitInfo();

                    @NonNull
                    public abstract ImmutableList<BinaryImage> getBinaries();

                    public abstract Exception getException();

                    @NonNull
                    public abstract Signal getSignal();

                    public abstract ImmutableList<Thread> getThreads();
                }

                @NonNull
                public static Builder builder() {
                    return new AutoValue_CrashlyticsReport_Session_Event_Application.Builder();
                }

                public abstract Boolean getBackground();

                public abstract ImmutableList<CustomAttribute> getCustomAttributes();

                @NonNull
                public abstract Execution getExecution();

                public abstract ImmutableList<CustomAttribute> getInternalKeys();

                public abstract int getUiOrientation();

                @NonNull
                public abstract Builder toBuilder();
            }

            public static abstract class Builder {
                @NonNull
                public abstract Event build();

                @NonNull
                public abstract Builder setApp(@NonNull Application application);

                @NonNull
                public abstract Builder setDevice(@NonNull Device device);

                @NonNull
                public abstract Builder setLog(@NonNull Log log);

                @NonNull
                public abstract Builder setTimestamp(long j10);

                @NonNull
                public abstract Builder setType(@NonNull String str);
            }

            public static abstract class Device {

                public static abstract class Builder {
                    @NonNull
                    public abstract Device build();

                    @NonNull
                    public abstract Builder setBatteryLevel(Double d10);

                    @NonNull
                    public abstract Builder setBatteryVelocity(int i10);

                    @NonNull
                    public abstract Builder setDiskUsed(long j10);

                    @NonNull
                    public abstract Builder setOrientation(int i10);

                    @NonNull
                    public abstract Builder setProximityOn(boolean z10);

                    @NonNull
                    public abstract Builder setRamUsed(long j10);
                }

                @NonNull
                public static Builder builder() {
                    return new AutoValue_CrashlyticsReport_Session_Event_Device.Builder();
                }

                public abstract Double getBatteryLevel();

                public abstract int getBatteryVelocity();

                public abstract long getDiskUsed();

                public abstract int getOrientation();

                public abstract long getRamUsed();

                public abstract boolean isProximityOn();
            }

            public static abstract class Log {

                public static abstract class Builder {
                    @NonNull
                    public abstract Log build();

                    @NonNull
                    public abstract Builder setContent(@NonNull String str);
                }

                @NonNull
                public static Builder builder() {
                    return new AutoValue_CrashlyticsReport_Session_Event_Log.Builder();
                }

                @NonNull
                public abstract String getContent();
            }

            @NonNull
            public static Builder builder() {
                return new AutoValue_CrashlyticsReport_Session_Event.Builder();
            }

            @NonNull
            public abstract Application getApp();

            @NonNull
            public abstract Device getDevice();

            public abstract Log getLog();

            public abstract long getTimestamp();

            @NonNull
            public abstract String getType();

            @NonNull
            public abstract Builder toBuilder();
        }

        public static abstract class OperatingSystem {

            public static abstract class Builder {
                @NonNull
                public abstract OperatingSystem build();

                @NonNull
                public abstract Builder setBuildVersion(@NonNull String str);

                @NonNull
                public abstract Builder setJailbroken(boolean z10);

                @NonNull
                public abstract Builder setPlatform(int i10);

                @NonNull
                public abstract Builder setVersion(@NonNull String str);
            }

            @NonNull
            public static Builder builder() {
                return new AutoValue_CrashlyticsReport_Session_OperatingSystem.Builder();
            }

            @NonNull
            public abstract String getBuildVersion();

            public abstract int getPlatform();

            @NonNull
            public abstract String getVersion();

            public abstract boolean isJailbroken();
        }

        public static abstract class User {

            public static abstract class Builder {
                @NonNull
                public abstract User build();

                @NonNull
                public abstract Builder setIdentifier(@NonNull String str);
            }

            @NonNull
            public static Builder builder() {
                return new AutoValue_CrashlyticsReport_Session_User.Builder();
            }

            @NonNull
            public abstract String getIdentifier();
        }

        @NonNull
        public static Builder builder() {
            return new AutoValue_CrashlyticsReport_Session.Builder().setCrashed(false);
        }

        @NonNull
        public abstract Application getApp();

        public abstract String getAppQualitySessionId();

        public abstract Device getDevice();

        public abstract Long getEndedAt();

        public abstract ImmutableList<Event> getEvents();

        @NonNull
        public abstract String getGenerator();

        public abstract int getGeneratorType();

        @NonNull
        @Encodable.Ignore
        public abstract String getIdentifier();

        @NonNull
        @Encodable.Field(name = "identifier")
        public byte[] getIdentifierUtf8Bytes() {
            return getIdentifier().getBytes(CrashlyticsReport.UTF_8);
        }

        public abstract OperatingSystem getOs();

        public abstract long getStartedAt();

        public abstract User getUser();

        public abstract boolean isCrashed();

        @NonNull
        public abstract Builder toBuilder();

        /* access modifiers changed from: package-private */
        @NonNull
        public Session withAppQualitySessionId(String str) {
            return toBuilder().setAppQualitySessionId(str).build();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Session withEvents(@NonNull ImmutableList<Event> immutableList) {
            return toBuilder().setEvents(immutableList).build();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Session withOrganizationId(@NonNull String str) {
            return toBuilder().setApp(getApp().withOrganizationId(str)).build();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Session withSessionEndFields(long j10, boolean z10, String str) {
            Builder builder = toBuilder();
            builder.setEndedAt(Long.valueOf(j10));
            builder.setCrashed(z10);
            if (str != null) {
                builder.setUser(User.builder().setIdentifier(str).build());
            }
            return builder.build();
        }
    }

    public enum Type {
        INCOMPLETE,
        JAVA,
        NATIVE
    }

    @NonNull
    public static Builder builder() {
        return new AutoValue_CrashlyticsReport.Builder();
    }

    public abstract ApplicationExitInfo getAppExitInfo();

    public abstract String getAppQualitySessionId();

    @NonNull
    public abstract String getBuildVersion();

    @NonNull
    public abstract String getDisplayVersion();

    public abstract String getFirebaseInstallationId();

    @NonNull
    public abstract String getGmpAppId();

    @NonNull
    public abstract String getInstallationUuid();

    public abstract FilesPayload getNdkPayload();

    public abstract int getPlatform();

    @NonNull
    public abstract String getSdkVersion();

    public abstract Session getSession();

    @Encodable.Ignore
    public Type getType() {
        if (getSession() != null) {
            return Type.JAVA;
        }
        if (getNdkPayload() != null) {
            return Type.NATIVE;
        }
        return Type.INCOMPLETE;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract Builder toBuilder();

    @NonNull
    public CrashlyticsReport withAppQualitySessionId(String str) {
        Builder appQualitySessionId = toBuilder().setAppQualitySessionId(str);
        if (getSession() != null) {
            appQualitySessionId.setSession(getSession().withAppQualitySessionId(str));
        }
        return appQualitySessionId.build();
    }

    @NonNull
    public CrashlyticsReport withApplicationExitInfo(ApplicationExitInfo applicationExitInfo) {
        return applicationExitInfo == null ? this : toBuilder().setAppExitInfo(applicationExitInfo).build();
    }

    @NonNull
    public CrashlyticsReport withEvents(@NonNull ImmutableList<Session.Event> immutableList) {
        if (getSession() != null) {
            return toBuilder().setSession(getSession().withEvents(immutableList)).build();
        }
        throw new IllegalStateException("Reports without sessions cannot have events added to them.");
    }

    @NonNull
    public CrashlyticsReport withFirebaseInstallationId(String str) {
        return toBuilder().setFirebaseInstallationId(str).build();
    }

    @NonNull
    public CrashlyticsReport withNdkPayload(@NonNull FilesPayload filesPayload) {
        return toBuilder().setSession((Session) null).setNdkPayload(filesPayload).build();
    }

    @NonNull
    public CrashlyticsReport withOrganizationId(@NonNull String str) {
        Builder builder = toBuilder();
        FilesPayload ndkPayload = getNdkPayload();
        if (ndkPayload != null) {
            builder.setNdkPayload(ndkPayload.toBuilder().setOrgId(str).build());
        }
        Session session = getSession();
        if (session != null) {
            builder.setSession(session.withOrganizationId(str));
        }
        return builder.build();
    }

    @NonNull
    public CrashlyticsReport withSessionEndFields(long j10, boolean z10, String str) {
        Builder builder = toBuilder();
        if (getSession() != null) {
            builder.setSession(getSession().withSessionEndFields(j10, z10, str));
        }
        return builder.build();
    }
}

package com.google.firebase.database;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.Logger;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.database.core.DatabaseConfig;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.RepoInfo;
import com.google.firebase.database.core.RepoManager;
import com.google.firebase.database.core.utilities.ParsedUrl;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.emulators.EmulatedServiceSettings;

public class FirebaseDatabase {
    private static final String SDK_VERSION = "20.2.2";
    private final FirebaseApp app;
    private final DatabaseConfig config;
    @Nullable
    private EmulatedServiceSettings emulatorSettings;
    /* access modifiers changed from: private */
    public Repo repo;
    private final RepoInfo repoInfo;

    FirebaseDatabase(@NonNull FirebaseApp firebaseApp, @NonNull RepoInfo repoInfo2, @NonNull DatabaseConfig databaseConfig) {
        this.app = firebaseApp;
        this.repoInfo = repoInfo2;
        this.config = databaseConfig;
    }

    private void assertUnfrozen(String str) {
        if (this.repo != null) {
            throw new DatabaseException("Calls to " + str + "() must be made before any other usage of FirebaseDatabase instance.");
        }
    }

    static FirebaseDatabase createForTests(FirebaseApp firebaseApp, RepoInfo repoInfo2, DatabaseConfig databaseConfig) {
        FirebaseDatabase firebaseDatabase = new FirebaseDatabase(firebaseApp, repoInfo2, databaseConfig);
        firebaseDatabase.ensureRepo();
        return firebaseDatabase;
    }

    private synchronized void ensureRepo() {
        if (this.repo == null) {
            this.repoInfo.applyEmulatorSettings(this.emulatorSettings);
            this.repo = RepoManager.createRepo(this.config, this.repoInfo, this);
        }
    }

    @NonNull
    public static FirebaseDatabase getInstance() {
        FirebaseApp instance = FirebaseApp.getInstance();
        if (instance != null) {
            return getInstance(instance);
        }
        throw new DatabaseException("You must call FirebaseApp.initialize() first.");
    }

    @NonNull
    public static String getSdkVersion() {
        return "20.2.2";
    }

    @NonNull
    public FirebaseApp getApp() {
        return this.app;
    }

    /* access modifiers changed from: package-private */
    public DatabaseConfig getConfig() {
        return this.config;
    }

    @NonNull
    public DatabaseReference getReference() {
        ensureRepo();
        return new DatabaseReference(this.repo, Path.getEmptyPath());
    }

    @NonNull
    public DatabaseReference getReferenceFromUrl(@NonNull String str) {
        ensureRepo();
        if (str != null) {
            ParsedUrl parseUrl = Utilities.parseUrl(str);
            parseUrl.repoInfo.applyEmulatorSettings(this.emulatorSettings);
            if (parseUrl.repoInfo.host.equals(this.repo.getRepoInfo().host)) {
                return new DatabaseReference(this.repo, parseUrl.path);
            }
            throw new DatabaseException("Invalid URL (" + str + ") passed to getReference().  URL was expected to match configured Database URL: " + getReference());
        }
        throw new NullPointerException("Can't pass null for argument 'url' in FirebaseDatabase.getReferenceFromUrl()");
    }

    public void goOffline() {
        ensureRepo();
        RepoManager.interrupt(this.repo);
    }

    public void goOnline() {
        ensureRepo();
        RepoManager.resume(this.repo);
    }

    public void purgeOutstandingWrites() {
        ensureRepo();
        this.repo.scheduleNow(new Runnable() {
            public void run() {
                FirebaseDatabase.this.repo.purgeOutstandingWrites();
            }
        });
    }

    public synchronized void setLogLevel(@NonNull Logger.Level level) {
        assertUnfrozen("setLogLevel");
        this.config.setLogLevel(level);
    }

    public synchronized void setPersistenceCacheSizeBytes(long j10) {
        assertUnfrozen("setPersistenceCacheSizeBytes");
        this.config.setPersistenceCacheSizeBytes(j10);
    }

    public synchronized void setPersistenceEnabled(boolean z10) {
        assertUnfrozen("setPersistenceEnabled");
        this.config.setPersistenceEnabled(z10);
    }

    public void useEmulator(@NonNull String str, int i10) {
        if (this.repo == null) {
            this.emulatorSettings = new EmulatedServiceSettings(str, i10);
            return;
        }
        throw new IllegalStateException("Cannot call useEmulator() after instance has already been initialized.");
    }

    @NonNull
    public DatabaseReference getReference(@NonNull String str) {
        ensureRepo();
        if (str != null) {
            Validation.validateRootPathString(str);
            return new DatabaseReference(this.repo, new Path(str));
        }
        throw new NullPointerException("Can't pass null for argument 'pathString' in FirebaseDatabase.getReference()");
    }

    @NonNull
    public static FirebaseDatabase getInstance(@NonNull String str) {
        FirebaseApp instance = FirebaseApp.getInstance();
        if (instance != null) {
            return getInstance(instance, str);
        }
        throw new DatabaseException("You must call FirebaseApp.initialize() first.");
    }

    @NonNull
    public static FirebaseDatabase getInstance(@NonNull FirebaseApp firebaseApp) {
        String databaseUrl = firebaseApp.getOptions().getDatabaseUrl();
        if (databaseUrl == null) {
            if (firebaseApp.getOptions().getProjectId() != null) {
                databaseUrl = "https://" + firebaseApp.getOptions().getProjectId() + "-default-rtdb.firebaseio.com";
            } else {
                throw new DatabaseException("Failed to get FirebaseDatabase instance: Can't determine Firebase Database URL. Be sure to include a Project ID in your configuration.");
            }
        }
        return getInstance(firebaseApp, databaseUrl);
    }

    @NonNull
    public static synchronized FirebaseDatabase getInstance(@NonNull FirebaseApp firebaseApp, @NonNull String str) {
        FirebaseDatabase firebaseDatabase;
        synchronized (FirebaseDatabase.class) {
            if (!TextUtils.isEmpty(str)) {
                p.l(firebaseApp, "Provided FirebaseApp must not be null.");
                FirebaseDatabaseComponent firebaseDatabaseComponent = (FirebaseDatabaseComponent) firebaseApp.get(FirebaseDatabaseComponent.class);
                p.l(firebaseDatabaseComponent, "Firebase Database component is not present.");
                ParsedUrl parseUrl = Utilities.parseUrl(str);
                if (parseUrl.path.isEmpty()) {
                    firebaseDatabase = firebaseDatabaseComponent.get(parseUrl.repoInfo);
                } else {
                    throw new DatabaseException("Specified Database URL '" + str + "' is invalid. It should point to the root of a Firebase Database but it includes a path: " + parseUrl.path.toString());
                }
            } else {
                throw new DatabaseException("Failed to get FirebaseDatabase instance: Specify DatabaseURL within FirebaseApp or from your getInstance() call.");
            }
        }
        return firebaseDatabase;
    }
}

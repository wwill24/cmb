package com.google.firebase.database;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Context;
import com.google.firebase.database.core.DatabaseConfig;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.RepoManager;
import com.google.firebase.database.core.ValidationPath;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.ParsedUrl;
import com.google.firebase.database.core.utilities.PushIdGenerator;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class DatabaseReference extends Query {
    private static DatabaseConfig defaultConfig;

    public interface CompletionListener {
        void onComplete(DatabaseError databaseError, @NonNull DatabaseReference databaseReference);
    }

    DatabaseReference(Repo repo, Path path) {
        super(repo, path);
    }

    private static synchronized DatabaseConfig getDefaultConfig() {
        DatabaseConfig databaseConfig;
        synchronized (DatabaseReference.class) {
            if (defaultConfig == null) {
                defaultConfig = new DatabaseConfig();
            }
            databaseConfig = defaultConfig;
        }
        return databaseConfig;
    }

    public static void goOffline() {
        goOffline(getDefaultConfig());
    }

    public static void goOnline() {
        goOnline(getDefaultConfig());
    }

    private Task<Void> setPriorityInternal(final Node node, CompletionListener completionListener) {
        Validation.validateWritablePath(getPath());
        final Pair<Task<Void>, CompletionListener> wrapOnComplete = Utilities.wrapOnComplete(completionListener);
        this.repo.scheduleNow(new Runnable() {
            public void run() {
                DatabaseReference databaseReference = DatabaseReference.this;
                databaseReference.repo.setValue(databaseReference.getPath().child(ChildKey.getPriorityKey()), node, (CompletionListener) wrapOnComplete.getSecond());
            }
        });
        return wrapOnComplete.getFirst();
    }

    private Task<Void> setValueInternal(Object obj, Node node, CompletionListener completionListener) {
        Validation.validateWritablePath(getPath());
        ValidationPath.validateWithObject(getPath(), obj);
        Object convertToPlainJavaTypes = CustomClassMapper.convertToPlainJavaTypes(obj);
        Validation.validateWritableObject(convertToPlainJavaTypes);
        final Node NodeFromJSON = NodeUtilities.NodeFromJSON(convertToPlainJavaTypes, node);
        final Pair<Task<Void>, CompletionListener> wrapOnComplete = Utilities.wrapOnComplete(completionListener);
        this.repo.scheduleNow(new Runnable() {
            public void run() {
                DatabaseReference databaseReference = DatabaseReference.this;
                databaseReference.repo.setValue(databaseReference.getPath(), NodeFromJSON, (CompletionListener) wrapOnComplete.getSecond());
            }
        });
        return wrapOnComplete.getFirst();
    }

    private Task<Void> updateChildrenInternal(Map<String, Object> map, CompletionListener completionListener) {
        if (map != null) {
            final Map<String, Object> convertToPlainJavaTypes = CustomClassMapper.convertToPlainJavaTypes(map);
            final CompoundWrite fromPathMerge = CompoundWrite.fromPathMerge(Validation.parseAndValidateUpdate(getPath(), convertToPlainJavaTypes));
            final Pair<Task<Void>, CompletionListener> wrapOnComplete = Utilities.wrapOnComplete(completionListener);
            this.repo.scheduleNow(new Runnable() {
                public void run() {
                    DatabaseReference databaseReference = DatabaseReference.this;
                    databaseReference.repo.updateChildren(databaseReference.getPath(), fromPathMerge, (CompletionListener) wrapOnComplete.getSecond(), convertToPlainJavaTypes);
                }
            });
            return wrapOnComplete.getFirst();
        }
        throw new NullPointerException("Can't pass null for argument 'update' in updateChildren()");
    }

    @NonNull
    public DatabaseReference child(@NonNull String str) {
        if (str != null) {
            if (getPath().isEmpty()) {
                Validation.validateRootPathString(str);
            } else {
                Validation.validatePathString(str);
            }
            return new DatabaseReference(this.repo, getPath().child(new Path(str)));
        }
        throw new NullPointerException("Can't pass null for argument 'pathString' in child()");
    }

    public boolean equals(Object obj) {
        return (obj instanceof DatabaseReference) && toString().equals(obj.toString());
    }

    @NonNull
    public FirebaseDatabase getDatabase() {
        return this.repo.getDatabase();
    }

    public String getKey() {
        if (getPath().isEmpty()) {
            return null;
        }
        return getPath().getBack().asString();
    }

    public DatabaseReference getParent() {
        Path parent = getPath().getParent();
        if (parent != null) {
            return new DatabaseReference(this.repo, parent);
        }
        return null;
    }

    @NonNull
    public DatabaseReference getRoot() {
        return new DatabaseReference(this.repo, new Path(""));
    }

    public int hashCode() {
        return toString().hashCode();
    }

    @NonNull
    public OnDisconnect onDisconnect() {
        Validation.validateWritablePath(getPath());
        return new OnDisconnect(this.repo, getPath());
    }

    @NonNull
    public DatabaseReference push() {
        return new DatabaseReference(this.repo, getPath().child(ChildKey.fromString(PushIdGenerator.generatePushChildName(this.repo.getServerTime()))));
    }

    @NonNull
    public Task<Void> removeValue() {
        return setValue((Object) null);
    }

    public void runTransaction(@NonNull Transaction.Handler handler) {
        runTransaction(handler, true);
    }

    /* access modifiers changed from: package-private */
    public void setHijackHash(final boolean z10) {
        this.repo.scheduleNow(new Runnable() {
            public void run() {
                DatabaseReference.this.repo.setHijackHash(z10);
            }
        });
    }

    @NonNull
    public Task<Void> setPriority(Object obj) {
        return setPriorityInternal(PriorityUtilities.parsePriority(this.path, obj), (CompletionListener) null);
    }

    @NonNull
    public Task<Void> setValue(Object obj) {
        return setValueInternal(obj, PriorityUtilities.parsePriority(this.path, (Object) null), (CompletionListener) null);
    }

    public String toString() {
        DatabaseReference parent = getParent();
        if (parent == null) {
            return this.repo.toString();
        }
        try {
            return parent.toString() + RemoteSettings.FORWARD_SLASH_STRING + URLEncoder.encode(getKey(), "UTF-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e10) {
            throw new DatabaseException("Failed to URLEncode key: " + getKey(), e10);
        }
    }

    @NonNull
    public Task<Void> updateChildren(@NonNull Map<String, Object> map) {
        return updateChildrenInternal(map, (CompletionListener) null);
    }

    DatabaseReference(String str, DatabaseConfig databaseConfig) {
        this(Utilities.parseUrl(str), databaseConfig);
    }

    static void goOffline(DatabaseConfig databaseConfig) {
        RepoManager.interrupt((Context) databaseConfig);
    }

    static void goOnline(DatabaseConfig databaseConfig) {
        RepoManager.resume((Context) databaseConfig);
    }

    public void removeValue(CompletionListener completionListener) {
        setValue((Object) null, completionListener);
    }

    public void runTransaction(@NonNull final Transaction.Handler handler, final boolean z10) {
        if (handler != null) {
            Validation.validateWritablePath(getPath());
            this.repo.scheduleNow(new Runnable() {
                public void run() {
                    DatabaseReference databaseReference = DatabaseReference.this;
                    databaseReference.repo.startTransaction(databaseReference.getPath(), handler, z10);
                }
            });
            return;
        }
        throw new NullPointerException("Can't pass null for argument 'handler' in runTransaction()");
    }

    public void setPriority(Object obj, CompletionListener completionListener) {
        setPriorityInternal(PriorityUtilities.parsePriority(this.path, obj), completionListener);
    }

    @NonNull
    public Task<Void> setValue(Object obj, Object obj2) {
        return setValueInternal(obj, PriorityUtilities.parsePriority(this.path, obj2), (CompletionListener) null);
    }

    public void updateChildren(@NonNull Map<String, Object> map, CompletionListener completionListener) {
        updateChildrenInternal(map, completionListener);
    }

    private DatabaseReference(ParsedUrl parsedUrl, DatabaseConfig databaseConfig) {
        this(RepoManager.getRepo(databaseConfig, parsedUrl.repoInfo), parsedUrl.path);
    }

    public void setValue(Object obj, CompletionListener completionListener) {
        setValueInternal(obj, PriorityUtilities.parsePriority(this.path, (Object) null), completionListener);
    }

    public void setValue(Object obj, Object obj2, CompletionListener completionListener) {
        setValueInternal(obj, PriorityUtilities.parsePriority(this.path, obj2), completionListener);
    }
}

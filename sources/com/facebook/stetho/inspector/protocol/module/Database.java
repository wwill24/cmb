package com.facebook.stetho.inspector.protocol.module;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.facebook.internal.ServerProtocol;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.ObjectIdMapper;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.jsonrpc.PendingRequestCallback;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.util.StringUtils;
import org.json.b;

public class Database implements ChromeDevtoolsDomain {
    private static final int MAX_BLOB_LENGTH = 512;
    private static final int MAX_EXECUTE_RESULTS = 250;
    private static final String UNKNOWN_BLOB_LABEL = "{blob}";
    private final ChromePeerManager mChromePeerManager;
    private List<DatabaseDriver2> mDatabaseDrivers = new ArrayList();
    private final ObjectMapper mObjectMapper;
    private final DatabasePeerRegistrationListener mPeerListener;

    public static class AddDatabaseEvent {
        @JsonProperty(required = true)
        public DatabaseObject database;
    }

    private static class DatabaseDescriptorHolder {
        public final DatabaseDescriptor descriptor;
        public final DatabaseDriver2 driver;

        public DatabaseDescriptorHolder(DatabaseDriver2 databaseDriver2, DatabaseDescriptor databaseDescriptor) {
            this.driver = databaseDriver2;
            this.descriptor = databaseDescriptor;
        }
    }

    @Deprecated
    public static abstract class DatabaseDriver extends BaseDatabaseDriver<String> {
        public DatabaseDriver(Context context) {
            super(context);
        }
    }

    public static class DatabaseObject {
        @JsonProperty(required = true)
        public String domain;
        @JsonProperty(required = true)

        /* renamed from: id  reason: collision with root package name */
        public String f37939id;
        @JsonProperty(required = true)
        public String name;
        @JsonProperty(required = true)
        public String version;
    }

    private static class DatabasePeerRegistrationListener extends PeersRegisteredListener {
        private final List<DatabaseDriver2> mDatabaseDrivers;
        private final SparseArray<DatabaseDescriptorHolder> mDatabaseHolders;
        private final ObjectIdMapper mDatabaseIdMapper;

        public DatabaseDescriptorHolder getDatabaseDescriptorHolder(String str) {
            return this.mDatabaseHolders.get(Integer.parseInt(str));
        }

        /* access modifiers changed from: protected */
        public synchronized void onFirstPeerRegistered() {
            for (DatabaseDriver2 next : this.mDatabaseDrivers) {
                for (DatabaseDescriptor databaseDescriptor : next.getDatabaseNames()) {
                    if (this.mDatabaseIdMapper.getIdForObject(databaseDescriptor) == null) {
                        this.mDatabaseHolders.put(Integer.valueOf(this.mDatabaseIdMapper.putObject(databaseDescriptor)).intValue(), new DatabaseDescriptorHolder(next, databaseDescriptor));
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public synchronized void onLastPeerUnregistered() {
            this.mDatabaseIdMapper.clear();
            this.mDatabaseHolders.clear();
        }

        /* access modifiers changed from: protected */
        public synchronized void onPeerAdded(JsonRpcPeer jsonRpcPeer) {
            int size = this.mDatabaseHolders.size();
            for (int i10 = 0; i10 < size; i10++) {
                int keyAt = this.mDatabaseHolders.keyAt(i10);
                DatabaseDescriptorHolder valueAt = this.mDatabaseHolders.valueAt(i10);
                DatabaseObject databaseObject = new DatabaseObject();
                databaseObject.f37939id = String.valueOf(keyAt);
                databaseObject.name = valueAt.descriptor.name();
                databaseObject.domain = valueAt.driver.getContext().getPackageName();
                databaseObject.version = "N/A";
                AddDatabaseEvent addDatabaseEvent = new AddDatabaseEvent();
                addDatabaseEvent.database = databaseObject;
                jsonRpcPeer.invokeMethod("Database.addDatabase", addDatabaseEvent, (PendingRequestCallback) null);
            }
        }

        /* access modifiers changed from: protected */
        public synchronized void onPeerRemoved(JsonRpcPeer jsonRpcPeer) {
        }

        private DatabasePeerRegistrationListener(List<DatabaseDriver2> list) {
            this.mDatabaseHolders = new SparseArray<>();
            this.mDatabaseIdMapper = new ObjectIdMapper();
            this.mDatabaseDrivers = list;
        }
    }

    public static class Error {
        @JsonProperty(required = true)
        public int code;
        @JsonProperty(required = true)
        public String message;
    }

    public static class ExecuteSQLRequest {
        @JsonProperty(required = true)
        public String databaseId;
        @JsonProperty(required = true)
        public String query;
    }

    public static class ExecuteSQLResponse implements JsonRpcResult {
        @JsonProperty
        public List<String> columnNames;
        @JsonProperty
        public Error sqlError;
        @JsonProperty
        public List<String> values;
    }

    private static class GetDatabaseTableNamesRequest {
        @JsonProperty(required = true)
        public String databaseId;

        private GetDatabaseTableNamesRequest() {
        }
    }

    private static class GetDatabaseTableNamesResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public List<String> tableNames;

        private GetDatabaseTableNamesResponse() {
        }
    }

    public Database() {
        ChromePeerManager chromePeerManager = new ChromePeerManager();
        this.mChromePeerManager = chromePeerManager;
        DatabasePeerRegistrationListener databasePeerRegistrationListener = new DatabasePeerRegistrationListener(this.mDatabaseDrivers);
        this.mPeerListener = databasePeerRegistrationListener;
        chromePeerManager.setListener(databasePeerRegistrationListener);
        this.mObjectMapper = new ObjectMapper();
    }

    private static String blobToString(byte[] bArr) {
        if (bArr.length > 512 || !fastIsAscii(bArr)) {
            return UNKNOWN_BLOB_LABEL;
        }
        try {
            return new String(bArr, StringUtils.USASCII);
        } catch (UnsupportedEncodingException unused) {
            return UNKNOWN_BLOB_LABEL;
        }
    }

    private static boolean fastIsAscii(byte[] bArr) {
        for (byte b10 : bArr) {
            if ((b10 & Byte.MIN_VALUE) != 0) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static ArrayList<String> flattenRows(Cursor cursor, int i10) {
        boolean z10;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Util.throwIfNot(z10);
        ArrayList<String> arrayList = new ArrayList<>();
        int columnCount = cursor.getColumnCount();
        for (int i11 = 0; i11 < i10 && cursor.moveToNext(); i11++) {
            for (int i12 = 0; i12 < columnCount; i12++) {
                int type = cursor.getType(i12);
                if (type == 0) {
                    arrayList.add((Object) null);
                } else if (type == 1) {
                    arrayList.add(String.valueOf(cursor.getLong(i12)));
                } else if (type == 2) {
                    arrayList.add(String.valueOf(cursor.getDouble(i12)));
                } else if (type != 4) {
                    arrayList.add(cursor.getString(i12));
                } else {
                    arrayList.add(blobToString(cursor.getBlob(i12)));
                }
            }
        }
        if (!cursor.isAfterLast()) {
            for (int i13 = 0; i13 < columnCount; i13++) {
                arrayList.add("{truncated}");
            }
        }
        return arrayList;
    }

    public void add(DatabaseDriver2 databaseDriver2) {
        this.mDatabaseDrivers.add(databaseDriver2);
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, b bVar) {
        this.mChromePeerManager.removePeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, b bVar) {
        this.mChromePeerManager.addPeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult executeSQL(JsonRpcPeer jsonRpcPeer, b bVar) {
        ExecuteSQLRequest executeSQLRequest = (ExecuteSQLRequest) this.mObjectMapper.convertValue(bVar, ExecuteSQLRequest.class);
        DatabaseDescriptorHolder databaseDescriptorHolder = this.mPeerListener.getDatabaseDescriptorHolder(executeSQLRequest.databaseId);
        try {
            return databaseDescriptorHolder.driver.executeSQL(databaseDescriptorHolder.descriptor, executeSQLRequest.query, new BaseDatabaseDriver.ExecuteResultHandler<ExecuteSQLResponse>() {
                public ExecuteSQLResponse handleInsert(long j10) throws SQLiteException {
                    ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
                    executeSQLResponse.columnNames = Collections.singletonList("ID of last inserted row");
                    executeSQLResponse.values = Collections.singletonList(String.valueOf(j10));
                    return executeSQLResponse;
                }

                public ExecuteSQLResponse handleRawQuery() throws SQLiteException {
                    ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
                    executeSQLResponse.columnNames = Collections.singletonList("success");
                    executeSQLResponse.values = Collections.singletonList(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                    return executeSQLResponse;
                }

                public ExecuteSQLResponse handleSelect(Cursor cursor) throws SQLiteException {
                    ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
                    executeSQLResponse.columnNames = Arrays.asList(cursor.getColumnNames());
                    executeSQLResponse.values = Database.flattenRows(cursor, 250);
                    return executeSQLResponse;
                }

                public ExecuteSQLResponse handleUpdateDelete(int i10) throws SQLiteException {
                    ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
                    executeSQLResponse.columnNames = Collections.singletonList("Modified rows");
                    executeSQLResponse.values = Collections.singletonList(String.valueOf(i10));
                    return executeSQLResponse;
                }
            });
        } catch (RuntimeException e10) {
            LogUtil.e(e10, "Exception executing: %s", executeSQLRequest.query);
            Error error = new Error();
            error.code = 0;
            error.message = e10.getMessage();
            ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
            executeSQLResponse.sqlError = error;
            return executeSQLResponse;
        }
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getDatabaseTableNames(JsonRpcPeer jsonRpcPeer, b bVar) throws JsonRpcException {
        DatabaseDescriptorHolder databaseDescriptorHolder = this.mPeerListener.getDatabaseDescriptorHolder(((GetDatabaseTableNamesRequest) this.mObjectMapper.convertValue(bVar, GetDatabaseTableNamesRequest.class)).databaseId);
        try {
            GetDatabaseTableNamesResponse getDatabaseTableNamesResponse = new GetDatabaseTableNamesResponse();
            getDatabaseTableNamesResponse.tableNames = databaseDescriptorHolder.driver.getTableNames(databaseDescriptorHolder.descriptor);
            return getDatabaseTableNamesResponse;
        } catch (SQLiteException e10) {
            throw new JsonRpcException(new JsonRpcError(JsonRpcError.ErrorCode.INVALID_REQUEST, e10.toString(), (b) null));
        }
    }
}

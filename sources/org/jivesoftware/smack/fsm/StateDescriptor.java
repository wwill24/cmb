package org.jivesoftware.smack.fsm;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;

public abstract class StateDescriptor {
    private static final Logger LOGGER = Logger.getLogger(StateDescriptor.class.getName());
    private final Set<Class<? extends StateDescriptor>> inferiorTo;
    private final Set<Class<? extends StateDescriptor>> precedenceOver;
    private final Set<Class<? extends StateDescriptor>> predecessors;
    private final Set<Property> properties;
    private transient String referenceCache;
    private final String rfcSection;
    private final Class<? extends State> stateClass;
    private final Constructor<? extends State> stateClassConstructor;
    private final String stateName;
    private final Set<Class<? extends StateDescriptor>> successors;
    private final int xepNum;

    public enum Property {
        multiVisitState,
        finalState,
        notImplemented
    }

    protected StateDescriptor() {
        this((Class<? extends State>) NoOpState.class, null);
    }

    private static void addAndCheckNonExistent(Set<Class<? extends StateDescriptor>> set, String str) {
        Class<StateDescriptor> cls = StateDescriptor.class;
        try {
            Class<?> cls2 = Class.forName(str);
            if (cls.isAssignableFrom(cls2)) {
                addAndCheckNonExistent(set, cls2.asSubclass(cls));
                return;
            }
            throw new IllegalArgumentException(cls2 + " is no state descriptor class");
        } catch (ClassNotFoundException e10) {
            Logger logger = LOGGER;
            Level level = Level.FINEST;
            logger.log(level, "Ignoring unknown state descriptor '" + str + "'", e10);
        }
    }

    public void addPredeccessor(Class<? extends StateDescriptor> cls) {
        addAndCheckNonExistent(this.predecessors, cls);
    }

    /* access modifiers changed from: protected */
    public void addSuccessor(Class<? extends StateDescriptor> cls) {
        addAndCheckNonExistent(this.successors, cls);
    }

    /* access modifiers changed from: protected */
    public State constructState(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        ModularXmppClientToServerConnection modularXmppClientToServerConnection = modularXmppClientToServerConnectionInternal.connection;
        try {
            return (State) this.stateClassConstructor.newInstance(new Object[]{modularXmppClientToServerConnection, this, modularXmppClientToServerConnectionInternal});
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException e10) {
            throw new IllegalStateException(e10);
        }
    }

    /* access modifiers changed from: protected */
    public void declareInferiorityTo(Class<? extends StateDescriptor> cls) {
        addAndCheckNonExistent(this.inferiorTo, cls);
    }

    /* access modifiers changed from: protected */
    public void declarePrecedenceOver(Class<? extends StateDescriptor> cls) {
        addAndCheckNonExistent(this.precedenceOver, cls);
    }

    public String getFullStateName(boolean z10) {
        char c10;
        String reference = getReference();
        if (reference == null) {
            return getStateName();
        }
        if (z10) {
            c10 = 10;
        } else {
            c10 = ' ';
        }
        return getStateName() + c10 + PropertyUtils.MAPPED_DELIM + reference + PropertyUtils.MAPPED_DELIM2;
    }

    public Set<Class<? extends StateDescriptor>> getPredeccessors() {
        return Collections.unmodifiableSet(this.predecessors);
    }

    public String getReference() {
        if (this.referenceCache == null) {
            if (this.xepNum > 0) {
                this.referenceCache = "XEP-" + String.format("%04d", new Object[]{Integer.valueOf(this.xepNum)});
            } else {
                String str = this.rfcSection;
                if (str != null) {
                    this.referenceCache = str;
                }
            }
        }
        return this.referenceCache;
    }

    public Class<? extends State> getStateClass() {
        return this.stateClass;
    }

    public String getStateName() {
        return this.stateName;
    }

    public Set<Class<? extends StateDescriptor>> getSubordinates() {
        return Collections.unmodifiableSet(this.precedenceOver);
    }

    public Set<Class<? extends StateDescriptor>> getSuccessors() {
        return Collections.unmodifiableSet(this.successors);
    }

    public Set<Class<? extends StateDescriptor>> getSuperiors() {
        return Collections.unmodifiableSet(this.inferiorTo);
    }

    public boolean isFinalState() {
        return this.properties.contains(Property.finalState);
    }

    public boolean isMultiVisitState() {
        return this.properties.contains(Property.multiVisitState);
    }

    public boolean isNotImplemented() {
        return this.properties.contains(Property.notImplemented);
    }

    public String toString() {
        return "StateDescriptor " + this.stateName;
    }

    protected StateDescriptor(Property... propertyArr) {
        this((Class<? extends State>) NoOpState.class, propertyArr);
    }

    /* access modifiers changed from: protected */
    public void declareInferiorityTo(String str) {
        addAndCheckNonExistent(this.inferiorTo, str);
    }

    /* access modifiers changed from: protected */
    public void declarePrecedenceOver(String str) {
        addAndCheckNonExistent(this.precedenceOver, str);
    }

    protected StateDescriptor(Class<? extends State> cls) {
        this(cls, -1, (String) null, Collections.emptySet());
    }

    protected StateDescriptor(Class<? extends State> cls, Property... propertyArr) {
        this(cls, -1, (String) null, new HashSet(Arrays.asList(propertyArr)));
    }

    protected StateDescriptor(Class<? extends State> cls, int i10) {
        this(cls, i10, (String) null, Collections.emptySet());
    }

    protected StateDescriptor(Class<? extends State> cls, int i10, Property... propertyArr) {
        this(cls, i10, (String) null, new HashSet(Arrays.asList(propertyArr)));
    }

    protected StateDescriptor(Class<? extends State> cls, String str) {
        this(cls, -1, str, Collections.emptySet());
    }

    private static <E> void addAndCheckNonExistent(Set<E> set, E e10) {
        if (!set.add(e10)) {
            throw new IllegalArgumentException("Element already exists in set");
        }
    }

    private StateDescriptor(Class<? extends State> cls, int i10, String str, Set<Property> set) {
        this.successors = new HashSet();
        this.predecessors = new HashSet();
        this.precedenceOver = new HashSet();
        this.inferiorTo = new HashSet();
        this.stateClass = cls;
        if (str == null || i10 <= 0) {
            this.xepNum = i10;
            this.rfcSection = str;
            this.properties = set;
            Constructor<? extends State> constructor = null;
            Constructor<? extends State>[] declaredConstructors = cls.getDeclaredConstructors();
            int length = declaredConstructors.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                Constructor<? extends State> constructor2 = declaredConstructors[i11];
                Class[] parameterTypes = constructor2.getParameterTypes();
                if (parameterTypes.length == 3 && ModularXmppClientToServerConnection.class.isAssignableFrom(parameterTypes[0]) && StateDescriptor.class.isAssignableFrom(parameterTypes[1]) && ModularXmppClientToServerConnectionInternal.class.isAssignableFrom(parameterTypes[2])) {
                    constructor = constructor2;
                    break;
                }
                i11++;
            }
            this.stateClassConstructor = constructor;
            if (constructor != null) {
                constructor.setAccessible(true);
            }
            this.stateName = getClass().getSimpleName().replaceFirst("StateDescriptor", "");
            return;
        }
        throw new IllegalArgumentException("Must specify either RFC or XEP");
    }
}

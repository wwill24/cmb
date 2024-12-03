package net.bytebuddy.description.method;

import com.facebook.internal.ServerProtocol;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.FilterableList;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;

public interface ParameterList<T extends ParameterDescription> extends FilterableList<T, ParameterList<T>> {

    public static abstract class AbstractBase<S extends ParameterDescription> extends FilterableList.AbstractBase<S, ParameterList<S>> implements ParameterList<S> {
        public ParameterList<ParameterDescription.InDefinedShape> asDefined() {
            ArrayList arrayList = new ArrayList(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                arrayList.add(((ParameterDescription) it.next()).asDefined());
            }
            return new Explicit(arrayList);
        }

        public ByteCodeElement.Token.TokenList<ParameterDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> elementMatcher) {
            ArrayList arrayList = new ArrayList(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                arrayList.add(((ParameterDescription) it.next()).asToken(elementMatcher));
            }
            return new ByteCodeElement.Token.TokenList<>(arrayList);
        }

        public TypeList.Generic asTypeList() {
            ArrayList arrayList = new ArrayList(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                arrayList.add(((ParameterDescription) it.next()).getType());
            }
            return new TypeList.Generic.Explicit((List<? extends TypeDefinition>) arrayList);
        }

        /* JADX WARNING: Removed duplicated region for block: B:3:0x000a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean hasExplicitMetaData() {
            /*
                r3 = this;
                java.util.Iterator r0 = r3.iterator()
            L_0x0004:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x001e
                java.lang.Object r1 = r0.next()
                net.bytebuddy.description.method.ParameterDescription r1 = (net.bytebuddy.description.method.ParameterDescription) r1
                boolean r2 = r1.isNamed()
                if (r2 == 0) goto L_0x001c
                boolean r1 = r1.hasModifiers()
                if (r1 != 0) goto L_0x0004
            L_0x001c:
                r0 = 0
                return r0
            L_0x001e:
                r0 = 1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.method.ParameterList.AbstractBase.hasExplicitMetaData():boolean");
        }

        /* access modifiers changed from: protected */
        public ParameterList<S> wrap(List<S> list) {
            return new Explicit(list);
        }
    }

    public static class Empty<S extends ParameterDescription> extends FilterableList.Empty<S, ParameterList<S>> implements ParameterList<S> {
        public ParameterList<ParameterDescription.InDefinedShape> asDefined() {
            return this;
        }

        public ByteCodeElement.Token.TokenList<ParameterDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> elementMatcher) {
            return new ByteCodeElement.Token.TokenList<>((S[]) new ParameterDescription.Token[0]);
        }

        public TypeList.Generic asTypeList() {
            return new TypeList.Generic.Empty();
        }

        public boolean hasExplicitMetaData() {
            return true;
        }
    }

    public static class Explicit<S extends ParameterDescription> extends AbstractBase<S> {
        private final List<? extends S> parameterDescriptions;

        public static class ForTypes extends AbstractBase<ParameterDescription.InDefinedShape> {
            private final MethodDescription.InDefinedShape methodDescription;
            private final List<? extends TypeDefinition> typeDefinitions;

            public ForTypes(MethodDescription.InDefinedShape inDefinedShape, TypeDefinition... typeDefinitionArr) {
                this(inDefinedShape, (List<? extends TypeDefinition>) Arrays.asList(typeDefinitionArr));
            }

            public int size() {
                return this.typeDefinitions.size();
            }

            public ForTypes(MethodDescription.InDefinedShape inDefinedShape, List<? extends TypeDefinition> list) {
                this.methodDescription = inDefinedShape;
                this.typeDefinitions = list;
            }

            public ParameterDescription.InDefinedShape get(int i10) {
                int i11 = !this.methodDescription.isStatic();
                for (int i12 = 0; i12 < i10; i12++) {
                    i11 += ((TypeDefinition) this.typeDefinitions.get(i12)).getStackSize().getSize();
                }
                return new ParameterDescription.Latent(this.methodDescription, ((TypeDefinition) this.typeDefinitions.get(i10)).asGenericType(), i10, i11);
            }
        }

        public Explicit(S... sArr) {
            this(Arrays.asList(sArr));
        }

        public int size() {
            return this.parameterDescriptions.size();
        }

        public Explicit(List<? extends S> list) {
            this.parameterDescriptions = list;
        }

        public S get(int i10) {
            return (ParameterDescription) this.parameterDescriptions.get(i10);
        }
    }

    public static abstract class ForLoadedExecutable<T> extends AbstractBase<ParameterDescription.InDefinedShape> {
        private static final boolean ACCESS_CONTROLLER;
        protected static final Executable EXECUTABLE = ((Executable) doPrivileged(JavaDispatcher.of(Executable.class)));
        protected final T executable;
        protected final ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource;

        @JavaDispatcher.Proxied("java.lang.reflect.Executable")
        protected interface Executable {
            @JavaDispatcher.Proxied("getParameterCount")
            int getParameterCount(Object obj);

            @JavaDispatcher.Proxied("getParameters")
            Object[] getParameters(Object obj);

            @JavaDispatcher.Proxied("isInstance")
            @JavaDispatcher.Instance
            boolean isInstance(Object obj);
        }

        protected static class OfConstructor extends ForLoadedExecutable<Constructor<?>> {
            protected OfConstructor(Constructor<?> constructor, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource) {
                super(constructor, parameterAnnotationSource);
            }

            public ParameterDescription.InDefinedShape get(int i10) {
                return new ParameterDescription.ForLoadedParameter.OfConstructor((Constructor) this.executable, i10, this.parameterAnnotationSource);
            }
        }

        protected static class OfLegacyVmConstructor extends AbstractBase<ParameterDescription.InDefinedShape> {
            private final Constructor<?> constructor;
            private final ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource;
            private final Class<?>[] parameterType;

            protected OfLegacyVmConstructor(Constructor<?> constructor2, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource2) {
                this.constructor = constructor2;
                this.parameterType = constructor2.getParameterTypes();
                this.parameterAnnotationSource = parameterAnnotationSource2;
            }

            public int size() {
                return this.parameterType.length;
            }

            public ParameterDescription.InDefinedShape get(int i10) {
                return new ParameterDescription.ForLoadedParameter.OfLegacyVmConstructor(this.constructor, i10, this.parameterType, this.parameterAnnotationSource);
            }
        }

        protected static class OfLegacyVmMethod extends AbstractBase<ParameterDescription.InDefinedShape> {
            private final Method method;
            private final ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource;
            private final Class<?>[] parameterType;

            protected OfLegacyVmMethod(Method method2, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource2) {
                this.method = method2;
                this.parameterType = method2.getParameterTypes();
                this.parameterAnnotationSource = parameterAnnotationSource2;
            }

            public int size() {
                return this.parameterType.length;
            }

            public ParameterDescription.InDefinedShape get(int i10) {
                return new ParameterDescription.ForLoadedParameter.OfLegacyVmMethod(this.method, i10, this.parameterType, this.parameterAnnotationSource);
            }
        }

        protected static class OfMethod extends ForLoadedExecutable<Method> {
            protected OfMethod(Method method, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource) {
                super(method, parameterAnnotationSource);
            }

            public ParameterDescription.InDefinedShape get(int i10) {
                return new ParameterDescription.ForLoadedParameter.OfMethod((Method) this.executable, i10, this.parameterAnnotationSource);
            }
        }

        static {
            boolean z10 = false;
            try {
                Class.forName("java.security.AccessController", false, (ClassLoader) null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
            } catch (ClassNotFoundException unused) {
            } catch (SecurityException unused2) {
                z10 = true;
            }
            ACCESS_CONTROLLER = z10;
        }

        protected ForLoadedExecutable(T t10, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource2) {
            this.executable = t10;
            this.parameterAnnotationSource = parameterAnnotationSource2;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static ParameterList<ParameterDescription.InDefinedShape> of(Constructor<?> constructor) {
            return of(constructor, (ParameterDescription.ForLoadedParameter.ParameterAnnotationSource) new ParameterDescription.ForLoadedParameter.ParameterAnnotationSource.ForLoadedConstructor(constructor));
        }

        public int size() {
            return EXECUTABLE.getParameterCount(this.executable);
        }

        public static ParameterList<ParameterDescription.InDefinedShape> of(Constructor<?> constructor, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource2) {
            return EXECUTABLE.isInstance(constructor) ? new OfConstructor(constructor, parameterAnnotationSource2) : new OfLegacyVmConstructor(constructor, parameterAnnotationSource2);
        }

        public static ParameterList<ParameterDescription.InDefinedShape> of(Method method) {
            return of(method, (ParameterDescription.ForLoadedParameter.ParameterAnnotationSource) new ParameterDescription.ForLoadedParameter.ParameterAnnotationSource.ForLoadedMethod(method));
        }

        public static ParameterList<ParameterDescription.InDefinedShape> of(Method method, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource2) {
            return EXECUTABLE.isInstance(method) ? new OfMethod(method, parameterAnnotationSource2) : new OfLegacyVmMethod(method, parameterAnnotationSource2);
        }
    }

    public static class ForTokens extends AbstractBase<ParameterDescription.InDefinedShape> {
        private final MethodDescription.InDefinedShape declaringMethod;
        private final List<? extends ParameterDescription.Token> tokens;

        public ForTokens(MethodDescription.InDefinedShape inDefinedShape, List<? extends ParameterDescription.Token> list) {
            this.declaringMethod = inDefinedShape;
            this.tokens = list;
        }

        public int size() {
            return this.tokens.size();
        }

        public ParameterDescription.InDefinedShape get(int i10) {
            int i11 = !this.declaringMethod.isStatic();
            for (ParameterDescription.Token type : this.tokens.subList(0, i10)) {
                i11 += type.getType().getStackSize().getSize();
            }
            return new ParameterDescription.Latent(this.declaringMethod, (ParameterDescription.Token) this.tokens.get(i10), i10, i11);
        }
    }

    public static class TypeSubstituting extends AbstractBase<ParameterDescription.InGenericShape> {
        private final MethodDescription.InGenericShape declaringMethod;
        private final List<? extends ParameterDescription> parameterDescriptions;
        private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;

        public TypeSubstituting(MethodDescription.InGenericShape inGenericShape, List<? extends ParameterDescription> list, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor2) {
            this.declaringMethod = inGenericShape;
            this.parameterDescriptions = list;
            this.visitor = visitor2;
        }

        public int size() {
            return this.parameterDescriptions.size();
        }

        public ParameterDescription.InGenericShape get(int i10) {
            return new ParameterDescription.TypeSubstituting(this.declaringMethod, (ParameterDescription) this.parameterDescriptions.get(i10), this.visitor);
        }
    }

    ParameterList<ParameterDescription.InDefinedShape> asDefined();

    ByteCodeElement.Token.TokenList<ParameterDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> elementMatcher);

    TypeList.Generic asTypeList();

    boolean hasExplicitMetaData();
}

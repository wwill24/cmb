package net.bytebuddy.description.method;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.FilterableList;
import net.bytebuddy.utility.ConstructorComparator;
import net.bytebuddy.utility.GraalImageCode;
import net.bytebuddy.utility.MethodComparator;

public interface MethodList<T extends MethodDescription> extends FilterableList<T, MethodList<T>> {

    public static abstract class AbstractBase<S extends MethodDescription> extends FilterableList.AbstractBase<S, MethodList<S>> implements MethodList<S> {
        public MethodList<MethodDescription.InDefinedShape> asDefined() {
            ArrayList arrayList = new ArrayList(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                arrayList.add(((MethodDescription) it.next()).asDefined());
            }
            return new Explicit(arrayList);
        }

        public List<MethodDescription.SignatureToken> asSignatureTokenList() {
            ArrayList arrayList = new ArrayList(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                arrayList.add(((MethodDescription) it.next()).asSignatureToken());
            }
            return arrayList;
        }

        public ByteCodeElement.Token.TokenList<MethodDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> elementMatcher) {
            ArrayList arrayList = new ArrayList(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                arrayList.add(((MethodDescription) it.next()).asToken(elementMatcher));
            }
            return new ByteCodeElement.Token.TokenList<>(arrayList);
        }

        /* access modifiers changed from: protected */
        public MethodList<S> wrap(List<S> list) {
            return new Explicit(list);
        }

        public List<MethodDescription.SignatureToken> asSignatureTokenList(ElementMatcher<? super TypeDescription> elementMatcher, TypeDescription typeDescription) {
            ArrayList arrayList = new ArrayList(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                arrayList.add(((MethodDescription.Token) ((MethodDescription) it.next()).asToken(elementMatcher)).asSignatureToken(typeDescription));
            }
            return arrayList;
        }
    }

    public static class Empty<S extends MethodDescription> extends FilterableList.Empty<S, MethodList<S>> implements MethodList<S> {
        public MethodList<MethodDescription.InDefinedShape> asDefined() {
            return this;
        }

        public List<MethodDescription.SignatureToken> asSignatureTokenList() {
            return Collections.emptyList();
        }

        public ByteCodeElement.Token.TokenList<MethodDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> elementMatcher) {
            return new ByteCodeElement.Token.TokenList<>((S[]) new MethodDescription.Token[0]);
        }

        public List<MethodDescription.SignatureToken> asSignatureTokenList(ElementMatcher<? super TypeDescription> elementMatcher, TypeDescription typeDescription) {
            return Collections.emptyList();
        }
    }

    public static class Explicit<S extends MethodDescription> extends AbstractBase<S> {
        private final List<? extends S> methodDescriptions;

        public Explicit(S... sArr) {
            this(Arrays.asList(sArr));
        }

        public int size() {
            return this.methodDescriptions.size();
        }

        public Explicit(List<? extends S> list) {
            this.methodDescriptions = list;
        }

        public S get(int i10) {
            return (MethodDescription) this.methodDescriptions.get(i10);
        }
    }

    public static class ForLoadedMethods extends AbstractBase<MethodDescription.InDefinedShape> {
        private final List<? extends Constructor<?>> constructors;
        private final List<? extends Method> methods;

        public ForLoadedMethods(Class<?> cls) {
            this((Constructor<?>[]) (Constructor[]) GraalImageCode.getCurrent().sorted(cls.getDeclaredConstructors(), ConstructorComparator.INSTANCE), (Method[]) GraalImageCode.getCurrent().sorted(cls.getDeclaredMethods(), MethodComparator.INSTANCE));
        }

        public int size() {
            return this.constructors.size() + this.methods.size();
        }

        public MethodDescription.InDefinedShape get(int i10) {
            if (i10 < this.constructors.size()) {
                return new MethodDescription.ForLoadedConstructor((Constructor) this.constructors.get(i10));
            }
            return new MethodDescription.ForLoadedMethod((Method) this.methods.get(i10 - this.constructors.size()));
        }

        public ForLoadedMethods(Constructor<?>[] constructorArr, Method[] methodArr) {
            this((List<? extends Constructor<?>>) Arrays.asList(constructorArr), (List<? extends Method>) Arrays.asList(methodArr));
        }

        public ForLoadedMethods(List<? extends Constructor<?>> list, List<? extends Method> list2) {
            this.constructors = list;
            this.methods = list2;
        }
    }

    public static class ForTokens extends AbstractBase<MethodDescription.InDefinedShape> {
        private final TypeDescription declaringType;
        private final List<? extends MethodDescription.Token> tokens;

        public ForTokens(TypeDescription typeDescription, MethodDescription.Token... tokenArr) {
            this(typeDescription, (List<? extends MethodDescription.Token>) Arrays.asList(tokenArr));
        }

        public int size() {
            return this.tokens.size();
        }

        public ForTokens(TypeDescription typeDescription, List<? extends MethodDescription.Token> list) {
            this.declaringType = typeDescription;
            this.tokens = list;
        }

        public MethodDescription.InDefinedShape get(int i10) {
            return new MethodDescription.Latent(this.declaringType, (MethodDescription.Token) this.tokens.get(i10));
        }
    }

    public static class TypeSubstituting extends AbstractBase<MethodDescription.InGenericShape> {
        protected final TypeDescription.Generic declaringType;
        protected final List<? extends MethodDescription> methodDescriptions;
        protected final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;

        public TypeSubstituting(TypeDescription.Generic generic, List<? extends MethodDescription> list, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor2) {
            this.declaringType = generic;
            this.methodDescriptions = list;
            this.visitor = visitor2;
        }

        public int size() {
            return this.methodDescriptions.size();
        }

        public MethodDescription.InGenericShape get(int i10) {
            return new MethodDescription.TypeSubstituting(this.declaringType, (MethodDescription) this.methodDescriptions.get(i10), this.visitor);
        }
    }

    MethodList<MethodDescription.InDefinedShape> asDefined();

    List<MethodDescription.SignatureToken> asSignatureTokenList();

    List<MethodDescription.SignatureToken> asSignatureTokenList(ElementMatcher<? super TypeDescription> elementMatcher, TypeDescription typeDescription);

    ByteCodeElement.Token.TokenList<MethodDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> elementMatcher);
}

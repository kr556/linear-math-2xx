package org.linear.main.matrix;

import org.linear.main.vector.AbsVector;
import org.liner.annotation.PropertiesMethod;
import org.linear.main.Arithmetic;

public abstract class AbsMatrix<E extends Number, V extends AbsMatrix<E, V, TRNS>, TRNS extends AbsMatrix<E, TRNS, V>>
        implements Matrix<E, V, TRNS>, Arithmetic<E, V>, MatrixFunctions<E, V, TRNS> {
    public AbsMatrix() {}

    public AbsMatrix(V copy) {
        if (copy != null) {
            this.set(copy);
        }
    }

    /**
     * Creating new instance. Useing default constracter.
     * @return Same type new empty instance.
     */
    public abstract V craete();

    public V clone() {
        V re = create();
        re.set((V) this);
        return re;
    }

    int posToIndex(int r, int c) {
        return r * rowDimension() + c;
    }

    public V map(MatrixElementMapper<E> map) {
        for (int r = 0; r < columnDimension(); r++) {
            for (int c = 0; c < rowDimension(); c++) {
                set(r, c, map.set(r, c, get(posToIndex(r, c))));
            }
        }

        return (V) this;
    }

    public V map(MatrixMapper<E> map) {
        for (int r = 0; r < columnDimension(); r++) {
            for (int c = 0; c < rowDimension(); c++) {
                set(r, c, map.set(r, c));
            }
        }

        return (V) this;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder re = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        String[] strL = new String[elementsSize()];
        int maxDigits = 0;
        E[] es = toArray();

        for (int r = 0; r < columnDimension(); r++) {
            for (int c = 0; c < rowDimension(); c++) {
                String s = String.valueOf(es[posToIndex(r, c)]);
                maxDigits = Math.max(s.length(), maxDigits);
                strL[posToIndex(r, c)] = s;
            }
        }

        for (int i = 0; i < strL.length; i++) {
            strL[i] = String.format("%" + maxDigits + "s", strL[i]);
        }

        for (int r = 0; r < columnDimension(); r++) {
            re.append('[');
            for (int c = 0; c < rowDimension(); c++) {
                re.append(strL[posToIndex(r, c)]);
                if (c != rowDimension() - 1) re.append(", ");
            }
            re.append("]\n");
        }

        return re.toString();
    }

    @Override
    public E[] toArray() {
        int esSize = elementsSize();
        Number[] el = new Number[esSize];


        for (int r = 0; r < columnDimension(); r++) {
            for (int c = 0; c < rowDimension(); c++) {
                el[posToIndex(r, c)] = get(posToIndex(r, c));
            }
        }

        return (E[]) el;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof AbsVector<?,?>)) return false;
        return this.equals((V)obj);
    }

    @PropertiesMethod
    @Override
    public final boolean isScalar() {
        return false;
    }
}

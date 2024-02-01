package org.linear.main;

import org.linear.main.matrix.Matrix;
import org.linear.main.vector.*;

public final class LinearMath {
    private LinearMath() {}

    public static Vector3f normal3f(Vector3f a, Vector3f b, boolean nomalize) {
        return normal3f(a, b, new Vector3f(), nomalize);
    }

    public static Vector3f normal3f(Vector3f a, Vector3f b, Vector3f pointer, boolean nomalize) {
        pointer.set(cross3f(a, b, pointer));
        if (nomalize) {
            return pointer.nomalize();
        } else {
            return pointer;
        }
    }

    public static Vector4f normal3f(Vector4f a, Vector4f b, boolean nomalize) {
        return normal3f(a, b, new Vector4f(), nomalize);
    }

    public static Vector4f normal3f(Vector4f a, Vector4f b, Vector4f pointer, boolean nomalize) {
        pointer.set(cross3f(a, b, pointer));
        pointer.w = 0;
        if (nomalize) {
            return pointer.nomalize();
        } else {
            return pointer;
        }
    }

    public static Vector3d normal3d(Vector3d a, Vector3d b, Vector3d pointer, boolean nomalize) {
        pointer.set(cross3d(a, b, pointer));
        if (nomalize) {
            return pointer.nomalize();
        } else {
            return pointer;
        }
    }

    public static Vector3d normal3d(Vector3d a, Vector3d b, boolean nomalize) {
        return normal3d(a, b, new Vector3d(), nomalize);
    }

    public static Vector4d normal3d(Vector4d a, Vector4d b, Vector4d pointer, boolean nomalize) {
        pointer.set(cross3d(a, b, pointer));
        pointer.w = 0;
        if (nomalize) {
            return pointer.nomalize();
        } else {
            return pointer;
        }
    }

    public static Vector4d normal3d(Vector4d a, Vector4d b, boolean nomalize) {
        return normal3d(a, b, new Vector4d(), nomalize);
    }

    public static Vector4d normal3dPos(Vector4d a, Vector4d b, Vector4d c) {
        return normal3dPos(a, b, c, new Vector4d());
    }

    public static Vector4d normal3dPos(Vector4d a, Vector4d b, Vector4d c, Vector4d pointer) {
        return cross(
                c.x - a.x,
                c.y - a.y,
                c.z - a.z,
                c.x - b.x,
                c.y - b.y,
                c.z - b.z,
                pointer);
    }

    public static Vector3d normal3dPos(Vector3d a, Vector3d b, Vector3d c) {
        return cross3d(a, b, new Vector3d());
    }

    public static Vector3d normal3dPos(Vector3d a, Vector3d b, Vector3d c, Vector3d pointer) {
        return cross(
                c.x - a.x,
                c.y - a.y,
                c.z - a.z,
                c.x - b.x,
                c.y - b.y,
                c.z - b.z,
                pointer);
    }

    public static Vector4f normal3fPos(Vector4f a, Vector4f b, Vector4f c) {
        return normal3fPos(a, b, c, new Vector4f());
    }

    public static Vector4f normal3fPos(Vector4f a, Vector4f b, Vector4f c, Vector4f pointer) {
        return cross(
                c.x - a.x,
                c.y - a.y,
                c.z - a.z,
                c.x - b.x,
                c.y - b.y,
                c.z - b.z,
                pointer);
    }

    public static Vector3f normal3fPos(Vector3f a, Vector3f b, Vector3f c) {
        return cross3f(a, b, new Vector3f());
    }

    public static Vector3f normal3fPos(Vector3f a, Vector3f b, Vector3f c, Vector3f pointer) {
        return cross(
                c.x - a.x,
                c.y - a.y,
                c.z - a.z,
                c.x - b.x,
                c.y - b.y,
                c.z - b.z,
                pointer);
    }

    public static Vector4d cross3d(Vector4d a, Vector4d b) {
        return cross3d(a, b, new Vector4d());
    }

    public static Vector4d cross3d(Vector4d a, Vector4d b, Vector4d pointer) {
        return cross(a.x, a.y, a.z, b.x, b.y, b.z, pointer);
    }

    public static Vector3d cross3d(Vector3d a, Vector3d b) {
        return cross3d(a, b, new Vector3d());
    }

    public static Vector3d cross3d(Vector3d a, Vector3d b, Vector3d pointer) {
        return cross(a.x, a.y, a.z, b.x, b.y, b.z, pointer);
    }

    private static Vector4d cross(double ax, double ay, double az,
                                  double bx, double by, double bz, Vector4d pointer) {
        pointer.set(
                ay * bz - az * by,
                ax * bz - az * bx,
                ax * by - ay * bx,
                1);
        return pointer;
    }

    private static Vector3d cross(double ax, double ay, double az,
                                  double bx, double by, double bz, Vector3d pointer) {
        pointer.set(
                ay * bz - az * by,
                ax * bz - az * bx,
                ax * by - ay * bx);
        return pointer;
    }

    public static Vector4f cross3f(Vector4f a, Vector4f b, Vector4f pointer) {
        return cross(a.x, a.y, a.z, b.x, b.y, b.z, pointer);
    }

    public static Vector3f cross3f(Vector3f a, Vector3f b, Vector3f pointer) {
        return cross(a.x, a.y, a.z, b.x, b.y, b.z, pointer);
    }

    private static Vector4f cross(float ax, float ay, float az,
                                  float bx, float by, float bz, Vector4f pointer) {
        pointer.set(
                ay * bz - az * by,
                ax * bz - az * bx,
                ax * by - ay * bx,
                1);
        return pointer;
    }

    private static Vector3f cross(float ax, float ay, float az,
                                  float bx, float by, float bz, Vector3f pointer) {
        pointer.set(
                ay * bz - az * by,
                ax * bz - az * bx,
                ax * by - ay * bx);
        return pointer;
    }

    public static <E extends Number> boolean canCalculate(Matrix<E, ?, ?> matrix, Vector<E, ?> vector) {
        return matrix.rowDimension() == vector.dimension();
    }

    public static <E extends Number> boolean canCalculate(Vector<E, ?> vector, Matrix<E, ?, ?> matrix) {
        return vector.dimension() == matrix.columnDimension();
    }
}

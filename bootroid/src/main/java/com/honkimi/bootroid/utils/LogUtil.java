package com.honkimi.bootroid.utils;

import android.util.Log;

import com.honkimi.bootroid.Conf;

import java.util.Objects;

/**
 * Created by honkimi on 14/11/28.
 */
public class LogUtil {
    private static final String TAG = "LogUtil";

    public static void v() {
        if (Conf.DEV_MODE) {
            Log.v(TAG, getMetaInfo());
        }
    }

    public static void v(Object message) {
        if (Conf.DEV_MODE && message != null) {
            Log.v(TAG, getMetaInfo() + null2str(message.toString()));
        }
    }

    public static void d() {
        if (Conf.DEV_MODE) {
            Log.d(TAG, getMetaInfo());
        }
    }

    public static void d(Object message) {
        if (Conf.DEV_MODE && message != null) {
            Log.d(TAG, getMetaInfo() + null2str(message.toString()));
        }
    }

    public static void i() {
        if (Conf.DEV_MODE) {
            Log.i(TAG, getMetaInfo());
        }
    }

    public static void i(Object message) {
        if (Conf.DEV_MODE && message != null) {
            Log.i(TAG, getMetaInfo() + null2str(message.toString()));
        }
    }

    public static void w(Object message) {
        if (Conf.DEV_MODE && message != null) {
            Log.w(TAG, getMetaInfo() + null2str(message.toString()));
        }
    }

    public static void w(Objects message, Throwable e) {
        if (Conf.DEV_MODE && message != null) {
            Log.w(TAG, getMetaInfo() + null2str(message.toString()), e);
            printThrowable(e);
            if (e.getCause() != null) {
                printThrowable(e.getCause());
            }
        }
    }

    public static void e(Object message) {
        if (Conf.DEV_MODE && message != null) {
            Log.e(TAG, getMetaInfo() + null2str(message.toString()));
        }
    }

    public static void e(Object message, Throwable e) {
        if (Conf.DEV_MODE && message != null) {
            Log.e(TAG, getMetaInfo() + null2str(message.toString()), e);
            printThrowable(e);
            if (e.getCause() != null) {
                printThrowable(e.getCause());
            }
        }
    }

    public static void e(Throwable e) {
        if (Conf.DEV_MODE) {
            printThrowable(e);
            if (e.getCause() != null) {
                printThrowable(e.getCause());
            }
        }
    }

    private static String null2str(String string) {
        if (string == null) {
            return "(null)";
        }
        return string;
    }

    /**
     * 例外のスタックトレースをログに出力する
     *
     * @param e
     */
    private static void printThrowable(Throwable e) {
        Log.e(TAG, e.getClass().getName() + ": " + e.getMessage());
        for (StackTraceElement element : e.getStackTrace()) {
            Log.e(TAG, "  at " + LogUtil.getMetaInfo(element));
        }
    }

    /**
     * ログ呼び出し元のメタ情報を取得する
     *
     * @return [className#methodName:line]
     */
    private static String getMetaInfo() {
        // スタックトレースから情報を取得 // 0: VM, 1: Thread, 2: LogUtil#getMetaInfo, 3: LogUtil#d など, 4: 呼び出し元
        final StackTraceElement element = Thread.currentThread().getStackTrace()[4];
        return LogUtil.getMetaInfo(element);
    }

    /**
     * スタックトレースからクラス名、メソッド名、行数を取得する
     *
     * @return [className#methodName:line]
     */
    public static String getMetaInfo(StackTraceElement element) {
        // クラス名、メソッド名、行数を取得
        final String fullClassName = element.getClassName();
        final String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf(""));
        final String methodName = element.getMethodName();
        final int lineNumber = element.getLineNumber();
        // メタ情報
        final String metaInfo = "[" + simpleClassName + "#" + methodName + ":" + lineNumber + "]";
        return metaInfo;
    }
}

package com.example.sc.common;


/**
 * 表示对象有 {@code status} 和 {@code notes} 属性。
 *
 */
public interface StatusAware {
    /**
     * 正常的状态码。
     */
    int STATUS_OK = 1;
    /**
     * 错误的状态码。
     */
    int STATUS_FAILED = 2;

    /**
     * 获取状态码。
     *
     * @return 状态码。
     */
    int getStatus();

    /**
     * 如果有错误，则为错误的描述。
     *
     * @return 错误描述。
     */
    String getNotes();

    default boolean isStatusOK() {
        return getStatus() == STATUS_OK;
    }

    default boolean isStatusFailed() {
        return !isStatusOK();
    }
}

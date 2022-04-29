package com.example.sc.feign.impl.client.web.bind;


import com.example.sc.common.OpenResponse;
import com.example.sc.common.ServiceException;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Nonnull;
import java.util.stream.Collectors;

import static java.lang.System.lineSeparator;

/**
 * 全局异常处理
 * <p>当feign接口实现端的处理时抛出异常，调用方也可以方便获取当前请求接口成功与否信息。<p/>
 */
@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {
    private final static String EOL = lineSeparator();
    private static final int MAX_BIND_ERRORS_TO_LOG = 5;

    @ExceptionHandler(Exception.class)
    public OpenResponse onGenericException(Exception e) {
        if (log.isErrorEnabled()) {
            log.error("处理请求时发生错误。{}", EOL, e);
        }

        return OpenResponse.failed("dxc:common:internal_error", "系统错误，请稍后再试。");
    }

    @ExceptionHandler(ServiceException.class)
    public OpenResponse onServiceException(@Nonnull ServiceException e) {
        var cause = e.getCause();
        if (cause == null) {
            if (log.isWarnEnabled()) {
                log.warn("{}（错误代码：{}）{}", e.getErrorMessage(), e.getErrorCode(), EOL);
            }
        } else {
            if (log.isErrorEnabled()) {
                log.error("{}（错误代码：{}）{}", e.getErrorMessage(), e.getErrorCode(), EOL, cause);
            }
        }

        return OpenResponse.failed(e.getErrorCode(), e.getErrorMessage());
    }


    @ExceptionHandler(BindException.class)
    public OpenResponse onBindException(@Nonnull BindException e) {
        var allErrors = e.getAllErrors();

        if (log.isWarnEnabled()) {
            var errors = allErrors.stream()
                    .limit(MAX_BIND_ERRORS_TO_LOG)
                    .map(ExceptionAdvice::toString)
                    .map(s -> "  * " + s)
                    .collect(Collectors.joining(EOL));
            if (allErrors.size() > MAX_BIND_ERRORS_TO_LOG) {
                errors = errors + EOL + "  ...";
            }

            log.warn("前端有 {} 个字段校验规则未验证。{}{}{}", allErrors.size(), EOL, errors, EOL);
        }

        var message = allErrors.stream()
                .findFirst()
                .map(ExceptionAdvice::toString)
                .orElse("您的请求包含错误，请检查。");


        return OpenResponse.failed("dxc:common:validation_failed", message);
    }


    private static String toString(ObjectError e) {
        var code = e.getCode();
        var message = e.getDefaultMessage();
        if (Strings.isNullOrEmpty(code)) {
            return message;
        }
        if (e instanceof FieldError) {
            var field = ((FieldError) e).getField();
            if (!Strings.isNullOrEmpty(field)) {
                return String.format("%s: %s (字段：%s)", code, message, field);
            }
        }
        return String.format("%s: %s", code, message);
    }
}

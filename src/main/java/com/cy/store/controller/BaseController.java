package com.cy.store.controller;

import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.ServiceException;
import com.cy.store.service.ex.UsernameDuplicatedException;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;
import java.util.DuplicateFormatFlagsException;

/**
 * 控制层类的基类
 */
public class BaseController {
    /**
     * 成功的状态码
     */
    public static final int OK=200;
    @ExceptionHandler(ServiceException.class)//统一处理抛出的异常
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<Void>(e);
//        if (e instanceof UsernameDuplicateException) {
//            result.setState(4000);
//        } else if (e instanceof UserNotFoundException) {
//            result.setState(4001);
//        } else if (e instanceof PasswordNotMatchException) {
//            result.setState(4002);
//        } else if (e instanceof AddressCountLimitException) {
//            result.setState(4003);
//        } else if (e instanceof AddressNotFoundException) {
//            result.setState(4004);
//        } else if (e instanceof AccessDeniedException) {
//            result.setState(4005);
//        } else if (e instanceof ProductNotFoundException) {
//            result.setState(4006);
//        } else if (e instanceof CartNotFoundException) {
//            result.setState(4007);
//        } else if (e instanceof InsertException) {
//            result.setState(5000);
//        } else if (e instanceof UpdateException) {
//            result.setState(5001);
//        } else if (e instanceof DeleteException) {
//            result.setState(5002);
//        } else if (e instanceof FileEmptyException) {
//            result.setState(6000);
//        } else if (e instanceof FileSizeException) {
//            result.setState(6001);
//        } else if (e instanceof FileTypeException) {
//            result.setState(6002);
//        } else if (e instanceof FileStateException) {
//            result.setState(6003);
//        } else if (e instanceof FileUploadIOException) {
//            result.setState(6004);
//        }
        return result;
    }

    protected final Integer getuidFromSession(HttpSession httpSession){
        return Integer.valueOf(httpSession.getAttribute("uid").toString());

    }

    protected final String getUsernameFromSession(HttpSession httpSession){
        return httpSession.getAttribute("username").toString();
    }
}

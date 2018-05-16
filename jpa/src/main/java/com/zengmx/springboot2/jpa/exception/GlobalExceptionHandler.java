package com.zengmx.springboot2.jpa.exception;

import com.zengmx.springboot2.core.exception.BaseException;
import com.zengmx.springboot2.core.web.BaseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Title:
 * Company:互撸娃大战铁茎肛.avi
 *
 * @author <a href="mailto:8574157@qq.com">zengmx</a>
 * @date 2018/5/15  19:47
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 指定捕获的exception类型，以及返回json格式数据
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public BaseResult<String> jsonErrorHandler(HttpServletRequest request, BaseException e) throws Exception {
        BaseResult<String> result = new BaseResult<>();
        result.setResultCode(e.getErrorCode());
        result.setMessage(e.getMessage());
        result.setData("it is an error...");
        return result;
    }

    /**
     * 使用模板引擎时，它们默认的模板配置路径为：src/main/resources/templates
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultExceptionHandler(HttpServletRequest request, Exception e) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}

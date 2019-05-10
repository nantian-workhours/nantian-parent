/**
 * @Description: 节假日信息管理
 * @ClassName: NtHolidayController
 * @author： Mr.Kong
 * @date: 2019/5/10 14:03
 * @Version： 1.0
 */
package cn.com.nantian.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NtHolidayController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(CustTypeController.class);

    @InitBinder("ntHoliday")
    public void initBindNtHoliday(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.setFieldDefaultPrefix("ntHoliday.");
    }




}

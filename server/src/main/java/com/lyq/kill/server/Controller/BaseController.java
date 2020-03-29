package com.lyq.kill.server.Controller;

import com.lyq.kill.api.enums.StatusCode;
import com.lyq.kill.api.response.BaseResponse;
import jodd.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("base")
public class BaseController {
//    private static final Logger log = (Logger) LoggerFactory.getLogger(BaseController.class);
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
    @GetMapping("/welcome")
    public String welcome(String name,String name1,String name2, ModelMap modelMap){
        
        if (StringUtil.isBlank(name)){
            name = "这是一个后台传递的welcome";
            name1 = "这是一个后台传递的welcome1";
            name2 = "这welcome1";
            
        }
        modelMap.put("name",name);
        modelMap.put("name1",name1);
        modelMap.put("name2",name2);
        return "welcome";
    }
    @GetMapping("/data")
    @ResponseBody
    public String data(String name){
        if (StringUtil.isBlank(name)) {
            name = "这是一个后台传递的welcome";
        }
        return name;
    }

    @GetMapping("/response")
    @ResponseBody
    public BaseResponse response(String name){
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        if (StringUtil.isBlank(name)) {
            name = "这是一个后台传递的welcome";
        }
        baseResponse.setData(name);
        return baseResponse;
    }
}

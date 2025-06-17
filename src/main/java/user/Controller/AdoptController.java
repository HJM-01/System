package user.Controller;


import entity.AdoptAnimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import user.service.AdoptAnimalService;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/adopt")
public class AdoptController {

    @Autowired
    private AdoptAnimalService adoptService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody  //表示返回数据直接写入 HTTP 响应体，而不是视图名称
    public Map<String, Object> createAdopt(@ModelAttribute AdoptAnimal adopt) {//将请求参数绑定到 AdoptAnimal 对象参数
        Map<String, Object> result = new HashMap<>();//返回 JSON 格式的响应数据

        try {
            adoptService.createAdopt(adopt);
            result.put("code", 200);
            result.put("msg", "申请提交成功");
        } catch (Exception e) {
            result.put("code", 500);
            result.put("msg", "申请提交失败");
        }

        return result;
    }
}
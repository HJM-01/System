package user.Controller;
import util.Message;
import entity.user;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import user.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/create")
    @ResponseBody
    public Message add(user user) {
        int add = userService.add(user);
        if (add > 0) {
            return Message.success();
        } else {
            return Message.fail();
        }
    }

    @RequestMapping("/login")
    @ResponseBody
    public Message loginuser(HttpSession session, String userName, String password) {
        user user = userService.loginuser(userName, password);
        if (user != null) {
            session.setAttribute("user", user);
            return Message.success().add("user", user);
        } else {
            return Message.fail();
        }
    }

    @RequestMapping("/logout")
    @ResponseBody
    public Message logout(HttpSession session) {
        session.invalidate();
        return Message.success();
    }

//    @RequestMapping("/users")
//    @ResponseBody
//    public Message users(@RequestParam(required = false) String userName, @RequestParam("pn")Integer pageNum){
//        Integer pageSize = 4;
//        PageInfo<user> users = userService.allUser(userName,pageNum,pageSize);
//        return Message.success().add("pageInfo",users);
//    }

    @RequestMapping("findById")
    @ResponseBody
    public Message findById(Integer id) {
        user byId = userService.findById(id);
        return Message.success().add("user", byId);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Message del(Integer id) {
        int del = userService.del(id);
        if (del > 0) {
            return Message.success();
        } else {
            return Message.fail();
        }
    }

    @RequestMapping("/home")
    public String about() {
        return "user/home";
    }

    @RequestMapping("/error")
    public String error() {
        return "user/error";
    }

    @RequestMapping("/pet knowledge")
    public String index() {
        return "user/pet knowledge";
    }


    @RequestMapping("/adoptionInformange")
    public String show() {
        return "user/adoptionInformange";
    }


    @RequestMapping("/update")
    @ResponseBody
    public Message update(user user) {
        Integer update = userService.update(user);
        if (update > 0) {
            return Message.success();
        } else {
            return Message.fail();
        }
    }
}
//    @RequestMapping("/updatePic")
//    @ResponseBody
//    public Message updatePic(HttpSession session, MultipartFile file){
//        String fileName = FileLoad.uploadUserPic(file);
//        user user = (user) session.getAttribute("user");
//        user.setPic(fileName);
//        Integer update = userService.update(user);
//        if (update > 0){
//            return Message.success();
//        }else {
//            return Message.fail();
//        }
//    }


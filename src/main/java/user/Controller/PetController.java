package user.Controller;

import entity.Pet;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import util.Message;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import user.service.PetService;
import entity.user;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
import user.service.UserService;
import entity.user;

import java.util.List;


@Controller
@RequestMapping("/pet")
public class PetController {

    @Resource
    private PetService petService;

//    @RequestMapping("/pets")
//    @ResponseBody
//    public Message pet(@RequestParam(required = false) String petType, @RequestParam("pn")Integer pageNum){
//        Integer pageSize = 3;
//        if(pageNum == null){
//            pageNum = 1;
//        }
//        PageInfo<Pet> pets = petService.allPet(petType, pageNum, pageSize);
//        return Message.success().add("pageInfo",pets );
//    }

    @RequestMapping("/findById")
    @ResponseBody
    public Message findPetById(HttpSession session, Integer id){
        Pet pet = petService.findById(id);
        String pics = pet.getPic();
        session.setAttribute("pet", pet);
        session.setAttribute("pics", pics);
        return Message.success().add("pet", pet);
    }

//    @RequestMapping("/create")
//    @ResponseBody
//    public Message add(Pet pet, MultipartFile file){
//        String pic = FileLoad.uploadPetPic(file);
//        pet.setPic(pic);
//        int add = petService.add(pet);
//        if(add>0){
//            return Message.success();
//        }else{
//            return Message.fail();
//        }
//
//    }

//    @RequestMapping("/update")
//    @ResponseBody
//    public Message update(Pet pet, MultipartFile file){
//        if (file != null && file.getSize() > 0){
//            String pic = FileLoad.uploadPetPic(file);
//            pet.setPic(pic);
//        }
//        int update = petService.update(pet);
//        if(update>0){
//            return Message.success();
//        }else{
//            return Message.fail();
//        }
//    }

    @RequestMapping("/delete")
    @ResponseBody
    public Message del(Integer id){
        int del = petService.del(id);
        if(del>0){
            return Message.success();
        }else {
            return Message.fail();
        }
    }

}

//        @RequestMapping("/pets")
//        @ResponseBody
//        public Message pet(@RequestParam(required = false) String petType, @RequestParam("pn")Integer pageNum){
//            Integer pageSize = 3;
//            if(pageNum == null){
//                pageNum = 1;
//            }
//            PageInfo<Pet> pets = petService.allPet(petType, pageNum, pageSize);
//            return Message.success().add("pageInfo",pets );
//        }


//        @RequestMapping("/create")
//        @ResponseBody
//        public Message add(Pet pet, MultipartFile file){
//            String pic = FileLoad.uploadPetPic(file);
//            pet.setPic(pic);
//            int add = petService.add(pet);
//            if(add>0){
//                return Message.success();
//            }else{
//                return Message.fail();
//            }
//
//        }

//        @RequestMapping("/update")
//        @ResponseBody
//        public Message update(Pet pet, MultipartFile file) {
//            if (file != null && file.getSize() > 0) {
//                String pic = FileLoad.uploadPetPic(file);
//                pet.setPic(pic);
//            }
//            int update = petService.update(pet);
//            if (update > 0) {
//                return Message.success();
//            } else {
//                return Message.fail();
//            }
//        }

//        @RequestMapping("/delete")
//        @ResponseBody
//        public Message del(Integer id) {
//            int del = petService.del(id);
//            if (del > 0) {
//                return Message.success();
//            } else {
//                return Message.fail();
//            }
//        }
//    }




////一个典型的Spring MVC控制器，遵循了MVC设计模式，将业务逻辑委托给Service层，并负责将数据传递给视图层。
//@Controller    //一个控制器，它的所有方法都会处理HTTP请求。
//@RequestMapping("/pet")     //设置了基础路径为 /pet
//public class PetController {
//
//        @Autowired
//        private PetService petService;
//
//        /**
//         * 显示宠物详情页面
//         * 访问路径: /pet/detail/{id} 或 /pet/detail?id={id}
//         */
//        @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)  //@PathVariable标注参数变量id,接受URL中的请求参数
//        public String showPetDetailById(@PathVariable Long id, Model model, HttpSession session) {//@PathVariable注解告诉Spring从请求的URL中提取此值。
//            return processePetDetail(id, model, session);//    Model 用于向视图添加属性
//        }
//
//        @RequestMapping(value = "/detail", method = RequestMethod.GET)
//        public String showPetDetailByParam(@RequestParam Long id, Model model, HttpSession session) {
//            return processePetDetail(id, model, session);
//        }
//
//
//         //处理宠物详情的核心方法
//        private String processePetDetail(Long id, Model model, HttpSession session) {
//            try {
//                // 获取宠物详情
//                Pet pet = petService.getPetById(id);
//                if (pet == null) {
//                    model.addAttribute("error", "宠物信息不存在");
//                    return "error"; // 转到错误页面
//                }
//
//                // 将数据添加到model中，供JSP页面使用
//                model.addAttribute("pet", pet);
//
//                // 将宠物ID存储到session中（用于JavaScript和后续操作）
//                session.setAttribute("pet", pet.getId());
//
//                // 获取当前登录用户信息
//                user user = (user) session.getAttribute("user");
//                if (user != null) {
//                    model.addAttribute("user", user);
//                } else {
//                    // 如果用户未登录，创建一个默认用户对象避免页面报错
//                    user defaultUser = new user();
//                    defaultUser.setUserName("游客");
//                    model.addAttribute("user", defaultUser);
//                }
//
//                // 返回JSP页面名称（不包括.jsp后缀）
//                return "adoptionInformange"; // 对应 /WEB-INF/views/petDetail.jsp
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                model.addAttribute("error", "获取宠物信息失败：" + e.getMessage());
//                return "error";
//            }
//        }
//
//        // 返回服务中心页面
//        @RequestMapping(value = "/service", method = RequestMethod.GET)
//        public String showService() {
//            return "service"; // 对应 /WEB-INF/views/service.jsp
//        }
//
//
//          //获取所有宠物列表（用于服务中心页面）
//        @RequestMapping(value = "/list", method = RequestMethod.GET)
//        public String showPetList(Model model) {
//            try {
//                List<Pet> pets = petService.getAllPets();
//                model.addAttribute("pets", pets);
//                return "petList"; // 对应 /WEB-INF/views/petList.jsp
//            } catch (Exception e) {
//                e.printStackTrace();
//                model.addAttribute("error", "获取宠物列表失败：" + e.getMessage());
//                return "error";
//            }
//        }
//    }


//    @Autowired
//    private PetService petService;  //自动注入 PetService，用于处理宠物相关的业务逻辑
//
//    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)  //@PathVariable标注参数变量id,接受URL中的请求参数
//    public String showPetDetail(@PathVariable Long id, Model model, HttpSession session) { //@PathVariable注解告诉Spring从请求的URL中提取此值。
//        // 获取宠物详情                                  Model 用于向视图添加属性
//        Pet pet = petService.getPetById(id);//通过 petService 获取宠物详情
//        if (pet == null) {
//            return "redirect:/error";  //如果宠物不存在，重定向到错误页面
//        }
//
//
//        // 将数据添加到model中
//        model.addAttribute("pet", pet);
//
//        // 将宠物信息存储到session中（用于JavaScript访问）
//        session.setAttribute("pet", pet.getId());
//
//        // 获取当前用户信息（假设已经登录）
//        user user = (user) session.getAttribute("user");
//        if (user != null) {
//            model.addAttribute("user", user);
//        }
//
//        return "petDetail"; // 返回JSP页面名称
//    }
//
//    @RequestMapping(value = "/service", method = RequestMethod.GET)
//    public String showService() {
//        return "service"; // 返回服务中心页面
//    }

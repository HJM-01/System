package user.Controller;

import entity.Pet;
import entity.user;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jakarta.servlet.http.HttpSession;
import user.service.PetService;

@Controller
@ComponentScan(basePackages = "user.Controller")
@RequestMapping("/pet")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/detail/{id}")
    public String showPetDetailById(@PathVariable Long id, Model model, HttpSession session) {
        try {
            // 获取宠物详情
            Pet pet = petService.getPetById(id);
            if (pet == null) {
                model.addAttribute("error", "宠物信息不存在");
                return "error"; // 转到错误页面
            }

            // 将数据添加到model中，供JSP页面使用
            model.addAttribute("pet", pet);

            // 将宠物ID存储到session中（用于JavaScript和后续操作）
            session.setAttribute("pet", pet.getId());

            // 获取当前登录用户信息
            user user = (user) session.getAttribute("user");
            if (user != null) {
                model.addAttribute("user", user);
            } else {
                // 如果用户未登录，创建一个默认用户对象避免页面报错
                user defaultUser = new user();
                defaultUser.setUserName("游客");
                model.addAttribute("user", defaultUser);
            }

            // 返回JSP页面名称（不包括.jsp后缀）
            return "adoptionInformange"; // 对应 /WEB-INF/views/adoptionInformange.jsp

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "获取宠物信息失败：" + e.getMessage());
            return "error";
        }
    }
}
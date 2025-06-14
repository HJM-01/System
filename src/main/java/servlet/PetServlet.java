package servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class PetServlet extends HttpServlet {
    //序列化版本号（Serial Version UID）
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws SecurityException, IOException{
        //可以直接获取参数
        //设置编码字符集
        req.setCharacterEncoding("utf-8");
        //假设我们的的参数请中都有一个标记（？？？？）
        String action = req.getParameter("action");
        if (action == null) {
            action="";//这是查询请求中没有action参数
        }
        switch (action) {
            case "inster":
                insterPet(req,resp);
        }
    }
//插入数据
    private void insterPet(HttpServletRequest req, HttpServletResponse resp)
            throws SecurityException, IOException {
            //获取所有的参数
        String petName = req.getParameter("petName");
        String petType = req.getParameter("petType");
        String Sex = req.getParameter("Sex");


    }
}

package cn.jack.controller;

import cn.jack.entity.Account;
import cn.jack.service.AccountService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AccountController {

    /**
     * 这里这样子写不好，还需优化
     */
    private static Integer totalRecords;//获取记录总数
    private static Integer pageSize = 3;//每页显示的记录数
    private static Integer pageCount;//总页数
    private static Integer currentPage;//待显示页码

    @Autowired
    private AccountService accountService;

    @RequestMapping("/queryAccounts")
    public String queryAccounts(HttpServletRequest request, Model model){
        totalRecords = accountService.queryTotalRecords();
        pageCount = (totalRecords%pageSize == 0)?(totalRecords/pageSize) : (totalRecords/pageSize+1);
        //获取当前页数
        String strCurrentPage;
        if ((strCurrentPage = (String) request.getParameter("pageNum")) == null){
            currentPage = 1;
        }else{
            currentPage = Integer.parseInt(strCurrentPage);
            //设置当前访问页面超出页数的大小
            if(currentPage >= pageCount) currentPage = pageCount;
            else if (currentPage < 1) currentPage = 1;
        }

        //查询数据
        Map<String, Integer> map = new HashMap<>();
        map.put("start", (currentPage - 1) * pageSize); //从哪一条记录开始查询
        map.put("pages", pageSize);
        List<Account> accounts = accountService.queryLimitAccounts(map);

        model.addAttribute("pageSize",pageSize);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalRecords",totalRecords);
        model.addAttribute("accounts",accounts);

        return "home";
    }
}

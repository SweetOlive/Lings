package com.gutan.servlet.Provider;
import com.google.gson.Gson;
import com.gutan.pojo.Provider;
import com.gutan.pojo.User;
import com.gutan.service.provider.ProviderService;
import com.gutan.service.provider.ProviderServiceImpl;
import com.gutan.util.Constans.Constant;
import com.mysql.cj.util.StringUtils;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProviderServlet extends HttpServlet {

    private ProviderService providerService;
    public ProviderServlet() {
        providerService = new ProviderServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("query".equals(method) && null!=method){
            this.query(req,resp);
        }else if("add".equals(method) && null !=method){
            this.add(req,resp);
        }else if ("delprovider".equals(method)){
            this.deleteProvider(req,resp);
        }else if("modify".equals(method)){
            this.getProviderById(req,resp,"providermodify.jsp");
        }else if("view".equals(method)){
            this.getProviderById(req,resp,"providerview.jsp");
        }else if("modifysave".equals(method)){
            this.modify(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    // 根据指定的procode和proname查询
    public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String queryProName = req.getParameter("queryProName");
        String queryProCode = req.getParameter("queryProCode");
        List<Provider> providerList = null;
        if(StringUtils.isNullOrEmpty(queryProName)){
            queryProName = "";
        }
        if(StringUtils.isNullOrEmpty(queryProCode)){
            queryProCode = "";
        }
        providerList = providerService.getProviderList(queryProName, queryProCode);
        for (Provider provider : providerList) {
            System.out.println(provider);
        }
        req.setAttribute("providerList", providerList);
        req.setAttribute("queryProName", queryProName);
        req.setAttribute("queryProCode", queryProCode);
        req.getRequestDispatcher("providerlist.jsp").forward(req, resp);
    }

    // 增加供应商
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String proCode = req.getParameter("proCode");
        String proName = req.getParameter("proName");
        String proContact = req.getParameter("proContact");
        String proPhone = req.getParameter("proPhone");
        String proAddress = req.getParameter("proAddress");
        String proFax = req.getParameter("proFax");
        String proDesc = req.getParameter("proDesc");
        Provider provider = new Provider();
        provider.setProCode(proCode);
        provider.setProName(proName);
        provider.setProContact(proContact);
        provider.setProPhone(proPhone);
        provider.setProFax(proFax);
        provider.setProAddress(proAddress);
        provider.setProDesc(proDesc);
        provider.setCreatedBy(((User)req.getSession().getAttribute(Constant.USER_SESSION)).getId());
        provider.setCreationDate(new Date());
        if(providerService.add(provider)){
            resp.sendRedirect(req.getContextPath()+"/jsp/provider.do?method=query");
        }else {
            req.getRequestDispatcher("provideradd.jsp").forward(req,resp);
        }
    }

    // 删除供应商
    public void deleteProvider(HttpServletRequest req, HttpServletResponse resp){
        String proid = req.getParameter("proid");
        Map<String, String> resultMap = new HashMap<>();
        if (!StringUtils.isNullOrEmpty(proid)){
            int flag = providerService.deleteProviderById(proid);
            if (flag==0){
                resultMap.put("delResult","true");
            }
            if (flag ==-1){
                resultMap.put("delResult","false");
            }
            if (flag>0){
                resultMap.put("delResult",String.valueOf(flag));
            }
        }else {
            resultMap.put("delResult","notexist");
        }
        //转换为Json格式
        resp.setContentType("application/json");
        try {
            PrintWriter writer = resp.getWriter();
            writer.write(new Gson().toJson(resultMap));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 跳转进修改供应商的界面
    public void getProviderById(HttpServletRequest req, HttpServletResponse resp,String url) throws IOException, ServletException {
        String proid = req.getParameter("proid");
        Provider provider = null;
        if (!StringUtils.isNullOrEmpty(proid)){
            provider = providerService.getProviderById(proid);
            req.setAttribute("provider",provider);
            System.out.println(provider);
            req.getRequestDispatcher(url).forward(req,resp);
        }
    }

    //modify provider
    public void modify(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String proName = request.getParameter("proName");
        String proContact = request.getParameter("proContact");
        String proPhone = request.getParameter("proPhone");
        String proAddress = request.getParameter("proAddress");
        String proFax = request.getParameter("proFax");
        String proDesc = request.getParameter("proDesc");
        String id = request.getParameter("id");
        Provider provider = new Provider();
        provider.setId(Integer.parseInt(id));
        provider.setProContact(proContact);
        provider.setProName(proName);
        provider.setProPhone(proPhone);
        provider.setProFax(proFax);
        provider.setProAddress(proAddress);
        provider.setProDesc(proDesc);
        provider.setModifyBy(((User)request.getSession().getAttribute(Constant.USER_SESSION)).getId());
        provider.setModifyDate(new Date());
        boolean flag = false;
        flag = providerService.modify(provider);
        if (flag){
            response.sendRedirect(request.getContextPath()+"/jsp/provider.do?method=query");
        }else {
            request.getRequestDispatcher("providermodify.jsp").forward(request,response);
        }
    }
}

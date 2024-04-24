package com.sangmeng.servlet;

import com.sangmeng.entity.Administrative;
import com.sangmeng.entity.Doctor;
import com.sangmeng.entity.IdInformation;
import com.sangmeng.service.impl.AdministrativeServiceImpl;
import com.sangmeng.service.impl.DoctorServiceImpl;
import com.sangmeng.service.impl.IdInformationServiceImpl;
import com.sangmeng.service.impl.LoginServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/CommitDoctorServlet")
public class CommitDoctorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        String user = null;
        String ad_no = null;
        String ad_name = null;
        String sno = null;
        String name = null;
        String self_introduction = null;
        String photo = null;
        int charge = 0;
        String level = null;
        String audit = "";
        String outputDir = "E:\\Paper\\web\\upload\\doc_photo";
        boolean multipartContent = ServletFileUpload.isMultipartContent(request);
        if(multipartContent)
        {
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            diskFileItemFactory.setSizeThreshold(1024*1024);
            ServletFileUpload upLoad = new ServletFileUpload(diskFileItemFactory);
            try {
                upLoad.setFileSizeMax(1024*1024*10);
                List<FileItem> items = upLoad.parseRequest(request);
                for(FileItem item:items)
                {
                    if(item.isFormField())
                    {
                        if(item.getFieldName().equals("name"))
                        {
                            name = item.getString("utf-8");
                        }else if(item.getFieldName().equals("ad"))
                        {
                            ad_no = item.getString("utf-8");
                            Administrative administrative = new AdministrativeServiceImpl().queryByAd_no(ad_no);
                            ad_name = administrative.getAd_name();
                        }else if (item.getFieldName().equals("sno"))
                        {
                            sno = item.getString("utf-8");
                        }else if (item.getFieldName().equals("self"))
                        {
                            self_introduction = item.getString("utf-8");
                        }
                        else if(item.getFieldName().equals("level")){
                            level = item.getString("utf-8");
                            if("profession".equals(level))
                            {
                                charge = 15;
                            }else
                            {
                                charge = 10;
                            }
                        } else if (item.getFieldName().equals("user"))
                        {
                            user = item.getString("utf-8");
                        }
                    }
                    else
                    {
                        photo = Long.toString(System.currentTimeMillis())+".jpg";
                        File file = new File(outputDir,photo);
                        try {
                            item.write(file);
                            System.out.println(file.getName()+"上传成功");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            catch (FileUploadBase.FileSizeLimitExceededException e) {
                System.out.println("文件过大！");
            }catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
        if(user!=null)
        {
            username = user;
        }
        if(new LoginServiceImpl().queryByUsername(username)==null)
        {
            response.getWriter().write("null");
            return;
        }else
        {
            if(new DoctorServiceImpl().queryDoctorByUsername(username)!=null)
            {
                if(user!=null)
                {
                    response.getWriter().write("exist");
                    return;
                }
                System.out.println("信息已存在！！！");
                response.sendRedirect("AccessExamineIdInformationServlet");
                return;
            }
        }
        if(user!=null)
        {
            audit="audited";
        }
        Doctor doctor = new Doctor(username,ad_no,ad_name,sno,name,self_introduction,photo,charge,level,audit);
        if(new DoctorServiceImpl().addDoctor(doctor))
        {
            if(user!=null)
            {
                response.getWriter().write("ok");
                return ;
            }
            System.out.println("添加成功！！！");
            response.sendRedirect("AccessDoctorInformationServlet");
            return ;
        }else{
            if(user!=null)
            {
                response.getWriter().write("error");
                return ;
            }
            System.out.println("添加失败！！！");
        }
    }
}

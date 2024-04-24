package com.sangmeng.servlet;

import com.sangmeng.entity.IdInformation;
import com.sangmeng.service.impl.IdInformationServiceImpl;
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
import java.util.Date;
import java.util.List;

@WebServlet("/AddIdInformationServlet")
public class AddIdInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        if(new IdInformationServiceImpl().queryIdInformationByUsername(username)!=null)
        {
            System.out.println("信息已存在！！！");
            response.sendRedirect("AccessExamineIdInformationServlet");
            return;
        }
        String name = null;
        String id = null;
        String province=null;
        String city = null;
        String address = null;
        String    date = null;
        String filename_p = null;
        String filename_n = null;
        String outputDir = "E:\\Paper\\web\\upload\\self_information";
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
                        }else if(item.getFieldName().equals("id"))
                        {
                            id = item.getString("utf-8");
                        }else if (item.getFieldName().equals("province"))
                        {
                            province = item.getString("utf-8");
                        }else if (item.getFieldName().equals("city"))
                        {
                            city = item.getString("utf-8");
                        }
                        else if(item.getFieldName().equals("address")){
                            address = item.getString("utf-8");
                        }else if(item.getFieldName().equals("date"))
                        {
                            date = item.getString("utf-8");
                        }
                    }
                    else
                    {
                        String Filename = Long.toString(System.currentTimeMillis());
                        File file = null;
                        if(item.getFieldName().equals("idp"))
                        {
                            filename_p = Filename+"1.jpg";
                            file = new File(outputDir,filename_p);
                        }else if(item.getFieldName().equals("idn"))
                        {
                            filename_n = Filename+"2.jpg";
                            file = new File(outputDir,filename_n);
                        }
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
        IdInformation idInformation = new IdInformation(username,name,id,province,city,address,date,filename_p,filename_p );
        if(new IdInformationServiceImpl().addIdInformation(idInformation)==1)
        {
            System.out.println("添加成功！！！");
            response.sendRedirect("AccessExamineIdInformationServlet");
            return ;
        }else{
            System.out.println("添加失败！！！");
        }
        System.out.println(idInformation);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

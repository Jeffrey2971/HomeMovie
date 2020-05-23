package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    用户下载模块
 */

@WebServlet("/downloadServlet")
public class downloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数，文件名称
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str_date = sdf.format(date);
        String filename = request.getParameter("filename");
        String data = request.getParameter("data");
        System.out.println(data);
        // 使用字节输入流加载文件进内存
        // 找到文件的服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/video/"+ data + "/" + filename);
        // 用字节流关联
        FileInputStream fis = new FileInputStream(realPath);

        // 设置response的响应头
        // 设置响应头：content-type
        String mimeType = servletContext.getMimeType(filename); // 获取文件的mime类型
        response.setHeader("content-type", mimeType);
        // 设置响应头打开方式：content-disposition
        response.setHeader("content-disposition", "attachment;filename=" + filename);

        // 将输入流的数据写出到输出流中
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ((len = fis.read(buff)) != -1) {
            sos.write(buff, 0, len);
        }

        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}

package com.springlec.file_download;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class DownloadController {

    private static final String FILE_PATH = "../test.pdf";
    private static final String APPLICATION_PDF = "application/pdf";
    
	@RequestMapping("/")
	   public String fileUploadForm(Model model) {
	      return "index";
	   }

    @RequestMapping(value = "/a", method = RequestMethod.GET, produces = APPLICATION_PDF)
    public void downloadA(HttpServletResponse response, HttpServletRequest request) throws IOException {
    	 System.out.println("downloadA");
        File file = getFile(request);
        InputStream in = new FileInputStream(file);

        response.setContentType(APPLICATION_PDF);
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));
        FileCopyUtils.copy(in, response.getOutputStream());
    }

    private File getFile(HttpServletRequest request) throws FileNotFoundException {
    	
    	String path =request.getSession().getServletContext().getRealPath("")+FILE_PATH;
    	System.out.println(path);
        File file = new File(path);
        if (!file.exists()){
            throw new FileNotFoundException("file with path: " + path + " was not found.");
        }
        return file;
    }

}

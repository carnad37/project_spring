package com.springlec.fileupload;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author imssbora
 */
@Controller
public class FileUploadController {
	private static final String FILE_EXT = ".jpg";


   @RequestMapping("/")
   public String fileUploadForm(Model model) {

      return "fileUploadForm";
   }

   // Handling single file upload request
   @RequestMapping("/singleFileUpload")
   public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model,
		   HttpServletRequest request)
         throws IOException {

      //1. make file name 
	  String fileName = genSaveFileName(FILE_EXT);
	  //2. get file path
	  String path =request.getSession().getServletContext().getRealPath("");
//	  String path =request.getSession().getServletContext().getRealPath("")+"../image/";
	  //3. make file using outputStream 
	   if (!file.getOriginalFilename().isEmpty()) {
		   BufferedOutputStream outputStream = new BufferedOutputStream(
	               new FileOutputStream(
	            		   new File(path,fileName)));
         outputStream.write(file.getBytes());
         outputStream.flush();
       //4. outputStream close
         outputStream.close();

         
         model.addAttribute("msg", "File uploaded successfully."+path);
      } else {
         model.addAttribute("msg", "Please select a valid file..");
      }

      return "fileUploadForm";
   }

   // Handling multiple files upload request
   @RequestMapping("/multipleFileUpload")
   public String multipleFileUpload(@RequestParam("file") MultipartFile[] files,
         Model model,  HttpServletRequest request) throws IOException {

	  String path =request.getSession().getServletContext().getRealPath("");
 
      for (MultipartFile file : files) {
         if (!file.getOriginalFilename().isEmpty()) {
            BufferedOutputStream outputStream = new BufferedOutputStream(
                  new FileOutputStream(
                        new File(path, file.getOriginalFilename())));

            outputStream.write(file.getBytes());
            outputStream.flush();
            outputStream.close();
         } else {
            model.addAttribute("msg", "Please select at least one file..");
            return "fileUploadForm";
         }
      }
      model.addAttribute("msg", "Multiple files uploaded successfully."+path);
      return "fileUploadForm";
   }
   
   private String genSaveFileName(String extName) {
	    String fileName = "";
	     
	    Calendar calendar = Calendar.getInstance();
	    fileName += calendar.get(Calendar.YEAR);
	    fileName += calendar.get(Calendar.MONTH);
	    fileName += calendar.get(Calendar.DATE);
	    fileName += calendar.get(Calendar.HOUR);
	    fileName += calendar.get(Calendar.MINUTE);
	    fileName += calendar.get(Calendar.SECOND);
	    fileName += calendar.get(Calendar.MILLISECOND);
	    fileName += extName;
	    System.out.println("genSaveFileName() : "+fileName); 
	    return fileName;
	  }


	
}

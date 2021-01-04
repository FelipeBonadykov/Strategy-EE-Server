package com.bonadykov.serverstrategy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class DownloadZip {
	private final int ARBITARY_SIZE = 1048;

	@GetMapping("/download")
	protected void downloadZipFile(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
    	resp.setContentType("application/zip");
		resp.setHeader("Content-disposition", "attachment; filename=Strategy.zip");
    	    	
    	try(InputStream in = req.getServletContext().getResourceAsStream("/WEB-INF/files/Strategy.zip");
    		OutputStream out = resp.getOutputStream()) {
    		byte[] buffer = new byte[ARBITARY_SIZE];
    		int numBytesRead;
    		while ((numBytesRead = in.read(buffer)) > 0) {
    			out.write(buffer, 0, numBytesRead);
    		} 		
    	}
    }
}

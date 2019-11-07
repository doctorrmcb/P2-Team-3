package com.revature.controller;

import static com.revature.util.LoggerUtil.info;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.s3.model.S3Object;
import com.revature.pojo.ControllerResponse;
import com.revature.pojo.ForumThread;
import com.revature.pojo.S3File;
import com.revature.pojo.User;
import com.revature.service.S3FileServiceImpl;

/**
 * This controller will control everything to do with S3 bucket files
 * 
 * @author ErikHaklar
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class S3FileController {
	
	private S3FileServiceImpl s3FileServiceImpl;

	@Autowired
	public void setS3FileServiceImpl(S3FileServiceImpl s3FileServiceImpl) {
		this.s3FileServiceImpl = s3FileServiceImpl;
	}
	
	
	/**
	 * Uploads a file to the S3 bucket
	 * 
	 * @author ErikHaklar
	 */
	@PostMapping("/upload-file")
	public ControllerResponse uploadFile(@RequestBody String return0){
		
		String[] infoString = return0.split("[!]");
		
		String keyName0 = infoString[1];
		String filePath0 = infoString[2];
		String category0 = infoString[3];
		//info(infoString[2]);
		S3File s3File = new S3File("lighthouse18882819", keyName0, filePath0, category0);
		
		
		info("Reached uploadFile in S3FileController");
		boolean status = false;
		//S3File s3File = new S3File();
		info("S3File: " + s3File);
		status = s3FileServiceImpl.uploadFile(s3File);
		
		ControllerResponse cr = new ControllerResponse();
		String response = "";
		
		if (status == true)
		{
			response = "success";
		}
		else
		{
			response = "failure";
		}
		
		cr.setResponse(response);
		return cr;
	}
	
	/**
	 * Grabs a file from the S3 bucket for download
	 * 
	 * @author ErikHaklar
	 */
	@GetMapping("/download-file/{}")
	public ControllerResponse downloadFile(@RequestBody String return0){
		
		String[] infoString = return0.split("[!]");
		
		String keyName0 = infoString[1];
		String filePath0 = infoString[2];
		
		info("Reached downloadFile in S3FileController");
		S3File file = new S3File();
		file.setKeyName(keyName0);
		file.setFilePath(filePath0);
		
		S3Object fileObject;
		fileObject = s3FileServiceImpl.sendFile(file);
		
		ControllerResponse cr = new ControllerResponse();
		
		cr.setResponse(fileObject.toString());
		return cr;
	}
	
	
	/**
	 * Gets list of files from the S3 bucket that have the specified category
	 * 
	 * @author ErikHaklar
	 */
	@GetMapping("/get-files/{category}")
	public List<S3File> getFilesByCategory(@PathVariable String category){
		info("Reached getFilesByCategory in S3FileController. Category: " + category);
		boolean status = false;
		//List<S3File> files = new ArrayList<S3File>();
		//files = s3FileServiceImpl.getFilesByCategory(category);
		
		List<S3File> files = s3FileServiceImpl.getFilesByCategory(category);
		
		//ControllerResponse cr = new ControllerResponse();
		info("Files: " + files);
		//cr.setResponse(files.toString());
		//info("cr: " + cr);
		return files;
	}

	
	/**
	 * Deletes a file from the S3 bucket
	 * 
	 * @author ErikHaklar
	 */
	@GetMapping("/delete-file")
	public ControllerResponse deleteFile(@RequestBody S3File file){
		info("Reached deleteFile in S3FileController");
		boolean status = false;
		status = s3FileServiceImpl.deleteFile(file);
		
		ControllerResponse cr = new ControllerResponse();
		String response = "";
		
		if (status == true)
		{
			response = "success";
		}
		else
		{
			response = "failure";
		}
		
		cr.setResponse(response);
		return cr;
	}
}


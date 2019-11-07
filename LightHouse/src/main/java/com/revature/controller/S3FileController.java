package com.revature.controller;

import static com.revature.util.LoggerUtil.info;

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
@CrossOrigin("*")
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
	@GetMapping("/upload-file")
	public ControllerResponse uploadFile(@RequestBody S3File file){
		info("Reached uploadFile in S3FileController");
		boolean status = false;
		status = s3FileServiceImpl.uploadFile(file);
		
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
	@GetMapping("/download-file")
	public ControllerResponse dwonloadFile(@RequestBody S3File file){
		info("Reached downloadFile in S3FileController");
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
	@GetMapping("/get-files")
	public ControllerResponse getFilesByCategory(@RequestBody String category){
		info("Reached getFilesByCategory in S3FileController");
		boolean status = false;
		List<S3File> files = new ArrayList<S3File>();
		files = s3FileServiceImpl.getFilesByCategory(category);
		
		ControllerResponse cr = new ControllerResponse();
		
		cr.setResponse(files.toString());
		return cr;
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


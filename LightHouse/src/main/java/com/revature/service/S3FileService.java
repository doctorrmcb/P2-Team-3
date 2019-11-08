package com.revature.service;

import java.util.List;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.revature.pojo.S3File;


/**
 * Interface for the S3FileService object
 * Acts as the liaison between the DAOs and the servlet
 * 
 * @author Erik
 */
public interface S3FileService {

	/**
	 * For uploading files to the S3 bucket
	 * 
	 * @author ErikHaklar
	 * @param file
	 * @param category
	 * @return boolean
	 */
	public boolean uploadFile(S3File file);
	
	/**
	 * For downloading files from the S3 bucket
	 * 
	 * @author ErikHaklar
	 * @param file
	 * @param category
	 * @return boolean
	 */
	public boolean downloadFile(S3File file);
	
	/**
	 * For retrieving files from the S3 bucket for viewing in list
	 * 
	 * @author ErikHaklar
	 * @param category
	 * @return List<S3File>
	 */
	public List<S3File> getFilesByCategory(String category);
	
	/**
	 * For sending file objects from the S3 bucket to Angular so that the user can download it
	 * from there. This should be used over downloadFile().
	 * 
	 * @author ErikHaklar
	 * @param S3File
	 * @return boolean
	 */
	public S3Object sendFile(S3File file);
	
	/**
	 * Call to remove a file from the S3 bucket. Returns true if successful.
	 * 
	 * @author ErikHaklar
	 * @param S3File
	 * @return boolean
	 */
	public boolean deleteFile(S3File file);
	
}

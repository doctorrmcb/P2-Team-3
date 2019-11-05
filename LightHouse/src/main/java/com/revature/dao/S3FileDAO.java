package com.revature.dao;

import java.util.List;

import com.amazonaws.services.s3.AmazonS3;
import com.revature.pojo.S3File;

/**
 * This is the interface to for S3 bucket file uploading, downloading, and retrieval
 * 
 * @author ErikHaklar
 */
public interface S3FileDAO {

	/**
	 * For uploading files to the S3 bucket
	 * 
	 * @author ErikHaklar
	 * @param file
	 * @param category
	 * @return boolean
	 */
	public boolean uploadFile(S3File file, String category);
	
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
	
}

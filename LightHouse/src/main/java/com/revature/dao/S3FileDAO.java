package com.revature.dao;

import java.util.List;

import com.amazonaws.services.s3.AmazonS3;
import com.revature.pojo.S3File;

/**
 * This is the interface to for S3 bucket file uploading, downloading, and retrieval
 * 
 * @author Erik
 */
public interface S3FileDAO {

	public boolean uploadFile(S3File file, String category);
	
	public boolean downloadFile(S3File file);
	
	public List<S3File> getFilesByCategory(String category);
	
}

package com.revature.dao;

import com.amazonaws.services.s3.AmazonS3;
import com.revature.pojo.S3File;

public interface S3FileDAO {

	public boolean uploadFile(S3File file);
	
	public boolean downloadFile(S3File file);
	
}

package com.revature.dao;

import com.revature.pojo.S3File;

public interface S3FileDAO {

	public boolean uploadFile(S3File file);
	
	public S3File downloadFile(S3File file);
	
}

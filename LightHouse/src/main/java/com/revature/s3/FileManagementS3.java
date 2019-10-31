package com.revature.s3;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.revature.dao.S3FileDAO;
import com.revature.pojo.S3File;
import static com.revature.util.LoggerUtil.*;

public class FileManagementS3 implements S3FileDAO{
	
	private final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();

	/**
	 * The UploadFile method uploads a specified file to the specified Amazon
	 * Web Services S3 bucket. The bucket name is the name of the S3 bucket to
	 * upload the file to, and should probably never be changed. Key name is
	 * just the name of for the file that is being uploaded to the bucket.
	 * The file path is the directory of the file on the clients computer.
	 * This is required to upload a file to AWS S3. Returns a boolean that is
	 * either true if the object has been uploaded or false if it has not been.
	 * 
	 * @author Erik Haklar
	 * @version 1.0
	 * @since 2019-10-30
	 */
	@Override
	public boolean uploadFile(S3File file) {
		
		try {
			s3.putObject(file.getBucketName(), file.getKeyName(), file.getFilePath());
		} catch (AmazonServiceException e) {
			error(e.getErrorMessage());
			return false;
		}
		
		return true;
	}

	@Override
	public S3File downloadFile(S3File file) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

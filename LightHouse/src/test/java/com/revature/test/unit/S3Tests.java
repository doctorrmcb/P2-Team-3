package com.revature.test.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.revature.pojo.S3File;
import com.revature.s3.FileManagementS3;

public class S3Tests {

private static FileManagementS3 fileMan = new FileManagementS3();


	
	@Before
	public void setUp() throws Exception {
		 
	}

	//--------------AWS S3 Bucket Tests------------------------------
	
	/**
	 * Tests whether or not a file at the directory specified in setFilePath
	 * can be uploaded to the AWS S3 Bucket.
	 * 
	 * @author Erik Haklar
	 * @version 1.0
	 * @since 2019-10-30
	 */
	@Test
	public void uploadFile()
	{
		fileMan = new FileManagementS3();
		
		S3File testFile = new S3File();
		testFile.setKeyName("UploadMe.txt");
		testFile.setFilePath("C:\\Users\\Erik\\Desktop\\S3Tests\\UploadMe.txt");
		
		assertEquals(true, fileMan.uploadFile(testFile));
	}
	
	/**
	 * Tests whether or not a file by the testFile.setKeyName value can be
	 * download from the AWS S3 bucket.
	 * 
	 * @author Erik Haklar
	 * @version 1.0
	 * @since 2019-10-31
	 */
	@Test
	public void downloadFile()
	{
		S3File testFile = new S3File();
		testFile.setKeyName("UploadMe.txt");
		testFile.setFilePath("C:\\Users\\Erik\\Desktop");
		
		assertEquals(true, fileMan.downloadFile(testFile));
	}
	
}

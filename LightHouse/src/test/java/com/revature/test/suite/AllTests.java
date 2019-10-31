package com.revature.test.suite;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

//import com.revature.dao.S3FileDAO;
import com.revature.pojo.S3File;
import com.revature.s3.FileManagementS3;

@RunWith(Suite.class)
@SuiteClasses({})
public class AllTests {
	
	private static FileManagementS3 fileMan;
	
	@Before
	public void setUp() throws Exception {
		 fileMan = new FileManagementS3();
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
		S3File testFile = new S3File();
		testFile.setKeyName("UploadMe.txt");
		testFile.setFilePath("C:\\Users\\Erik\\Desktop\\S3Tests\\UploadMe.txt");
		
		assertEquals(true, fileMan.uploadFile(testFile));
	}
	
}

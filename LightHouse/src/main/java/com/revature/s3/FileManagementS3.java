package com.revature.s3;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.revature.dao.S3FileDAO;
import com.revature.pojo.S3File;
import static com.revature.util.LoggerUtil.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileManagementS3 implements S3FileDAO{
	
	AWSCredentials credentials = new BasicAWSCredentials(
			System.getenv("AWS_ACCESS_KEY_ID"), 
			System.getenv("AWS_SECRET_ACCESS_KEY")
	);
							
	AmazonS3 s3client = AmazonS3ClientBuilder
		  .standard()
		  .withCredentials(new AWSStaticCredentialsProvider(credentials))
		  .withRegion(Regions.US_EAST_2)
		  .build();
	
	//private final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();

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
			PutObjectRequest request = new PutObjectRequest(file.getBucketName(), file.getKeyName(), new File(file.getFilePath()));
            ObjectMetadata metadata = new ObjectMetadata();
            //metadata.setContentType("plain/text");
            metadata.addUserMetadata("x-amz-meta-title", "someTitle");
            request.setMetadata(metadata);
            s3client.putObject(request);
		} catch (AmazonServiceException e) {
			// The call was transmitted successfully, but Amazon S3 couldn't process 
            // it, so it returned an error response.
			error(e.getErrorMessage());
			//System.exit(1);
			return false;
		} catch (SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            //e.printStackTrace();
			error(e.getLocalizedMessage());
            return false;
        }
		
		return true;
	}
	
	/**
	 * The downloadFile method will get the file specified within the file given
	 * to the method and write it to the client's specified file path on their
	 * machine. Oppose to the UploadFile method, the file.getFilePath() now
	 * specifies the path on the client's machine where the downloaded file
	 * should go to.
	 * 
	 * @author Erik Haklar
	 * @version 1.0
	 * @since 2019-10-31
	 */
	@Override
	public boolean downloadFile(S3File file) {
		
		boolean gotFile = false;
		S3Object object = s3client.getObject(new GetObjectRequest(file.getBucketName(), file.getKeyName()));
		InputStream objectDataInput = object.getObjectContent();
		//process the object data input stream
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(object.getObjectContent()));
			
			FileWriter writer = new FileWriter(file.getFilePath()); 
			BufferedWriter bufferWriter = new BufferedWriter(writer);
			
			String line;
			while((line = reader.readLine()) != null)
			{
				bufferWriter.write(line);
				gotFile = true;
			}
			
			objectDataInput.close();
			bufferWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return gotFile;
	}

	
	
}

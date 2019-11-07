package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.s3.model.S3Object;
import com.revature.dao.S3FileDAO;
import com.revature.pojo.S3File;

/**
 * The implementation of S3File Service
 * Acts as liaison between DAOs and servlet
 * 
 * @author ErikHaklar
 */
@Component
public class S3FileServiceImpl implements S3FileService {

	private static S3FileDAO s3FileDAO;
	private static String category;
	
	@Autowired
	public void setS3FileDAO(S3FileDAO fileDAO) {
		this.s3FileDAO = fileDAO;
	}
	
	/**
	 * For uploading files to the S3 bucket
	 * 
	 * @author ErikHaklar
	 * @param file
	 * @param category
	 * @return boolean
	 */
	@Override
	public boolean uploadFile(S3File file) {
		return s3FileDAO.uploadFile(file);
	}

	/**
	 * For downloading files from the S3 bucket
	 * 
	 * @author ErikHaklar
	 * @param file
	 * @param category
	 * @return boolean
	 */
	@Override
	public boolean downloadFile(S3File file) {
		return s3FileDAO.downloadFile(file);
	}

	/**
	 * For retrieving files from the S3 bucket for viewing in list
	 * 
	 * @author ErikHaklar
	 * @param category
	 * @return List<S3File>
	 */
	@Override
	public List<S3File> getFilesByCategory(String category) {
		return s3FileDAO.getFilesByCategory(category);
	}

	/**
	 * For sending file objects from the S3 bucket to Angular so that the user can download it
	 * from there. This should be used over downloadFile().
	 * 
	 * @author ErikHaklar
	 * @param S3File
	 * @return boolean
	 */
	@Override
	public S3Object sendFile(S3File file) {
		return s3FileDAO.sendFile(file);
	}

	/**
	 * Call to remove a file from the S3 bucket. Returns true if successful.
	 * 
	 * @author ErikHaklar
	 * @param S3File
	 * @return boolean
	 */
	@Override
	public boolean deleteFile(S3File file) {
		return s3FileDAO.deleteFile(file);
	}

}

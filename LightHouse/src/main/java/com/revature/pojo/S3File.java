package com.revature.pojo;

public class S3File {

	//This should not be changed, it is the name of the server that stores our files
	private String bucketName = "lighthouse18882819";
	
	private String keyName = "";
	private String filePath = "";
	
	public String getBucketName() {
		return bucketName;
	}
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bucketName == null) ? 0 : bucketName.hashCode());
		result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
		result = prime * result + ((keyName == null) ? 0 : keyName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		S3File other = (S3File) obj;
		if (bucketName == null) {
			if (other.bucketName != null)
				return false;
		} else if (!bucketName.equals(other.bucketName))
			return false;
		if (filePath == null) {
			if (other.filePath != null)
				return false;
		} else if (!filePath.equals(other.filePath))
			return false;
		if (keyName == null) {
			if (other.keyName != null)
				return false;
		} else if (!keyName.equals(other.keyName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "S3File [bucketName=" + bucketName + ", keyName=" + keyName + ", filePath=" + filePath + "]";
	}
	public S3File(String bucketName, String keyName, String filePath) {
		super();
		this.bucketName = bucketName;
		this.keyName = keyName;
		this.filePath = filePath;
	}
	public S3File() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

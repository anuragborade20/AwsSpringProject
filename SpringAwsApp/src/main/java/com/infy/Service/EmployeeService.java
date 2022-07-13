package com.infy.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.infy.EmployeeDTO.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeService {
	
	AmazonS3 amazonS3 = AmazonS3Client.builder().withRegion("ap-south-1")
			.withCredentials(new DefaultAWSCredentialsProviderChain()).build();
	public String addFileIntoS3(List<EmployeeDTO> employeeDTOS) {
		String fileName = "D:\\JsonData.json";
		String bucket = "jsonpostos3";
		StringBuilder key = new StringBuilder().append("S3Data").append(LocalDateTime.now()).append(".json");
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			mapper.writeValue(new File(fileName), employeeDTOS);
		}catch(IOException e) {
			e.printStackTrace();
		}
		amazonS3.putObject(bucket, String.valueOf(key),new File(fileName));
		return "File Uploaded Successfully";
	}
}

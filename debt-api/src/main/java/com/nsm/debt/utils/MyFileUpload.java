package com.nsm.debt.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class MyFileUpload {
	public static List<String> upload(MultipartFile[] files) throws IOException{
		List<String> imgNames=new ArrayList<String>();
		String path=MyPropertiesUtil.getProperty("myupload.properties", "window_path");
		for (MultipartFile file : files) {
			if(!file.isEmpty()) {
				String OriginalFilename=file.getOriginalFilename();
				String filename=UUID.randomUUID().toString()+OriginalFilename.substring(OriginalFilename.lastIndexOf("."));
				String url=path+filename;
				imgNames.add(filename);
				File file1=new File(url);
				if(!file1.exists()) {
					file1.createNewFile();
				}
				file.transferTo(file1);
			}
			
		}
		return imgNames;
	}
}

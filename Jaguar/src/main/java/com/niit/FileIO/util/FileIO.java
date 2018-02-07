package com.niit.FileIO.util; 


import java.io.FileOutputStream;

import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.nio.file.Path;



import org.springframework.web.multipart.MultipartFile;



public class FileIO {



	public static void upload(Path path,MultipartFile f,String fName)
	{
		if(!f.isEmpty()){

			InputStream inputStream=null;

			OutputStream outputStream=null;

			

			if(f.getSize()>0){

				try{

				inputStream=f.getInputStream();

				outputStream=new FileOutputStream(path+fName);

				int readBytes=0;

				byte[] buffer=new byte[1024];

				while((readBytes=inputStream.read(buffer, 0, 1024))!=-1){

					outputStream.write(buffer, 0, readBytes);

				}

				}catch(IOException e){

					e.printStackTrace();

				}

				finally{

					try{

						outputStream.close();

						inputStream.close();

					}catch(IOException e){

						e.printStackTrace();

					}

				}

			}

		}

	}



	 
		

	}




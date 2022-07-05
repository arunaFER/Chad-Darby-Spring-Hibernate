package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class TrueFileFortuneService implements FortuneService {
	
	private String fileName = "D:/eclipse-workspace/Section 8 Practice Question/src/FortuneData.txt";
	//arraylist to store fortunes
	private ArrayList<String> fortunes;
	
	//random object
	Random myRandom = new Random();
	
	//read file using buffer reader
	public TrueFileFortuneService() {
		
		File theFile = new File(fileName);

		System.out.println("Reading fortunes from file: " + theFile);
		System.out.println("File exists: " + theFile.exists());
		
		try(BufferedReader br = new BufferedReader(new FileReader(theFile))){
			
			//initialise arraylist
			fortunes = new ArrayList<String>();
			
			String sCurrentLine;
			
			//read until file is over
			while((sCurrentLine = br.readLine())  != null ) {
				fortunes.add(sCurrentLine);
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String getFortuneService() {
		//pick random string from arraylist
		int randIndex = myRandom.nextInt(fortunes.size());
		String newFortune = fortunes.get(randIndex);
		
		//return a random fortune
		return newFortune;
	}

}


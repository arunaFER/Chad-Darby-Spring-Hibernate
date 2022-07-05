package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {
	
	//arraylist to store fortunes
	private ArrayList<String> fortunes;
	
	//random object
	Random myRandom = new Random();
	
	//read file using buffer reader
	public FileFortuneService() {
		try(BufferedReader br = new BufferedReader(new FileReader("D:/eclipse-workspace/Section 8 Practice Question/src/FortuneData.txt"))){
			
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


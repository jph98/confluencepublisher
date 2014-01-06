package com.froyo.confpub;

import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.Task;
import org.swift.confluence.cli.ConfluenceClient;

public class ConfPubTask extends Task {

	public void execute() {
		
		String username = "jholloway";
		String password = "password";
		String parentPageName = "Home";
		String pageName = "Generated Confluence CLI Page";
		String spaceName = "DEV10";
		String confluenceUrl = "http://confluenceinstance:8082";
		
		// Example CLI 
		List<String> args = new ArrayList<String>();		
		args.add("--action");
		args.add("addPage");
		args.add("--space");
		args.add(spaceName);
		args.add("--title");
		args.add(pageName);
		args.add("--parent");
		args.add(parentPageName);
		args.add("-u");
		args.add(username);
		args.add("-p");
		args.add(password);
		args.add("--server");
		args.add(confluenceUrl);
				
		new ConfluenceClient().main(args.toArray(new String[args.size()]));	
	}
	
	public static String q(String part) {
		return new String("\"" + part + "\"");
	}
	
	public static void main(String[] args) {
		new ConfPubTask().execute();
	}
}

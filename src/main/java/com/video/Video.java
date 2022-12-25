package com.video;

public class Video {
	
	private int id;
	private String videoname;
	private String filename;
	private String path;
	private String description;
	private String category;
	
	public Video(int id, String videoname, String filename, String path, String description, String category) {
		
		this.id = id;
		this.videoname = videoname;
		this.filename = filename;
		this.path = path;
		this.description = description;
		this.category = category;
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getVideoname() {
		return videoname;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public String getPath() {
		return path;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getCategory() {
		return category;
	}
	
}

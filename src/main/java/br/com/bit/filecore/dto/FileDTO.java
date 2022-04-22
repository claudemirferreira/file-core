package br.com.bit.filecore.dto;

import java.nio.file.Path;

public class FileDTO {
	
	private String content;
	
	private String from;
	
	private String target;
	
	private boolean existFrase;
	
	private Path pathFile;
	
	private Path pathDirectory;
	
	private String typeFile;
	
	public FileDTO() {
		this.content = "";
		this.existFrase = false;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public boolean isExistFrase() {
		return existFrase;
	}

	public void setExistFrase(boolean existFrase) {
		this.existFrase = existFrase;
	}

	public Path getPathFile() {
		return pathFile;
	}

	public void setPathFile(Path pathFile) {
		this.pathFile = pathFile;
	}

	public Path getPathDirectory() {
		return pathDirectory;
	}

	public void setPathDirectory(Path pathDirectory) {
		this.pathDirectory = pathDirectory;
	}

	public String getTypeFile() {
		return typeFile;
	}

	public void setTypeFile(String typeFile) {
		this.typeFile = typeFile;
	}

	public void addContent(String line) {
		if (line.contains(from)) {
			line = line.replaceAll(from, target);
			existFrase = true;
		}
		content = content + line + "\n";
	}
	
	public void print() {
		System.out.println("PARAMETROS DE ENTRADA");
		System.out.println("from="+getFrom());
		System.out.println("target="+getTarget());
		System.out.println("pathDirectory="+getPathDirectory());
		System.out.println("typeFile="+getTypeFile());
		
	}
	
}

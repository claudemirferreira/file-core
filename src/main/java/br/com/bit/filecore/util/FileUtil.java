package br.com.bit.filecore.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.bit.filecore.dto.FileDTO;

public class FileUtil {

	public static void main(String[] args) throws IOException {
		FileDTO fileDTO = new FileDTO();
		fileDTO.setFrom("http://localhost:9091/mock/holidays/");
		fileDTO.setTarget("http://1.1.1.1:9091/mock/");

		String pathFile = "/home/claudemir/work/fonte/script/script/";
		List<File> files = new ArrayList<>();
		listAllFiles(new File(pathFile), fileDTO, files);

		for (File file : files) {
			fileDTO.setPathFile(Paths.get(file.getAbsolutePath()));
			getFile(fileDTO);
		}
	}

	public static void process(FileDTO fileDTO) throws IOException {
		List<File> files = new ArrayList<>();
		listAllFiles(new File(fileDTO.getPathDirectory().toUri()), fileDTO, files);

		for (File file : files) {
			fileDTO.setPathFile(Paths.get(file.getAbsolutePath()));
			getFile(fileDTO);
		}
	}

	public static void init() throws IOException {

		FileDTO fileDTO = new FileDTO();
		Scanner input = new Scanner(System.in);

//	    System.out.print("Informe a frase a ser alterada: ");
//	    fileDTO.setFrom(input.next());
//	    
//	    System.out.print("Informe o novo valor: ");
//	    fileDTO.setTarget(input.next());
//	    
//	    System.out.print("Informe a extenção do arquivo .yml ou .sidhh: ");
//	    fileDTO.setTypeFile(input.next());
//	    
//	    System.out.print("Informe o diretorio dos arquivos: ");
//	    fileDTO.setPathDirectory(Path.of(input.next()));

		fileDTO.setFrom("http://localhost:9091/mock/holidays/");
		fileDTO.setTarget("http://1.1.1.1:9091/mock/");
		fileDTO.setPathDirectory(Path.of("/home/claudemir/work/fonte/script/script/"));
		fileDTO.setTypeFile(".yml");

		fileDTO.print();

		process(fileDTO);

	}

	public static void getFile(FileDTO fileDTO) throws IOException {
		System.out.println("Read file " + fileDTO.getPathFile());
		fileDTO.setContent("");
		Files.lines(fileDTO.getPathFile()).forEach(line -> fileDTO.addContent(line));
		if (fileDTO.isExistFrase()) {
			System.out.println(fileDTO.getPathFile().getFileName());
			System.out.println(fileDTO.getContent());
			//System.out.println(fileDTO.isExistFrase());
		}
	}

	public void whiteFile() {

	}

	public static List<File> listAllFiles(File file, FileDTO fileDTO, List<File> files) {
		File[] tab = file.listFiles();
		for (File current : tab) {
			if (current.isFile() && current.getName().contains(fileDTO.getTypeFile())) {
				files.add(current);
			} else if (current.isDirectory()) {
				listAllFiles(current, fileDTO, files);
			}
		}
		return files;
	}
}

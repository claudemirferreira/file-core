package br.com.bit.filecore;

import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.bit.filecore.util.FileUtil;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Override
	public void run(String... args) throws IOException {
		main(args);
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Init application");
		FileUtil.init();
	}
}

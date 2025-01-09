package cat.aoc.dcoc.cocref;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages= { "cat.aoc.dcoc.cocref.service", "cat.aoc.dcoc.cocref.config" })
@ServletComponentScan ()
public class CocrefGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CocrefGradleApplication.class, args);
	}

}

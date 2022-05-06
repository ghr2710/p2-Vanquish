package dev.roberts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.voteappboot.VoteAppBootApplication;

@SpringBootApplication
public class FakeMain {
	public static void main(String[] args) {
		SpringApplication.run(VoteAppBootApplication.class, args);
	}

}

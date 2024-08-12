package com.bankingsystem.bankingapi;

import com.bankingsystem.bankingdb.BankingDbApplication;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.bankingsystem.bankingdb", "com.bankingsystem.bankingapi"})
public class BankingApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(BankingApiApplication.class, args);
    Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
    dotenv.entries().forEach(entry -> {
      System.setProperty(entry.getKey(), entry.getValue());
    });
    SpringApplication.run(BankingDbApplication.class, args);
  }
}

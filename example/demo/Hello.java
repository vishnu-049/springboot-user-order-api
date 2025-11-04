package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    public static void main(String args[]){
        SpringApplication.run(DemoApplication.class, args);
    }
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello from cs ";
    }
    @GetMapping("/bye")
    public String sayBye(){
        return "Bye from the java World";
    }
    @GetMapping("/greet")
    public String greet(String name){
        return "Hey"+name+", Welcome to Spring Boot";
    }
    @GetMapping("/info")
    public Profile showInfo() {
        return new Profile("Gangisetty Vishnu", "Java Developer", "Learning Spring Boot & Backend Development");
    }
    static class Message {
        private String text;
        private String type;

        public Message(String text, String type) {
            this.text = text;
            this.type = type;
        }

        public String getText() { return text; }
        public String getType() { return type; }
    }

    static class Profile {
        private String name;
        private String role;
        private String message;

        public Profile(String name, String role, String message) {
            this.name = name;
            this.role = role;
            this.message = message;
        }

        public String getName() { return name; }
        public String getRole() { return role; }
        public String getMessage() { return message; }
    }
}

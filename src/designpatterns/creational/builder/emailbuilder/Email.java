package designpatterns.creational.builder.emailbuilder;

import java.util.*;
import java.util.Map;

public class Email {
    private final String to;
    private final String subject;
    private List<String> cc;

    Email(Builder builder){
        this.to = builder.to;
        this.subject = builder.subject;
        this.cc = builder.cc;
    }

    @Override
    public String toString() {
        return "Email{" +
                "to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", cc=" + cc +
                '}';
    }

    public static class Builder{
        private String to;
        private String subject;

        private List<String> cc = new ArrayList<>();

        public Builder(String to, String subject){
            this.to = to;
            this.subject = subject;
        }

        public Builder cc(String cc){
            this.cc.add(cc);
            return this;
        }

        public Email build(){
            return new Email(this);
        }

    }
}

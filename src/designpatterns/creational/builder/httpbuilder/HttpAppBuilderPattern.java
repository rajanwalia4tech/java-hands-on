package designpatterns.creational.builder.httpbuilder;

public class HttpAppBuilderPattern {
    public static void main(String[] args) {
        HttpRequest request1 = new HttpRequest.Builder().url("https://api.example.com/data")
            .build();

        HttpRequest request2 = new HttpRequest.Builder().url("https://api.example.com/data")
            .method("POST")
            .addBodyParam("name","rajan").addBodyParam("email" , "example@gmail.com")
            .timeout(15000)
            .build();

        HttpRequest request3 = new HttpRequest.Builder().url("https://api.example.com/data")
            .method("PUT")
            .addHeader("X-API-Key", "secret")
            .addQueryParam("env", "prod")
            .addBodyParam("name","rajan").addBodyParam("email" , "example@gmail.com")
            .timeout(5000)
            .build();

        System.out.println(request1);
        System.out.println(request2);
        System.out.println(request3);
    }
}
package com.korit.springboot.controller;

import com.korit.springboot.dto.ReqDataDto6;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RequestDataController {

    //Get 요청 파라미터 받는 방법 1(서블릿 / 자료형변환 직접필요)
    @GetMapping("/req/data1")
    public ResponseEntity<Map<String, String>> reqGet1(HttpServletRequest request) {
        String name = request.getParameter("a");
        int age = Integer.parseInt(request.getParameter("b"));
        System.out.println("data1:" + name);
        System.out.println("data1:" + age);
        return ResponseEntity.ok().build();
    }

    //Get 요청 파라미터 받는 방법 2
    @GetMapping("/req/data2")
    public ResponseEntity<Map<String, String>> reqGet2(@RequestParam("a") String name, @RequestParam("b") int age) {
        System.out.println("data2:" + name);
        System.out.println("data2:" + age);
        return ResponseEntity.ok().build();
    }

    //Get 요청 파라미터 받는 방법 3 - 변수명과 파라미터 명이 일치하면 @RequestParam의 이름을 생략할 수 있다.
    @GetMapping("/req/data3")
    public ResponseEntity<Map<String, String>> reqGet3(@RequestParam String name, @RequestParam int age) {
        System.out.println("data3:" + name);
        System.out.println("data3:" + age);
        return ResponseEntity.ok().build();
    }

    // Get 요청 파라미터 받는 방법 3 - 해당 파라미터를 필수 항목으로 설정 할 수 있다.(기본 값 True)
    // 정수 자료형의 파라미터가 필수가 아닐 때 Integer 자료형을 사용해야한다.
    @GetMapping("/req/data4")
    public ResponseEntity<Map<String, String>> reqGet4(@RequestParam String name, @RequestParam(required = false) Integer age) {
        System.out.println("data4:" + name);
        System.out.println("data4:" + age);
        return ResponseEntity.ok().build();
    }

    //Get 요청 파라미터 받는 방법 5   -   파라미터가 많아졌을 때 정리하는 방법
    @GetMapping("/req/data5")
    public ResponseEntity<Map<String, String>> reqGet5(
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam String address,
            @RequestParam String phone) {
        System.out.println("data5:" + name);
        System.out.println("data5:" + age);
        return ResponseEntity.ok().build();
    }

    //Get 요청 파라미터 받는 방법 6   -   파라미터가 많아졌을 때 DTO로 처리하는 방법
    @GetMapping("/req/data6")
    public ResponseEntity<Map<String, String>> reqGet6(ReqDataDto6 dto) {
        System.out.println("data6:" + dto.getName());
        System.out.println("data6:" + dto.getAge());
        return ResponseEntity.ok().build();
    }

    //Get 요청 파라미터 받는 방법 7   -   주소에서 값 가져오기
    @GetMapping("/req/{path}/data7/{id}")
    public ResponseEntity<Map<String, String>> reqGet7(
            @PathVariable int id,
            @PathVariable String path,
            ReqDataDto6 dto) {
        System.out.println("data7:" + id);
        System.out.println("data7:" + path);
        System.out.println("data7:" + dto.getName());
        System.out.println("data7:" + dto.getAge());
        return ResponseEntity.ok().build();
    }
}

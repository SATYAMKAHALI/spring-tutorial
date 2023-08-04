package com.example.Satyam.controller;

import com.example.Satyam.model.Student;
import org.springframework.web.bind.annotation.*;


@RestController
public class MainController {

    // get request without any data or plain get request
    @GetMapping("hey")
    public String heySatyam() {
        return "Hey Satyam!";
    }

    // get request with data as request param
    @GetMapping("/getSquare")
    public int getSquare(@RequestParam("num") int num) {

        return squareOfANumber(num);
    }

    public int squareOfANumber(int num) {
        int sq = num * num;
        System.out.println(sq);
        return sq;
    }

    // get request with data as path variable
    @GetMapping("/getCube/{num}")
    public int getCube(@PathVariable("num") int num) {

        return getCubeOfNumber(num);
    }

    private int getCubeOfNumber(int num) {

        return getSquare(num) * num;
    }

    // post with path variable
    @PostMapping("/showNum/{num}")
    public int showNum(@PathVariable int num) {
        return num;
    }

    // post with request body
    @PostMapping("/showBody")
    public Student showBody(@RequestBody Student s) {

        return s;
    }


    // put with path variable
    @PutMapping("/updateNum/{num}")
    public String updateNum(@PathVariable int num) {

        return "Num is updated successfully";
    }

    // delete with path variable
    @DeleteMapping("/deleteNum/{num}")
    public String deleteNum(@PathVariable int num) {

        return "Num is deleted successfully";
    }

}

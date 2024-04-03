package com.example.thymeleafdemo.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {
    // need a controller method to show initial HTML form
    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    //need a controller method to process form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    /*
        Here we are taking that studentName and making it all upper case. So we are reading
        form data and calling methods on it.
    */
    @RequestMapping("/processFormVersionTwo")
    //HttpServletRequest lets us read the form data in our controller code
    public String letsShoutDude(HttpServletRequest request, Model model) {
        //read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        // convert the data to all caps
        theName = theName.toUpperCase();

        //create the message
        String result = "Yo! " + theName;

        //add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }


    /*
    Another way of doing this is by binding data to variables using the @RequestParam annotation
    here we can bind studentName to theName without having to everything we did above.
     */
    @PostMapping("/processFormVersionThree")
    public String letsShoutDude(@RequestParam("studentName") String theName, Model model) {
        // convert the data to all caps
        theName = theName.toUpperCase();

        //create the message
        String result = "Yo! " + theName;

        //add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

    /*
    @RequestMapping is a catch-all for http requests. @GetMapping and @PostMapping are examples of
    more specific mapping for methods. We can use @GetMapping(path="...", method=RequestMethod.GET)
    so that this method only handles GET requests and will reject everything else.
    Note: in post requests, the data is sent in the body of the http request message
    GET - good for:
    -debugging
    -bookmarking and email URL
    -limited data length

    POST - good for:
    -can't bookmark or email URL
    -no limitations on data length
    -can also use binary data
     */

}

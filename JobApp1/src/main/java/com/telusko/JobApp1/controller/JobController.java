package com.telusko.JobApp1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.telusko.JobApp1.model.JobPost;
import com.telusko.JobApp1.service.JobService;

@Controller
@RequestMapping("/")
public class JobController {

    @Autowired
    private JobService service;

    /**
     * Handles requests to the home page.
     * Accessible at "/" and "/home".
     */
    @GetMapping("/")
    public String home() {
        return "newhome"; // Maps to home.jsp
    }

    /**
     * Displays the "Add Job" form.
     * Accessible at "/addjob".
     */
    @GetMapping("/addjob")
    public String addJob() {
        return "addjob"; // Maps to addjob.jsp
    }

    /**
     * Displays all job posts.
     * Accessible at "/viewalljobs".
     */
    @GetMapping("/viewalljobs")
    public String viewJobs(Model model) {
        List<JobPost> jobPosts = service.returnAllJobPosts();
        model.addAttribute("jobPosts", jobPosts);
        return "viewalljobs"; // Maps to viewalljobs.jsp
    }

    /**
     * Handles the form submission for adding a new job.
     * Accessible at "/handleForm".
     */
    @PostMapping("/handleForm")
    public String handleAddJobForm(JobPost jobPost, Model model) {
        service.addJobPost(jobPost); // Save the job post
        model.addAttribute("jobPost", jobPost);
        return "success"; // Maps to success.jsp
    }
}

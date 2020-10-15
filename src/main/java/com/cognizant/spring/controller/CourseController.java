package com.cognizant.spring.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.spring.entity.Course;
import com.cognizant.spring.services.CourseService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;

	private final String courseStatus = "Active";

	@RequestMapping("/home")
	public String home() {
		return "home/searchList";
	}

	@RequestMapping("/exporttoexcel")
	public String exportToExcel(@PathVariable List<Course> courseList) {
		System.out.println("CourseList received for export: " + courseList);
		return "home/searchList";

	}

	@RequestMapping("/basicSearch")
	@ResponseBody
	public String findAllCourseUsingbasicSearch(@ModelAttribute("course") Course course) {
		System.out.println("course: " + course);
		String courseName = course.getCourseName() == null ? "" : course.getCourseName();
		String courseSkillFamily = course.getCourseSkillFamily() == null ? "" : course.getCourseSkillFamily();

//		Integer courseProficiencyInteger = course.getCourseProficiency();
		String courseProficiency = course.getCourseProficiency() == null ? "" : course.getCourseProficiency();
		System.out.println(courseName == "");
		System.out.println(courseSkillFamily == "");
		System.out.println(courseProficiency == "");

		List<Course> courseList = null;
		if (courseName != "" && courseSkillFamily != "" && courseProficiency != "") {
			System.out.println("Three property are not null");
			courseList = courseService.findCourseByCourseNameSkillProficiency(courseName, courseSkillFamily,
					courseProficiency, courseStatus);

		} else if (courseName != "" && courseSkillFamily != "") {
			System.out.println("courseName and skillfamily not null");
			courseList = courseService.findCourseByCourseNameSkill(courseName, courseSkillFamily, courseStatus);

		} else if (courseSkillFamily != "" && courseProficiency != "") {
			System.out.println("skill and proficiency not null");
			courseList = courseService.findCourseBySkillProficiency(courseSkillFamily, courseProficiency, courseStatus);

		} else if (courseProficiency != "" && courseName != "") {
			System.out.println("proficiency and coursename not null");
			courseList = courseService.findCourseByCourseNameProficiency(courseName, courseProficiency, courseStatus);

		} else if (courseName != "") {
			System.out.println("coursename is not null");
			courseList = courseService.findByCourseName(courseName, courseStatus);

		} else if (courseSkillFamily != "") {
			System.out.println("skill is not null");
			courseList = courseService.findBySkill(courseSkillFamily, courseStatus);

		} else if (courseProficiency != "") {
			System.out.println("proficiency not null");
			courseList = courseService.findByProficiency(courseProficiency, courseStatus);

		}

		Collections.sort(courseList);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(courseList);

		System.out.println("Found Courses: " + courseList);
		System.out.println(json);
//		model.addAttribute("courseList", courseList);
		return json;

	}

	@RequestMapping("/advanceSearch")
	public String findAllCourseUsingAdvanceSearch(@ModelAttribute("course") Course course, Model model) {
		System.out.println("Inside Advance Search Method");
		return "home/searchList";
	}

}

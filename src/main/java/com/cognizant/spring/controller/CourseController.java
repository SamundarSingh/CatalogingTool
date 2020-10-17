package com.cognizant.spring.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	private List<Course> courseList = new ArrayList<Course>();
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	String json = null;

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

//		List<Course> courseList = null;
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
			courseList = courseService.findCourseByCourseName(courseName, courseStatus);

		} else if (courseSkillFamily != "") {
			System.out.println("skill is not null");
			courseList = courseService.findCourseBySkill(courseSkillFamily, courseStatus);

		} else if (courseProficiency != "") {
			System.out.println("proficiency not null");
			courseList = courseService.findCourseByProficiency(courseProficiency, courseStatus);

		}

		Collections.sort(courseList);

//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		json = gson.toJson(courseList);

		System.out.println("Found Courses: " + courseList);
		System.out.println(json);
//		model.addAttribute("courseList", courseList);
		return json;

	}

	@RequestMapping("/advanceSearch")
	@ResponseBody
	public String findAllCourseUsingAdvanceSearch(@ModelAttribute("course") Course course) {
		System.out.println("Course: " + course);
		String courseCode = course.getCourseCode() == null ? "" : course.getCourseCode();
		String courseDescription = course.getCourseDescription() == null ? "" : course.getCourseDescription();
		String courseLicence = course.getCourseLicence() == null ? "" : course.getCourseLicence();
		String courseActivityType = course.getCourseActivityType() == null ? "" : course.getCourseActivityType();

		if (courseCode != "" && courseDescription != "" && courseLicence != "" && courseActivityType != "") {
			System.out.println("Four property are not null");
			courseList = courseService.findCourseByCodeDescriptionLicenceActivity(courseCode, courseDescription,
					courseLicence, courseActivityType, courseStatus);
		} else if (courseCode != "" && courseDescription != "" && courseLicence != "") {
			System.out.println("courseName, courseDescription, courseLicence not null");
			courseList = courseService.findCourseByCodeDescriptionLicence(courseCode, courseDescription, courseLicence,
					courseStatus);
		} else if (courseDescription != "" && courseLicence != "" && courseActivityType != "") {
			System.out.println("courseDescription, courseLicence, courseActivityTypeString not null");
			courseList = courseService.findCourseByDescriptionLicenceActivity(courseDescription, courseLicence,
					courseActivityType, courseStatus);
		} else if (courseCode != "" && courseLicence != "" && courseActivityType != "") {
			System.out.println("courseCode, courseLicence, courseActivityTypeString not null");
			courseList = courseService.findCourseByCodeLicenceActivity(courseCode, courseLicence, courseActivityType,
					courseStatus);
		} else if (courseCode != "" && courseDescription != "") {
			System.out.println("courseCode, courseDescription not null");
			courseList = courseService.findCourseByCodeDescription(courseCode, courseDescription, courseStatus);
		} else if (courseCode != "" && courseLicence != "") {
			System.out.println("courseLicence, courseLicence not null");
			courseList = courseService.findCourseByCodeLicence(courseCode, courseLicence, courseStatus);
		} else if (courseDescription != "" && courseLicence != "") {
			System.out.println("courseDescription, courseLicence not null");
			courseList = courseService.findCourseByDescriptionLicence(courseDescription, courseLicence, courseStatus);
		} else if (courseDescription != "" && courseActivityType != "") {
			System.out.println("courseActivityType, courseDescription not null");
			courseList = courseService.findCourseByDescriptionActivity(courseDescription, courseActivityType,
					courseStatus);
		} else if (courseLicence != "" && courseActivityType != "") {
			System.out.println("courseLicence, courseActivityTypeString not null");
			courseList = courseService.findCourseByLicenceActivity(courseLicence, courseActivityType, courseStatus);
		} else if (courseCode != "" && courseActivityType != "") {
			System.out.println("courseCode, courseActivityTypeString not null");
			courseList = courseService.findCourseByCodeActivity(courseCode, courseActivityType, courseStatus);
		} else if (courseCode != "") {
			System.out.println("courseCode not null");
			courseList = courseService.findCourseByCode(courseCode, courseStatus);
		} else if (courseDescription != "") {
			System.out.println("courseDescription not null");
			courseList = courseService.findCourseByDescription(courseDescription, courseStatus);
		} else if (courseLicence != "") {
			System.out.println("courseLicence not null");
			courseList = courseService.findCourseByLicence(courseLicence, courseStatus);
		} else if (courseActivityType != "") {
			System.out.println("courseActivityTypeString not null");
			courseList = courseService.findCourseByActivity(courseActivityType, courseStatus);
		}

		Collections.sort(courseList);

		json = gson.toJson(courseList);

		System.out.println("Found Courses: " + courseList);
		System.out.println(json);

		return json;
	}

}

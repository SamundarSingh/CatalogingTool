package com.cognizant.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.spring.entity.Course;
import com.cognizant.spring.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> findAllCourse() {
		return (List<Course>) courseRepository.findAll();
	}

	public List<Course> findCourseByCourseNameSkillProficiency(String courseName, String courseSkillFamily,
			String courseProficiency, String courseStatus) {
		return (List<Course>) courseRepository.findByCourseNameAndCourseSkillFamilyAndCourseProficiencyAndCourseStatus(
				courseName, courseSkillFamily, courseProficiency, courseStatus);

	}

	public List<Course> findCourseByCourseNameSkill(String courseName, String courseSkillFamily, String courseStatus) {
		return courseRepository.findByCourseNameAndCourseSkillFamilyAndCourseStatus(courseName, courseSkillFamily,
				courseStatus);
	}

	public List<Course> findCourseBySkillProficiency(String courseSkillFamily, String courseProficiency,
			String courseStatus) {
		return courseRepository.findByCourseSkillFamilyAndCourseProficiencyAndCourseStatus(courseSkillFamily,
				courseProficiency, courseStatus);

	}

	public List<Course> findCourseByCourseNameProficiency(String courseName, String courseProficiency,
			String courseStatus) {
		return courseRepository.findByCourseNameAndCourseProficiencyAndCourseStatus(courseName, courseProficiency,
				courseStatus);
	}

	public List<Course> findByCourseName(String courseName, String courseStatus) {
		return courseRepository.findByCourseNameAndCourseStatus(courseName, courseStatus);
	}

	public List<Course> findBySkill(String courseSkillFamily, String courseStatus) {
		return courseRepository.findByCourseSkillFamilyAndCourseStatus(courseSkillFamily, courseStatus);
	}

	public List<Course> findByProficiency(String courseProficiency, String courseStatus) {
		return courseRepository.findByCourseProficiencyAndCourseStatus(courseProficiency, courseStatus);
	}
}

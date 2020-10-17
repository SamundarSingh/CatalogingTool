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

	public List<Course> findCourseByCourseName(String courseName, String courseStatus) {
		return courseRepository.findByCourseNameAndCourseStatus(courseName, courseStatus);
	}

	public List<Course> findCourseBySkill(String courseSkillFamily, String courseStatus) {
		return courseRepository.findByCourseSkillFamilyAndCourseStatus(courseSkillFamily, courseStatus);
	}

	public List<Course> findCourseByProficiency(String courseProficiency, String courseStatus) {
		return courseRepository.findByCourseProficiencyAndCourseStatus(courseProficiency, courseStatus);
	}

	public List<Course> findCourseByCodeDescriptionLicenceActivity(String courseCode, String courseDescription,
			String courseLicence, String courseActivityType, String courseStatus) {
		return courseRepository
				.findByCourseCodeAndCourseDescriptionAndCourseLicenceAndCourseActivityTypeAndCourseStatus(courseCode,
						courseDescription, courseLicence, courseActivityType, courseStatus);
	}

	public List<Course> findCourseByCodeDescriptionLicence(String courseCode, String courseDescription,
			String courseLicence, String courseStatus) {
		return courseRepository.findByCourseCodeAndCourseDescriptionAndCourseLicenceAndCourseStatus(courseCode,
				courseDescription, courseLicence, courseStatus);

	}

	public List<Course> findCourseByDescriptionLicenceActivity(String courseDescription, String courseLicence,
			String courseActivityType, String courseStatus) {
		return courseRepository.findByCourseDescriptionAndCourseLicenceAndCourseActivityTypeAndCourseStatus(
				courseDescription, courseLicence, courseActivityType, courseStatus);

	}

	public List<Course> findCourseByCodeLicenceActivity(String courseCode, String courseLicence,
			String courseActivityType, String courseStatus) {
		return courseRepository.findByCourseCodeAndCourseLicenceAndCourseActivityTypeAndCourseStatus(courseCode,
				courseLicence, courseActivityType, courseStatus);

	}

	public List<Course> findCourseByCodeDescription(String courseCode, String courseDescription, String courseStatus) {
		return courseRepository.findByCourseCodeAndCourseDescriptionAndCourseStatus(courseCode, courseDescription,
				courseStatus);
	}

	public List<Course> findCourseByCodeLicence(String courseCode, String courseLicence, String courseStatus) {
		return courseRepository.findByCourseCodeAndCourseLicenceAndCourseStatus(courseCode, courseLicence,
				courseStatus);
	}

	public List<Course> findCourseByDescriptionLicence(String courseDescription, String courseLicence,
			String courseStatus) {
		return courseRepository.findByCourseDescriptionAndCourseLicenceAndCourseStatus(courseDescription, courseLicence,
				courseStatus);
	}

	public List<Course> findCourseByDescriptionActivity(String courseDescription, String courseActivityType,
			String courseStatus) {
		return courseRepository.findByCourseDescriptionAndCourseActivityTypeAndCourseStatus(courseDescription,
				courseActivityType, courseStatus);
	}

	public List<Course> findCourseByLicenceActivity(String courseLicence, String courseActivityType,
			String courseStatus) {
		return courseRepository.findByCourseLicenceAndCourseActivityTypeAndCourseStatus(courseLicence,
				courseActivityType, courseStatus);

	}

	public List<Course> findCourseByCodeActivity(String courseCode, String courseActivityType, String courseStatus) {
		return courseRepository.findByCourseCodeAndCourseActivityTypeAndCourseStatus(courseCode, courseActivityType,
				courseStatus);
	}

	public List<Course> findCourseByCode(String courseCode, String courseStatus) {
		return courseRepository.findByCourseCodeAndCourseStatus(courseCode, courseStatus);
	}

	public List<Course> findCourseByDescription(String courseDescription, String courseStatus) {
		return courseRepository.findByCourseDescriptionAndCourseStatus(courseDescription, courseStatus);
	}

	public List<Course> findCourseByLicence(String courseLicence, String courseStatus) {
		return courseRepository.findByCourseLicenceAndCourseStatus(courseLicence, courseStatus);
	}

	public List<Course> findCourseByActivity(String courseActivityType, String courseStatus) {
		return courseRepository.findByCourseActivityTypeAndCourseStatus(courseActivityType, courseStatus);
	}
}

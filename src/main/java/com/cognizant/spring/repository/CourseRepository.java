package com.cognizant.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.spring.entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, String> {

	List<Course> findByCourseNameAndCourseSkillFamilyAndCourseProficiencyAndCourseStatus(String courseName,
			String courseSkillFamily, String courseProficiency, String courseStatus);

	List<Course> findByCourseNameAndCourseSkillFamilyAndCourseStatus(String courseName, String courseSkillFamily,
			String courseStatus);

	List<Course> findByCourseSkillFamilyAndCourseProficiencyAndCourseStatus(String courseSkillFamily,
			String courseProficiency, String courseStatus);

	List<Course> findByCourseNameAndCourseProficiencyAndCourseStatus(String courseName, String courseProficiency,
			String courseStatus);

	List<Course> findByCourseNameAndCourseStatus(String courseName, String courseStatus);

	List<Course> findByCourseSkillFamilyAndCourseStatus(String courseSkillFamily, String courseStatus);

	List<Course> findByCourseProficiencyAndCourseStatus(String courseProficiency, String courseStatus);

	List<Course> findByCourseCodeAndCourseDescriptionAndCourseLicenceAndCourseActivityTypeAndCourseStatus(
			String courseCode, String courseDescription, String courseLicence, String courseActivityType,
			String courseStatus);

	List<Course> findByCourseCodeAndCourseDescriptionAndCourseLicenceAndCourseStatus(String courseCode,
			String courseDescription, String courseLicence, String courseStatus);

	List<Course> findByCourseDescriptionAndCourseLicenceAndCourseActivityTypeAndCourseStatus(String courseDescription,
			String courseLicence, String courseActivityType, String courseStatus);

	List<Course> findByCourseCodeAndCourseLicenceAndCourseActivityTypeAndCourseStatus(String courseCode,
			String courseLicence, String courseActivityType, String courseStatus);

	List<Course> findByCourseCodeAndCourseDescriptionAndCourseStatus(String courseCode, String courseDescription,
			String courseStatus);

	List<Course> findByCourseCodeAndCourseLicenceAndCourseStatus(String courseCode, String courseLicence,
			String courseStatus);

	List<Course> findByCourseDescriptionAndCourseLicenceAndCourseStatus(String courseDescription, String courseLicence,
			String courseStatus);

	List<Course> findByCourseDescriptionAndCourseActivityTypeAndCourseStatus(String courseDescription,
			String courseActivityType, String courseStatus);

	List<Course> findByCourseLicenceAndCourseActivityTypeAndCourseStatus(String courseLicence,
			String courseActivityType, String courseStatus);

	List<Course> findByCourseCodeAndCourseActivityTypeAndCourseStatus(String courseCode, String courseActivityType,
			String courseStatus);

	List<Course> findByCourseCodeAndCourseStatus(String courseCode, String courseStatus);

	List<Course> findByCourseDescriptionAndCourseStatus(String courseDescription, String courseStatus);

	List<Course> findByCourseLicenceAndCourseStatus(String courseLicence, String courseStatus);

	public List<Course> findByCourseActivityTypeAndCourseStatus(String courseActivityType, String courseStatus);

}

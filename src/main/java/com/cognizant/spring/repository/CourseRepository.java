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
	
}

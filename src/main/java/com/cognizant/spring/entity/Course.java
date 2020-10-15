package com.cognizant.spring.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course implements Comparable<Course> {

	@Id
	private String courseCode;
	private String courseName;
	private String courseSkillFamily;
	private String courseDescription;
	private String courseProficiency;
	private String courseStatus;
	private String courseLicence;
	private String courseActivityType;
	private Date courseCreationDate;

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseSkillFamily() {
		return courseSkillFamily;
	}

	public void setCourseSkillFamily(String courseSkillFamily) {
		this.courseSkillFamily = courseSkillFamily;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getCourseProficiency() {
		return courseProficiency;
	}

	public void setCourseProficiency(String courseProficiency) {
		this.courseProficiency = courseProficiency;
	}

	public String getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}

	public String getCourseLicence() {
		return courseLicence;
	}

	public void setCourseLicence(String courseLicence) {
		this.courseLicence = courseLicence;
	}

	public String getCourseActivityType() {
		return courseActivityType;
	}

	public void setCourseActivityType(String courseActivityType) {
		this.courseActivityType = courseActivityType;
	}

	public Date getCourseCreationDate() {
		return courseCreationDate;
	}

	public void setCourseCreationDate(Date courseCreationDate) {
		this.courseCreationDate = courseCreationDate;
	}

	public Course() {

	}

	public Course(String courseCode, String courseName, String courseSkillFamily, String courseDescription,
			String courseProficiency, String courseStatus, String courseLicence, String courseActivityType,
			Date courseCreationDate) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.courseSkillFamily = courseSkillFamily;
		this.courseDescription = courseDescription;
		this.courseProficiency = courseProficiency;
		this.courseStatus = courseStatus;
		this.courseLicence = courseLicence;
		this.courseActivityType = courseActivityType;
		this.courseCreationDate = courseCreationDate;
	}

	@Override
	public String toString() {
		return "Course [courseCode=" + courseCode + ", courseName=" + courseName + ", courseSkillFamily="
				+ courseSkillFamily + ", courseDescription=" + courseDescription + ", courseProficiency="
				+ courseProficiency + ", courseStatus=" + courseStatus + ", courseLicence=" + courseLicence
				+ ", courseActivityType=" + courseActivityType + ", courseCreationDate=" + courseCreationDate + "]";
	}

	@Override
	public int compareTo(Course course) {
		course.courseCreationDate.compareTo(this.courseCreationDate);
		return 0;
	}

}

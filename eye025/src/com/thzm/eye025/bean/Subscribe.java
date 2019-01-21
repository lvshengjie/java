package com.thzm.eye025.bean;

import java.sql.Date;

public class Subscribe {
		
		private String name;
		private String conner;
		private String email;
		private String gender;
		private String age;
		private String item;
		private Date date;
		private String description;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getConner() {
			return conner;
		}
		public void setConner(String conner) {
			this.conner = conner;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getItem() {
			return item;
		}
		public void setItem(String item) {
			this.item = item;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Subscribe() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Subscribe(String name, String conner, String email, String gender, String age, String item, Date date,
				String description) {
			super();
			this.name = name;
			this.conner = conner;
			this.email = email;
			this.gender = gender;
			this.age = age;
			this.item = item;
			this.date = date;
			this.description = description;
		}
		@Override
		public String toString() {
			return "Subscribe [name=" + name + ", conner=" + conner + ", email=" + email + ", gender=" + gender
					+ ", age=" + age + ", item=" + item + ", date=" + date + ", description=" + description + "]";
		}
		
}

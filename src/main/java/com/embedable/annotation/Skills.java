package com.embedable.annotation;

import jakarta.persistence.Embeddable;

@Embeddable
public class Skills {
		private String language;
		private String experience;
		
		public Skills() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Skills(String language, String experience) {
			super();
			this.language = language;
			this.experience = experience;
		}

		public String getLanguage() {
			return language;
		}
		public void setLanguage(String language) {
			this.language = language;
		}
		public String getExperience() {
			return experience;
		}
		public void setExperience(String experience) {
			this.experience = experience;
		}
		
}

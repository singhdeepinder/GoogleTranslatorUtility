package com.prudle.prudle_ggl_translator;

public class FixQuery {

	
	
	public static void main(String[] args) {
		
		String[]  arr = {
				"Assessments,Assessments",
				"Professional Development,Professional Development",
				"Collections,Collections",
				"All content will be inaccessible to the classrooms tied to it,All content will be inaccessible to the classrooms tied to it",
				"I can explain,I can explain",
				"Please use Google signin. We can't reset your password.,Please use Google signin. We can't reset your password.",
				"Lessons,Lessons",
				"{{count}} Students,{{count}} Students",
				"Questions,Questions",
				"Highlight Text,Highlight Text",
				"Question,Question",
				"Resources,Resources",
				"Units,Units",
				"You've reached the character limit.,You've reached the character limit.",
				"Login,Login",
				"Please select Subject.,Please select Subject.",
				"Welcome to Gooru! Check out these resources to learn what you can do with Gooru and get started quickly.,Welcome to Gooru! Check out these resources to learn what you can do with Gooru and get started quickly.",
				"Learn by example through stories of teachers who say Gooru has made a difference in their classroom.,Learn by example through stories of teachers who say Gooru has made a difference in their classroom.",
				"We offer free webinars and trainings to help you get started with Gooru.,We offer free webinars and trainings to help you get started with Gooru.,We offer free webinars and trainings to help you get started with Gooru.",
				"Monitor,Monitor",
				"Learn More about Our Approach,Learn More about Our Approach",
				"Delete Classroom,Delete Classroom",
				"Edit Classroom Settings,Edit Classroom Settings",
				"Add to Daily Class Activities,Add to Daily Class Activities",
				"View Both,View Both",
				"Class Average,Class Average,Class Average,Class Average",
				"View Mastery,View Mastery,View Mastery",
				"Copy and customize a featured course for your students,Copy and customize a featured course for your students",
				"<p>An assessment is a set of scored questions which you and your students can use to monitor understanding and performance.</p><p>Use a variety of question types (including several based on the SBAC) in your assessment so students can demonstrate understanding in different ways. We recommend tagging each question to standards, micro-standards, and Webb's Depth of Knowledge.</p>,<p>An assessment is a set of scored questions which you and your students can use to monitor understanding and performance.</p><p>Use a variety of question types (including several based on the SBAC) in your assessment so students can demonstrate understanding in different ways. We recommend tagging each question to standards, micro-standards, and Webb's Depth of Knowledge.</p>,<p>An assessment is a set of scored questions which you and your students can use to monitor understanding and performance.</p><p>Use a variety of question types (including several based on the SBAC) in your assessment so students can demonstrate understanding in different ways. We recommend tagging each question to standards, micro-standards, and Webb's Depth of Knowledge.</p>",
				"Get Started,Get Started",
				"By clicking Join Classroom, I agree to share my assessment and collection progress data generated from studying this Gooru classroom with the teacher(s) of this classroom.,By clicking Join Classroom, I agree to share my assessment and collection progress data generated from studying this Gooru classroom with the teacher(s) of this classroom.,By clicking Join Classroom, I agree to share my assessment and collection progress data generated from studying this Gooru classroom with the teacher(s) of this classroom.",
				"<p>Students interact with your content at the collection level. When creating a learning collection, make sure to include learning objectives, and consider using a variety of resource types to expose students to the concepts in multiple ways.</p><p>Use the sequencing of the resources to build on concepts. Progression through a collection should flow in a logical manner and take the intended audience from a general to more complex level of understanding if appropriate, or allow adequately for student exploration.</p><p>Include checks for understanding along the way via our Gooru questions or other interactives. We recommend enough resources and/or enough variety of resources to accomplish the objectives in the collection and ensuring that each resource has a role and purpose.</p>,<p>Students interact with your content at the collection level. When creating a learning collection, make sure to include learning objectives, and consider using a variety of resource types to expose students to the concepts in multiple ways.</p><p>Use the sequencing of the resources to build on concepts. Progression through a collection should flow in a logical manner and take the intended audience from a general to more complex level of understanding if appropriate, or allow adequately for student exploration.</p><p>Include checks for understanding along the way via our Gooru questions or other interactives. We recommend enough resources and/or enough variety of resources to accomplish the objectives in the collection and ensuring that each resource has a role and purpose.</p>,<p>Students interact with your content at the collection level. When creating a learning collection, make sure to include learning objectives, and consider using a variety of resource types to expose students to the concepts in multiple ways.</p><p>Use the sequencing of the resources to build on concepts. Progression through a collection should flow in a logical manner and take the intended audience from a general to more complex level of understanding if appropriate, or allow adequately for student exploration.</p><p>Include checks for understanding along the way via our Gooru questions or other interactives. We recommend enough resources and/or enough variety of resources to accomplish the objectives in the collection and ensuring that each resource has a role and purpose.</p>",
				"Description,Description,Description,Description",
				"Question Type,Question Type",
				"Select the correct answer.,Select the correct answer.",
				"Write your question.,Write your question.,Write your question.,Write your question.,Write your question.",
				"Oops! Unable to unbookmark this {{type}} right now. Please try again shortly.,Oops! Unable to unbookmark this {{type}} right now. Please try again shortly.",
				"All student data will be deleted,All student data will be deleted",
				"Are you sure you want to continue? Please type “delete” below and click “delete”.,Are you sure you want to continue? Please type “delete” below and click “delete”.",
				"Copies of this resource, in your collections and any collection by other users in the community, will be deleted,Copies of this resource, in your collections and any collection by other users in the community, will be deleted",
				"Are you sure you want to continue? Please type “remove” below and click “remove”.,Are you sure you want to continue? Please type “remove” below and click “remove”.",
				"Are you sure you want to continue? Please type “delete” below and click “delete”.,Are you sure you want to continue? Please type “delete” below and click “delete”.",
				"Confirm you want to remove <b>{{title}}</b> from <b>{{parentName}}</b>.,Confirm you want to remove <b>{{title}}</b> from <b>{{parentName}}</b>.",
				"Permanently Delete,Permanently Delete,Permanently Delete",
				"Please select a license,Please select a license,Please select a license,Please select a license",
				"You're currently enrolled in {{count}} classrooms,You're currently enrolled in {{count}} classrooms",
				"You're currently teaching {{count}} classrooms,You're currently teaching {{count}} classrooms",
				"Today,Today",
				"My Report,My Report",
				"Total time spent,Total time spent",
				"Study,Study",
				"Update Report,Update Report",
				"View Report,View Report",
				" or , or ",
				"Collections,Collections",
				"View more,View more",
				"You have not set any goals yet. You can add a goal by clicking \"Add Goal\" button above.,You have not set any goals yet. You can add a goal by clicking \"Add Goal\" button above.",
				"You've created the goal {{goalTitle}},You've created the goal {{goalTitle}}",
				"You've deleted the goal,You've deleted the goal",
				"You've updated the goal,You've updated the goal",
				"You have {{count}} attempts,You have {{count}} attempts",
				"See Stories,See Stories",
				"Enter Classroom Code,Enter Classroom Code",
				"See Our Impact,See Our Impact",
				"Learn More,Learn More",
				": Provides guided tours on how to use our features.,: Provides guided tours on how to use our features.",
				": At-your-fingertips support for additional questions.,: At-your-fingertips support for additional questions.",
				": Identifies new features for you to try out.,: Identifies new features for you to try out.",
				"December,December",
				"Please enter your birth date.,Please enter your birth date.",
				"Free Response,Free Response",
				"Author,Author",
				"View Report,View Report",
				"See Usage Report,See Usage Report",
				"requirements that take you to another page to view the content.,requirements that take you to another page to view the content.,requirements that take you to another page to view the content.",
				"Followers,Followers",
				"Select a district...,Select a district...",
				"Total Time Spent,Total Time Spent",
				"Not Started,Not Started",
				"{{count}} Units,{{count}} Units",
				"This class has no assigned course content.,This class has no assigned course content.,This class has no assigned course content.",
				"{{count}} Units,{{count}} Units",
				"{{count}} Resources,{{count}} Resources",
				"{{count}} Questions,{{count}} Questions",
				"Start studying,Start studying",
				"{{count}} Courses,{{count}} Courses",
				"{{count}} Students,{{count}} Students",
				"{{count}} Collections,{{count}} Collections",
				"{{count}} Assessments,{{count}} Assessments",
				"{{count}} Classrooms,{{count}} Classrooms,{{count}} Classrooms",
				"Add to,Add to",
				"Skipped,Skipped",
				"Following,Following",
				"Follow,Follow",
				"Create Classroom,Create Classroom",
				"Enter Classroom Code,Enter Classroom Code",
				"Featured Courses,Featured Courses",
				"Teacher Toolkit,Teacher Toolkit,Teacher Toolkit",
				"Standards Framework and Course,Standards Framework and Course",
				"{{count}} domains selected,{{count}} domains selected",
				"Course is in,Course is in",
				"{{count}} standards selected,{{count}} standards selected",
				"{{count}} competencies selected,{{count}} competencies selected",
				"Unit is tagged to,Unit is tagged to",
				"Trigonometry,Trigonometry",
				"Create Expression,Create Expression",
				"Welcome to your Gooru homepage! Here you can find a list of the classrooms you create in Gooru. Classrooms allow you to share content directly with students. You can always come back to your homepage by clicking on the Gooru icon.,Welcome to your Gooru homepage! Here you can find a list of the classrooms you create in Gooru. Classrooms allow you to share content directly with students. You can always come back to your homepage by clicking on the Gooru icon.",
				"Any classrooms you teach or join this school year will appear here under Active Classrooms.,Any classrooms you teach or join this school year will appear here under Active Classrooms.",
				"Click here to create a new classroom. Once you have content to share with students, you will assign it to them via a classroom.,Click here to create a new classroom. Once you have content to share with students, you will assign it to them via a classroom.",
				"This is your Profile. Click on your profile at any time to access content you create or remix in Gooru.,This is your Profile. Click on your profile at any time to access content you create or remix in Gooru.,This is your Profile. Click on your profile at any time to access content you create or remix in Gooru.",
				"Welcome to Take a Tour! This is your personal home page. Remember you can always get back to your page by clicking on the Gooru logo. Now let’s get started!,Welcome to Take a Tour! This is your personal home page. Remember you can always get back to your page by clicking on the Gooru logo. Now let’s get started!",
				"Here you will see announcements that your teacher or school would like you to know about.,Here you will see announcements that your teacher or school would like you to know about.",
				"See all of the classes in which you are enrolled.,See all of the classes in which you are enrolled.",
				"To join a new classroom, enter the class code and it will be displayed under “My Classes.”,To join a new classroom, enter the class code and it will be displayed under “My Classes.”",
				"Explore and bookmark topics that interest you and that you want learn more about.,Explore and bookmark topics that interest you and that you want learn more about.",
				"Search our content catalog for topics that interest to you.,Search our content catalog for topics that interest to you.",
				"Return to your home page.,Return to your home page.",
				"Browse our featured courses.,Browse our featured courses.",
				"See a summary of your performance in the courses you are enrolled in.,See a summary of your performance in the courses you are enrolled in.",
				"Access and update your user profile.,Access and update your user profile.",
				"Now go ahead and click on a course you have enrolled in, join a classroom, or search for content that is of interest to you. ,Now go ahead and click on a course you have enrolled in, join a classroom, or search for content that is of interest to you. ,Now go ahead and click on a course you have enrolled in, join a classroom, or search for content that is of interest to you. ",
				"Welcome to your Performance Dashboard. You can view how you are performing in all classes and courses.,Welcome to your Performance Dashboard. You can view how you are performing in all classes and courses.",
				"Click on the arrow to filter your performance by activity, time period, subject, and course. ,Click on the arrow to filter your performance by activity, time period, subject, and course. ",
				"Once you have selected your filters, click on update report to display results.,Once you have selected your filters, click on update report to display results.",
				"Download your report.,Download your report.",
				"Go ahead and analyze your performance!,Go ahead and analyze your performance!,Go ahead and analyze your performance!",
				"Welcome to your Course Page. Here you will find your daily activities, course map, and performance data. Let’s get started!,Welcome to your Course Page. Here you will find your daily activities, course map, and performance data. Let’s get started!",
				"Access a list of activities assigned by your teacher. Select the activities you want to study.,Access a list of activities assigned by your teacher. Select the activities you want to study.",
				"Click on the units and lessons to complete the collections and assessments in the course.,Click on the units and lessons to complete the collections and assessments in the course.",
				"Take a look at your overall class performance. ,Take a look at your overall class performance. ",
				"Get started by clicking on the Course Map or Daily Activities tab to start studying.,Get started by clicking on the Course Map or Daily Activities tab to start studying.,Get started by clicking on the Course Map or Daily Activities tab to start studying.",
				"This is your Study Player. Let’s walk through the features available to you.,This is your Study Player. Let’s walk through the features available to you.",
				"Indicates where the collection or assessment are located in your course.,Indicates where the collection or assessment are located in your course.",
				"Indicates how you are performing and how much of the course you have completed.,Indicates how you are performing and how much of the course you have completed.",
				"Let your teacher know what you think about this resource.,Let your teacher know what you think about this resource.",
				"Return to your Course Map to see additional course content.,Return to your Course Map to see additional course content.",
				"These are resources that you might want to explore based on what you are currently studying.,These are resources that you might want to explore based on what you are currently studying.",
				",",
				"Start studying!,Start studying!,Start studying!",
				"This setting determines how students can move through an assessment and shows whether their answers are correct or incorrect. It does not show them an answer key.,This setting determines how students can move through an assessment and shows whether their answers are correct or incorrect. It does not show them an answer key.",
				"This setting allows an answer key to be revealed and sets the number of attempts students have on the assessment.,This setting allows an answer key to be revealed and sets the number of attempts students have on the assessment.,This setting allows an answer key to be revealed and sets the number of attempts students have on the assessment.",
				"The course map provides your students access to all assessments and collections you assign to them.,The course map provides your students access to all assessments and collections you assign to them.",
				"Each classroom you create has a unique class code. You will give this code to students when you are ready for them to join your classroom and access your content.,Each classroom you create has a unique class code. You will give this code to students when you are ready for them to join your classroom and access your content.",
				"This allows you to see class and individual student assessment data when students complete assessments that are part of a course.,This allows you to see class and individual student assessment data when students complete assessments that are part of a course.",
				"Here you can edit your classroom name, post announcements for your students, see the names of students enrolled in your class, and delete your classroom.,Here you can edit your classroom name, post announcements for your students, see the names of students enrolled in your class, and delete your classroom.",
				"When you are in a classroom, click here to edit any of the course content assigned to your students.,When you are in a classroom, click here to edit any of the course content assigned to your students.",
				"Use the real-time dashboard to monitor class progress on an assessment in real-time.<br><br>Click on the \"Go Live\" icon found to the left of every assessment to launch a real-time assessment for students. <br><br><i class=\"real-time-icon\">,Use the real-time dashboard to monitor class progress on an assessment in real-time.<br><br>Click on the \"Go Live\" icon found to the left of every assessment to launch a real-time assessment for students. <br><br><i class=\"real-time-icon\">,Use the real-time dashboard to monitor class progress on an assessment in real-time.<br><br>Click on the \"Go Live\" icon found to the left of every assessment to launch a real-time assessment for students. <br><br><i class=\"real-time-icon\">",
				"This is a view of a newly created classroom. To get back to a classroom at any time, click on \"Classrooms\" and use the drop down menu to select the classroom you wish to enter.,This is a view of a newly created classroom. To get back to a classroom at any time, click on \"Classrooms\" and use the drop down menu to select the classroom you wish to enter.",
				"We suggest creating an assessment as a way to get started with Gooru and to assess current levels of student understanding in your class.,We suggest creating an assessment as a way to get started with Gooru and to assess current levels of student understanding in your class.,We suggest creating an assessment as a way to get started with Gooru and to assess current levels of student understanding in your class.",
				"Click on each question to see a breakdown of how students answered.,Click on each question to see a breakdown of how students answered.",
				"Select each student tile to see individual student data reports.,Select each student tile to see individual student data reports.",
				"Select \"title view\" or \"list view\" to see options for displaying data.,Select \"title view\" or \"list view\" to see options for displaying data.",
				"See the class average calculated in real-time for all responses.,See the class average calculated in real-time for all responses.",
				"Use this option to project an anonymous view of student data.,Use this option to project an anonymous view of student data.,Use this option to project an anonymous view of student data.",
				"National Research Center for Life and Work,National Research Center for Life and Work",
				"Key Learning Skills and Techniques,Key Learning Skills and Techniques,Key Learning Skills and Techniques",
				"Add rubric above and preview here,Add rubric above and preview here",
				"Worst,Worst,Worst",
				"Featured Course,Featured Course",
				"{{count}} Courses,{{count}} Courses",
				"{{count}} Collections,{{count}} Collections",
				"{{count}} Assessments,{{count}} Assessments",
				"{{count}} Resources,{{count}} Resources",
				"{{count}} Questions,{{count}} Questions",
				"{{count}} Rubrics,{{count}} Rubrics,{{count}} Rubrics",
				"Resources,Resources",
				"Questions,Questions",

		};
		
		for (int i = 0; i < arr.length; i++) {
			
			String value = arr[i];
			String halfSplit = value.substring(0, value.length()/2);
			String otherHalf = value.substring(value.length()/2 + 1);
			
			//System.out.println(halfSplit);
			//System.out.println(otherHalf);
			
			if(halfSplit.equals(otherHalf)) {
				String query = "update prudle.tbl_projectassignment A set Valuetarget = (Select DISTINCT value from prudle.tbl_translationmem B where B.Name = \""
						+ halfSplit
						+ "\" AND B.TargetLang=\"ES-XM\"),A.value=\"" + halfSplit + "\"  WHERE A.Value=\""
						+ value + "\"  AND A.Target=17;";
				
				System.out.println(query);
			} else {
				//System.out.println("*****");
				 halfSplit = value.substring(0, value.length()/3);
				 otherHalf = value.substring(value.length()/3 + 1,1 + (value.length()/3 )*2);
				 String thirdHalf = value.substring((value.length()/3 + 1)*2);
//				System.out.println(value);
//				System.out.println(halfSplit);
//				System.out.println(otherHalf);
//				System.out.println(thirdHalf);
				
				 String query = "update prudle.tbl_projectassignment A set Valuetarget = (Select DISTINCT value from prudle.tbl_translationmem B where B.Name = \""
						+ halfSplit
						+ "\" AND B.TargetLang=\"ES-XM\"),A.value=\"" + halfSplit + "\"  WHERE A.Value=\""
						+ value + "\"  AND A.Target=17;";
				 System.out.println(query);
				
			}
			
			
			/*String query = "update prudle.tbl_projectassignment A set Valuetarget = (Select DISTINCT value from prudle.tbl_translationmem B where B.Name = \""
					+ arr[i]
					+ "\" AND B.TargetLang=\"AR-SA\") WHERE A.Value=\""
					+ arr[i] + "\";";
			
			System.out.println(query);*/
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
}

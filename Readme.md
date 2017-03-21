README DOCUMENT FOR XTAF V1.0.1-SNAPSHOT

Example maven command to execute the TestNG/JUnit Tests
mvn clean test

We use 'maven clean test' to run and then pass in these options

-DrunSuite=**/RunCukesTest.class 
	this runs only the BDD tests with the manual tag

-Dbrowser.type="Cloud" -Ddevice.name="HTC One M8" -Dbrowser.name="android" -Dplatform.name="ANDROID"
	this aids tester to run on cloud instance (BrowserStack already configured) change the cloud config file and you are ready to go. 

-Dbrowser.type="ResolutionScreen" -Dscreen.width="460" -Dscreen.height="640" 
	this aids tester to use the chrome emulation and runs the test on the specified resolution

-Dbrowser.type="Device" -Ddevice.name="Google Nexus 5" 
	this aids tester to use the chrome emulation and runs the test on the specified device




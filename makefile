all:
	mkdir -p build	
	find -name "*.java" > build/sources
	javac @"build/sources" -d build 
	java -cp .:build:**/*.class com.yahtzee.Game

test:
	mkdir -p build	
	find -name "*.java" > build/sources
	javac @"build/sources" -d build 
	java -cp $(CLASSPATH).:build:**/*.class  org.junit.runner.JUnitCore com.yahtzee.tests.TestCases

clean:
	rm -rf build

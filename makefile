all:
	mkdir -p build	
	find -name "*.java" > build/sources
	javac @"build/sources" -d build 
	java -cp .:build:**/*.class com.yahtzee.Game
	
clean:
	rm -rf build
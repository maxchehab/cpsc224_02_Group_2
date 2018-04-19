all:
	mkdir -p build	
	find -name "*.java" > build/sources
	javac @"build/sources" -d build 
	cp -a src/assets/. build/com/yahtzee/assets
	java -cp .:build:**/*.class com.yahtzee.Game
	
clean:
	rm -rf build
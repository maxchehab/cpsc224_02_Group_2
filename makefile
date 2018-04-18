all:
	javac -d ./build *.java
	cd build && java Game	
	
clean:
	rm -rf build

setup:
	mkdir build
	mkdir dist


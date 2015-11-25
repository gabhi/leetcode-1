# About

This repository contains the most popular programming questions. Here I try to give my most clean, readable, and optimized solution. Enjoy!

# Install JAVA in sublime text

1. Click menu `Tool -> Build System -> New Build System`
2. Save the followings as `Java.sublime-build`

	{
		"cmd": "javac $file_name && java $file_base_name", 
		"selector": "source.java", 
		"shell": true 
	}

3. Use `command + B` to build & run your JAVA code

